package liubomyr.stepanenko.applenews.dto.external;

import java.util.List;
import lombok.Data;

@Data
public class ApiArticleDto {
    private String id;
    private ApiPublisherDto publisher;
    private String title;
    private String author;
    private String published_utc;
    private String article_url;
    private List<String> tickers;
    private String amp_url;
    private String image_url;
    private String description;
    private List<String> keywords;
}
