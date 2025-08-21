package com.example.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test") // 테스트 프로필을 사용하도록 명시
@SpringBootTest
class Demo1ApplicationTests {

    @Test
    void contextLoads() {
    }

}
