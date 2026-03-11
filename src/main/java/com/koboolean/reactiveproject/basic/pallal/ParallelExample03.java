package com.koboolean.reactiveproject.basic.pallal;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ParallelExample03 {
    public static void main(String[] args) throws InterruptedException {
        Flux.fromArray(new Integer[]{1, 3, 5, 7, 9, 11, 13, 15, 14, 23})
                .parallel()
                .runOn(Schedulers.parallel())
                .subscribe(val -> log.info("Value is {}", val));

        Thread.sleep(100L);
    }
}
