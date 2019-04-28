package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.security.SecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy(@ContextConfiguration(classes = SecurityConfig.class))
public class EchoControllerTest {

    MockMvc mockMvc, mockMvcSecurity;

    @Autowired
    FilterChainProxy springSecurityFilterChain;

    @Before
    public void setupMockMvc() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(new EchoController())
                .build();
        // security
        this.mockMvcSecurity = MockMvcBuilders
                .standaloneSetup(new EchoController())
                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .build();
    }

    @Test
    public void POSTテスト() throws Exception {
        mockMvc.perform(post("/echo/post"))
                .andExpect(status().isOk());
    }

    @Test
    public void POSTテストwoクロスサイトリクエストフォージェリー() throws Exception {
        mockMvcSecurity.perform(post("/echo/post").with(csrf()))
                .andExpect(status().isOk());
        mockMvcSecurity.perform(post("/echo/post"))
                .andExpect(status().isForbidden());
    }

}