package com.koboolean.reactiveproject.operators.createSequence.generate;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Map;

@Slf4j
public class GenerateExample03 {
    public static void main(String[] args) {
        Map<Integer, Tuple2<Integer, Long>> map = SampleData.getBtcTopPricesPerYearMap();
        Flux
                .generate(() -> 2017, (state, sink) -> {
                    if (state > 2021) {
                        sink.complete();
                    } else {
                        sink.next(map.get(state));
                    }

                    return ++state;
                })
                .subscribe(v -> log.info("Value : {}", v));
    }
}
