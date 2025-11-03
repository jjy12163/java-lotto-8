package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

import java.util.*;

import static lotto.Config.GameConfig.END_EXCLUSIVE;
import static lotto.Config.GameConfig.START_INCLUSIVE;


public class InputView {

    public static Integer purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawPurchasePrice = Console.readLine();
        validatePurchasePrice(rawPurchasePrice);
        return Integer.parseInt(rawPurchasePrice);
    }

    public static List<Integer> lotteryWinningNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String rawLotteryWinningNum = Console.readLine();
        List<String> SplitNumString = Arrays.asList(rawLotteryWinningNum.trim().split(","));
        List<Integer> list = validateLotteryWinningNum(SplitNumString);
        return list;
    }

    public static Integer BonusNumber(List<Integer> lotteryWinningNum) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        Integer bonusNum = validateBonusNumber(Console.readLine(), lotteryWinningNum);
        return bonusNum;
    }

    private static void validatePurchasePrice(String rawPurchasePrice) {

        if (isEmptyInput(rawPurchasePrice)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }

        int price = PurchasePriceStringToInt(rawPurchasePrice);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.ODD_INPUT.getMessage());
        }
        if(price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXTRA_CHANGE.getMessage());
        }
    }

    private static boolean isEmptyInput(String raw) {
        return raw == null || raw.trim().isEmpty();
    }

    private static int PurchasePriceStringToInt(String raw) {
        try {
            isValueInRangeOfInt(raw);
            return Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_PURCHASE_NUM.getMessage());
        }
    }
    private static void isValueInRangeOfInt(String raw) {
        long parsedLong = Long.parseLong(raw);
        if(parsedLong > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_INT_RANGE.getMessage());
        }
    }


    private static List<Integer> validateLotteryWinningNum(List<String> SplitNumString) {

        List<Integer> lotteryWinningNum = new ArrayList<>();

        for(String splitNumString : SplitNumString) {
            lotteryWinningNum.add(WinningNumStringToInt(splitNumString));
        }
        return lotteryWinningNum;
    };

    private static Integer WinningNumStringToInt(String number) {
        try {
            int winnningNum = Integer.parseInt(number);
            return winnningNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTONUM_ERROR.getMessage());
        }
    }


    private static Integer validateBonusNumber(String number, List<Integer> lotteryWinningNum) {

        if (isEmptyInput(number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }

        int num = BonusNumStringToInt(number);
        if (!LotteryNumRange(num)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_RANGE.getMessage());
        }
        if(lotteryWinningNum.contains(num)) {
            throw new IllegalArgumentException(ErrorMessage.EXISTNUM_IN_LOTTO.getMessage());
        }
        return num;
    }

    private static int BonusNumStringToInt(String raw) {
        try {
            isValueInRangeOfInt(raw);
            return Integer.parseInt(raw);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_BONUS_NUM.getMessage());
        }
    }

    private static boolean LotteryNumRange(int num) {
        if(num < START_INCLUSIVE || num > END_EXCLUSIVE) {
            return false;
        }
        return true;
    }
}