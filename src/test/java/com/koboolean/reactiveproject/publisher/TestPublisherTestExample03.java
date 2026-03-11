package com.koboolean.reactiveproject.publisher;

import com.koboolean.reactiveproject.basic.testing.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample03 {
    @Test
    public void divideByTwoTest() {
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.occurError(source.flux()))
                .expectSubscription()
                .then(() -> {
                    source.next(2, 4, 6, 8);
                    source.error(new ArithmeticException());
                })
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectError()
                .verify();
    }
}
