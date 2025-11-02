package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.ErrorMessage;

import java.util.*;

import static lotto.Config.gameConfig.*;


public class InputView {

    public static Integer purchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawPurchasePrice = Console.readLine();
        return validatePurchasePrice(rawPurchasePrice);
    }

    public static List<Integer> lotteryWinningNum() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String rawLotteryWinningNum = Console.readLine();
        List<String> SplitNumString = Arrays.asList(rawLotteryWinningNum.trim().split(","));
        return validateLotteryWinningNum(SplitNumString);
    }

    public static Integer BonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNum = validateBonusNumber(Console.readLine());
        return bonusNum;
    }

    private static Integer validatePurchasePrice(String rawPurchasePrice) {

        if (isEmptyPurchasePrice(rawPurchasePrice)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }

        int price = PurchasePriceStringToInt(rawPurchasePrice);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessage.ODD_INPUT.getMessage());
        }
        if(price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.EXTRA_CHANGE.getMessage());
        }

        return price;
    }

    private static void isInputEmpty(String raw) {
        if(isEmptyPurchasePrice(raw)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK.getMessage());
        }
    }

    private static boolean isEmptyPurchasePrice(String raw) {
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












    private static List<Integer> stringToIntWinningNum(List<String> SplitNumString) {
        Set<Integer> set = new HashSet<>();
        List<Integer> lotteryWinningNum = new ArrayList<>();

        for(String splitNumString : SplitNumString) {
            int winningNum = WinningNumStringToInt(splitNumString);

            isInOfLotteryNumRange(winningNum);

            lotteryWinningNum.add(winningNum);
            set.add(winningNum);
        }
        if(set.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.DOUBLE_NUM.getMessage());
        }
        return lotteryWinningNum;
    }

    private static void isInOfLotteryNumRange(int winningNum) {
        if(LotteryNumRange(winningNum)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_RANGE.getMessage());
        }
    }




    private static Integer validateBonusNumber(String number) {


    }


}