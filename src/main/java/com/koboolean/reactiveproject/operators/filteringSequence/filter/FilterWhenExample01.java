package com.koboolean.reactiveproject.operators.filteringSequence.filter;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import static com.koboolean.reactiveproject.operators.exam.CoronaVaccineService.isGreaterThan;

@Slf4j
public class FilterWhenExample01 {

    public static void main(String[] args) throws InterruptedException {
        Flux
                .fromIterable(SampleData.coronaVaccineNames)
                .filterWhen(vaccine -> isGreaterThan(vaccine, 3_000_000))
                .subscribe(v -> log.info("Value : {}", v));

        Thread.sleep(1000);
    }
}
