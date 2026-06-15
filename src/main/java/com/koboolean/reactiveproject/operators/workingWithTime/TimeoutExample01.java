package com.koboolean.reactiveproject.operators.workingWithTime;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
public class TimeoutExample01 {
    public static void main(String[] args) throws InterruptedException {
        requestToServer()
                .timeout(Duration.ofSeconds(2))
                .subscribe(log::info,
                        error -> log.error("Error : {}", error));

        Thread.sleep(3500);
    }

    private static Mono<String> requestToServer() {
        return Mono.just("complete to process request from client successfully")
                .delayElement(Duration.ofSeconds(3));
    }
}
