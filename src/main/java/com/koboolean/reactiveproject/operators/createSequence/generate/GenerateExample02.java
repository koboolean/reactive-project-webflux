package com.koboolean.reactiveproject.operators.createSequence.generate;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuples;

@Slf4j
public class GenerateExample02 {
    public static void main(String[] args) {
        Flux
                .generate(() -> Tuples.of(2, 1), (state, sink) -> {
                    sink.next(state.getT1() + " * " + state.getT2() + " = " + state.getT1() * state.getT2());
                    if (state.getT2() == 9)
                        sink.complete();
                    return Tuples.of(state.getT1(), state.getT2() + 1);
                }, state -> log.info("# 구구단 {}단 종료!", state.getT1()))
                .subscribe(v -> log.info("Value : {}", v));
    }
}
