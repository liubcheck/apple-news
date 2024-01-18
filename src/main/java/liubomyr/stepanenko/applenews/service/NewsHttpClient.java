package liubomyr.stepanenko.applenews.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import liubomyr.stepanenko.applenews.dto.external.ApiResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewsHttpClient {
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final ObjectMapper objectMapper;
    @Value("${polygon.api.key}")
    private String apiKey;

    public ApiResponseDto getNews(String url) {
        String urlWithApiKey = url + "&apiKey=" + apiKey;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlWithApiKey))
                .build();
        try {
            HttpResponse<String> response =
                    httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), ApiResponseDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
