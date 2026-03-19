package com.koboolean.reactiveproject.operators.filteringSequence.filter;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FilterExample01 {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .filter(num -> num % 2 == 0)
                .subscribe(v -> log.info("Value : {}", v));
    }
}
