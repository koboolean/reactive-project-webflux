package com.koboolean.reactiveproject.operators.filteringSequence.take;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class TakeExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .doOnNext(d -> log.info("On Next Data : {}", d))
                .take(3)
                .subscribe(d -> log.info("Subscribe Data : {}", d));


        Thread.sleep(5000L);
    }
}
