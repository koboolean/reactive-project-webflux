package com.koboolean.reactiveproject.context;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ContextFeatureExample03 {
    public static void main(String[] args) throws InterruptedException {
        String key1 = "id";

        Mono.deferContextual(ctx ->
                        Mono.just("ID: " + " " + ctx.get(key1))
                )
                .publishOn(Schedulers.parallel())
                .contextWrite(context -> context.put(key1, "itWorld"))
                .contextWrite(context -> context.put(key1, "itVillage"))
                .subscribe(log::info);

        Thread.sleep(100L);
    }
}
