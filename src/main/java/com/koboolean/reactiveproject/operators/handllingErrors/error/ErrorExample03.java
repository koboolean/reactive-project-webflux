package com.koboolean.reactiveproject.operators.handllingErrors.error;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.zip.DataFormatException;

@Slf4j
public class ErrorExample03 {

    public static void main(String[] args) {
        Flux
                .just('a', 'b', 'c', '3', 'd')
                .flatMap(letter -> {
                    try{
                        return convert(letter);
                    }catch(DataFormatException e){
                        return Mono.error(e);
                    }
                }).subscribe(
                        v -> log.info("Success : {}", v)
                         , e -> log.error("Error, ", e.fillInStackTrace())
                );
    }

    private static Mono<String> convert(char ch) throws DataFormatException {
        CharacterValidator.isAlphabeticCharacter(ch);
        return Mono.just("Converted to " + Character.toUpperCase(ch));
    }
}
