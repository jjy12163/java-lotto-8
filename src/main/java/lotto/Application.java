package lotto;

import lotto.Controller.LottoController;
import lotto.View.InputView;
import lotto.View.OutputView;

public class Application {
    public static void main(String[] args) {
        long price;

        try{
            price = InputView.purchasePrice();
        }
        catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            price = InputView.purchasePrice();
        }

        LottoController lottoController = new LottoController(price);
        lottoController.run();
    }
}
