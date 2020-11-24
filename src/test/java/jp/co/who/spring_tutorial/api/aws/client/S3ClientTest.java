package jp.co.who.spring_tutorial.api.aws.client;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        List<Bucket> list = List.of(
                new Bucket("dummy_bucket")
        );
        doReturn(list).when(amazonS3).listBuckets();
    }

    @Test
    public void getBucketのテスト() {
        List<Bucket> actual = s3Client.getBuckets();
        assertThat(actual.get(0).getName())
                .isEqualTo("dummy_bucket");
    }
}
