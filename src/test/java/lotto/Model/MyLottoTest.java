package lotto.Model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.Model.MyLotto.purchase;

public class MyLottoTest {

    @Test
    @DisplayName("입력된 lottAmount 수만큼 lotto가 발행되는지")
    public void purchaseTest() {
        int lottoAmount = 3;
        List<Lotto> lottos = purchase(lottoAmount);

        int expect = 3;
        Assertions.assertThat(lottos).hasSize(expect);
    }
//    @DisplayName("randomNumber가 6개의 숫자를 출력하는지 테스트")
//    @DisplayName("randomNumber가 1 이상의 숫자를 출력하는지 테스트")
//    @DisplayName("randomNumber가 45 이하의 숫자를 출력하는지 테스트")
}
