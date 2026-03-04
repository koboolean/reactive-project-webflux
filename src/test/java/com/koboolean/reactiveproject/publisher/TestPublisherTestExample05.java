package com.koboolean.reactiveproject.publisher;

import com.koboolean.reactiveproject.testing.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample05 {
    @Test
    public void divideByTwoTest() {
        TestPublisher<Integer> source = TestPublisher.createNoncompliant(TestPublisher.Violation.ALLOW_NULL);
//        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.divideByTwo(source.flux()))
                .expectSubscription()
                .then(() -> source.next(2, 4, 6, 8, null))
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectComplete()
                .verify();
    }
}
