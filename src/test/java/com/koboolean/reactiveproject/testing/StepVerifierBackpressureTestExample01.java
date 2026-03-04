package com.koboolean.reactiveproject.testing;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class StepVerifierBackpressureTestExample01 {
    @Test
    public void generateNumberTest() {
        StepVerifier
                .create(BackpressureExample.generateNumberByErrorStrategy(), 1L)
                .thenConsumeWhile(num -> num >= 1) // emit 된 데이터들을 소비한다.
                .verifyComplete();
    }
}
