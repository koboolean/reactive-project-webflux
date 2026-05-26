package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.flatMapOperator.flatMapMany;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

@Slf4j
public class FlatMapManyExample {
    private static final int BUY_PRICE = 500;
    private static final int INVESTMENT_AMOUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        Mono
                .just(Tuples.of(BUY_PRICE, INVESTMENT_AMOUNT))
                .flatMapMany(FlatMapManyExample::calculateMaxProfitPerYear)
                .subscribe(v -> log.info("Data : {}", v));

        Thread.sleep(200L);
    }

    private static Flux<Long> calculateMaxProfitPerYear(Tuple2<Integer, Integer> buyInfo) {
        return Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .map(btcInfo -> btcInfo.getT2() * buyInfo.getT2() / buyInfo.getT1() - buyInfo.getT2());
    }
}
