package com.koboolean.reactiveproject.testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

public class TimeBasedTestExample02 {
    @Test
    public void getCOVID19CountTest() {
        StepVerifier
                .withVirtualTime(() -> TimebasedExample.getCOVID19Count(
                                Flux.interval(Duration.ofHours(12)).take(1)
                        )
                )
                .expectSubscription()
                .thenAwait(Duration.ofHours(12))
                .expectNextCount(11)
                .expectComplete()
                .verify();

    }
}
