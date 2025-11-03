package lotto.View;

import lotto.Model.CalculateLottoResult;
import lotto.Model.CalculateReturnRate;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.ResultFormat;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void myLottoPrint(Integer lottoAmount, List<Lotto> lottos) {
        System.out.println("\n" + lottoAmount + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static Long printResultLottoAndCalculateTotalInput(List<LottoResult> resultLottos) {
        System.out.println("\n당첨 통계\n---");
        CalculateLottoResult LottoResult = new CalculateLottoResult(resultLottos);
        Map<ResultFormat, Long> lottoResultMap = LottoResult.calculateLottoResult();
        long totalInput = 0;
        List<ResultFormat> resultToPrint = ResultFormatList();
        for (ResultFormat result : resultToPrint) {
            Long count = lottoResultMap.getOrDefault(result, 0L);
            System.out.printf("%s - %d개\n", result.getMessage(), count);
            totalInput += count * result.getMoney();
        }
        return totalInput;

    }

    public static void printInputRate(long price, long totalInput) {
        CalculateReturnRate calculateReturnRate = new CalculateReturnRate(price, totalInput);
        double rate = calculateReturnRate.calculate();
        System.out.printf("수익률은 %.2f%%입니다.\n", rate);
    }

    private static List<ResultFormat> ResultFormatList() {
        return List.of(
                ResultFormat.FIFTH,
                ResultFormat.FOURTH,
                ResultFormat.THIRD,
                ResultFormat.SECOND,
                ResultFormat.FIRST
        );
    }

}
