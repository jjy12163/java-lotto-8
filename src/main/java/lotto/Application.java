package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {


        LottoController lottoController = new LottoController();
        lottoController.purchaseLotto();
        lottoController.resultLotto();



    }
}
