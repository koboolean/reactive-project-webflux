package com.koboolean.reactiveproject.operators.filteringSequence.skip;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class SkipExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .interval(Duration.ofSeconds(1))
                .doOnNext(v -> log.info("Data : {}" , v))
                .skip(3)
                .subscribe(v -> log.info("Subscribe Data : {}", v));

        Thread.sleep(5000L);
    }
}
