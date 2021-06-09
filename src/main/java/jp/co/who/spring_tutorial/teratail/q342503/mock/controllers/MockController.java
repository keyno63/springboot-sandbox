package jp.co.who.spring_tutorial.teratail.q342503.mock.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MockController {

    @GetMapping("/q342503/mock")
    public Response mock() {
        var title = "XXX";
        var item = new Item(new Author(title));
        return new Response(List.of(item, item, item));
    }

    private static class Response {
        @JsonProperty("Items")
        private final List<Item> items;
        public Response(List<Item> items) {
            this.items = items;
        }
    }

    private static class Item {
        @JsonProperty("Item")
        private final Author author;

        public Item(Author author) {
            this.author = author;
        }
    }

    private static class Author {
        @JsonProperty("author")
        private final String title;

        public Author(String title) {
            this.title = title;
        }
    }
}
