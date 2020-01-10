package com.example.termojuridico.itext7;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.io.IOException;

public class MainItext7 {

    public static final String destinationFile = "C:\\Users\\re039550\\Documents\\pdfs\\itext7.pdf";
    public static final String htmlPath = "C:\\Users\\re039550\\Desktop\\relatorio.html";


    public static void main(String... args) throws IOException {

        HtmlToPdf pdfConverter = new HtmlToPdf();
        pdfConverter.createPDF(htmlPath, destinationFile);
    }

}
