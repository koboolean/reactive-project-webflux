package com.koboolean.reactiveproject.operators.transformingAnExistingSequence.map;

import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class MapExample03 {
    public static void main(String[] args) {
        Flux.just("...", "---", "...")
                .map(MapExample03::transformMorseCode)
                .subscribe(log::info);
    }

    private static String transformMorseCode(String morseCode){
        return SampleData.morseCodeMap.get(morseCode);
    }
}
