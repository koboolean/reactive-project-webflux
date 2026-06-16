package com.koboolean.reactiveproject.operators.handllingErrors.retry;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Slf4j
public class RetryExample01 {
    public static void main(String[] args) throws InterruptedException {
        final int[] count = {1};
        Flux
                .range(1, 3)
                .delayElements(Duration.ofSeconds(1))
                .map(num -> {
                    if (num == 3 && count[0] == 1) {
                        count[0]++;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    return num;
                })
                .timeout(Duration.ofMillis(1500))
                .retry(1)
                .subscribe(v -> log.info("Data : {}", v),
                        e -> log.error("Error ", e),
                        () -> log.info("Finish "));

        Thread.sleep(7000);
    }
}
