//package com.example.termojuridico.itext5;
//
//import com.itextpdf.text.*;
//import com.itextpdf.text.pdf.*;
//
//import java.io.File;
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.nio.file.Files;
//
//public class HeaderAndFooter extends PdfPageEventHelper {
//
//    private PdfTemplate t;
//    private Image total;
//
//    public void onOpenDocument(PdfWriter writer, Document document) {
//        t = writer.getDirectContent().createTemplate(30, 16);
//        try {
//            total = Image.getInstance(t);
//            total.setRole(PdfName.ARTIFACT);
//        } catch (DocumentException de) {
//            throw new ExceptionConverter(de);
//        }
//    }
//
//    @Override
//    public void onEndPage(PdfWriter writer, Document document) {
//        addHeader(writer);
//        addFooter(writer);
//    }
//
//    private void addHeader(PdfWriter writer){
//        PdfPTable header = new PdfPTable(2);
//        try {
//            // set defaults
//            header.setWidths(new int[]{13, 13});
//            header.setTotalWidth(527);
//            header.setLockedWidth(true);
//            header.getDefaultCell().setFixedHeight(40);
//            header.getDefaultCell().setBorder(Rectangle.BOTTOM);
//            header.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
//
//            // add image
//
//            File fi = new File("C:\\Users\\re039550\\Desktop\\logo.png");
//            byte[] fileContent = Files.readAllBytes(fi.toPath());
//
//            Image logo = Image.getInstance(fileContent);
//            logo.scaleAbsolute(40, 40);
//            header.addCell(logo);
////            header.addCell("testing the header");
//
//            // add text
//            PdfPCell text = new PdfPCell();
//            text.setPaddingBottom(15);
//            text.setPaddingLeft(10);
//            text.setBorder(Rectangle.BOTTOM);
//            text.setBorderColor(BaseColor.LIGHT_GRAY);
//            text.addElement(new Phrase("Instrumento Particular de Constituição de Alienação " +
//                    "Fiduciária em Garantia de Bens Móveis (Floor Plan) nº " +
//                    "[nº Instrumento Alienação]", new Font(Font.FontFamily.TIMES_ROMAN, 12)));
////            text.addElement(new Phrase("https://memorynotfound.com", new Font(Font.FontFamily.TIMES_ROMAN, 8)));
//            header.addCell(text);
//
//            // write content
//            header.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
//        } catch(DocumentException de) {
//            throw new ExceptionConverter(de);
//        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    private void addFooter(PdfWriter writer){
//        PdfPTable footer = new PdfPTable(3);
//        try {
//            // set defaults
//            footer.setWidths(new int[]{24, 2, 1});
//            footer.setTotalWidth(527);
//            footer.setLockedWidth(true);
//            footer.getDefaultCell().setFixedHeight(40);
//            footer.getDefaultCell().setBorder(Rectangle.TOP);
//            footer.getDefaultCell().setBorderColor(BaseColor.BLACK);
//
//            // add copyright
//            footer.addCell(new Phrase("Esta página é parte integrante e inseparável do Instrumento Particular de Constituição de Alienação Fiduciária em Garantia " +
//                    "de Bens Móveis (Floorplan) firmado entre o Banco Pan S.A. e a empresa [nº da CCB] em [Data da CCB]", new Font(Font.FontFamily.TIMES_ROMAN, 7)));
//
//            // add current page count
//            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//            footer.addCell(new Phrase(String.format("%d", writer.getPageNumber()), new Font(Font.FontFamily.TIMES_ROMAN, 10)));
//
//            // add placeholder for total page count
//            PdfPCell totalPageCount = new PdfPCell(total);
//            totalPageCount.setBorder(Rectangle.TOP);
//            totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
//            footer.addCell(totalPageCount);
//
//            // write page
//            PdfContentByte canvas = writer.getDirectContent();
//            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
//            footer.writeSelectedRows(0, -1, 34, 50, canvas);
//            canvas.endMarkedContentSequence();
//        } catch(DocumentException de) {
//            throw new ExceptionConverter(de);
//        }
//    }
//
//    public void onCloseDocument(PdfWriter writer, Document document) {
//        int totalLength = String.valueOf(writer.getPageNumber()).length();
//        int totalWidth = totalLength * 5;
//        ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
//                new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.TIMES_ROMAN, 8)),
//                totalWidth, 6, 0);
//    }
//
//}
