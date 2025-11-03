package lotto.Model;

import lotto.ErrorMessage;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.sort;
import static lotto.Config.GameConfig.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUM.getMessage());
        }
        if (!doubleCount(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DOUBLE_NUM.getMessage());
        }
        if(!LotteryNumRange(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_LOTTO_RANGE.getMessage());
        }

    }

    private boolean doubleCount(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() == COUNT;
    }

    private static boolean LotteryNumRange(List<Integer> numbers) {
        for (Integer num : numbers) {
            if(num < START_INCLUSIVE || num > END_EXCLUSIVE) {
                return false;
            }
        }
        return true;
    }


}
