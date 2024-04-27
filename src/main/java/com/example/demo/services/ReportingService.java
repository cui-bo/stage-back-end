package com.example.demo.services;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReportingService {

    /**
     * Generates HTML content based on the season code and calculated extraction date.
     *
     * @return The generated HTML content.
     */
    public String prepareHtmlContent() {
        return HtmlGeneratorService.buildHtmlDocument();
    }


}
