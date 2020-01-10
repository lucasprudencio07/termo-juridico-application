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

import static com.itextpdf.html2pdf.html.AttributeConstants.SRC;

public class HtmlToPdf {

    public void createPDF(String HTMLsource, String destinationPDF) throws IOException {

        HtmlConverter.convertToPdf(new File(HTMLsource), new File(destinationPDF));

    }

//    public void manipulatePDF(String destinationPDF) {
//
//        PdfDocument pdfDoc = new PdfDocument(new PdfReader(HTMLsource), new PdfWriter(destinationPDF));
//        Document doc = new Document(pdfDoc);
//        int n = pdfDoc.getNumberOfPages();
//        for (int i = 1; i <= n; i++) {
//            doc.showTextAligned(new Paragraph(String.format("page %s of %s", i, n)),
//                    559, 806, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
//        }
//        doc.close();
//
//    }

}
