package jp.co.who.spring_tutorial.java17.record;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
//@EqualsAndHashCode
@RequiredArgsConstructor
public class Product {
    private final String id;
    private final String name;
    private final int value;
}
