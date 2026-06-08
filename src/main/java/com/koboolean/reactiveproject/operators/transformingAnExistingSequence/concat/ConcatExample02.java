package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.concat;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class ConcatExample02 {

    public static void main(String[] args) {
        List<Flux<Integer>> sources = List.of(Flux.just(1, 2, 3), Flux.just(4, 5, 6));

        Flux
                .concat(sources)
                .subscribe(v -> log.info("Data : {}", v));
    }
}
