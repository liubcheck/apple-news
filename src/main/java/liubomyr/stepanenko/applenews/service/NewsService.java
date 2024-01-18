package liubomyr.stepanenko.applenews.service;

import java.util.List;
import liubomyr.stepanenko.applenews.dto.external.ApiArticleDto;

public interface NewsService {
    List<ApiArticleDto> getNews();
}
