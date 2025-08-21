package com.example.demo1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest 없이 순수 Java 단위 테스트
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void 덧셈_테스트() { // 메서드 이름은 한글로 작성하여 가독성을 높일 수 있습니다.
        // given
        int a = 2;
        int b = 3;

        // when
        int result = calculator.sum(a, b);

        // then
        assertEquals(5, result, "2 + 3은 5여야 합니다.");
    }
}