package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.concat;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class ConcatExample01 {

    public static void main(String[] args) {
        Flux.concat(Flux.just(1,2,3), Flux.just(4,5))
                .subscribe(v -> log.info("Data : {}", v));
    }
}
