package jp.co.who.spring_tutorial.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.aws.s3")
public class S3Property {

    private String bucket;
    private String region;
    private String accessKey;
    private String secretKey;

    public String getBucket() {
        return bucket;
    }
    public String getRegion() {
        return region;
    }
    public String getAccessKey() {
        return accessKey;
    }
    public String getSecretKey() {
        return secretKey;
    }
    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
