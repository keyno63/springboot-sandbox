package jp.co.who.spring_tutorial;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
@Primary
public class TestConfig {

//    @Bean
//    public AmazonS3 createAmazonS3() {
//        return mock(AmazonS3.class);
//    }
}
