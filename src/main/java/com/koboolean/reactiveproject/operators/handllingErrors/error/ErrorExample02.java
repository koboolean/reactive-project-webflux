package com.koboolean.reactiveproject.operators.handllingErrors.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.zip.DataFormatException;

@Slf4j
public class ErrorExample02 {

    public static void main(String[] args) {
        Flux
                .just('a', 'b', 'c', '3', 'd')
                .flatMap(ErrorExample02::convert).subscribe(
                        v -> log.info("Success : {}", v)
                         , e -> log.error("Error, ", e.fillInStackTrace())
                );
    }

    private static Mono<String> convert(char ch){
        if(!Character.isAlphabetic(ch)){
            // 알파벳이 아닌경우 Error 처리
            return Mono.error(new DataFormatException("Not Alphabetic"));
        }
        return Mono.just("Converted to " + Character.toUpperCase(ch));
    }
}
