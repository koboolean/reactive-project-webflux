package com.koboolean.reactiveproject.operators.createSequence.defer;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
public class DeferExample01 {
    public static void main(String[] args) throws InterruptedException {
        log.info("# Starting");

        Mono<LocalDateTime> justMono = Mono.just(LocalDateTime.now());
        Mono<LocalDateTime> deferMono = Mono.defer(() -> Mono.just(LocalDateTime.now()));

        Thread.sleep(2000);

        justMono.subscribe(data -> log.info("just1 {}", data));
        deferMono.subscribe(data -> log.info("defer1 {}", data));

        Thread.sleep(2000);

        justMono.subscribe(data -> log.info("just2 {}", data));
        deferMono.subscribe(data -> log.info("defer2 {}", data));
    }
}
