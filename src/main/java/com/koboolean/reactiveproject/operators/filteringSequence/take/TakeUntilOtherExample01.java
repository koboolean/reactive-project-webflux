package com.koboolean.reactiveproject.operators.filteringSequence.take;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class TakeUntilOtherExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(300))
                .takeUntilOther(doSomeTask())
                .subscribe(d -> log.info("Data : {}", d));

        Thread.sleep(2000);
    }

    private static Publisher<?> doSomeTask() {
        return Mono.empty().delay(Duration.ofSeconds(1));
    }
}
