package lotto.View;

import lotto.Model.CalculateLottoResult;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.ResultFormat;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.ResultFormat.CalculateResult;

public class OutputView {
    public static void myLottoPrint(Integer lottoAmount, List<Lotto> lottos) {
        System.out.println(lottoAmount + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void resultLottoPrint(List<LottoResult> resultLottos) {

        System.out.println("당첨 통계");
        System.out.println("---");
        CalculateLottoResult LottoResult = new CalculateLottoResult(resultLottos);

        Map<ResultFormat, Long> lottoResultMap = LottoResult.calculateLottoResult();

        List<ResultFormat> resultToPrint = List.of(
                ResultFormat.FIFTH,
                ResultFormat.FOURTH,
                ResultFormat.THIRD,
                ResultFormat.SECOND,
                ResultFormat.FIRST
        );
        for (ResultFormat result : resultToPrint) {
            Long count = lottoResultMap.getOrDefault(result, 0L);
            System.out.printf("%s - %d개\n", result.getMessage(), count);
        }
    }

}
