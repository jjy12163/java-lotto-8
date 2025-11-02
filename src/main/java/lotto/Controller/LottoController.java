package lotto.Controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.Model.MyLotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    public static final Integer LottoPrice = 1000;

    public void purchaseLotto() {
        try {
            Integer price = InputView.purchasePrice();
            int lottoAmount = LottoAmount(price);
            MyLotto myLotto = new MyLotto();
            List<Lotto> lottos = myLotto.purchase(lottoAmount);
            OutputView.myLottoPrint(lottoAmount, lottos);
        } catch (Exception e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            purchaseLotto();
        }
    }

    private static int LottoAmount(int price) {
        return price / LottoPrice;
    }


    public void resultLotto() {
        try {
            List<Integer> lotteryWinningNum = InputView.lotteryWinningNum();
        }
    }
}
