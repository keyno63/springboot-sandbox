package jp.co.who.spring_tutorial.java17.record;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductRecordService {

    public Product product() {
        Product product = new Product("productId", "productName", 100);
        return product;
    }

    public ProductRecord productRecord() {
        ProductRecord pd =  new ProductRecord("productRecordId", "productRecordName", 200);
        return pd;
    }

    public String matchProduct(Object p) {
//        Product p = product();
        return switch (p) {
            case null -> "is null";
            case Product p1 -> p1.getName();
            default -> "not match" + p.getClass();
        };
    }

    public String matchProductRecord(Object pr) {
        return switch (pr) {
//            case ProductRecord("productRecordId", "productRecordName", 200) -> "value: 200";
//            case ProductRecord("productRecordId", "productRecordName", 300) -> "value: 300";
            case null -> "is null";
            case Product p1 -> "product: " + p1.getName();
            case ProductRecord p -> "product record: " + p.name();
//            case ProductRecord(id, name, v) -> "";
            default -> "not match: " + pr.getClass();
        };
    }

    public String matchSample(int value) {
        return switch (value) {
            case 0 -> "0";
            case 1 -> "1";
            default -> "others";
        };
    }
}
