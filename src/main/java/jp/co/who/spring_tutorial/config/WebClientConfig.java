package jp.co.who.spring_tutorial.config;

import io.netty.channel.ChannelOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ClientHttpConnector;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
public class WebClientConfig implements WebMvcConfigurer {

    @Bean
    public WebClient webClient() {
        ClientHttpConnector connector = new ReactorClientHttpConnector(
                HttpClient.create()
                        .wiretap(true)
                .tcpConfiguration(
                        tcpClient -> tcpClient.option(
                                ChannelOption.CONNECT_TIMEOUT_MILLIS,
                                1000)
                )

        );
        return WebClient
                .builder()
                .clientConnector(connector)
                .filter(logRequest())
                .build();
    }

    private ExchangeFilterFunction logRequest() {
        Logger log = LoggerFactory.getLogger(WebClientConfig.class);

        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            log.info("Request: {} {}", clientRequest.method(), clientRequest.url());
            clientRequest.headers().forEach((name, values) -> values.forEach(value -> log.info("header: {}={}", name, value)));
            var b = clientRequest.body();
            log.info(b.toString());
            return Mono.just(clientRequest);
        });
    }

}
