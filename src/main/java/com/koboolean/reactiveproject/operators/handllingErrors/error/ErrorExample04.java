package com.koboolean.reactiveproject.operators.handllingErrors.error;

import com.koboolean.reactiveproject.operators.exam.Member;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.zip.DataFormatException;

@Slf4j
public class ErrorExample04 {
    private final static String EXIST_EMAIL = "koboolean@gmail.com";
    private final static String NOT_EXIST_EMAIL = "tom@gmail.com";

    public static void main(String[] args) {
        verifyExistMember(EXIST_EMAIL)
//        verifyExistMember(NOT_EXIST_EMAIL)
                .flatMap(notUse -> saveMember(
                        Member.builder()
                                .id(1L)
                                .email(NOT_EXIST_EMAIL)
                                .name("koboolean")
                                .build())
                )
                .subscribe(
                        createdMember -> log.info("created member {}", createdMember.getEmail()),
                        e -> log.error("Error, " + e),
                        () -> log.info("Complete")
                );
    }

    private static Mono<Member> verifyExistMember(String email) {
        return selectFromMemberWhere(email)
                .switchIfEmpty(Mono.just(Member.builder().build())) // saveMember()를 실행시킬 수 있도록 비어있는 member를 리턴한다.
                .flatMap(foundMember -> {
                    if (foundMember.getEmail() != null) {
                        return Mono.error(new RuntimeException("Member exists"));
                    }
                    return Mono.just(foundMember);
                });
    }

    private static Mono<Member> selectFromMemberWhere(String email) {
        // 파라미터로 전달 받은 email로 DB에 조회한걸로 가정.
        log.info("# select from member where email=" + email);
        Mono existMember = Mono.just(Member.builder().id(1L).email("koboolean@gmail.com").name("koboolean").build());

        return email.equals(EXIST_EMAIL) ? existMember : Mono.empty();
    }

    private static Mono<Member> saveMember(Member member) {
        // DB에 저장한걸로 가정
        log.info("# insert into member...");
        return Mono.just(member);
    }
}
