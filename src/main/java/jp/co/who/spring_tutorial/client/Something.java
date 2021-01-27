package jp.co.who.spring_tutorial.client;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class Something {

    @Getter
    public static class Person {
        String firstName;
        String lastName;
        String prefecture;

        Person(String firstName, String lastName, String prefecture) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.prefecture = prefecture;
        }

        public String getFirstName() {return firstName;}
        public String getLastName() {return lastName;}
        public String getPrefecture() {return prefecture;}
    }

    public static void main(String[] args) {
        var people = List.of(
                new Person("tarou", "yamada", "tokyo"),
                new Person("hanako", "yamada", "tokyo"),
                new Person("hanako", "tanaka", "osaka")
        );

        // 変換処理
        var target = people
                .stream()
                .collect(Collectors.groupingBy(Person::getPrefecture, Collectors.groupingBy(Person::getLastName)));

        // 結果の表示
        target.entrySet().forEach(x -> {
            x.getValue().entrySet().forEach(y -> {
                System.out.printf("Jusyo: %s, Myoji: %s\n", x.getKey(), y.getKey());
                y.getValue().stream().forEach(z -> {
                    System.out.printf("  Person: %s %s\n", z.getLastName(), z.getFirstName());
                        }
                );
            });
        });

        // 結果の表示
        for (var xxx : target.entrySet()) {
            for (var yyy : xxx.getValue().entrySet()) {
                System.out.printf("Jusyo: %s, Myoji: %s\n", xxx.getKey(), yyy.getKey());
                for (var zzz : yyy.getValue()) {
                    System.out.printf("  Person: %s %s\n", zzz.lastName, zzz.firstName);
                }
            }
        }
    }
}
