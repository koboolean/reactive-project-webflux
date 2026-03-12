package com.koboolean.reactiveproject.operators.createSequence.defer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
public class DeferExample02 {
    public static void main(String[] args) throws InterruptedException {
        log.info("# Start");
        Mono
                .just("Hello")
                .delayElement(Duration.ofSeconds(2))
                .switchIfEmpty(sayDefault())
                .subscribe(log::info);

        Thread.sleep(2500);
    }

    private static Mono<String> sayDefault() {
        log.info("# Say Hi");
        return Mono.just("Hi");
    }
}
