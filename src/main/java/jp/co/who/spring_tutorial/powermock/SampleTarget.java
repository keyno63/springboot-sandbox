package jp.co.who.spring_tutorial.powermock;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class SampleTarget {

    private Dto setDto(Sample1 sample1, Sample2 sample2) {
        return new Dto(sample1.getValue(), sample2.getValue());
    }

    @Getter
    public static class Sample1 {
        private final String value;
        public Sample1(String value) { this.value = value; }
    }

    @Getter
    public static class Sample2 {
        private final String value;
        public Sample2(String value) { this.value = value; }
    }

    @Setter
    public static class Dto {
        private String value1;
        private String value2;

        public Dto(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return String.join(",", Arrays.asList(value1, value2));
        }
    }
}
