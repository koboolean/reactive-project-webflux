package com.koboolean.reactiveproject.operators.peekingInfoASequence;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class DoAfterTerminateExample01 {
    public static void main(String[] args) {
        Flux
                .just("HI", "HELLO")
                .filter(data -> data.equals("HI"))
                .doOnTerminate(() -> log.info("doOnTerminate filter"))
                .doAfterTerminate(() -> log.info("doAfterTerminate filter"))
                .map(String::toLowerCase)
                .doOnTerminate(() -> log.info("doOnTerminate map"))
                .doAfterTerminate(() -> log.info("doAfterTerminate map"))
                .subscribe(
                        log::info,
                        error -> {},
                        () -> log.info("doOnComplete()"));
    }
}
