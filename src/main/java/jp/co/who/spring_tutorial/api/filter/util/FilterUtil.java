package jp.co.who.spring_tutorial.api.filter.util;

import java.util.Objects;

public class FilterUtil {

    public static String parse(String value) {
        if (Objects.isNull(value)) {
            return "false";
        }
        return "true";
    }
}
