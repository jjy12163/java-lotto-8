package lotto.Model;

import lotto.Config.ResultFormat;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static lotto.Config.ResultFormat.*;

public class CalculateLottoResult {

    private final List<LottoResult> resultLottos;

    public CalculateLottoResult(List<LottoResult> resultLottos) {
        this.resultLottos = resultLottos;
    }

    public Map<ResultFormat, Long> calculateLottoResult() {
        List<ResultFormat> resultFormats = new ArrayList<>();     // { FIRST, FIRST, SECOND }

        for(LottoResult lottoResult : resultLottos) {
            ResultFormat resultFormat = CalculateResult(lottoResult.sameNumCount(), lottoResult.isBonus());
            resultFormats.add(resultFormat);
        }

        return resultFormats.stream()
                .collect(Collectors.groupingBy(
                        result -> result,
                        () -> new EnumMap<>(ResultFormat.class),
                        Collectors.counting()
                ));
    }


}
