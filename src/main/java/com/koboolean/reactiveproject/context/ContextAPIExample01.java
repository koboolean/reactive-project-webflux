package com.koboolean.reactiveproject.context;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;

@Slf4j
public class ContextAPIExample01 {
    public static void main(String[] args) throws InterruptedException {
        String key1 = "id";
        String key2 = "name";
        Mono<String> mono =
                Mono.deferContextual(ctx ->
                                Mono.just("ID: " + " " + ctx.get(key1) + ", " + "Name: " + ctx.get(key2))
                        )
                        .publishOn(Schedulers.parallel())
                        .contextWrite(Context.of(key1, "itVillage", key2, "Kevin"));


        mono.subscribe(log::info);

        Thread.sleep(100L);
    }
}
