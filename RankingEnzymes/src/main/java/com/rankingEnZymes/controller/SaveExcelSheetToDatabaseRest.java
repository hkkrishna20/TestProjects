package com.rankingEnZymes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.monitorjbl.xlsx.StreamingReader;
import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
import com.rankingEnZymes.model.FinalCAZymes.SettersAndGetters;
import com.rankingEnZymes.service.FinalCAZvService;
import com.rankingEnZymes.service.FungiCAZymesService;

@ComponentScan(basePackages = "com")
@RestController
public class SaveExcelSheetToDatabaseRest {

	@Autowired
	FinalCAZvService finalCAZvService;

	@Autowired
	FungiCAZymesService FungiCAZymesService;

	static String cellulosedegrading = "GH5; GH6; GH7; GH8; GH9; GH10; GH12; GH26; GH44; GH45; GH48; GH51; GH74; GH124; GH1; GH2; GH3; GH5; GH9; GH30; GH39; GH116; GH5; GH6; GH9; AA9; AA10; AA15; AA3; GH1; GH3; GH5; GH9; CBM1; CBM2; CBM3; CBM4; CBM6; CBM8; CBM9; CBM10; CBM16; CBM17; CBM28; CBM30; CBM37; CBM44; CBM46; CBM49; CBM59; CBM63; CBM64; CBM72";
	static String hemicellulosedegrading = "GH3; GH5; GH8; GH9; GH10; GH11; GH12; GH16; GH26; GH30; GH43; GH44; GH51; GH62; GH98; GH141;GH1; GH2; GH3; GH5; GH9; GH30; GH39; GH116; GH1; GH2; GH5; GH1; GH3; GH5; GH30; GH39; GH43; GH51; GH52; GH54; GH116; GH120;GH3; GH5; GH16; GH17; GH55; GH5; GH9; GH26; GH44; GH113; GH134; GH5; GH9; GH12; GH16; GH26; GH44; GH74; GH30; GH5;CE1; CE2; CE3; CE4; CE5; CE6; CE7; CE12; CE15; AA9; AA14;CBM2; CBM4; CBM6; CBM9; CBM13; CBM15; CBM22; CBM31; CBM35; CBM36; CBM37; CBM42; CBM54; CBM59; CBM60; CBM72;CBM13; CBM16; CBM23; CBM27; CBM29; CBM35; CBM59; CBM62; CBM72; CBM76; CBM80;CBM13; CBM42; CBM62; CBM44; CBM62; CBM65; CBM75; CBM76; CBM78; CBM80; CBM81; GH3; GH43; GH51; GH54; GH62; GH127; GH137; GH142; GH146;";
	static String lignindegrading = "AA1; AA2; AA3; AA4; AA5; AA6; AA8; AA9; AA12; CE1; CE15; CE10;";
	static String pectindegrading = "GH28; GH28; GH33; GH78; GH106;GH4; GH78; GH106; GH2; GH3; GH10; GH43; GH51; GH54; GH62;GH93; GH1; GH2; GH3; GH35; GH39; GH42; GH50; GH59; GH147;PL1; PL2; PL3; PL9; PL10; PL1; PL2; PL9; PL1; PL4; PL9; PL11;PL11; PL26; PL22; CE8; CE12; CE13; CE6; CBM41; CBM77; CBM13; CBM32; CBM51; CBM61; CBM80; CBM67; CBM62;";
	static String starchdegrading = "GH13; GH14; GH57; GH119; GH126;AA13; GH4; GH31; GH63; GH97; GH122; GT35; CBM20; CBM21; CBM25; CBM26; CBM34; CBM45; CBM53; CBM69; CBM74; CBM82; CBM83;";
	static String inulingrading = " GH32; GH91; CBM38";

	static String cellulosedegradingArray[] = cellulosedegrading.split(";");
	static String hemicellulosedegradingArray[] = hemicellulosedegrading.split(";");
	static String lignindegradingArray[] = lignindegrading.split(";");
	static String pectindegradingArray[] = pectindegrading.split(";");
	static String starchdegradingArray[] = starchdegrading.split(";");
	static String inulingradingArray[] = inulingrading.split(";");

