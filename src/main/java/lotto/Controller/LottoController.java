package lotto.Controller;

import lotto.Model.Lotto;
import lotto.Model.MyLotto;
import lotto.View.OutputView;

import java.util.List;

public class LottoController {

    public static final Integer LottoPrice = 1000;

    private final Integer price;


    public LottoController(Integer price) {
        this.price = price;
    }

    public void run() {
        int lottoAmount = LottoAmount(price);
        MyLotto myLotto = new MyLotto();
        List<Lotto> lottos = myLotto.purchase(lottoAmount);

        OutputView.myLottoPrint(lottoAmount, lottos);
    }


    private static int LottoAmount(int price) {
        return price / LottoPrice;
    }




}
