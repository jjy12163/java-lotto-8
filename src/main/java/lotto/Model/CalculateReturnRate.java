package lotto.Model;

public class CalculateReturnRate {

    private final long price;
    private final long totalInput;

    public CalculateReturnRate(long price, long totalInput) {
        this.price = price;
        this.totalInput = totalInput;
    }

    public double calculate() {
        return (double) totalInput / price * 100;
    }



}
