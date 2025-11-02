package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import static lotto.Model.RandomNumberGenerater.randomNumber;

public class MyLotto {

    public static List<Lotto> purchase(int lottoAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < lottoAmount; i++) {
            Lotto lotto = new Lotto(randomNumber());
            lottos.add(lotto);
        }
        return lottos;
    };

}
