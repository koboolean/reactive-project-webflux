package com.koboolean.reactiveproject.testing;

import com.koboolean.reactiveproject.basic.testing.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class StepVerifierGeneralTestExample02 {

    @Test
    public void sayHelloReactorTest(){
        StepVerifier
                .create(GeneralExample.sayHelloReactor())
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .expectComplete()
                .verify();
    }
}
