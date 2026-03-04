package com.koboolean.reactiveproject.testing;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class StepVerifierGeneralTestExample01 {

    @Test
    public void sayHelloReactorTest(){
        StepVerifier.create(Mono.just("Hello Reactor"))
                .expectNext("Hello Reactor")
                .expectComplete()
                .verify();
    }
}
