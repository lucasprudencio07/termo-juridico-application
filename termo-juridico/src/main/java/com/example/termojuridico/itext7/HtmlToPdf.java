package com.example.termojuridico.itext7;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.io.IOException;

public class HtmlToPdf {

    public void createPDF(String HTMLsource, String destinationPDF, String pagedPDF) throws IOException {

        HtmlConverter.convertToPdf(new File(HTMLsource), new File(destinationPDF));

        new HtmlToPdf().pagePDF(destinationPDF, pagedPDF);
    }


    protected void pagePDF(String destinationPDF, String pagedPDF) throws IOException {

        PdfDocument pdfDocument = new PdfDocument(new PdfReader(destinationPDF), new PdfWriter(pagedPDF));
        Document document = new Document(pdfDocument);

        int numberOfPages = pdfDocument.getNumberOfPages();

        for (int i = 1; i <= numberOfPages; i++ ) {

            document.showTextAligned(new Paragraph( new Text(String.format("%s", i))
                                         .setFontColor(ColorConstants.BLACK, 0.65f).setFontSize(10f)),
                                      538, 40, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);

            document.showTextAligned(new Paragraph( new Text(String.format("_______________________________________________________________________________________\n\n" +
                    "Esta página é parte integrante e inseparável do Instrumento Particular de Constituição de Alienação\n" +
                    "de Bens Móveis (Floorplan) firmado entre o Banco Pan S.A. e a empresa [nº da CCB]\n" +
                    "em [Data da CCB]")).setFontColor(ColorConstants.BLACK, 0.65f)
                                     .setFontSize(10f)), 55, 45, i, TextAlignment.JUSTIFIED,
                                     VerticalAlignment.BOTTOM, 0);



        }

        document.close();

    }

}
