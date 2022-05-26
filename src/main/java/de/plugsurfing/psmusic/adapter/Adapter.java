package de.plugsurfing.psmusic.adapter;

import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

/**
 * @author Andrei Kukharau
 * @since 0.0.1
 */
public abstract class Adapter {
    protected final WebClient webClient;

    protected Adapter(WebClient.Builder webClientBuilder, String baseUrl) {
        this.webClient = webClientBuilder.clientConnector(new ReactorClientHttpConnector(HttpClient.create().followRedirect(true)))
                .baseUrl(baseUrl)
                .build();
    }
}
