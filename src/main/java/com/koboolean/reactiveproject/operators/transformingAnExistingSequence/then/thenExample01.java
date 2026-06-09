package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.then;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class thenExample01 {
    public static void main(String[] args) throws InterruptedException {
        Mono
                .just("Hi")
                .delayElement(Duration.ofSeconds(1))
                .doOnNext(log::info)
                .then()
                .subscribe(
                        v -> log.info("Data : {}",v),
                        e -> log.error("Error : {}", e),
                        () -> log.info("Complete")
                );

        Thread.sleep(1500);
    }
}
