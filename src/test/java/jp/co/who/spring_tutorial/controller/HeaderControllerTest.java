package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.controller.api.sample.HeaderController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class HeaderControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new HeaderController())
                .build();
    }

    @Test
    public void getCookieEndpoint() throws Exception {
        mockMvc.perform(get("/header/cookie"))
                .andExpect(status().isOk());
    }

    @Test
    public void getUserAgentEndpoint() throws Exception {
        mockMvc.perform(get("/header/userAgent"))
                .andExpect(status().isOk());
    }
}