package com.koboolean.reactiveproject.basic.context;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ContextFeatureExample01 {
    public static void main(String[] args) throws InterruptedException {
        String key1 = "id";

        Mono<String> mono = Mono.deferContextual(ctx ->
                        Mono.just("ID: " + " " + ctx.get(key1))
                )
                .publishOn(Schedulers.parallel());


        mono.contextWrite(context -> context.put(key1, "itVillage"))
                .subscribe(data -> log.info("subscriber 1 {}", data));

        mono.contextWrite(context -> context.put(key1, "itWorld"))
                .subscribe(data -> log.info("subscriber 2 {}", data));

        Thread.sleep(100L);
    }
}
