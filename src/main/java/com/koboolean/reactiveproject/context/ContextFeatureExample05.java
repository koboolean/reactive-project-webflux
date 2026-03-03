package com.koboolean.reactiveproject.context;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class ContextFeatureExample05 {
    public static void main(String[] args) throws InterruptedException {
        String key1 = "id";
        Mono.just("Kevin")
                .transformDeferredContextual((stringMono, contextView) -> contextView.get("job"))
                .flatMap(name -> Mono.deferContextual(ctx ->
                                Mono.just(ctx.get(key1) + ", " + name)
                                        .transformDeferredContextual((mono, innerCtx) ->
                                                mono.map(data -> data + ", " + innerCtx.get("job"))
                                        )
                                        .contextWrite(context -> context.put("job", "Software Engineer"))
                        )
                )
                .publishOn(Schedulers.parallel())
                .contextWrite(context -> context.put(key1, "itVillage"))
                .subscribe(log::info);

        Thread.sleep(100L);
    }
}
