package com.example.demo.controllers;

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
        if (!CustomConstant.dayList.contains(dayId)) {
            log.warn("[ReportingController][generateBulletinInformation] bad parameter given : {}", dayId);
            return ResponseEntity.badRequest().build();
        }

        String calculatedDateExtraction = DateUtils.getCurrentDate(dayId);
        log.info("[ReportingController][generateBulletinInformation] by given day {}, calculated date extraction {}", dayId, calculatedDateExtraction);

        try {
            String htmlContent = reportingService.prepareHtmlContent(codeSaison, calculatedDateExtraction);
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
