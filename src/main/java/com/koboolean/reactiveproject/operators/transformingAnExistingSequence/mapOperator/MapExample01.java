package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.mapOperator;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class MapExample01 {
    public static void main(String[] args) {
        Flux.just("Green-Circle", "Yellow-Circle", "Blue-Circle")
                .map(c -> c.replace("Circle", "Rectangle"))
                .subscribe(log::info);
    }
}
