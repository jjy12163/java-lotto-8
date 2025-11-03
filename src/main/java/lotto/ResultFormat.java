package lotto;

import lotto.Model.LottoResult;

import java.util.List;

public enum ResultFormat {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원)"),
    FOURTH(4, 50_000, "4개 일치 (50,000원)"),
    FIFTH(3, 5_000, "3개 일치 (5,000원)"),
    ZERO(0, 0, "당첨x");

    private final int count;
    private final int money;
    private final String message;

    ResultFormat(int count, int money, String message) {
        this.count = count;
        this.money = money;
        this.message = message;
    }

    public static ResultFormat CalculateResult(int count, boolean BonusBall) {

        if (count == FIRST.count) {
            return FIRST;
        }
        if (count == SECOND.count && BonusBall) {
            return SECOND;
        }
        if (count == THIRD.count) {
            return THIRD;
        }
        if (count == FOURTH.count) {
            return FOURTH;
        }
        if (count == FIFTH.count) {
            return FIFTH;
        }
        return ZERO;
    }

    public String getMessage() {
        return message;
    }
    public int getMoney() {
        return money;
    }


}
