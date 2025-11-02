package lotto.Model;

import lotto.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public static Integer validatePurchasePrice(String rawPurchasePrice) {

        if (isPriceEmpty(rawPurchasePrice)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }

        int price = StringToInt(rawPurchasePrice);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.ODD_INPUT.getMessage());
        }
        if(price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXTRA_CHANGE.getMessage());
        }

        return price;
    }

    private static boolean isPriceEmpty(String raw) {
        return raw == null || raw.trim().isEmpty();
    }

    private static int StringToInt(String raw) {
        try {
            isValueInRangeOfInt(raw);
            return Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
    private static void isValueInRangeOfInt(String raw) {
        long parsedLong = Long.parseLong(raw);
        if(parsedLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }


}
