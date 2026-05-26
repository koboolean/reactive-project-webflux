package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.flatMapIterable;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.List;

@Slf4j
public class FlatMapIterableExample {
    public static void main(String[] args) {
        Flux.just(getViralVectorVaccines(), getmRNAVaccines(), getSubunitVaccines())
                .flatMapIterable(vaccines -> vaccines)
                .subscribe(v -> log.info("Data : {}, {}", v.getT1(), v.getT2()));
    }

    private static List<Tuple2<SampleData.CoronaVaccine, Integer>> getViralVectorVaccines() {
        return SampleData.viralVectorVaccines;
    }

    private static List<Tuple2<SampleData.CoronaVaccine, Integer>> getmRNAVaccines() {
        return SampleData.mRNAVaccines;
    }

    private static List<Tuple2<SampleData.CoronaVaccine, Integer>> getSubunitVaccines() {
        return SampleData.subunitVaccines;
    }
}
