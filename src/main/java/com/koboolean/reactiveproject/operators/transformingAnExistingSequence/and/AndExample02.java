package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.and;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class AndExample02 {
    public static void main(String[] args) throws InterruptedException {
        restartApplicationServer()
                .and(restartDBServer())
                .subscribe(
                v -> log.info("Data : {}", v),
                e -> log.error("Error : {}", e),
                () -> log.info("Send an email to Administrator: All Servers are restarted successfully")
                );

        Thread.sleep(6000L);
    }

    private static Mono<String> restartApplicationServer() {
        return Mono
                .just("Application Server was restarted successfully.")
                .delayElement(Duration.ofSeconds(2))
                .doOnNext(log::info);
    }

    private static Publisher<String> restartDBServer() {
        return Mono
                .just("DB Server was restarted successfully.")
                .delayElement(Duration.ofSeconds(4))
                .doOnNext(v -> log.info("Data : {}",v));
    }
}
