package lotto.Controller;

import lotto.Model.CalculateReturnRate;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.MyLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    public static final Integer LottoPrice = 1000;
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
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            return purchaseLotto();
        }
    }

    private static int LottoAmount(long price) {
        return (int) (price / LottoPrice);
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
            resultLotto(myLottos);
        }
    }


}
