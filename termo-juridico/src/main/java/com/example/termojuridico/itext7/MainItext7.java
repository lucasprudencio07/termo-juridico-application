package com.example.termojuridico.itext7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainItext7 {

    public static void main(String... args) throws IOException {

        // insert your Html path here
        String HtmlPath = "C:\\Users\\re039550\\Downloads\\index.html";

        ByteArrayOutputStream pdfOS = new ByteArrayOutputStream();

        HtmlToPdf pdfConverter = new HtmlToPdf();
        pdfConverter.createPDF(HtmlPath, pdfOS.toByteArray());
    }

}
