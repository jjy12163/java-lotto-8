package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        long price = inputPrice();

        LottoController lottoController = new LottoController(price);
        lottoController.run();
    }
    private static long inputPrice() {
        while (true) {
            try {
                long price = InputView.purchasePrice();
                return price;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
