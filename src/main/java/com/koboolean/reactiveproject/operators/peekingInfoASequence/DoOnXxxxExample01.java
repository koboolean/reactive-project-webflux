package com.koboolean.reactiveproject.operators.peekingInfoASequence;

import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

@Slf4j
public class DoOnXxxxExample01 {
    public static void main(String[] args) {
        Flux
                .range(1, 5)
                .doFinally(signalType -> log.info("doFinally() > range"))
                .doOnNext(data -> log.info("range", data))
                .doOnRequest(n -> log.info("doOnRequest > range: {}", 1))
                .doOnSubscribe(subscription -> log.info("doOnSubscribe() > range"))
                .doFirst(() -> log.info("doFirst() > range"))
                .doOnComplete(() -> log.info("doOnComplete() > range"))
                .filter(num -> num % 2 == 1)
                .doOnNext(data -> log.info("filter", data))
                .doOnRequest(n -> log.info("doOnRequest > filter: {}", 1))
                .doOnSubscribe(subscription -> log.info("doOnSubscribe() > filter"))
                .doFinally(signalType -> log.info("doFinally() > filter"))
                .doOnComplete(() -> log.info("doOnComplete() > filter"))
                .doFirst(() -> log.info("doFirst() > filter"))
                .subscribe(new BaseSubscriber<>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        log.info("# hookOnNext: {}", value);
                        request(1);
                    }
                });
    }

}
