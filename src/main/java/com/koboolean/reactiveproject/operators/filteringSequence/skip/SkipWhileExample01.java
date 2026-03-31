package com.koboolean.reactiveproject.operators.filteringSequence.skip;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class SkipWhileExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .skipWhile(tuple -> tuple.getT2() < 10_000_000)
                .subscribe(tuple -> log.info("Data : {} , {}", tuple.getT1(), tuple.getT2()));
    }
}
