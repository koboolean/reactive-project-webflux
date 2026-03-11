package com.koboolean.reactiveproject.testing;

import com.koboolean.reactiveproject.basic.testing.ContextExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class StepVerifierContextTestExample01 {
    final private static String KEY = "helloTarget";

    @Test
    public void helloMessageTest() {
        Mono<String> source = Mono.just("Hello");

        StepVerifier
                .create(ContextExample
                        .helloMessage(source, KEY)
                        .contextWrite(context -> context.put(KEY, "Reactor"))
                )
                .expectSubscription()
                .expectAccessibleContext()
                .hasKey("helloTarget")
                .then()
                .expectNext("Hello, Reactor")
                .expectComplete()
                .verify();
    }
}
