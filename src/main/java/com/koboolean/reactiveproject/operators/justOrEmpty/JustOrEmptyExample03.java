package com.koboolean.reactiveproject.operators.justOrEmpty;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
public class JustOrEmptyExample03 {
    public static void main(String[] args) {
        Mono.justOrEmpty(Optional.ofNullable(null)).log().subscribe(v -> log.info("Data : {}", v));
    }
}
