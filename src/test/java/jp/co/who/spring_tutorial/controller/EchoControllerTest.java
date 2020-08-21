package jp.co.who.spring_tutorial.controller;

import jp.co.who.spring_tutorial.security.SecurityConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
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
    public void ルートディレクトリの遷移() throws Exception {
        mockMvc.perform(get("/echo"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("echo/input"));
    }

    @Test
    public void フォワードURL() throws Exception {
        mockMvc.perform(get("/echo/echo_forward"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("/echo"));
    }

    @Test
    public void Jsonテスト() throws Exception {
        mockMvc.perform(get("/echo/json"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("json/sample.json"));
    }

    @Test
    public void easyのURLテスト() throws Exception {
        final String easyContent =
                String.format("{\"%s\":\"%s\",\"%s\":\"%s\"}", "version", "1", "user", "user1");
        mockMvc.perform(get("/echo/easy"))
                .andExpect(status().isOk())
                .andExpect(content().string(easyContent));
    }

    @Test
    public void json_reのテスト() throws Exception {
        // TODO: json ファイルの読み込みで表現すべき
        final String json =
                "{" +
                        "\"param\":[" +
                        "{" +
                        "\"path\":\"json_re\"}," +
                        "{\"sample\":\"data\"}," +
                        "{\"data\":" +
                          "{\"source\":\"json\"," +
                          "\"version\":1," +
                          "\"queue\":false" +
        "}}]}";
        mockMvc.perform(get("/echo/json_re"))
                .andExpect(status().isOk())
                .andExpect(content().string(json));
    }

    @Test
    public void POSTテスト() throws Exception {
        mockMvc.perform(post("/echo/post"))
                .andExpect(status().isOk());
    }

    @Test
    public void POSTテストwoクロスサイトリクエストフォージェリー() throws Exception {
        mockMvcSecurity.perform(post("/echo/post").with(csrf()))
                .andExpect(status().isOk())
                .andDo(log());
        mockMvcSecurity.perform(post("/echo/post"))
                .andExpect(status().isForbidden())
                .andDo(log());
    }

}