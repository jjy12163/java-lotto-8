package lotto.View;

import lotto.Model.Lotto;
import lotto.Model.MyLotto;

import java.util.List;

public class OutputView {
    public static void myLottoPrint(Integer lottoAmount, List<Lotto> lottos) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

}
