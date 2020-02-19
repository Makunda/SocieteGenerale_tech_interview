package com.soge.particlesChamber;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class ParticlesChamberRESTTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnMatrice() throws Exception {
        String speed = "2";
        String init = "..R....";
        String result = "[..X...., ....X.., ......X, .......]" ;

        this.mockMvc.perform(get("/animate").param("speed", speed).param("init", init)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(result)));
    }

    @Test
    public void shouldReturnBadRequestError() throws Exception {
        mockMvc.perform(get("/animate")).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnTooHighSpeedError() throws Exception {
        String speed = "12";
        String init = "..R....";
        mockMvc.perform(get("/animate").param("speed", speed).param("init", init)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnToLowSpeedError() throws Exception {
        String speed = "0";
        String init = "..R....";
        mockMvc.perform(get("/animate").param("speed", speed).param("init", init)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnInvalidCharError() throws Exception {
        String speed = "2";
        String init = "..R..K..";
        mockMvc.perform(get("/animate").param("speed", speed).param("init", init)).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldReturnInvalidLengthError() throws Exception {
        String speed = "2";
        String init = "";
        mockMvc.perform(get("/animate").param("speed", speed).param("init", init)).andExpect(status().isBadRequest());
    }
}
