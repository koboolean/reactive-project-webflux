package com.koboolean.reactiveproject.operators.createSequence.justOrEmpty;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class JustOrEmptyExample02 {
    public static void main(String[] args) {
        Mono.justOrEmpty(null).log().subscribe(v -> log.info("Data : {}", v));
    }
}