	static List<String> cellulosedegradinglist = new ArrayList<String>(Arrays.asList(cellulosedegradingArray));
	static List<String> hemicellulosedegradinglist = new ArrayList<String>(Arrays.asList(hemicellulosedegradingArray));
	static List<String> lignindegradinglist = new ArrayList<String>(Arrays.asList(lignindegradingArray));
	static List<String> pectindegradinglist = new ArrayList<String>(Arrays.asList(pectindegradingArray));
	static List<String> starchdegradinglist = new ArrayList<String>(Arrays.asList(starchdegradingArray));
	static List<String> inulingradinglist = new ArrayList<String>(Arrays.asList(inulingradingArray));

	static List<String> uniquecellulosedegradinglistStrings = cellulosedegradinglist.stream().map(String::trim)
			.collect(Collectors.toList());
	static List<String> uniquehemicellulosedegradinglistStrings = hemicellulosedegradinglist.stream().map(String::trim)
			.collect(Collectors.toList());
	static List<String> uniquelignindegradinglistStrings = lignindegradinglist.stream().map(String::trim)
			.collect(Collectors.toList());
	static List<String> uniquepectindegradinglistStrings = pectindegradinglist.stream().map(String::trim)
			.collect(Collectors.toList());
	static List<String> uniquestarchdegradinglistStrings = starchdegradinglist.stream().map(String::trim)
			.collect(Collectors.toList());
	static List<String> uniqueinulingradinglistStrings = inulingradinglist.stream().map(String::trim)
			.collect(Collectors.toList());

	static List<String> uniquecellulosedegradinglist = uniquecellulosedegradinglistStrings.stream().distinct()
			.collect(Collectors.toList());
	static List<String> uniquehemicellulosedegradinglist = uniquehemicellulosedegradinglistStrings.stream().distinct()
			.collect(Collectors.toList());
	static List<String> uniquelignindegradinglist = uniquelignindegradinglistStrings.stream().distinct()
			.collect(Collectors.toList());
	static List<String> uniquepectindegradinglist = uniquepectindegradinglistStrings.stream().distinct()
			.collect(Collectors.toList());
	static List<String> uniquestarchdegradinglist = uniquestarchdegradinglistStrings.stream().distinct()
			.collect(Collectors.toList());
	static List<String> uniqueinulingradinglist = uniqueinulingradinglistStrings.stream().distinct()
			.collect(Collectors.toList());

