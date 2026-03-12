package com.koboolean.reactiveproject.operators.createSequence.defer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class DeferExample04 {
    public static void main(String[] args) throws InterruptedException {
        log.info("# Start");
        Mono<Object> mono =
                Mono
                        .empty()
                        .switchIfEmpty(Mono.defer(DeferExample04::sayDefault));

        Thread.sleep(3000);
        mono.subscribe(v -> log.info("Data : {}", v));
    }

    private static Mono<String> sayDefault() {
        log.info("# Say Hi");
        return Mono.just("Hi");
    }
}
