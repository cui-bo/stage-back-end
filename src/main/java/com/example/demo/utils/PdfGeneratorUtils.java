package com.example.demo.utils;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

public class PdfGeneratorUtils {

    /**
     * Generates a PDF from the provided HTML content.
     *
     * @param htmlContent the HTML content from which the PDF will be generated
     * @return a byte array representing the generated PDF
     * @throws Exception if an error occurs during PDF generation
     */
    public static byte[] generatePdfFromHtml(String htmlContent) throws Exception {
        // Create an ITextRenderer instance
        ITextRenderer renderer = new ITextRenderer();

        // Set up the document
        renderer.setDocumentFromString(htmlContent);

        // Render the PDF to an output stream
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            renderer.layout();
            renderer.createPDF(outputStream);
            return outputStream.toByteArray();
        }
    }
}
