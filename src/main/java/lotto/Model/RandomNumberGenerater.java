package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Config.GameConfig.*;

public class RandomNumberGenerater {

    public static List<Integer> randomNumber() {
        List<Integer> RandomNumbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_EXCLUSIVE, COUNT);
        List<Integer> numbers = new ArrayList<>(RandomNumbers);
        Collections.sort(numbers);
        return numbers;
    }
}
