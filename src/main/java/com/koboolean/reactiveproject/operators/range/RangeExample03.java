package com.koboolean.reactiveproject.operators.range;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class RangeExample03 {
    public static void main(String[] args) {
        Flux
                .range(7, 5)
                .map(SampleData.btcTopPricesPerYear::get)
                .subscribe(tuple -> log.info("{} 's: {}", tuple.getT1(), tuple.getT2()));
    }
}
