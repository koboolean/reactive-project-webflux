package com.koboolean.reactiveproject.operators.handllingErrors.onErrorReturn;

import com.koboolean.reactiveproject.operators.exam.Book;
import com.koboolean.reactiveproject.operators.exam.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
public class OnErrorReturnExample01 {
    public static void main(String[] args) {
        getBooks()
                .map(book -> book.getPenName().toUpperCase())
                .onErrorReturn("No pen name")
                .subscribe(log::info, e -> log.error("Error " + e));
    }

    public static Flux<Book> getBooks() {
        return Flux.fromIterable(SampleData.books);
    }
}
