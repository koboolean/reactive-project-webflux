package com.koboolean.reactiveproject.debug;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class CheckpointExample04 {
    public static void main(String[] args) {
        Flux.just(2, 4, 6, 8)
                .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x/y)
                .checkpoint("CheckpointExample02.zipWith.checkpoint", true)
                .map(num -> num + 2)
                .checkpoint("CheckpointExample02.map.checkpoint", true)
                .subscribe(v -> log.info("Value : {}" , v), e -> log.error("Error : {}", e));
    }
}
