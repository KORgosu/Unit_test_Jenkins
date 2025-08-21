package com.example.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("test") // "test" 프로필을 활성화하여 H2 DB를 사용
@DataJpaTest // JPA 관련 컴포넌트만 로드하여 테스트
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 회원_저장_테스트() {
        // given
        Member newMember = Member.builder()
                .age(25)
                .email("repo@email.com")
                .name("repository")
                .build();

        // when
        Member savedMember = memberRepository.save(newMember);

        // then
        assertNotNull(savedMember.getId());
        assertEquals(newMember.getName(), savedMember.getName());
        assertEquals(newMember.getEmail(), savedMember.getEmail());
    }
}