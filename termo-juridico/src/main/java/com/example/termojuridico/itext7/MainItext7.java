package com.example.termojuridico.itext7;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MainItext7 {

    public static void main(String... args) throws IOException {


        String HTMLPATH = "C:\\Users\\re039550\\Downloads\\index2.html";

        ByteArrayOutputStream pdfOS = new ByteArrayOutputStream();
        ByteArrayOutputStream pdfOSFooter = new ByteArrayOutputStream();

        HtmlToPdf pdfConverter = new HtmlToPdf();
//        pdfConverter.createPDF(HTMLPATH, DESTINATIONFILE, PAGEDFILE);
        pdfConverter.createPDF(HTMLPATH, pdfOS.toByteArray());
    }

}
