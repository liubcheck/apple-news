package liubomyr.stepanenko.applenews.dto.external;

import java.util.List;
import lombok.Data;

@Data
public class ApiResponseDto {
    private List<ApiArticleDto> results;
    private String status;
    private String request_id;
    private String next_url;
}
