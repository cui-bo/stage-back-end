package com.example.demo.controllers;

import com.example.demo.services.ReportingService;
import com.example.demo.utils.PdfGeneratorUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/reporting")
public class ReportingController {

    private final ReportingService reportingService;

    @Operation(summary = "Generate a report in PDF", description = "", tags = {"Manage reporting"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get report ",
                    content = {@Content(mediaType = "application/pdf")}),
            @ApiResponse(responseCode = "400", description = "Bad parameters",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content)})
    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdfFromHtml() {
        try {
            String htmlContent = reportingService.prepareHtmlContent();
            byte[] pdfBytes = PdfGeneratorUtils.generatePdfFromHtml(htmlContent);
            return ResponseEntity.ok()
                    .header("Content-Type", "application/pdf")
                    .body(pdfBytes);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
