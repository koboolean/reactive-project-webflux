package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.merge;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class MergeExample01 {

    public static void main(String[] args) throws InterruptedException {
        Flux.merge(
                Flux.just(1,2,3).delayElements(Duration.ofMillis(300L)),
        Flux.just(4,5,6).delayElements(Duration.ofMillis(500L))
        ).subscribe(v -> log.info("Data : {}", v));

        Thread.sleep(3500L);
    }
}
