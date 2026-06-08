package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.zip;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class ZipExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .zip(
                        Flux.just(1, 2, 3).delayElements(Duration.ofMillis(300L)),
                        Flux.just(4, 5, 6).delayElements(Duration.ofMillis(500L))
                )
                .subscribe(tuple2 -> log.info("Data : {}, {}", tuple2.getT1(), tuple2.getT2()));

        Thread.sleep(2500L);
    }
}
