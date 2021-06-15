package jp.co.who.spring_tutorial.teratail.q344182.controllers;

import jp.co.who.spring_tutorial.teratail.q344182.session.SampleSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {SampleSession.class})
@AutoConfigureMockMvc
class SessionControllerTest {

    @Autowired
    SessionController sessionController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    SampleSession sampleSession;

//    @BeforeAll
//    static void setUp() {
//        var sampleSession = new SampleSession();
//        mockMvc = MockMvcBuilders.standaloneSetup(new SessionController(sampleSession)).build();
//    }

    @Test
    void test() throws Exception {
        var result = mockMvc
                .perform(
                        get("/q344182/session1")
                                .param("name", "test_value")
                )
                .andExpect(status().isOk())
                .andReturn();

        var mockSession = (MockHttpSession) result
                .getRequest()
                .getSession(false);

        assertThat(mockSession).isNotNull();

        mockMvc.perform(
                get("/q344182/session2")
                        .session(mockSession)
        )
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("test_value")));

    }

}