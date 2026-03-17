package com.koboolean.reactiveproject.operators.createSequence.generate;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class GenerateExample01 {
    public static void main(String[] args) {
        Flux
                .generate(() -> 0, (state, sink) -> {
                    sink.next(state);
                    if (state == 10)
                        sink.complete();
                    return ++state;
                })
                .subscribe(v -> log.info("Value : {}", v));
    }
}
