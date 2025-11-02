package lotto.Controller;

import lotto.Model.MyLotto;

public class LottoController {

    public static final Integer LottoPrice = 1000;

    private final Integer price;


    public LottoController(Integer price) {
        this.price = price;
    }

    public void run() {
        int lottoAmount = LottoAmount(price);
        MyLotto myLotto = new MyLotto(lottoAmount);
        myLotto.buy();

    }


    private static int LottoAmount(int price) {
        return price / LottoPrice;
    }




}
