package lotto;

public enum ErrorMessage {
    INPUT_BLANK("빈 값이 입력되었습니다."),
    NOT_NUMBER("구입 금액은 숫자로 입력해 주세요."),
    OUT_OF_INT_RANGE("정수 최대값(2,147,483,647) 까지만 입력 가능합니다."),
    ODD_INPUT("구입 금액은 양의 정수로 입력해 주세요."),
    EXTRA_CHANGE("1000원 단위로 입력해 주세요.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
