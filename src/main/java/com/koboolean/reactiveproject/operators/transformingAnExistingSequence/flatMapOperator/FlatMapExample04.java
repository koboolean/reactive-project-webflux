package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.flatMapOperator;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Slf4j
public class FlatMapExample04 {
    private static final int BUY_PRICE = 500;
    private static final int INVESTMENT_AMOUNT = 1000;

    public static void main(String[] args) {
        Flux
                .just(Tuples.of(BUY_PRICE, INVESTMENT_AMOUNT))
                .flatMap(FlatMapExample04::calculateMaxProfitPerYear)
                .subscribe(v -> log.info("Data : {}", v));
    }

    private static Flux<Long> calculateMaxProfitPerYear(Tuple2<Integer, Integer> buyInfo) {
        return Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .map(btcInfo -> btcInfo.getT2() * buyInfo.getT2() / buyInfo.getT1() - buyInfo.getT2());
    }
}
