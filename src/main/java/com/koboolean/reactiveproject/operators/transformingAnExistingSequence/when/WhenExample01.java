package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.when;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class WhenExample01 {

    public static void main(String[] args) throws InterruptedException {
        Mono
                .when(
                        Flux
                                .just("Hi", "Tom")
                                .delayElements(Duration.ofSeconds(2))
                                .doOnNext(log::info),
                        Flux
                                .just("Hello", "David")
                                .delayElements(Duration.ofSeconds(1))
                                .doOnNext(log::info)
                )
                .subscribe(
                        v -> log.info("Value : {}", v),
                        e -> log.error("Error : {}", e),
                        () -> log.info("Complete")
                );

        Thread.sleep(5000);
    }
}
