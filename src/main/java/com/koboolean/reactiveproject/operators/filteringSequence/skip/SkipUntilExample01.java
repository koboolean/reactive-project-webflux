package com.koboolean.reactiveproject.operators.filteringSequence.skip;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class SkipUntilExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .skipUntil(t -> t.getT1() > 2016)
                .subscribe(tuple -> log.info("Data {} : {}", tuple.getT1(), tuple.getT2()));
    }
}
