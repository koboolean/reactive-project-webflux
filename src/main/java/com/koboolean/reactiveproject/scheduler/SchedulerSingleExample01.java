package com.koboolean.reactiveproject.scheduler;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@Slf4j
public class SchedulerSingleExample01 {
    public static void main(String[] args) throws InterruptedException {

        doTask("task1")
                .subscribe(data -> log.info(data.toString()));

        doTask("task2")
                .subscribe(data -> log.info(data.toString()));

        Thread.sleep(500L);
    }

    private static Flux<Integer> doTask(String task){
        return Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .publishOn(Schedulers.single())
                .filter(data -> data > 3)
                .doOnNext(data -> log.info("{} filter {}", task, data))
                .map(data -> data * 10)
                .doOnNext(data -> log.info("{} map {}", task, data));
    }
}
