package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.and;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class AndExample01 {

    public static void main(String[] args) throws InterruptedException {
        Mono.just("Okay")
                .delayElement(Duration.ofSeconds(1))
                .doOnNext(log::info)
                .and(
                        Flux.just("Hi", "Tom")
                                .delayElements(Duration.ofSeconds(2))
                                .doOnNext(log::info)
                ).subscribe(
                        v -> {
                            log.info("Data : {}", v);
                            log.info("onComplete");
                        }
                );

        Thread.sleep(5000);
    }
}
