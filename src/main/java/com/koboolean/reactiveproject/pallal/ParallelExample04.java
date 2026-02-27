package com.koboolean.reactiveproject.pallal;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ParallelExample04 {
    public static void main(String[] args) throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 14, 23})
                .parallel(4)
                .runOn(Schedulers.parallel())
                .subscribe(val -> log.info("Value is {}", val));

        Thread.sleep(100L);
    }
}
