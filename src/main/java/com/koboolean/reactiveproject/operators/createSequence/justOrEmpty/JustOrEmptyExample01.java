package com.koboolean.reactiveproject.operators.createSequence.justOrEmpty;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class JustOrEmptyExample01 {
    public static void main(String[] args) {
        Mono.just(null).log().subscribe(v -> log.info("Data : {}", v));
    }
}
