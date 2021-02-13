package jp.co.who.spring_tutorial.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberMatcher;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import jp.co.who.spring_tutorial.powermock.SampleTarget.Sample1;
import jp.co.who.spring_tutorial.powermock.SampleTarget.Sample2;
import jp.co.who.spring_tutorial.powermock.SampleTarget.Dto;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SampleTarget.class})
public class SampleTargetTest {

    @Test
    public void test001() throws Exception{

        final String value1 = "1_value";
        final String value2 = "2_value";
        SampleTarget.Dto mockDto = new Dto(value1, value2);

        SampleTarget mockInstance = PowerMockito.mock(SampleTarget.class);
        PowerMockito.when(mockInstance, MemberMatcher.method(SampleTarget.class, "setDto", Sample1.class, Sample2.class))
                .withArguments(any(Sample1.class), any(Sample2.class))
                .thenReturn(mockDto);

        // privateメソッドにアクセスするためにリフレクションを使う
        Method method = SampleTarget.class.getDeclaredMethod("setDto", Sample1.class, Sample2.class);
        method.setAccessible(true);

        assertThat(method.invoke(mockInstance, new Sample1("ccc"), new Sample2("ddd")).toString())
                .isEqualTo("1_value,2_value");
        assertThat(method.invoke(mockInstance, new Sample1("eee"), new Sample2("fff")).toString())
                .isEqualTo("1_value,2_value");
    }
}