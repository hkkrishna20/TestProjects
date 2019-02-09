package com.compare.main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class TestPdf {

	public static void main(String[] args) throws Exception {

		 File file = new File("C:\\Users\\dell pc\\Documents\\compare\\test.pdf");
		   /* PDDocument document = PDDocument.load(file);        
		    PDFTextStripper pdfStripper = new PDFTextStripper();
		    pdfStripper.setParagraphEnd("/n");
		  //  pdfStripper.setSortByPosition(true);
		   String text = pdfStripper.getText(document);
		   System.out.println(text);*/
		    /*for (String line: pdfStripper.getText(document).split(pdfStripper.getParagraphStart(),pdfStripper.getParagraphEnd()))
		            {
		                System.out.println(line);
		                System.out.println("********************************************************************");
		            }*/
		 
		 InputStream inputStream =  new FileInputStream(file);
			XWPFDocument doc=new XWPFDocument(OPCPackage.open(inputStream));
			List<XWPFParagraph> paraList = doc.getParagraphs();
			for (XWPFParagraph xwpfParagraph : paraList) {
				System.out.println(xwpfParagraph.getText());
			}
	}

}
