package com.example.termojuridico.itext7;

import com.example.termojuridico.FalhaDeDelecaoException;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

public class HtmlToPdf extends PdfStream{

    private Long numeroCCB;
    private LocalDate dataCCB;

    public void createPDF(String HTMLsource, byte[] pdfSemFooter) throws IOException {

        FileInputStream FIS = new FileInputStream(HTMLsource);
        ByteArrayInputStream htmlIS = new ByteArrayInputStream(FIS.readAllBytes());
        ByteArrayOutputStream pdfOS = new ByteArrayOutputStream();

        HtmlConverter.convertToPdf(htmlIS, pdfOS);

        this.footerPDF(pdfOS.toByteArray());
    }

//            this.footerPDFByteArray(arquivoEm64);

//        try {
//
//            deleteFile(pdfSemFooter);
//            deleteFile(pdfComFooter);
//
//        } catch(FalhaDeDelecaoException ex) {
//
//            ex.getMessage();
//        }


    protected void footerPDF(byte[] pdfParaLer) throws IOException {

        ByteArrayInputStream pdfParaLerBIS = new ByteArrayInputStream(pdfParaLer);
        ByteArrayOutputStream pdfParaEscreverBOS = new ByteArrayOutputStream();

        PdfReader pdfSemFooter = new PdfReader(pdfParaLerBIS);
        PdfWriter pdfComFooter = new PdfWriter(pdfParaEscreverBOS);

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
                            "em " + dataCCB + " " + LocalDateTime.now())).setFontColor(ColorConstants.BLACK, 0.65f)
                            .setFontSize(10f)), 55, 40, i, TextAlignment.JUSTIFIED,
                    VerticalAlignment.BOTTOM, 0);

        }

        document.close();

        ByteArrayInputStream fileInputStream = new ByteArrayInputStream(pdfParaEscreverBOS.toByteArray());
        String arquivoEm64 = new String(Base64.getEncoder().encode(fileInputStream.readAllBytes()));

        byte[] decodePdf = Base64.getDecoder().decode(new String(arquivoEm64).getBytes());
        String decodedPdfBase64 = new String(decodePdf);

        System.out.println(arquivoEm64);

    }


//    public void deleteFile(String pdfToBeDeleted) throws FalhaDeDelecaoException {
//        File fileToBeDeleted = new File(pdfToBeDeleted);
//
//
//            Boolean exception = fileToBeDeleted.delete();
//
//            if(exception)
//                throw new FalhaDeDelecaoException();
//
//    }
//
//    protected byte[] footerPDFByteArray(String arquivoSemFooter) throws IOException {
//
//        byte[] arquivoSemFooterBytes = Base64.getDecoder().decode(arquivoSemFooter);
//
//        ByteArrayInputStream pdfEntrada = new ByteArrayInputStream(arquivoSemFooterBytes);
//        ByteArrayOutputStream pdfSaida = new ByteArrayOutputStream();
//
////        pdfSaida.write(pdfEntradaIS.readAllBytes());
////        pdfSaida.write(pdfEntrada.readAllBytes());
////        pdfSaida.write(arquivoSemFooterBytes);
//
//        PdfReader pdfReader = new PdfReader(pdfEntrada);
//        PdfWriter pdfWriter = new PdfWriter(pdfSaida);
//
//        PdfDocument pdfDocument = new PdfDocument(pdfReader, pdfWriter);
//        Document document = new Document(pdfDocument);
//
//        int numberOfPages = pdfDocument.getNumberOfPages();
//
//        for (int i = 1; i <= numberOfPages; i++) {
//
//            document.showTextAligned(new Paragraph(new Text(String.format("%s", i))
//                                .setFontColor(ColorConstants.BLACK, 0.65f).setFontSize(10f)),
//                        538, 40, i, TextAlignment.RIGHT, VerticalAlignment.BOTTOM, 0);
//
//            document.showTextAligned(new Paragraph(new Text(String.format("_______________________________________________________________________________________\n\n" +
//                                "Esta página é parte integrante e inseparável do Instrumento Particular de Constituição de Alienação\n" +
//                                "de Bens Móveis (Floorplan) firmado entre o Banco Pan S.A. e a empresa " + numeroCCB + "\n" +
//                                "em " + dataCCB)).setFontColor(ColorConstants.BLACK, 0.65f)
//                                .setFontSize(10f)), 55, 40, i, TextAlignment.JUSTIFIED,
//                        VerticalAlignment.BOTTOM, 0);
//
//        }
//
//        OutputStream pdfFooter = pdfWriter.getOutputStream();
//
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//
//        byteArrayOutputStream.writeTo(pdfFooter);
//
//        byte[] pdfComFooterByteArray = byteArrayOutputStream.toByteArray();
//
//
//        return pdfComFooterByteArray;
//
//    }

}
