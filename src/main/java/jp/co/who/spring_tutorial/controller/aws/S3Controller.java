package jp.co.who.spring_tutorial.controller.aws;

import com.amazonaws.services.s3.model.Bucket;
import jp.co.who.spring_tutorial.client.S3Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aws/s3")
public class S3Controller {
    S3Client s3Client;

    public S3Controller(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @GetMapping("buckets")
    public List<Bucket> buckets() {
        return s3Client.getBuckets();
    }
}
