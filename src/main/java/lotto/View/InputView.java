package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

public class InputView {

    public static Integer purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawPurchasePrice = Console.readLine();
        return validatePurchasePrice(rawPurchasePrice);
    }

    public static String lotteryWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static String BonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

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