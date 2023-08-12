package com.skateboard;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import com.skateboard.web.DesignSkateBoardController;

@WebMvcTest(DesignSkateBoardController.class)
public class DesignSkateBoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testPage() throws Exception {
        mockMvc.perform(get("/design"));
//                .andExpect(status().isOk());

    }
}
