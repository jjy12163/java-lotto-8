package lotto;

public enum ErrorMessage {
    INPUT_BLANK("빈 값이 입력되었습니다."),
    NOT_PURCHASE_NUM("구입 금액은 숫자로 입력해 주세요."),
    OUT_OF_INT_RANGE("정수 최대값(2,147,483,647) 까지만 입력 가능합니다."),
    ODD_INPUT("구입 금액은 양의 정수로 입력해 주세요."),
    EXTRA_CHANGE("1000원 단위로 입력해 주세요."),

    LOTTONUM_ERROR(" 로또 번호는 쉼표(,)로 구분된 숫자로 입력해 주세요."),
    NOT_SIX_NUM("숫자는 6개를 입력해 주셔야 합니다."),
    DOUBLE_NUM("중복 없이 입력해 주세요."),
    OUT_OF_LOTTO_RANGE("1이상 45이하의 값만 입력해 주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
