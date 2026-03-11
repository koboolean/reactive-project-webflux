package com.koboolean.reactiveproject.operators.exam;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Book {
    private int bookId;
    private String bookName;
    private String authorName;
    private String penName;
    private int price;
    private int stockQuantity;
}
