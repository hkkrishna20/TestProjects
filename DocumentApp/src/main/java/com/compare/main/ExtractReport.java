package com.compare.main;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.web.multipart.MultipartFile;

public class ExtractReport {

	//public static String FilePath = "C:\\Users\\muralimohan.janakira\\Documents\\Test";
	public static String ExcelPath = "C:\\Users\\Public\\POC Files\\BaseDir\\Report\\";
	public void extractReport(MultipartFile[] listOfFiles) {
		
		XSSFRow row = null;
		XSSFCell cell = null;
		XSSFCell cell1 = null;
		 FileOutputStream fileOut = null;
		 XSSFWorkbook workbook = null;
		try{
		//File folder = new File(FilePath);
	//	File[] listOfFiles = folder.listFiles();
		if(listOfFiles.length > 1){
			
		    fileOut = new FileOutputStream(ExcelPath);
		    workbook = new XSSFWorkbook();
			XSSFSheet worksheet = workbook.createSheet("POI Worksheet");
		
			XSSFRow row1 = worksheet.createRow(0);
			XSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setWrapText(true);
			
			XSSFFont  font = workbook.createFont();
			font.setBold(true);
			font.setFontName("Calibri");
			cellStyle.setFont(font);
			
			cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);
			
			XSSFCell cellA1 = row1.createCell(0);
			cellA1.setCellValue("Item");
			cellA1.setCellStyle(cellStyle);
			
			XSSFCellStyle cellStyle1 = workbook.createCellStyle();
			cellStyle1.setWrapText(true);
			
			XSSFFont  font1 = workbook.createFont();
			font1.setFontName("Calibri");
			cellStyle1.setFont(font1);
			
			cellStyle1.setBorderBottom(BorderStyle.THIN);
			cellStyle1.setBorderLeft(BorderStyle.THIN);
			cellStyle1.setBorderRight(BorderStyle.THIN);
			cellStyle1.setBorderTop(BorderStyle.THIN);
			
			worksheet.setColumnWidth(0, 15000);
			BaseParaFile bsFile = getBaseParaList(listOfFiles);
			//merge cells
			int s=1;
			for(int i=0; i < listOfFiles.length; i++){
				worksheet.setColumnWidth(s, 15000);
				XSSFCell cellA2 = row1.createCell(s);
				XSSFCell cellA = row1.createCell(s+1);
		    	worksheet.addMergedRegion(new CellRangeAddress(0,0,s,s+1));
		    	cellA2.setCellValue(listOfFiles[i].getOriginalFilename());
		    	cellA2.setCellStyle(cellStyle);
		    	cellA.setCellStyle(cellStyle);
		    	s = s+2;
	    	}
			int x = 1;
		    for (int k = 0;  bsFile.getFiles().size() != 0; k++) {
		    	System.out.println(bsFile.getFileName()+": base File");
			    for(int i= k; i < listOfFiles.length; i++){
			    	if(i != 0) 
			    		x = (i*2)+1;
			    	System.out.println(listOfFiles[i].getOriginalFilename());
				    List<XWPFParagraph> paraList =  extractParaList(listOfFiles[i]);
				    	// get base file Items list
				    	for(int j=0; j < bsFile.getParaList().size(); j++){
				    		if(null == worksheet.getRow(j+1)){
					    		row = worksheet.createRow(j+1);
					    		cell = row.createCell(k);
					    		cell.setCellValue(bsFile.getParaList().get(j).getText().toString());
						    	cell.setCellStyle(cellStyle1);
					    	}
				    	}
				    	//compare f1->basefile f2->basefile... and para1->para1, para1->para2...
				    	for(int j=0; j < paraList.size(); j++){
				    		for(int y=0; y < bsFile.getParaList().size(); y++){
				    			if(null != worksheet.getRow(j+1)){
						    		row = worksheet.getRow(j+1);
					    			if(null == row.getCell(x) && null == row.getCell(x+1)){
						    			if(paraList.get(j).getText().equals(bsFile.getParaList().get(y).getText())){
					    					//row = worksheet.getRow(j+1);
					    					//cell for matching details
						    				cell = row.createCell(x);
							    			cell.setCellValue("Maching at "+bsFile.getFileName().toString()+" and para No:" + (y+1));
							    			cell.setCellStyle(cellStyle1);
							    			//cell1 for accuracy
							    			cell1 = row.createCell(x+1);
							    			cell1.setCellValue("100%");
							    			cell1.setCellStyle(cellStyle1);
							    			break;
							    	}
					    			else{
							    		if(null != worksheet.getRow(j+1)){
							    			WordAccuracy wa = new WordAccuracy();
							    			row = worksheet.getRow(j+1);
							    			int accuracy = wa.getAccuracy(paraList.get(j).getText(), bsFile.getParaList().get(y).getText());
							    			if(accuracy >= 90){
							    				cell = row.createCell(x);
							    				cell1 = row.createCell(x+1);
							    				cell.setCellValue("Maching at "+bsFile.getFileName().toString()+" and para No:" + (y+1));
								    			cell1.setCellValue(accuracy+"%");
							    			}else{
							    				cell = row.createCell(x);
							    				cell1 = row.createCell(x+1);
							    				cell.setCellValue(paraList.get(j).getText().toString());
							    				cell1.setCellValue("0%");
							    			}
							    			cell.setCellStyle(cellStyle1);
							    			cell1.setCellStyle(cellStyle1);
							    		}
							    	}
					    		}
					    			
				    			else if(null !=row.getCell(x) && null !=row.getCell(x+1) &&  !row.getCell(x+1).getStringCellValue().contains("100%") ){
					    			if(paraList.get(j).getText().equals(bsFile.getParaList().get(y).getText())){
					    				row = worksheet.getRow(j+1);
					    				cell = row.createCell(x);
					    				cell.setCellValue("Maching at "+bsFile.getFileName().toString()+" and para No:" + (y+1));
						    			cell.setCellStyle(cellStyle1);
						    			
						    			cell1 = row.createCell(x+1);
						    			cell1.setCellValue("100%");
						    			cell1.setCellStyle(cellStyle1);
						    			break;
							    	}
					    			else{
							    		if(null != worksheet.getRow(j+1)){
							    			WordAccuracy wa = new WordAccuracy();
							    			row = worksheet.getRow(j+1);
							    			int accuracy = wa.getAccuracy(paraList.get(j).getText(), bsFile.getParaList().get(y).getText());
							    			String value =row.getCell(x+1).getStringCellValue();
							    			value = value.replace("%", "");
							    			int previous = Integer.parseInt(value);
							    			if(accuracy >= 90 && accuracy > previous){
							    				cell = row.createCell(x);
							    				cell1 = row.createCell(x+1);
							    				cell.setCellValue("Maching at "+bsFile.getFileName().toString()+" and para No:" + (y+1));
								    			cell1.setCellValue(accuracy+"%");
							    			}else if(accuracy < 90 && previous < 90){
							    				cell = row.createCell(x);
							    				cell1 = row.createCell(x+1);
							    				cell.setCellValue(paraList.get(j).getText().toString());
							    			//	bsFile.getParaList().add(paraList.get(j));
							    				cell1.setCellValue("0%");
							    			}
							    			cell.setCellStyle(cellStyle1);
							    			cell1.setCellStyle(cellStyle1);
							    		}
							    	}
							    	

					    		}
				    	    }
				    	}		
				    					    	
				    }
			    }
			    //if(bsFile.getFileName() != bsFile.getFiles().get(k).getName()){
			    	  bsFile.setParaList(extractParaList(bsFile.getFiles().get(0)));
			    	  List<MultipartFile> bsList = bsFile.getFiles();
					  bsFile.setFileName(bsList.get(0).getOriginalFilename());
					  System.out.println(bsList.get(0).getOriginalFilename()+ "-----Sudha");
					  bsList.remove(0);
			    //}
		    }
		}
		
		workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static List<XWPFParagraph> extractParaList(MultipartFile file) throws Exception{
		
		//FileInputStream fis = new FileInputStream((File)file);
		InputStream inputStream =  new BufferedInputStream(file.getInputStream());
		XWPFDocument doc=new XWPFDocument(OPCPackage.open(inputStream));
		List<XWPFParagraph> paraList =  new ArrayList<XWPFParagraph>();		
	    for(XWPFParagraph para : doc.getParagraphs()){
	    	if(StringUtils.isNotBlank(para.getParagraphText())){
	    		paraList.add(para);
	    	}
	    }
	    
		return paraList;
		
	}
	
public static BaseParaFile getBaseParaList(MultipartFile[] listOfFiles) throws Exception{
	BaseParaFile bs = new BaseParaFile();	
	List<MultipartFile> fl = new ArrayList<MultipartFile>();
	String fileName = listOfFiles[0].getOriginalFilename();
			List<XWPFParagraph> para = extractParaList(listOfFiles[0]);
			bs.setParaList(para);
			bs.setFileName(fileName);
			for(int i = 1; i < listOfFiles.length; i++){
				List<XWPFParagraph> para2 = extractParaList(listOfFiles[i]);
				if(bs.getParaList().size() < para2.size()){
					fileName = listOfFiles[i].getOriginalFilename();
					bs.setFileName(fileName);
					bs.setParaList(para2);
					//bs.setFiles(files);
					System.out.println("inside getBaseParaList If: ");
				}
			}
			
			for(MultipartFile file: listOfFiles){
				if(!file.getOriginalFilename().equalsIgnoreCase(bs.getFileName())){
					fl.add(file);
					System.out.println("list of FIles: "+file.getOriginalFilename());
				}
			}
			bs.setFiles(fl);
			System.out.println(bs.getFileName()+""+bs.getFiles().size());
			return bs;
	}
}
