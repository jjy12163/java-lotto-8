package lotto.View;

import lotto.Model.CalculateLottoResult;
import lotto.Model.Lotto;
import lotto.Model.LottoResult;
import lotto.Config.ResultFormat;

import javax.xml.transform.Result;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.Config.GameConfig.ERROR_FORMAT;

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

    public static void printInputRate(long price, long ResultMoney) {
        if(ResultMoney == 0) {
            System.out.println("총 수익률은 " + 0 + "%입니다.");
            return;
        }
        double rate = (double) ResultMoney / price * 100.0;
        DecimalFormat df = new DecimalFormat("0.##");
        System.out.println("총 수익률은 " + df.format(rate) + "%입니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_FORMAT + errorMessage);

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
