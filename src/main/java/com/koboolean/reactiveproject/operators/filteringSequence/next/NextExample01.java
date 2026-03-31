package com.koboolean.reactiveproject.operators.filteringSequence.next;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class NextExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .doOnNext(data -> log.info("doOnNext : {}", data))
                .filter(tuple -> tuple.getT1() >= 2015)
                .next()
                .subscribe(tuple -> log.info("Data : {} , {}", tuple.getT1(), tuple.getT2()));
    }
}
