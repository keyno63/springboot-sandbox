package jp.co.who.spring_tutorial.teratail.q342503.app.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class AppController {

    RestTemplate restTemplate;

    // Bean 登録めんどくさいからコンストラクタ内で build してる
    public AppController() {
        this.restTemplate = new RestTemplateBuilder().build();
    }

    @GetMapping("/q342503/app")
    public Response app() {
        log.debug("app");
        Response response = restTemplate.getForObject("http://localhost:8090/q342503/mock", Response.class);
        log.debug("desialize");
        log.debug(Optional.ofNullable(response)
                .map(Response::toString)
                .orElse("nothing"));
        //return new Response(List.of());
        return response;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Response {
        @JsonProperty("Items")
        private List<Item> items;

        public Response(List<Item> items) {
            this.items = items;
        }

        public Response() {
        }

        @Override
        public String toString() {
            return items
                    .stream()
                    .map(Item::getAuthor)
                    .map(Author::getTitle)
                    .collect(Collectors.joining());
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    private static class Item {
        @JsonProperty("Item")
        private Author author;

        public Item(Author author) {
            this.author = author;
        }

        public Item() {
        }

        public void setAuthor(Author author) {
            this.author = author;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    private static class Author {
        public void setTitle(String title) {
            this.title = title;
        }

        @JsonProperty("author")
        private String title;

        public Author(String title) {
            this.title = title;
        }

        public Author() {
        }
    }
}
