package com.example.demo.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
