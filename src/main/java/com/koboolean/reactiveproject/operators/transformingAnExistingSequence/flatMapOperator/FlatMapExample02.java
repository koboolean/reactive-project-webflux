package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.flatMapOperator;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FlatMapExample02 {
    public static void main(String[] args) {
        Flux
                .just(3)
                .flatMap(dan -> Flux.range(1, 9).map(n -> dan + " * " + n + " = " + dan * n))
                .subscribe(log::info);
    }
}
