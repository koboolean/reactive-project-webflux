package com.koboolean.reactiveproject.operators.createSequence.range;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class RangeExample01 {
    public static void main(String[] args) {
        Flux.range(5, 10).subscribe(v -> log.info("Data : {}", v));
    }
}
