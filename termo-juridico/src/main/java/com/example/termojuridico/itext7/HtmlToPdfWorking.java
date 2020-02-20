package com.example.termojuridico.itext7;

import com.example.termojuridico.FalhaDeDelecaoException;
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
import com.sun.jersey.core.util.Base64;

import java.io.*;
import java.time.LocalDate;

public class HtmlToPdfWorking {

    private Long numeroCCB;
    private LocalDate dataCCB;

    public void createPDF(String HTMLsource, String destinationPDF, String pagedPDF) throws IOException {

        HtmlConverter.convertToPdf(new File(HTMLsource), new File(destinationPDF));

        FileInputStream fileInputStream = new FileInputStream(destinationPDF);

        String arquivoEm64 = new String(Base64.encode(fileInputStream.readAllBytes()));
//        System.out.println(arquivoEm64);

//        new HtmlToPdf().footerPDF(destinationPDF, pagedPDF);
            this.footerPDFByteArray(arquivoEm64);

//        try {
//
//            deleteFile(destinationPDF);
//            deleteFile(pagedPDF);
//
//        } catch(FalhaDeDelecaoException ex) {
//
//            ex.getMessage();
//        }

    }


    public void deleteFile(String pdfToBeDeleted) throws FalhaDeDelecaoException {
        File fileToBeDeleted = new File(pdfToBeDeleted);


            Boolean exception = fileToBeDeleted.delete();

            if(exception)
                throw new FalhaDeDelecaoException();

    }

    protected byte[] footerPDFByteArray(String arquivoSemFooter) throws IOException {

        byte[] arquivoSemFooterBytes = Base64.decode(arquivoSemFooter);

        ByteArrayInputStream pdfEntrada = new ByteArrayInputStream(arquivoSemFooterBytes);
        ByteArrayOutputStream pdfSaida = new ByteArrayOutputStream();

//        pdfSaida.write(pdfEntradaIS.readAllBytes());
//        pdfSaida.write(pdfEntrada.readAllBytes());
//        pdfSaida.write(arquivoSemFooterBytes);

        PdfReader pdfReader = new PdfReader(pdfEntrada);
        PdfWriter pdfWriter = new PdfWriter(pdfSaida);

        PdfDocument pdfDocument = new PdfDocument(pdfReader, pdfWriter);
        Document document = new Document(pdfDocument);

        int numberOfPages = pdfDocument.getNumberOfPages();

        for (int i = 1; i <= numberOfPages; i++) {

            document.showTextAligned(new Paragraph(new Text(String.format("%s", i))
                                .setFontColor(ColorConstants.BLACK, 0.65f).setFontSize(10f)),
                        538, 40, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);

            document.showTextAligned(new Paragraph(new Text(String.format("_______________________________________________________________________________________\n\n" +
                                "Esta página é parte integrante e inseparável do Instrumento Particular de Constituição de Alienação\n" +
                                "de Bens Móveis (Floorplan) firmado entre o Banco Pan S.A. e a empresa " + numeroCCB + "\n" +
                                "em " + dataCCB)).setFontColor(ColorConstants.BLACK, 0.65f)
                                .setFontSize(10f)), 55, 40, i, TextAlignment.JUSTIFIED,
                        VerticalAlignment.BOTTOM, 0);

        }

        OutputStream pdfFooter = pdfWriter.getOutputStream();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byteArrayOutputStream.writeTo(pdfFooter);

        byte[] pdfComFooterByteArray = byteArrayOutputStream.toByteArray();


        return pdfComFooterByteArray;

    }



    protected void footerPDF(String pdfParaLer, String pdfParaEscrever) throws IOException {

        PdfReader pdfSemFooter = new PdfReader(pdfParaLer);
        PdfWriter pdfComFooter = new PdfWriter(pdfParaEscrever);

        PdfDocument pdfDocument = new PdfDocument(pdfSemFooter, pdfComFooter);
        Document document = new Document(pdfDocument);

        int numberOfPages = pdfDocument.getNumberOfPages();

        for (int i = 1; i <= numberOfPages; i++ ) {

            document.showTextAligned(new Paragraph( new Text(String.format("%s", i))
                            .setFontColor(ColorConstants.BLACK, 0.65f).setFontSize(10f)),
                    538, 40, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);

            document.showTextAligned(new Paragraph( new Text(String.format("_______________________________________________________________________________________\n\n" +
                            "Esta página é parte integrante e inseparável do Instrumento Particular de Constituição de Alienação\n" +
                            "de Bens Móveis (Floorplan) firmado entre o Banco Pan S.A. e a empresa " + numeroCCB + "\n" +
                            "em " + dataCCB)).setFontColor(ColorConstants.BLACK, 0.65f)
                            .setFontSize(10f)), 55, 40, i, TextAlignment.JUSTIFIED,
                    VerticalAlignment.BOTTOM, 0);

        }

//        PdfFont font = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
//        document.setFont(font);



        document.close();
    }

}
