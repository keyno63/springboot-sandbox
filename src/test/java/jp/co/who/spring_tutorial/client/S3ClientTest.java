package jp.co.who.spring_tutorial.client;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import jp.co.who.spring_tutorial.api.aws.client.S3Client;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;

// SpringRunnner のお試し
@RunWith(SpringRunner.class)
@SpringBootTest
public class S3ClientTest {

    @MockBean
    AmazonS3 amazonS3;

    @Autowired
    S3Client s3Client;

    @Mock
    Bucket ret;

    @Before
    public void setUp() {
        List<Bucket> list = new ArrayList<>();
        list.add(ret);
        doReturn(list).when(amazonS3).listBuckets();
    }

    @Test
    public void test1() {
        s3Client.getBuckets();
    }
}
