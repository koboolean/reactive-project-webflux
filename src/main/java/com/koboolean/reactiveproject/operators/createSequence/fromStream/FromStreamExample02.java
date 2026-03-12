package com.koboolean.reactiveproject.operators.createSequence.fromStream;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class FromStreamExample02 {
    public static void main(String[] args) {
        Flux
                .fromStream(SampleData.coinNames.stream())
                .filter(coin -> coin.equals("BTC") || coin.equals("ETC"))
                .subscribe(log::info);
    }
}
