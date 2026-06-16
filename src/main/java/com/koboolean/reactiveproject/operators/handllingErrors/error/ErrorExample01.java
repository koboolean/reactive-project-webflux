package com.koboolean.reactiveproject.operators.handllingErrors.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class ErrorExample01 {

    public static void main(String[] args) {
        Flux.range(1, 5)
                .flatMap(num -> {
                    if((num * 2) % 3 == 0){
                        return Mono.error(new IllegalAccessException("Not Allowed multiplication of 3"));
                    }else{
                        return Mono.just(num * 2);
                    }
                }).subscribe(
                        v -> log.info("Success : {}", v)
                         , Throwable::printStackTrace
                );
    }
}
