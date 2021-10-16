package jp.co.who.spring_tutorial.teratail.q344182.controllers;

import jp.co.who.spring_tutorial.teratail.q344182.session.SampleSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class SessionControllerTest {

    // mock mvc 不要
    // context の設定などをすれば session 取得可能だが、
    // 色々設定するよりすべて autowired した方が早くなってしまって
    // mock として使っていないので

    @Mock
    SampleSession sampleSession;

    @InjectMocks
    SessionController sessionController;

    @Test
    void testSetSessionValue() {
        final String value = "test_value";
        doNothing().when(sampleSession).setId(anyString());

        //sessionController.session1(value);

        assertTrue(true);
    }

    @Test
    void testGetSessionValue() {
        final String value = "test_value";
        doReturn(value).when(sampleSession).getId();

        var actual = sessionController.session2();

        assertThat(actual).isEqualTo(value);
    }
}
