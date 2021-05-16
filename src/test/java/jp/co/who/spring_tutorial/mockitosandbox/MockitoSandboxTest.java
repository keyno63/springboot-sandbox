package jp.co.who.spring_tutorial.mockitosandbox;

import jp.co.who.spring_tutorial.mockitosandbox.libs.MockitoSandboxModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MockitoSandboxTest {

    @Mock
    MockitoSandboxModule mockitoSandboxModule;

    @InjectMocks
    MockitoSandbox target;


    @Test
    void test1() {
        doReturn("any")
                .doReturn("one")
                .when(mockitoSandboxModule)
                .get(anyString());

        var ret1 = target.getValue("value");
        var ret2 = target.getValue("value");

        assertThat(ret1).isEqualTo("any");
        assertThat(ret2).isEqualTo("one");
    }
}