package com.example.demo.services;

public class HtmlGeneratorService {

    /**
     * TODO
     */
    public static String buildHtmlDocument() {
        StringBuilder htmlBuilder = new StringBuilder();
        // Append HTML document structure
        // TODO Chantier à remplir
        htmlBuilder.append("""
                <html>
                <head>
                <title>Test</title>
                </head>
                <body>
                    <h1 style="color:green;text-align:center;"> Hello World </h1>
                </body>
                </html>
                """);
        return htmlBuilder.toString();
    }

}
