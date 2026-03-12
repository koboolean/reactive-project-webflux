package com.koboolean.reactiveproject.operators.createSequence.range;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.util.List;

@Slf4j
public class RangeExample02 {
    public static void main(String[] args) {
        List<String> coinNames = SampleData.coinNames;

        Flux
                .range(0, coinNames.size())
                .subscribe(index -> log.info(coinNames.get(index)));
    }
}
