package com.koboolean.reactiveproject.basic.debug;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

@Slf4j
public class DebugModeExample01 {
    public static void main(String[] args) {
        Hooks.onOperatorDebug();

        Flux.just(2, 4, 6, 8)
                .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x/y)
                .subscribe(a -> log.info("Data : {}", a), e -> log.error("Error : {}", e));
    }
}
