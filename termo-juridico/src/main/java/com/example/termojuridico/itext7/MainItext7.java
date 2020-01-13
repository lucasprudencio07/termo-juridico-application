package com.example.termojuridico.itext7;

import java.io.IOException;

public class MainItext7 {

    public static final String HTMLPATH = "C:\\Users\\re039550\\Downloads\\arquivosTermo\\relatorio2.html";
    public static final String DESTINATIONFILE = "C:\\Users\\re039550\\Documents\\pdfs\\itext7.pdf";
    public static final String PAGEDFILE = "C:\\Users\\re039550\\Documents\\pdfs\\itext7paged.pdf";

    public static void main(String... args) throws IOException {

        HtmlToPdf pdfConverter = new HtmlToPdf();
        pdfConverter.createPDF(HTMLPATH, DESTINATIONFILE, PAGEDFILE);

    }

}
