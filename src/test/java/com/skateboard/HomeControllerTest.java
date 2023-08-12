package com.skateboard;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest // 해당 클래스만 Spring MVC 형태로 테스트
public class HomeControllerTest {

    @Autowired // 자동주입
    private MockMvc mockMvc; // 테스트에 쓰일 간단한 가짜 객체 생성

    @Test // Test 할 메소드
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) // '/'를 get 형태로 호출
                .andExpect(status().isOk()) // HTTP response code는 OK(200)
                .andExpect(view().name("home")) // 호출되는 view의 이름은 home
                .andExpect(content()
                        .string(containsString(
                                "어서오세요."))// 뷰의 컨텐츠에는 해당 String이 포함되어야한다
                );
    }
}