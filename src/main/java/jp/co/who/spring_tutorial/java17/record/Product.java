package jp.co.who.spring_tutorial.java17.record;

import lombok.Getter;

@Getter
public class Product {
    private final String id;
    private final String name;
    private final int value;

    public Product(String id, String name, int value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }
}
