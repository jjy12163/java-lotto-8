package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {


        long price = InputView.purchasePrice();

        LottoController lottoController = new LottoController(price);
        lottoController.run();



    }
}
