package com.koboolean.reactiveproject.operators.createSequence.create;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class CreateExample01 {
    public static int SIZE = 0;
    public static int COUNT = -1;
    private static List<Integer> dataSource =
            Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        log.info("# start");
        Flux.create((FluxSink<Integer> emitter) -> {
            emitter.onRequest(n -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for (int i = 0; i < n; i++) {
                    if (COUNT >= 9) {
                        emitter.complete();
                    } else {
                        COUNT++;
                        emitter.next(dataSource.get(COUNT));
                    }
                }
            });

            emitter.onDispose(() -> log.info("# clean up"));
        }).subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(2);
            }

            @Override
            protected void hookOnNext(Integer value) {
                SIZE++;
                log.info("Value : {}" , value);
                if (SIZE == 2) {
                    request(2);
                    SIZE = 0;
                }
            }

            @Override
            protected void hookOnComplete() {
                log.info("# onComplete");
            }
        });
    }

}
