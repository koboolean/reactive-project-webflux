package com.koboolean.reactiveproject.testing;

import com.koboolean.reactiveproject.basic.testing.TimebasedExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

public class TimeBasedTestExample01 {
    @Test
    public void getCOVID19CountTest() {
        StepVerifier
                .withVirtualTime(() -> TimebasedExample.getCOVID19Count(
                                Flux.interval(Duration.ofHours(12)).take(1)
                        )
                )
                .expectSubscription()
                .then(() -> VirtualTimeScheduler.get().advanceTimeBy(Duration.ofHours(12)))
                .expectNextCount(11)
                .expectComplete()
                .verify();
    }
}
