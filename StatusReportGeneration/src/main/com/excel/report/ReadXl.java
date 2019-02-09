package com.excel.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXl {
	private static final String FILEPath = "C:\\Users\\HDMI\\Downloads\\standupReport.xlsx";

	public List<ListsReq> excelData() {
		List Names = new ArrayList();

		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILEPath);
			Workbook wb = new XSSFWorkbook(fis);
			int index = wb.getActiveSheetIndex();
			Sheet sheet = wb.getSheetAt(index);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {

				ListsReq listreq = new ListsReq();
				Row row = rowIterator.next();
				Cell cell = row.getCell(0);
				if (cell != null) {
					listreq.setNames(cell.getStringCellValue());
				}

				Names.add(listreq);
			}
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Names;
	}
}
