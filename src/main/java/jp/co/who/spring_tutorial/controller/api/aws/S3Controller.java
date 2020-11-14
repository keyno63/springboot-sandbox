package jp.co.who.spring_tutorial.controller.api.aws;

import com.amazonaws.services.s3.model.Bucket;
import jp.co.who.spring_tutorial.service.S3Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aws/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @GetMapping("buckets")
    public List<Bucket> buckets() {
        return s3Service.getBuckets();
    }
}
