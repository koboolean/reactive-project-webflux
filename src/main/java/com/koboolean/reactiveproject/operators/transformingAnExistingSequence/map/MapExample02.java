package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.map;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class MapExample02 {

    public static void main(String[] args) {
        final double buyPrice = 40_000_000;
        Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .filter(tuple -> tuple.getT1() == 2021)
                .doOnNext(d -> log.info("Data : {}, {}", d.getT1(), d.getT2()))
                .map(tuple -> calculateProfitRate(buyPrice, tuple.getT2()))
                .subscribe(result -> log.info(result + "%"));
    }

    private static double calculateProfitRate(double buyPrice, long topPrice) {
        return (topPrice - buyPrice) / buyPrice * 100;
    }
}
