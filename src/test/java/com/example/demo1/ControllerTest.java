package com.example.demo1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class) // CalculatorController만 테스트
class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Controller가 의존하는 Bean들을 Mock으로 만듦
    @MockBean
    private Calculator calculator;
    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("Health Check 엔드포인트 테스트")
    void health_check_테스트() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"))
                .andDo(print());
    }

    @Test
    @DisplayName("Sum 엔드포인트 테스트")
    void sum_엔드포인트_테스트() throws Exception {
        // given
        when(calculator.sum(5, 10)).thenReturn(15);

        // when & then
        mockMvc.perform(get("/sum")
                        .param("a", "5")
                        .param("b", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"))
                .andDo(print());
    }
}