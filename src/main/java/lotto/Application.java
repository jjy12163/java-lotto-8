package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;

public class Application {
    public static void main(String[] args) {

        String rawPurchasePrice = InputView.purchasePrice();

        LottoController lottoController = new LottoController(rawPurchasePrice);
        lottoController.run();

    }
}