	public void readFinalCAZvTypeExcel() throws IOException, InvalidFormatException {
		String path = System.getProperty("user.dir") + "/Final_CAZymes.xlsx";
		System.out.println(path);
		File file = new File(path);
		try (Workbook wb = StreamingReader.builder().open(file);) {
			DataFormatter df = new DataFormatter();
			Collections.sort(uniquecellulosedegradinglist);
			Collections.sort(uniquehemicellulosedegradinglist);
			Collections.sort(uniquelignindegradinglist);
			Collections.sort(uniquepectindegradinglist);
			Collections.sort(uniquestarchdegradinglist);
			Collections.sort(uniqueinulingradinglist);
			Map<String, String> colNamesmap = new HashMap<String, String>();
			// XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
			//Sheet sheet = wb.getSheetAt(0);
			List<List<Cell>> obj = new ArrayList<>();
			for (Row r : wb.getSheetAt(0)) {
				List<Cell> o = new ArrayList<>();
				for (Cell c : r) {
					o.add(c);
				}
				obj.add(o);
			}
			System.out.println(obj.size());
			//
			//int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			List<Cell> row0 = obj.get(0);
			int maxColumns = 0;
			String lastCellValue = "";
			String lastRowCellValue = "";
			//System.out.println(sheet.getLastRowNum());
			//System.out.println(sheet.getFirstRowNum());
			for (int j = 0; j < row0.size(); j++) {
				if (row0.get(j) != null) {
					String value = "";
					value = df.formatCellValue(row0.get(j));
					if (!value.trim().isEmpty()) {
						maxColumns = j;
						lastCellValue = value;
					}
				}
			}

			int mamxRows = 0;
			for (int j = 1; j < obj.size(); j++) {
				List<Cell> rown = obj.get(j);
				if (rown.get(0) != null) {
					String value = "";
					value = df.formatCellValue(rown.get(0));
					if (!value.trim().isEmpty()) {
						mamxRows = j;
						lastRowCellValue = value;
					}

				}
			}
			System.out.println(maxColumns + " " + lastCellValue);
			System.out.println(mamxRows + " " + lastRowCellValue);
		//	System.out.println(maxColumns + " " + rowCount);
			for (int i = 1; i < obj.size(); i++) {
				FinalCAZvType finall = new FinalCAZvType();
				Long cellulosedegrading = new Long("0");
				Long hemicellulosedegrading = new Long("0");
				Long lignindegrading = new Long("0");
				Long pectindegrading = new Long("0");
				Long starchdegrading = new Long("0");
				Long inulingrading = new Long("0");
				int cellulosedegradingCount = 0;
				int hemicellulosedegradingCount = 0;
				int lignindegradingCount = 0;
				int pectindegradingCount = 0;
				int starchdegradingCount = 0;
				int inulingradingCount = 0;
				if (null != obj.get(i)) {

					List<Cell> rowColNames = obj.get(0);
					List<Cell> row = obj.get(i);
					row0 = obj.get(1);
					for (int j = 0; j < maxColumns; j++) {
						String value = "";
						try {
							if (row.get(j) != null) {
								value = df.formatCellValue(row.get(j));
							}
							if ((!value.trim().isEmpty()) && value != null) {
								String cellName = getCellName(row0.get(j));
								cellName = cellName.replaceAll("2", "");
								value = value.trim() + "";
								String colName = rowColNames.get(j).getStringCellValue();
								colNamesmap.put(colName, colName);
								System.out.println(
										"colName................................................................."
												+ colName);

								for (String s : uniquecellulosedegradinglist) {
									if ((s.trim().equalsIgnoreCase(colName.trim()))) {
										cellulosedegrading = cellulosedegrading + (new Long(value));
										cellulosedegradingCount++;
										break;
										// Run your code here
									}
								}
								for (String s : uniquehemicellulosedegradinglist) {
									if ((s.trim().equalsIgnoreCase(colName.trim()))) {
										hemicellulosedegrading = hemicellulosedegrading + (new Long(value)); // Run your
																												// code
																												// here
										hemicellulosedegradingCount++;
										break;
									}
								}
								for (String s : uniquelignindegradinglist) {
									if ((s.trim().equalsIgnoreCase(colName.trim()))) {
										lignindegrading = lignindegrading + (new Long(value)); // Run your code here
										lignindegradingCount++;
										break;
									}
								}
								for (String s : uniquepectindegradinglist) {
									if ((s.trim().equalsIgnoreCase(colName.trim()))) {
										pectindegrading = pectindegrading + (new Long(value));// Run your code here
										pectindegradingCount++;
										break;
									}
								}

								for (String s : uniquestarchdegradinglist) {

									if ((s.trim().equalsIgnoreCase(colName.trim()))) {
										System.out.println(
												".................................................................");
										System.out.println("    S-" + s + "-colName-" + colName);

										starchdegrading = starchdegrading + (new Long(value)); // Run your code here
										starchdegradingCount++;
										break;
									}
								}
								for (String s : uniqueinulingradinglist) {
									if (s.trim().equalsIgnoreCase(colName.trim())) {
										inulingrading = inulingrading + (new Long(value)); // Run your code here
										inulingradingCount++;
										break;
									}
								}
								SettersAndGetters.setValue(cellName, value, finall);
							}
						} catch (Exception e) {
							String cellName = getCellName(row0.get(j));
							System.out.println("<Exception Block>");
							System.out.println(cellName + "    " + value);
							System.out.println(value);

							System.out.println("</Exception Block>");
							value = "" + value;

							String colName = rowColNames.get(j).getStringCellValue();
							// System.out.println(colName);

							for (String s : uniquecellulosedegradinglist) {
								// System.out.println(" S-" + s + "-colName-" + colName);
								if ((s.trim().equalsIgnoreCase(colName.trim()))) {
									cellulosedegrading = cellulosedegrading + (new Long(value));
									cellulosedegradingCount++;
									break;
									// Run your code here
								}
							}
							for (String s : uniquehemicellulosedegradinglist) {
								// System.out.println(" S-" + s + "-colName-" + colName);
								if ((s.trim().equalsIgnoreCase(colName.trim()))) {
									hemicellulosedegrading = hemicellulosedegrading + (new Long(value)); // Run your
																											// code
																											// here
									hemicellulosedegradingCount++;
									break;
								}
							}
							for (String s : uniquelignindegradinglist) {
								// System.out.println(" S-" + s + "-colName-" + colName);
								if ((s.trim().equalsIgnoreCase(colName.trim()))) {
									lignindegrading = lignindegrading + (new Long(value)); // Run your code here
									lignindegradingCount++;
									break;
								}
							}
							for (String s : uniquepectindegradinglist) {
								// System.out.println(" S-" + s + "-colName-" + colName);
								if ((s.trim().equalsIgnoreCase(colName.trim()))) {
									pectindegrading = pectindegrading + (new Long(value));// Run your code here
									pectindegradingCount++;
									break;
								}
							}
							for (String s : uniquestarchdegradinglist) {
								// System.out.println(" S-" + s + "-colName-" + colName);
								if ((s.trim().equalsIgnoreCase(colName.trim()))) {
									starchdegrading = starchdegrading + (new Long(value)); // Run your code here
									starchdegradingCount++;
									break;
								}
							}
							for (String s : uniqueinulingradinglist) {
								if (s.trim().equalsIgnoreCase(colName.trim())) {
									inulingrading = inulingrading + (new Long(value)); // Run your code here
									inulingradingCount++;
									break;
								}
							}
							SettersAndGetters.setValue(cellName, value, finall);
						}
					}
					System.out.println(uniquecellulosedegradinglist.size() + "-" + cellulosedegradingCount);
					System.out.println(uniquehemicellulosedegradinglist.size() + "-" + hemicellulosedegradingCount);
					System.out.println(uniquelignindegradinglist.size() + "-" + lignindegradingCount);
					System.out.println(uniquepectindegradinglist.size() + "-" + pectindegradingCount);
					System.out.println(uniquestarchdegradinglist.size() + "-" + starchdegradingCount);
					System.out.println(uniqueinulingradinglist.size() + "-" + inulingradingCount);
					System.out.println();
					System.out.println();
					finall.setCelluloseDegrading(cellulosedegrading);
					finall.setHemiCelluloseDegrading(hemicellulosedegrading);
					finall.setLigninDegrading(lignindegrading);
					finall.setPectinDegrading(pectindegrading);
					finall.setStarchDegrading(starchdegrading);
					finall.setInulin(inulingrading);
					finalCAZvService.add(finall);
					System.out.println();
				} else {
					System.out.println(i);

				}

			}
			final List<String> sortedStats = colNamesmap.entrySet().stream()
					.sorted(Comparator.comparing(Map.Entry::getValue, Comparator.naturalOrder())).map(Map.Entry::getKey)
					.collect(Collectors.toList());
			System.out.println(sortedStats);
			// Collections.sort(sortedStats);
			System.out.println(
					" ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println();
			System.out.println(
					"uniquecellulosedegradinglist------------------------------------------------------------------");
			System.out.println(uniquecellulosedegradinglist + "  " + uniquecellulosedegradinglist.size());
			System.out.println();
			System.out.println();

			System.out.println(
					"uniquehemicellulosedegradinglist------------------------------------------------------------------");
			System.out.println(uniquehemicellulosedegradinglist + "  " + uniquehemicellulosedegradinglist.size());
			System.out.println();
			System.out.println();

			System.out.println(
					"uniquelignindegradinglist------------------------------------------------------------------");
			System.out.println(uniquelignindegradinglist + "  " + uniquelignindegradinglist.size());
			System.out.println();
			System.out.println();

			System.out.println(
					"uniquepectindegradinglist------------------------------------------------------------------");
			System.out.println(uniquepectindegradinglist + "  " + uniquepectindegradinglist.size());
			System.out.println();
			System.out.println();

			System.out.println(
					"uniquestarchdegradinglist------------------------------------------------------------------");
			System.out.println(uniquestarchdegradinglist + "  " + uniquestarchdegradinglist.size());
			System.out.println();
			System.out.println();

			System.out.println(
					"uniqueinulingradinglist------------------------------------------------------------------");
			System.out.println(uniqueinulingradinglist + "  " + uniqueinulingradinglist.size());
		}
	}

	public void readFungiCAZymesExcel() throws IOException, InvalidFormatException {
		// File file = new File(filePath + "\\" + fileName);
		String path = System.getProperty("user.dir") + "/RankingFungi_CAZymes.xlsx";
		System.out.println(path);
		// File file = new File(path);

		// File file = new File("/Final_CAZymes.xlsx");
		// FileInputStream inputStream = new FileInputStream(file);
		DataFormatter df = new DataFormatter();
		List<String> sheetNames = new ArrayList<String>();
		File file = new File(path);
		OPCPackage opcPackage = OPCPackage.open(file.getAbsolutePath());
		XSSFWorkbook wb = new XSSFWorkbook(opcPackage);
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			sheetNames.add(wb.getSheetName(i));
			System.out.println(i + " ->" + wb.getSheetName(i));
		}

		Sheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row0 = sheet.getRow(1);
		int maxColumns = 0;
		for (int j = 0; j < row0.getLastCellNum(); j++) {
			if (row0.getCell(j) != null) {
				String value = "";
				value = df.formatCellValue(row0.getCell(j));
				if (value.trim().isEmpty()) {
					maxColumns = j;
				}
			}
		}

		System.out.println(maxColumns + " " + rowCount);
		for (int i = 1; i <= rowCount; i++) {
			FungiCAZymes finall = new FungiCAZymes();
			String genomeCode = "";
			String name = "";
			String published = "";
			String assemblyLength = "";
			String genes = "";

			if (null != sheet.getRow(i)) {
				Row row = sheet.getRow(i);
				row0 = sheet.getRow(1);
				for (int j = 0; j < maxColumns; j++) {
					String value = "";
					try {
						if (row.getCell(j) != null) {
							value = df.formatCellValue(row.getCell(j));
						}
						if ((!value.trim().isEmpty()) && value != null) {
							value = value.trim();
							String cellName = getCellName(row0.getCell(j));
							cellName = cellName.replaceAll("2", "");
							if (j == 0) {
								genomeCode = value;
							}
							if (j == 1) {

								name = value;
							}
							if (j == 2) {

								published = value;
							}
							if (j == 3) {

								assemblyLength = value;
							}
							if (j == 4) {

								genes = value;
							}
						}
					} catch (Exception e) {
						String cellName = getCellName(row0.getCell(j));
						System.out.println("<Exception Block>");
						System.out.println(cellName + "    " + value);
						System.out.println(value);
						System.out.println("</Exception Block>");
						value = "" + value;
						if (j == 0) {

							genomeCode = value;
						}
						if (j == 1) {

							name = value;
						}
						if (j == 2) {

							published = value;
						}
						if (j == 3) {

							assemblyLength = value;
						}
						if (j == 4) {

							genes = value;
						}
					}

				}
				finall.setGenes(genes);
				finall.setAssemblylength(assemblyLength);
				finall.setGenomecode(genomeCode);
				finall.setName(name);
				finall.setPublished(published);
				FungiCAZymesService.add(finall);
				System.out.println();
			} else {
				System.out.println(i);

			}

		}
	}

	@RequestMapping(value = "saveFinalCAZSheet", method = RequestMethod.GET)
	public ResponseEntity<?> insertFinalCAZ(UriComponentsBuilder ucBuilder) throws IOException, InvalidFormatException {
		readFinalCAZvTypeExcel();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "saveFungiRankSheet", method = RequestMethod.GET)
	public ResponseEntity<?> insertFungi(UriComponentsBuilder ucBuilder) throws IOException, InvalidFormatException {
		readFungiCAZymesExcel();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	private static String getCellName(Cell cell) {
		return "" + CellReference.convertNumToColString(cell.getColumnIndex()) + (cell.getRowIndex() + 1);
	}

}