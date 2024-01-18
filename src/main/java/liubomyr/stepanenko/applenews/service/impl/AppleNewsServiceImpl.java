package liubomyr.stepanenko.applenews.service.impl;

import java.util.ArrayList;
import java.util.List;
import liubomyr.stepanenko.applenews.dto.external.ApiArticleDto;
import liubomyr.stepanenko.applenews.dto.external.ApiResponseDto;
import liubomyr.stepanenko.applenews.service.NewsService;
import liubomyr.stepanenko.applenews.service.NewsHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppleNewsServiceImpl implements NewsService {
    private static final String BASE_URL = "https://api.polygon.io/v2/reference/news?"
            + "limit=1000"
            + "&published_utc.gte=2023-12-01T00:00:00Z&published_utc.lte=2023-12-31T23:59:59Z";
    private static final String APPLE = "Apple";
    private static final int ARTICLE_LIMIT = 100;
    private final NewsHttpClient apiClient;

    @Override
    public List<ApiArticleDto> getNews() {
        ApiResponseDto articlesInfo = apiClient.getNews(BASE_URL);
        List<ApiArticleDto> articles = new ArrayList<>();
        while (articlesInfo.getNext_url() != null || articles.size() <= 100) {
            articles.addAll(articlesInfo.getResults().stream()
                    .filter(article -> article.getTitle().contains(APPLE))
                    .toList());
            articlesInfo = apiClient.getNews(articlesInfo.getNext_url());
        }
        return articles.stream()
                .limit(ARTICLE_LIMIT)
                .toList();
    }
}
