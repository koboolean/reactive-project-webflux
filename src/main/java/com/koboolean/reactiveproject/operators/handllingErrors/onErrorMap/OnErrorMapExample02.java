package com.koboolean.reactiveproject.operators.handllingErrors.onErrorMap;

import com.koboolean.reactiveproject.operators.exam.TimezoneNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

@Slf4j
public class OnErrorMapExample02 {
    private final static URI WORLD_TIME_URI = UriComponentsBuilder.newInstance().scheme("http")
            .host("worldtimeapi.org")
            .port(80)
            .path("/api/timezone/Asia/Mars") // 잘못된 URI 입력
            .build()
            .encode()
            .toUri();

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono.fromSupplier(() ->
                        restTemplate.exchange(WORLD_TIME_URI, HttpMethod.GET, new HttpEntity<String>(headers), String.class)
                )
                .onErrorMap(HttpClientErrorException.class, (HttpClientErrorException ex) -> {
                    if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                        return new TimezoneNotFoundException(ex.getResponseBodyAsString());
                    }
                    return new HttpClientErrorException(ex.getStatusCode());
                })
                .subscribe(response -> log.info("Response : {}", response),
                        e -> log.error("Error ", e),
                        () -> log.info("Complete"));
    }
}
