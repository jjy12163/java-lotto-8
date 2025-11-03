package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.MyLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

import static lotto.View.OutputView.myLottoPrint;


public class LottoController {

    public static final Integer LOTTO_PRICE = 1000;
    public final long price;

    public LottoController(long price) {
        this.price = price;
    }

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        resultLotto(lottos);
    }

    private List<Lotto> purchaseLotto() {
        try {
            int lottoAmount = LottoAmount(price);
            List<Lotto> lottos = MyLotto.purchase(lottoAmount);
            myLottoPrint(lottoAmount, lottos);
            return lottos;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return purchaseLotto();
        }
    }
    public void resultLotto(List<Lotto> myLottos) {
        try {
            List<Integer> lotteryWinningNum = InputView.lotteryWinningNum();
            Integer bonusNumber = InputView.BonusNumber(lotteryWinningNum);
            List<LottoResult> resultLottos = MyLotto.resultLottos(myLottos, lotteryWinningNum, bonusNumber);
            long totalInput = OutputView.printResultLottoAndCalculateTotalInput(resultLottos);
            OutputView.printInputRate(price, totalInput);
        }
        catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            resultLotto(myLottos);
        }
    }

    private static int LottoAmount(long price) {
        return (int) (price / LOTTO_PRICE);
    }




}
