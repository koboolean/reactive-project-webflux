package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.then;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class thenExample02 {
    public static void main(String[] args) throws InterruptedException {
        restartApplicationServer()
                .then()
                .subscribe(
                        v -> log.info("Data : {}",v),
                        e -> log.error("Error : {}", e),
                        () -> log.info("Send an email to Administrator: Application Server is restarted successfully")
                );

        Thread.sleep(3000L);
    }

    private static Mono<Void> restartApplicationServer() {
        return Mono
                .just("Application Server was restarted successfully.")
                .delayElement(Duration.ofSeconds(2))
                .doOnNext(log::info)
                .flatMap(notUse -> Mono.empty());
    }
}
