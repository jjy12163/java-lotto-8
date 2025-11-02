package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.Config.gameConfig.*;

public class RandomNumberGenerater {

    public static List<Integer> randomNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_EXCLUSIVE, COUNT);
        return numbers;
    }
}
