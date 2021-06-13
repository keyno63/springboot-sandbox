package jp.co.who.spring_tutorial.teratail.q343766.model;

import jp.co.who.spring_tutorial.teratail.q343766.service.SampleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@SuppressWarnings({"Unchecked"})
@ExtendWith(MockitoExtension.class)
class SampleModelTest {

    @Mock
    SampleService sampleService;

    @InjectMocks
    SampleModel target;

    @Test
    void argTest() {
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);

        int testValue = 10;
        target.write(testValue);

        verify(sampleService).update(captor.capture());
        Integer argValue = captor.getValue();

        assertThat(argValue).isEqualTo(testValue);
    }

    @Test
    void argTesBytes() {
        ArgumentCaptor<byte[]> captor = ArgumentCaptor.forClass(byte[].class);

        byte[] testValues = {(byte) 1, (byte) 2};
        target.writeByte(testValues);

        verify(sampleService).update(captor.capture());
        byte[] argValue = captor.getValue();

        assertThat(argValue).isEqualTo(testValues);
    }
}