package jp.co.who.spring_tutorial.service;

import com.amazonaws.services.s3.model.Bucket;
import jp.co.who.spring_tutorial.client.S3Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

// MockitoJUnitRunner のお試し
@RunWith(MockitoJUnitRunner.class)
public class S3ServiceTest {

    @Mock
    private S3Client s3Client;

    @Mock
    Bucket ret;

    @InjectMocks
    S3Service s3Service;

    @Before
    public void setUp() {
        List<Bucket> list = new ArrayList<>();
        list.add(ret);
        doReturn(list).when(s3Client).getBuckets();
    }

    @Test
    public void test1() {
        s3Service.getBuckets();
    }
}
