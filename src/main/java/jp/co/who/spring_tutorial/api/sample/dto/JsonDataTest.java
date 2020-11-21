package jp.co.who.spring_tutorial.api.sample.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
public class JsonDataTest {

    @JsonProperty("v")
    private final String value;
    @JsonProperty("c")
    private final List<JsonDataChildren> children;

    @JsonCreator
    public JsonDataTest(@JsonProperty("v") String value, @JsonProperty("c") List<JsonDataChildren> children) {
        this.value = value;
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("JsonDataTest[ value: %s, children: %s ]", value, Optional.ofNullable(children).map(Objects::toString).orElse("null"));
    }

    @Getter
    public static class JsonDataChildren {
        @JsonProperty("value1")
        private String value1;

        @JsonProperty("value2")
        private String value2;

        @JsonCreator
        public JsonDataChildren(@JsonProperty("value1") String value1, @JsonProperty("value2") String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        @Override
        public String toString() {
            return String.format("JsonDataChildren[ value1: %s, value2: %s ]", value1, value2);
        }
    }
}
