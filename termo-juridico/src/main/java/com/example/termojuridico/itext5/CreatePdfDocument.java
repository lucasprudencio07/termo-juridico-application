//package com.example.termojuridico.itext5;
//
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.html.simpleparser.HTMLWorker;
//import com.itextpdf.text.pdf.PdfWriter;
//
//import java.io.*;
//
//public class CreatePdfDocument {
//
//        public static void main(String... args) throws IOException, DocumentException {
//
//            String htmlPath = "C:\\Users\\re039550\\Desktop\\relatorio-teste.html";
//            String destinationFile = "C:\\Users\\re039550\\Documents\\pdfs\\testHeaderAndFooter.pdf";
//
//            // create document
//            Document document = new Document(PageSize.A4, 36, 36, 90, 36);
//            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(destinationFile));
//
//            // add header and footer
//            HeaderAndFooter event = new HeaderAndFooter();
//            writer.setPageEvent(event);
//
//            // write to document
//            document.open();
//
////            String htmlText = getStringHtml();
//
//            StringBuilder contentBuilder = new StringBuilder();
//
//            BufferedReader in = new BufferedReader(new FileReader(htmlPath));
//            String str;
//            while ((str = in.readLine()) != null) {
//                contentBuilder.append(str);
//            }
//            in.close();
//
//            String content = contentBuilder.toString();
//
//            HTMLWorker htmlWorker = new HTMLWorker(document);
//            htmlWorker.parse(new StringReader(content));
//
////            document.add(new Paragraph("Adding a footer to PDF Document using iText."));
//            document.close();
//        }

//}
