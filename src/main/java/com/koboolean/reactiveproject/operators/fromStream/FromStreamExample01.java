package com.koboolean.reactiveproject.operators.fromStream;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux
                .fromStream(SampleData.coinNames.stream())
                .subscribe(log::info);
    }
}
