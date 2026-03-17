package com.koboolean.reactiveproject.operators.createSequence.using;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class UsingExample01 {

    public static void main(String[] args) {
        Mono.using(() -> "Resource",
            resource -> Mono.just(resource),
            resource -> log.info("Cleanup : {}", resource))
                .subscribe(log::info);
    }
}
