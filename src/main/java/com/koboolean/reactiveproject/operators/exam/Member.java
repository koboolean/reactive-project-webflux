package com.koboolean.reactiveproject.operators.exam;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private Long id;
    private String email;
    private String name;
}
