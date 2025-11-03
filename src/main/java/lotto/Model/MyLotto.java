package lotto.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Config.GameConfig.BONUSBALL_CHECKPOINT;
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

    public static List<LottoResult> resultLottos(List<Lotto> myLottos, List<Integer> lotteryWinningNum, Integer bonusNumber) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for(Lotto lotto : myLottos) {

            int count = count(lotto.getNumbers(), lotteryWinningNum);

            boolean hasBonus = bonus_checkpoint(count, lotteryWinningNum, bonusNumber);
            LottoResult lottoResult = new LottoResult(count, hasBonus);
            lottoResults.add(lottoResult);
        }
        return lottoResults;

    }
    private static Integer count(List<Integer> myLottoNumbers, List<Integer> lotteryWinningNum) {
        Set<Integer> lotteryWinningNumSet = new HashSet<>(myLottoNumbers);
        return (int) lotteryWinningNum.stream()
                .filter(lotteryWinningNumSet::contains)
                .count();
    }

    private static boolean bonus_checkpoint(int count, List<Integer> lotteryWinningNum, int bonusNumber) {
        return count == BONUSBALL_CHECKPOINT || lotteryWinningNum.contains(bonusNumber);
    }

}
