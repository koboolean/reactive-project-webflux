package com.koboolean.reactiveproject.operators.fromIterable;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FromIterableExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coinNames)
                .subscribe(log::info);
    }
}
