package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.collect;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class CollectListExample01 {

    public static void main(String[] args) {
        Flux.just("...", "---", "...")
                .map(CollectListExample01::transformMorseCode)
                .collectList()
                .subscribe(list -> log.info(String.join("", list)));
    }

    public static String transformMorseCode(String morseCode) {
        return SampleData.morseCodeMap.get(morseCode);
    }
}
