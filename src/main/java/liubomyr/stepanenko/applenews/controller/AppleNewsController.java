package liubomyr.stepanenko.applenews.controller;

import java.util.List;
import liubomyr.stepanenko.applenews.dto.external.ApiArticleDto;
import liubomyr.stepanenko.applenews.service.AppleNewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class AppleNewsController {
    private final AppleNewsService appleNewsService;

    @GetMapping("/apple")
    public List<ApiArticleDto> getAppleNews() {
        return appleNewsService.getNews();
    }
}
