package com.koboolean.reactiveproject.operators.workingWithTime;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class DelaySubscriptionExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(1, 10)
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe > upstream"))
                .delaySubscription(Duration.ofSeconds(2))
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe > downstream"))
                .subscribe(v -> log.info("Value : {}", v));

        Thread.sleep(2500);
    }
}
