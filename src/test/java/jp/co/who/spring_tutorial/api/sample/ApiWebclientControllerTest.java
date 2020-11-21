package jp.co.who.spring_tutorial.api.sample;

import jp.co.who.spring_tutorial.api.sample.controller.ApiWebclientController;
import jp.co.who.spring_tutorial.api.sample.dto.JsonDataTest;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest
class ApiWebclientControllerTest {

    @Autowired
    private ApiWebclientController apiWebclientController;

    private static MockWebServer mockWebServer;

//    @BeforeAll
//    static void beforeAll() throws IOException {
//        mockWebServer = new MockWebServer();
//        mockWebServer.start(8888);
//    }
//
//    @AfterAll
//    static void afterAll() throws IOException {
//        mockWebServer.shutdown();
//    }

    @BeforeEach
    void init() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(8888);
    }

    @AfterEach
    void finished() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    public void sampleTest() {
        var response = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .addHeader(CONTENT_TYPE, APPLICATION_JSON_VALUE)
                .setBody("{}");
        mockWebServer.enqueue(response);
        JsonDataTest jsonDataTest = apiWebclientController.getTest();
    }

}