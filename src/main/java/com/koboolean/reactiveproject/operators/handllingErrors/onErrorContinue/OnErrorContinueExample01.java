package com.koboolean.reactiveproject.operators.handllingErrors.onErrorContinue;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class OnErrorContinueExample01 {

    public static void main(String[] args) {
        Flux
                .just(1, 2, 4, 0, 6, 12)
                .map(num -> 12 / num)
                .onErrorContinue((error, num) -> log.error("error: {}, num: {}", error, num))
                .subscribe(v -> log.info("Data : {}", v),
                        e -> log.error("Error ", e));
    }

}
