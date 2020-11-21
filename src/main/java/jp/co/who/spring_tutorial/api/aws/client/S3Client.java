package jp.co.who.spring_tutorial.api.aws.client;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class S3Client {

    private final AmazonS3 s3;

    public S3Client(AmazonS3 s3) {
        this.s3 = s3;
    }

    public List<Bucket> getBuckets() {
        return s3.listBuckets();
    }
}
