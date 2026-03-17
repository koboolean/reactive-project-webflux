package com.koboolean.reactiveproject.operators.createSequence.create;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Slf4j
public class CreateExample03 {
    public static int start = 1;
    public static int end = 4 ;

    public static void main(String[] args) throws InterruptedException {
        Flux.create((FluxSink<Integer> emitter) -> {
                    emitter.onRequest(n -> {
                        log.info("# requested: " + n);
                        try {
                            Thread.sleep(500L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        for (int i = start; i <= end; i++) {
                            emitter.next(i);
                        }
                        start += 4;
                        end += 4;
                    });

                    emitter.onDispose(() -> {
                        log.info("# clean up");
                    });
                }, FluxSink.OverflowStrategy.DROP)
                .subscribeOn(Schedulers.boundedElastic())
                .publishOn(Schedulers.parallel(), 2)
                .subscribe(data -> {
                    log.info("Data : {}", data);
                });

        Thread.sleep(3000L);
    }
}
