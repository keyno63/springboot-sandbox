package jp.co.who.spring_tutorial.service;

import com.amazonaws.services.s3.model.Bucket;
import jp.co.who.spring_tutorial.client.S3Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S3Service {

    private final S3Client s3Client;

    public S3Service(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public List<Bucket> getBuckets() {
        return s3Client.getBuckets();
    }
}
