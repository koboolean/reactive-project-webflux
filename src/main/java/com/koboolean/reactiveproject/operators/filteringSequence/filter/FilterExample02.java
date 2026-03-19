package com.koboolean.reactiveproject.operators.filteringSequence.filter;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FilterExample02 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .filter(tuple -> tuple.getT2() > 10_000_000)
                .subscribe(filtered -> log.info("Data : {} : {}", filtered.getT1(),filtered.getT2()));
    }
}
