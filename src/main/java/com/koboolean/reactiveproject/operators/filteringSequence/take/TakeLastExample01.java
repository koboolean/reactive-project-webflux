package com.koboolean.reactiveproject.operators.filteringSequence.take;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class TakeLastExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .takeLast(2)
                .subscribe(tuple -> log.info("Data : {} {}", tuple.getT1(), tuple.getT2()));
    }
}
