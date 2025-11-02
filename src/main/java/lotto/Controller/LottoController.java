package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Model.MyLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public static final Integer LottoPrice = 1000;

    public void run() {
        List<Lotto> lottos = purchaseLotto();
        resultLotto(lottos);
    }

    private List<Lotto> purchaseLotto() {
        try {
            Integer price = InputView.purchasePrice();
            int lottoAmount = LottoAmount(price);
            List<Lotto> lottos = MyLotto.purchase(lottoAmount);
            OutputView.myLottoPrint(lottoAmount, lottos);
            return lottos;
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            purchaseLotto();
        }
    }

    private static int LottoAmount(int price) {
        return price / LottoPrice;
    }


    public void resultLotto(List<Lotto> myLottos) {
        try {
            List<Integer> lotteryWinningNum = InputView.lotteryWinningNum();
            Integer bonusNumber = InputView.BonusNumber(lotteryWinningNum);

            List<LottoResult> resultLottos = MyLotto.resultLottos(myLottos, lotteryWinningNum, bonusNumber);
            OutputView.resultLottoPrint(resultLottos);

        }
    }
}
