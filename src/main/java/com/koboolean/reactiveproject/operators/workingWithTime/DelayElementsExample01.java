package com.koboolean.reactiveproject.operators.workingWithTime;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class DelayElementsExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(1, 10)
                .doOnNext(num -> log.info("doOnNext : {}", num))
                .delayElements(Duration.ofMillis(500))
                .subscribe(v -> log.info("Subscribe : {}", v));

        Thread.sleep(6000);
    }
}
