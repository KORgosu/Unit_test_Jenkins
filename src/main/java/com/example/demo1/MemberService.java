package com.example.demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member save() {
        Member member = Member.builder()
                .age(20)
                .email("test@email.com")
                .name("tester")
                .build();
        return memberRepository.save(member);
    }
}