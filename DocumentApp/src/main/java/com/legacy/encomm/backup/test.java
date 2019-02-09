package com.legacy.encomm.backup;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.POIXMLProperties.CoreProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class test {

	public static void main(String[] args) throws Exception {
	
		String string = null;
		String[] loggers = { "org.apache.pdfbox.util.PDFStreamEngine", "org.apache.pdfbox.pdmodel.font.PDSimpleFont",
				"org.apache.pdfbox.pdmodel.font.PDFont", "org.apache.pdfbox.pdmodel.font.FontManager",
				"org.apache.pdfbox.pdfparser.PDFObjectStreamParser",
				"org.apache.fontbox.util.autodetect.FontFileFinder", "org.apache.pdfbox.io.ScratchFileBuffer",
				"org.apache.pdfbox.pdmodel.font.FileSystemFontProvider",
				"org.apache.pdfbox.pdmodel.font.FileSystemFontProvider",
				"org.apache.fontbox.util.autodetect.FontFileFinder" };
		for (String logger : loggers) {
			org.apache.log4j.Logger logpdfengine = org.apache.log4j.Logger.getLogger(logger);
			logpdfengine.setLevel(org.apache.log4j.Level.OFF);
		}
		try {
			PDFParser pdfParser = new PDFParser(
					new RandomAccessFile(new File("C:\\Users\\Public\\POC Files\\BaseDir\\Test.pdf"), "r"));
			pdfParser.parse();
			PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
			PDFTextStripper pdfTextStripper = new PDFLayoutTextStripper();
			string = pdfTextStripper.getText(pdDocument);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(string);
		
		
		String OutputFolder = "C:\\Users\\harikrishna.manupadi\\Downloads\\";
		String outputFile = OutputFolder + "TestPDFExtract" + ".pdf";
		File fileTest = new File(outputFile);
		FileOutputStream fileout = new FileOutputStream(fileTest);
		Document document = new Document(PageSize.A4);
		PdfWriter writer = PdfWriter.getInstance(document, fileout);
		document.open();
		testDataPDF(string,document,writer);
		document.close();
		
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\Test.txt";
		Files.write(Paths.get(path), string.getBytes(), StandardOpenOption.CREATE);
		System.out.println("PDF Content Displaying.......................................");
		System.out.println(".......................................");
		System.out.println(".......................................");
		// System.out.println(string);
		System.out.println(".......................................");
		System.out.println(".......................................");
		// try {

		FileInputStream fis = new FileInputStream("C:\\Users\\Public\\POC Files\\BaseDir\\fPowerwriting.pptx");
		XMLSlideShow pptxshow = new XMLSlideShow(fis);
		//readPPT(pptxshow);
		/*
		 * List<XSLFSlide> slide2 = pptxshow.getSlides(); for (int i = 0; i <
		 * slide2.size(); i++) { System.out.println(i); try { XSLFNotes mynotes =
		 * slide2.get(i).getNotes(); for (XSLFShape shape : mynotes) { if (shape
		 * instanceof XSLFTextShape) { XSLFTextShape txShape = (XSLFTextShape) shape;
		 * for (XSLFTextParagraph xslfParagraph : txShape.getTextParagraphs()) {
		 * System.out.println(xslfParagraph.getText()); } } } } catch (Exception e) {
		 * 
		 * }
		 * 
		 * } } catch (IOException e) {
		 * 
		 * }
		 */
	}
private static Document testDataPDF(String string, Document document, PdfWriter writer) throws DocumentException {
		
		/*Font f=new Font(FontFamily.TIMES_ROMAN,14.0f,Font.NORMAL,BaseColor.BLACK);
		chunk.setFont(f);*/
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(string);
		//paragraph2.setAlignment(Element.PARAGRAPH);
		document.add(paragraph2);
		
		return document;
	}
	public static void readPPT(XMLSlideShow ppt) throws IOException {
		CoreProperties props = ppt.getProperties().getCoreProperties();
		String title = props.getTitle();
		String text = "";
		for (XSLFSlide slide : ppt.getSlides()) {
			XSLFShape[] shapes = slide.getShapes();
			for (XSLFShape shape : shapes) {
				if (shape instanceof XSLFTextShape) {
					XSLFTextShape textShape = (XSLFTextShape) shape;
					text = text + textShape.getText();

				}
			}
		}
		System.out.println(".......................................");
		System.out.println(".......................................");
		System.out.println("Power Point Content Displaying.......................................");
		System.out.println(text);
		System.out.println(".......................................");
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\Test2.txt";
		Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.CREATE);
	}

}
