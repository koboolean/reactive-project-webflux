package com.koboolean.reactiveproject.operators.fromIterable;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FromIterableExample02 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coins)
                .subscribe(coin -> log.info("coin 명: {}, 현재가: {}", coin.getT1(), coin.getT2()));
    }
}
