package jp.co.who.spring_tutorial.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import jp.co.who.spring_tutorial.config.property.S3Property;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Bean
    public AmazonS3 amazon3s(S3Property property) {
        final BasicAWSCredentials credentials = new BasicAWSCredentials(property.getAccessKey(), property.getSecretKey());
        final AWSStaticCredentialsProvider provider = new AWSStaticCredentialsProvider(credentials);
        AmazonS3 s3 = AmazonS3ClientBuilder
                .standard()
                .withCredentials(provider)
                .withRegion(property.getRegion())
                .build();
        return s3;
    }
}
