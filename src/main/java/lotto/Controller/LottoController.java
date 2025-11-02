package lotto.Controller;

import lotto.Model.MyLotto;
import lotto.Model.Validator;

public class LottoController {

    public static final Integer LottoPrice = 1000;

    private final String rawPurchasePrice;


    public LottoController(String rawPurchasePrice) {
        this.rawPurchasePrice = rawPurchasePrice;
    }

    public void run() {
        int price = Validator.validatePurchasePrice(rawPurchasePrice);
        int lottoAmount = LottoAmount(price);
        MyLotto myLotto = new MyLotto(lottoAmount);
        myLotto.buy();

    }


    private static int LottoAmount(int price) {
        return price / LottoPrice;
    }




}
