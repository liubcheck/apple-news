package liubomyr.stepanenko.applenews.service.impl;

import java.util.List;
import liubomyr.stepanenko.applenews.dto.external.ApiArticleDto;
import liubomyr.stepanenko.applenews.dto.external.ApiResponseDto;
import liubomyr.stepanenko.applenews.service.AppleNewsService;
import liubomyr.stepanenko.applenews.service.NewsHttpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppleNewsServiceImpl implements AppleNewsService {
    private static final String APPLE = "Apple";
    private final NewsHttpClient apiClient;
    @Override
    public List<ApiArticleDto> getNews() {
        ApiResponseDto articlesInfo = apiClient.getNews();
        return articlesInfo.getResults().stream()
                .filter(article -> article.getTitle().contains(APPLE))
                .toList();
    }
}
