package jp.co.who.spring_tutorial.java17.record;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ProductRecordServiceTest {

    private ProductRecordService target;

    @BeforeEach
    void setUp() {
        target = new ProductRecordService();
    }


    @Test
    void testProduct() {
        Product ret = target.product();
//        assertThat()
        System.out.println(ret);
        System.out.println(ret.hashCode());
    }

    @Test
    void testProductRecord() {
        ProductRecord ret = target.productRecord();
//        assertThat()
        System.out.println(ret);
        System.out.println(ret.name());
        System.out.println(ret.name());
        System.out.println(ret.hashCode());
    }

    /**
     * Hash Key の実装の確認. map の key になれるか.
     */
    @Test
    void testHashKey() {
        Product ret = target.product();
        Map<Product, String> map = Map.of(ret, "key1");

        Product ret2 = target.product();
        var actual = map.get(ret2);
        assertThat(actual).isNull();
        assertThat(ret.hashCode()).isNotEqualTo(ret2.hashCode());

        ProductRecord pd = target.productRecord();
        Map<ProductRecord, String> pdMap = Map.of(pd, "pdKey");
        ProductRecord pd2 = target.productRecord();
        var pdActual = pdMap.get(pd2);
        assertThat(pdActual).isEqualTo("pdKey");
        assertThat(pd.hashCode()).isNotEqualTo(pd2.hashCode());
    }

    @Test
    void testPatternMatchForSwitching() {

        var actual = target.matchSample(1);
        assertThat(actual).isEqualTo("1");

        Product p = target.product();
        var matched = target.matchProductRecord(p);
        assertThat(matched).isEqualTo("product: productName");

        ProductRecord pr = target.productRecord();
        var matchedPr = target.matchProductRecord(pr);
        assertThat(matchedPr).isEqualTo("product record: productRecordName");
    }
}
