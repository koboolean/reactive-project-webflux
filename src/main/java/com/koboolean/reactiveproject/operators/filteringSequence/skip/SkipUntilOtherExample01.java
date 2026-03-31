package com.koboolean.reactiveproject.operators.filteringSequence.skip;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.Flow;

@Slf4j
public class SkipUntilOtherExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofSeconds(1))
                .skipUntilOther(doSomeTask())
                .subscribe(d -> log.info("Data : {}", d));

        Thread.sleep(4000);
    }

    private static Publisher<?> doSomeTask() {
        return Mono.empty().delay(Duration.ofMillis(2500));
    }
}
