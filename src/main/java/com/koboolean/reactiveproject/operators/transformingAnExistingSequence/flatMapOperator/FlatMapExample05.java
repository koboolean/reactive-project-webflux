package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.flatMapOperator;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class FlatMapExample05 {
    public static void main(String[] args) {
        Flux
                .just("Hello", "World")
                .map(Mono::just)
                .flatMap(word -> word)
                .subscribe(v -> log.info("Data : {}", v));
    }
}
