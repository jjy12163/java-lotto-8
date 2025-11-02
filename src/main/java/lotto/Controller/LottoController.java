package lotto.Controller;

import lotto.Model.Validator;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

public class LottoController {

    private final String rawPurchasePrice;

    public LottoController(String rawPurchasePrice) {
        this.rawPurchasePrice = rawPurchasePrice;
    }

    public void run() {
        int price = Validator.validatePurchasePrice(rawPurchasePrice);
    }






}
