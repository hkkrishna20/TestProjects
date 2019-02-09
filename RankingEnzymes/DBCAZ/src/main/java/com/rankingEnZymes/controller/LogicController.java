package com.rankingEnZymes.controller;
/*package com.rankingEnZymes.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@SuppressWarnings("unused")
@CrossOrigin(origins = "https://gateway3.cgi.com/,DanaInfo=localhost,Port=4200+")
@ComponentScan(basePackages = "com")
@RestController
public class NgRestController {
	@RequestMapping(value = "sendReport", method = RequestMethod.POST)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public ResponseEntity<?> sendReport(UriComponentsBuilder ucBuilder) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/encomm/get/{id}").buildAndExpand("1234").toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "reportList", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public static List<String> listFilesr(@RequestParam String fileName) {
		String path = "C:\\Users\\Public\\POC Files\\BaseDir\\Report\\";
		File dir = new File(fileName);
		File[] files = dir.listFiles();
		List<String> fileNames = new ArrayList<String>();
		Arrays.sort(files, new Comparator<File>() {
			public int compare(File f1, File f2) {
				return Long.valueOf(f2.lastModified()).compareTo(f1.lastModified());
			}
		});
		for (int index = 0; index < files.length; index++) {
			// Print out the name of files in the directory
			if (files[index].getName().startsWith("~$")) {
				continue;
			}
			if (files[index].isDirectory()) {
				continue;
			}
			fileNames.add(path + files[index].getName());
			System.out.println(files[index].getName());
		}
		System.out.println(fileNames.get(0));
		return fileNames;
	}

	@RequestMapping(value = "previewList", method = RequestMethod.POST)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public Preview preview(@RequestParam String fileName) throws IOException, JAXBException {
		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		List<String> versionList = new ArrayList<String>();
		Preview previW = new Preview();
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				versionList.add("" + fileTableTypes.get(i).getVersionNo());
			}
		}
		previW.setBaseFileVersion(versionList.get(0));
		previW.setVersions(versionList);
		return previW;
	}

	@RequestMapping(value = "saveList", method = RequestMethod.POST)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public ContentInfoStatus saveList(@RequestParam String fileName, @RequestParam String version,
			@RequestParam List<String> contentList) throws IOException {

		DefaultArtifactVersion minVersion = new DefaultArtifactVersion("");
		DefaultArtifactVersion maxVersion = new DefaultArtifactVersion("");

		DefaultArtifactVersion versionNeww = new DefaultArtifactVersion("");

		if (versionNeww.compareTo(minVersion) < 0 || versionNeww.compareTo(maxVersion) > 0) {
			System.out.println("Sorry, your version is unsupported");
		}

		int fileId = 0;
		String formId = "";
		float versionNew = 0;

		ContentInfoStatus status = new ContentInfoStatus();
		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		int count = 0;
		float versionRest = 0;
		if (!(version.equals("new"))) {
			versionRest = Float.valueOf(version);
		} else {
			versionRest = -1;
		}
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (count == 0) {
					minVersion = new DefaultArtifactVersion("" + fileTableTypes.get(i).getVersionNo());
					maxVersion = new DefaultArtifactVersion("" + fileTableTypes.get(i).getVersionNo());
					count++;
				}

				DefaultArtifactVersion testVersion = new DefaultArtifactVersion(
						"" + fileTableTypes.get(i).getVersionNo());
				if (testVersion.compareTo(minVersion) < 0) {
					minVersion = testVersion;
				}
				if (testVersion.compareTo(minVersion) > 0) {
					maxVersion = testVersion;
				}
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(versionRest) == 0) {
					{
						formId = fileTableTypes.get(i).getFormId();
						fileId = fileTableTypes.get(i).getFileId();
					}

				}
			}
		}

		DefaultArtifactVersion testVersion = new DefaultArtifactVersion("");
		float f = 0;
		if (version.equals("new")) {
			double value = Float.valueOf(maxVersion.toString());
			value = value + 0.1;
			version = "" + value;
		}
		String paraList = "";

		for (int i = 0; i < contentList.size(); i++) {
			paraList = paraList + "<ParaType><paraSeq>" + (i + 1) + "</paraSeq><content>" + contentList.get(i)
					+ "</content></ParaType>";
		}

		String testString = "<fileTable><formId>" + formId + "</formId><formTitle>" + fileName
				+ "</formTitle><versionNo>" + version + "</versionNo>" + paraList + "</fileTable>";

		System.out.println(testString);
		String urlSave = "https://gateway3.cgi.com/,DanaInfo=localhost,Port=2018+IntegrationRest/encomm/save";
		postClient(urlSave, testString, "application/xml");

		status.setStatus("success");
		status.setVersion(version);
		System.out.println(fileName);
		return status;

	}

	@RequestMapping(value = "getCompareParalist", method = RequestMethod.POST)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public CompareList getCompareParalist(@RequestParam String fileName, @RequestParam String baseFileVersion,
			@RequestParam String compareFileVersion) throws IOException, JAXBException {
		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		Integer baseFileId = 0;
		Integer compareFileId = 0;
		CompareList compList = new CompareList();
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(Float.valueOf(baseFileVersion)) == 0) {
					baseFileId = fileTableTypes.get(i).getFileId();
					break;
				}

			}
		}
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(Float.valueOf(compareFileVersion)) == 0) {
					{
						compareFileId = fileTableTypes.get(i).getFileId();
						break;
					}

				}
			}
		}
		List<String> baseFileVersionList = new ArrayList<String>();
		List<String> compareFileVersionList = new ArrayList<String>();
		FileTableType baseFile = encommFileTableTypeService.get(baseFileId);
		FileTableType compareFile = encommFileTableTypeService.get(compareFileId);
		if (baseFile == null || compareFile == null) {
			System.out.println("");
			compList.setFileName(fileName);
			compList.setBaseVersionParaList(baseFileVersionList);
			compList.setCompareVersionParaList(compareFileVersionList);

			return compList;
		}

		System.out.println(baseFile.getParas().size());
		System.out.println(compareFile.getParas().size());
		List<ParaType> contentTableList = encommContentTypeService.getAll();

		for (int i = 0; i < contentTableList.size(); i++) {
			ParaType para = contentTableList.get(i);
			if (para.getFileId() == baseFileId) {
				System.out.println("Base File Content" + para.getContent());
				baseFileVersionList.add(para.getContent());
			}
			if (para.getFileId() == compareFileId) {
				System.out.println("compareFileIdContent" + para.getContent());
				compareFileVersionList.add(para.getContent());
			}
		}

		for (int j = 0; j < baseFile.getParas().size(); j++) {
			baseFileVersionList.add(baseFile.getParas().get(j).getContent());
		}
		for (int j = 0; j < compareFile.getParas().size(); j++) {
			compareFileVersionList.add(compareFile.getParas().get(j).getContent());
		}
		compList.setFileName(fileName);
		compList.setBaseVersionParaList(baseFileVersionList);
		compList.setCompareVersionParaList(compareFileVersionList);
		System.out.println("");
		CompareList c = new CompareList();
		return compList;
	}

	@RequestMapping(value = "getFileId/{fileName}/{version}", method = RequestMethod.GET)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	public String getFileId(@PathVariable String fileName, @PathVariable String version) throws Exception {

		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		int fileId = 0;
		CompareList compList = new CompareList();
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(Float.valueOf(version)) == 0) {
					fileId = fileTableTypes.get(i).getFileId();
					break;
				}

			}
		}

		if (fileId == 0) {
			return null;
		}
		return new String("" + fileId);
	}

	@RequestMapping(value = "genFile/{fileName}", method = RequestMethod.GET)

public String genFile(@PathVariable(name = "fileName") String fileName) throws Exception {

		String[] files = fileName.split("_");
		fileName = files[0];
		String version = files[1];
		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		int fileId = 0;
		CompareList compList = new CompareList();
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(Float.valueOf(version)) == 0) {
					fileId = fileTableTypes.get(i).getFileId();
					break;
				}

			}
		}

		if (fileId == 0) {
			return null;
		}
		FileTableType file = encommFileTableTypeService.find(fileId);

		String url = "http://localhost:2018/IntegrationRest/get/" + fileId;
		String output = getClient(url);
		if (output == null) {
			return null;
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(ListofResponseObject.class);
		StringReader reader = new StringReader(output);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ListofResponseObject objOutput = (ListofResponseObject) jaxbUnmarshaller.unmarshal(reader);
		List<String> paraSortList = new ArrayList<String>();
		for (int i = 0; i < objOutput.getResponses().get(0).getParaType().size(); i++) {
			paraSortList.add("" + objOutput.getResponses().get(0).getParaType().get(i).getParaSeq());
		}
		Collections.sort(paraSortList);
		System.out.println(paraSortList);

		String reqID = "" + generateString();
		String documentID = reqID;
		String OutputFolder = "C:\\Users\\Public\\ouput\\";
		fileName = fileName.replace(".", "");
		String outputFile = OutputFolder + reqID + ".pdf";
		File fileTest = new File(outputFile);
		FileOutputStream fileout = new FileOutputStream(fileTest);

		Document document = new Document(PageSize.A4);
		// ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, fileout);
		document.open();
		document = addMetaData(document);
		document = addTitlePage(document);
		document = addMetaData(document, writer, paraSortList, objOutput);
		document.close();
		File fileN = new File(outputFile);
		if (!fileN.exists()) {
			throw new Exception("File does not exists: " + fileN.getPath());
		}
		String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(fileN.toPath()));
		Resource resource = new FileSystemResource(new File(outputFile));
		return "Success";
	}

		@RequestMapping(value = "getPDF", method = RequestMethod.POST)

		public ResponseEntity<?> getPDF(@RequestParam String fileName, @RequestParam String version) throws Exception {
		Response.ResponseBuilder responseBuilder = null;
			List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		int fileId = 0;
		CompareList compList = new CompareList();
		for (int i = 0; i < fileTableTypes.size(); i++) {
			if (fileName.equals(fileTableTypes.get(i).getFormTitle())) {
				if (new Float(fileTableTypes.get(i).getVersionNo()).compareTo(Float.valueOf(version)) == 0) {
					fileId = fileTableTypes.get(i).getFileId();
					break;
				}

			}
		}

		if (fileId == 0) {
			return null;
		}
		FileTableType file = encommFileTableTypeService.find(fileId);

		String url = "http://localhost:2018/IntegrationRest/get/" + fileId;
		String output = getClient(url);
		if (output == null) {
			return null;
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(ListofResponseObject.class);
		StringReader reader = new StringReader(output);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		ListofResponseObject objOutput = (ListofResponseObject) jaxbUnmarshaller.unmarshal(reader);
		List<String> paraSortList = new ArrayList<String>();
		for (int i = 0; i < objOutput.getResponses().get(0).getParaType().size(); i++) {
			paraSortList.add("" + objOutput.getResponses().get(0).getParaType().get(i).getParaSeq());
		}
		Collections.sort(paraSortList);
		System.out.println(paraSortList);

		String reqID = "" + generateString();
		String documentID = reqID;
		String OutputFolder = "C:\\Users\\Public\\ouput\\";
		fileName = fileName.replace(".", "");
		String outputFile = OutputFolder + reqID + ".pdf";
		File fileTest = new File(outputFile);
		FileOutputStream fileout = new FileOutputStream(fileTest);

		Document document = new Document(PageSize.A4);
		// ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		PdfWriter writer = PdfWriter.getInstance(document, fileout);
		document.open();
		document = addMetaData(document);
		document = addTitlePage(document);
		document = addMetaData(document, writer, paraSortList, objOutput);
		document.close();
		File fileN = new File(outputFile);
		if (!fileN.exists()) {
			throw new Exception("File does not exists: " + fileN.getPath());
		}
		String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(Files.readAllBytes(fileN.toPath()));
		}
		
		Resource resource = new FileSystemResource(new File(outputFile));
		
		
		return resource;
	}



	
	
	
	private Document addMetaData(Document document, PdfWriter writer, List<String> paraSortList,
			ListofResponseObject objOutput) throws DocumentException {
		for (int i = 0; i < paraSortList.size(); i++) {
			for (int j = 0; j < objOutput.getResponses().get(0).getParaType().size(); j++) {
				if (paraSortList.get(i)
						.equals("" + objOutput.getResponses().get(0).getParaType().get(j).getParaSeq())) {
					// paragraph2.setAlignment(Element.ALIGN_LEFT);
					Paragraph paragraph = new Paragraph();
					paragraph.add(objOutput.getResponses().get(0).getParaType().get(j).getContent());
					paragraph.setAlignment(Element.PARAGRAPH);
					document.add(paragraph);
					break;
				}
			}

		}
		Chunk chunk = new Chunk(
				"iText TestiText TestiText TestiText Test iText Test iText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText TestiText Test");
		Font font = new Font();
		font.setStyle(Font.UNDERLINE);
		font.setStyle(Font.ITALIC);
		chunk.setFont(font);
		chunk.setBackground(BaseColor.CYAN);
		Paragraph paragraph2 = new Paragraph();
		paragraph2.add(chunk);
		document.add(paragraph2);
		document.newPage();
		PdfContentByte cb = writer.getDirectContent();
		String code402 = "" + Barcode128.FNC1;
		String code90 = "EncommPOC" + Barcode128.FNC1;
		String code421 = "";
		String data = code402 + code90 + code421;
		Barcode128 shipBarCode = new Barcode128();
		shipBarCode.setX(0.75f);
		shipBarCode.setN(1.5f);
		shipBarCode.setChecksumText(true);
		shipBarCode.setGenerateChecksum(true);
		shipBarCode.setSize(10f);
		shipBarCode.setTextAlignment(Element.ALIGN_CENTER);
		shipBarCode.setBaseline(10f);
		shipBarCode.setCode(data);
		shipBarCode.setBarHeight(50f);
		Image imgShipBarCode = shipBarCode.createImageWithBarcode(cb, BaseColor.BLACK, BaseColor.BLUE);
		document.add(imgShipBarCode);

		return document;
	}

	private static Document addTitlePage(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Encomm POC  document", catFont));
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("Report generated by: Encomm POC user Team" + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$
				smallBold));
		addEmptyLine(preface, 8);
		preface.add(new Paragraph("This document is a preliminary version.", redFont));
		document.add(preface);
		// Start a new page
		document.newPage();
		return document;
	}

	*//**
	 * HTTP DELETE - Delete
	 *//*
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=4200+",
			"https://gateway3.cgi.com/,DanaInfo=10.154.75.96,Port=6003+",
			"https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	@RequestMapping(value = "/encomm/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePost(@PathVariable("id") String id) {
		FileTableType inc = encommFileTableTypeService.find(Integer.parseInt(id));
		Collection<ParaType> contentTable = inc.getParas();
		if (inc != null) {
			for (ParaType s : contentTable)
				encommContentTypeService.remove(s);
			encommFileTableTypeService.remove(inc);
		}
		return new ResponseEntity<String>(HttpStatus.GONE);
	}

	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=4200+",
			"https://gateway3.cgi.com/,DanaInfo=10.154.75.96,Port=6003+",
			"https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	@RequestMapping(value = "/encomm/getAll", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String getAllPosts(Pageable pageable) throws Exception {
		List<ResponseObject> listofResponses = new ArrayList<ResponseObject>();
		List<FileTableType> fileTableTypes = encommFileTableTypeService.getAll();
		List<ParaType> ParaTypes = encommContentTypeService.getAll();
		if (fileTableTypes == null || fileTableTypes.size() < 0 || fileTableTypes.isEmpty()) {
			return null;
		}
		for (int i = 0; i < fileTableTypes.size(); i++) {
			ResponseObject response = new ResponseObject();
			FileTableType inc = fileTableTypes.get(i);
			response.setFileId(inc.getFileId());
			response.setFormId(inc.getFormId());
			response.setFormTitle(inc.getFormTitle());
			response.setVersionNo(inc.getVersionNo());
			for (int j = 0; j < ParaTypes.size(); j++) {
				ContentObj obj = new ContentObj();
				if (inc.getFileId() == ParaTypes.get(j).getFileId()) {
					obj.setContent(ParaTypes.get(j).getContent());
					obj.setContentId(ParaTypes.get(j).getContentId());
					obj.setParaSeq(ParaTypes.get(j).getParaSeq());
					response.getParaType().add(obj);
				}
			}
			listofResponses.add(response);
		}
		ListofResponseObject obj = new ListofResponseObject();
		obj.setResponses(listofResponses);

		String o = convertObjectToXML(obj);
		return o;
	}

	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=4200+",
			"https://gateway3.cgi.com/,DanaInfo=10.154.75.96,Port=6003+",
			"https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	@RequestMapping(value = "/encomm/get/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public String get(@PathVariable("id") String id) throws Exception {
		FileTableType inc = encommFileTableTypeService.find(Integer.parseInt(id));
		if (inc == null)
			return null;
		ResponseObject response = new ResponseObject();
		response.setFileId(inc.getFileId());
		response.setFormId(inc.getFormId());
		response.setFormTitle(inc.getFormTitle());
		response.setVersionNo(inc.getVersionNo());
		List<ParaType> ParaTypes = encommContentTypeService.getAll();
		for (int j = 0; j < ParaTypes.size(); j++) {
			ContentObj obj = new ContentObj();
			if (inc.getFileId() == ParaTypes.get(j).getFileId()) {
				obj.setContent(ParaTypes.get(j).getContent());
				obj.setContentId(ParaTypes.get(j).getContentId());
				obj.setParaSeq(ParaTypes.get(j).getParaSeq());
				response.getParaType().add(obj);
			}
		}
		List<ResponseObject> resp = new ArrayList<ResponseObject>();
		resp.add(response);
		ListofResponseObject obj = new ListofResponseObject();
		obj.setResponses(resp);
		String o = convertObjectToXML(obj);
		return o;
	}

	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=4200+",
			"https://gateway3.cgi.com/,DanaInfo=10.154.75.96,Port=6003+",
			"https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	@RequestMapping(value = "/encomm/save", method = { RequestMethod.PUT, RequestMethod.POST }, consumes = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> create(@Valid @RequestBody String file, UriComponentsBuilder ucBuilder)
			throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(com.encomm.models.content.entityTypeP.ObjectFactory.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		StreamSource sc = new StreamSource(new StringReader(file));
		JAXBElement<FileTableType> bookingElement = (JAXBElement<FileTableType>) unmarshaller.unmarshal(sc);
		FileTableType requestObject = bookingElement.getValue();
		List<FileTableType> fileFrmDb1 = encommFileTableTypeService.getAll();
		boolean check = false;
		int dbFileID = 0;
		for (FileTableType fileFrmDb : fileFrmDb1) {
			if (requestObject.getFormId().equalsIgnoreCase(fileFrmDb.getFormId())
					&& requestObject.getVersionNo() == fileFrmDb.getVersionNo()) {
				dbFileID = fileFrmDb.getFileId();
				check = true;
				break;
			}
		}
		int fileID = 0;
		fileID = (int) ((Math.random() * 900000000) + 100000000);
		if (!check) {
			if (0 == requestObject.getFileId()) {
				requestObject.setFileId(fileID);
			}
			encommFileTableTypeService.add(requestObject);
		} else {
			fileID = dbFileID;
			requestObject.setFileId(fileID);
			encommFileTableTypeService.update(requestObject);
		}
		if (requestObject.getParas().size() < 1) {
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/encomm/get/{id}").buildAndExpand(fileID).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}
		for (int i = 0; i < requestObject.getParas().size(); i++) {
			if (0 == requestObject.getParas().get(i).getFileId())
				requestObject.getParas().get(i).setFileId(fileID);
		}
		List<ParaType> contentDbFet = null;
		try {
			contentDbFet = encommContentTypeService.getAll();
		} catch (NoSuchElementException e) {
			contentDbFet = null;
		}
		if (null == contentDbFet || contentDbFet.isEmpty() || (contentDbFet.size() < 1)) {
			for (int i = 0; i < requestObject.getParas().size(); i++) {
				int contentID = 0;
				contentID = (int) ((Math.random() * 900000000) + 100000000);
				if (0 == requestObject.getParas().get(i).getContentId()) {
					requestObject.getParas().get(i).setContentId(contentID);
					System.out.println();
					encommContentTypeService.add(requestObject.getParas().get(i));
				}
			}
		} else {
			for (int j = 0; j < requestObject.getParas().size(); j++) {
				int matchedContentId = -1;
				boolean checkk = false;
				ParaType para = requestObject.getParas().get(j);
				for (int i = 0; i < contentDbFet.size(); i++) {
					if (para.getParaSeq() == contentDbFet.get(i).getParaSeq()
							&& (para.getFileId() == contentDbFet.get(i).getFileId())) {
						System.out.println();
						requestObject.getParas().get(j).setContentId(contentDbFet.get(i).getContentId());
						matchedContentId = contentDbFet.get(i).getContentId();
						System.out.println(matchedContentId);
						checkk = true;
						break;
					}
				}
				if (!checkk) {
					int contentID = 0;
					contentID = (int) ((Math.random() * 900000000) + 100000000);
					if (0 == para.getContentId())
						requestObject.getParas().get(j).setContentId(contentID);
				}
				ParaType contentDbFetch = null;
				try {
					if (matchedContentId != -1)
						contentDbFetch = encommContentTypeService.get(matchedContentId);
				} catch (NoSuchElementException e) {
					contentDbFetch = null;
				}
				if (null == contentDbFetch) {
					int contentID = 0;
					contentID = (int) ((Math.random() * 900000000) + 100000000);
					requestObject.getParas().get(j).setContentId(contentID);
					encommContentTypeService.add(requestObject.getParas().get(j));
				} else if (para.getParaSeq() == contentDbFetch.getParaSeq()
						&& (para.getContent().equals(contentDbFetch.getContent()))
						&& (para.getFileId() == contentDbFetch.getFileId())) {
					continue;
				} else {
					if (para.getFileId() == contentDbFetch.getFileId()) {
						if ((para.getParaSeq() != contentDbFetch.getParaSeq()
								|| (!(para.getContent().equals(contentDbFetch.getContent()))))) {
							encommContentTypeService.update(requestObject.getParas().get(j));
						}
					} else {
						int contentID = 0;
						contentID = (int) ((Math.random() * 900000000) + 100000000);
						requestObject.getParas().get(j).setContentId(contentID);
						encommContentTypeService.add(requestObject.getParas().get(j));
					}
				}
			}
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/encomm/get/{id}").buildAndExpand(fileID).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	@CrossOrigin(origins = { "https://gateway3.cgi.com/,DanaInfo=localhost,Port=6003+" })
	void send(@RequestParam String toEmail, @RequestParam String ccEmail, @RequestParam String bccEmail,
			@RequestParam String fileName) throws IOException {
		if (toEmail == null)
			toEmail = "";
		if (ccEmail == null)
			ccEmail = "";
		if (bccEmail == null)
			bccEmail = "";
		if (ccEmail.trim().isEmpty() && bccEmail.trim().isEmpty() && toEmail.trim().isEmpty()) {
			return;
		}
		final String username = "encommpoc@gmail.com";
		final String password = "thunderhead";
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.googlemail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			MimeMessage message = new MimeMessage(session);
			String[] bccListArray = bccEmail.split(";");
			String[] ccListArray = ccEmail.split(";");
			String[] toListArray = toEmail.split(";");
			List<String> cclist = Arrays.asList(ccListArray);
			List<String> bcclist = Arrays.asList(bccListArray);
			List<String> tolist = Arrays.asList(bccListArray);

			if (!(ccEmail.trim().isEmpty())) {
				if (ccListArray != null && cclist.size() > 0) {
					final Address[] toCcAddress = new InternetAddress[cclist.size()];
					for (int i = 0; i < toCcAddress.length; i++) {
						toCcAddress[i] = new InternetAddress(cclist.get(i));
					}
					message.addRecipients(Message.RecipientType.CC, toCcAddress);
				}

			}
			if (!(bccEmail.trim().isEmpty())) {
				if (bccListArray != null && bcclist.size() > 0) {
					final Address[] tobCcAddress = new InternetAddress[bcclist.size()];
					for (int i = 0; i < tobCcAddress.length; i++) {
						tobCcAddress[i] = new InternetAddress(bcclist.get(i));
					}
					message.addRecipients(Message.RecipientType.BCC, tobCcAddress);
				}
			}
			if (!(toEmail.trim().isEmpty())) {
				if (toListArray != null && tolist.size() > 0) {
					final Address[] toAddress = new InternetAddress[tolist.size()];
					for (int i = 0; i < toAddress.length; i++) {
						toAddress[i] = new InternetAddress(tolist.get(i));
					}
					message.addRecipients(Message.RecipientType.TO, toAddress);
				}
			}
			message.setFrom(new InternetAddress("encommpoc@gmail.com"));
			message.setSubject("This is the Subject Line!");
			Multipart multipart = new MimeMultipart();
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("\"<h1>This is actual message</h1>\"", "utf-8", "html");
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			if (fileName == null)
				attachmentBodyPart.attachFile(new File("C:\\Users\\Public\\POC Files\\actualFile.pdf"),
						"application/pdf", null);
			else
				attachmentBodyPart.attachFile(new File(fileName), "application/pdf", null);
			multipart.addBodyPart(attachmentBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private static Document addMetaData(Document document) {
		document.addTitle("Form Generate Module");
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
		document.addAuthor("Hari Krishna");
		document.addCreator("Hari Krishna");
		return document;
	}

	public static String postClient(String url, String o, String type) {
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.type(type).post(ClientResponse.class, o);
		String output = resp.getEntity(String.class);
		return trimXML(output);
	}

	
	 * public static ListofResponseObject getClient(String url, String type) {
	 * Client restClient = Client.create(); WebResource webResource =
	 * restClient.resource(url); ClientResponse resp =
	 * webResource.get(ClientResponse.class); ListofResponseObject output =
	 * resp.getEntity(ListofResponseObject.class); return output; }
	 
	public static String getClient(String url) {
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.get(ClientResponse.class);
		String output = resp.getEntity(String.class);
		return trimXML(output);
	}

	public static String convertObjectToXML(Object object) throws Exception {
		StringWriter stringWriter = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(
				new Class[] { FileTableType.class, ParaType.class, ResponseObject.class, ListofResponseObject.class });
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.marshal(object, stringWriter);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static String marshal(Object object) throws JAXBException {
		StringWriter stringWriter = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		Marshaller m = jc.createMarshaller();
		m.marshal(object, stringWriter);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static <E> ArrayList<E> toList(Iterable<E> iterable) {
		if (iterable instanceof List) {
			return (ArrayList<E>) iterable;
		}
		ArrayList<E> list = new ArrayList<E>();
		if (iterable != null) {
			for (E e : iterable) {
				list.add(e);
			}
		}
		return list;
	}

	public static String marshalToJson(Object o) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonVal = "";
		jsonVal = mapper.writeValueAsString(o);
		return jsonVal;
	}

	static String generateString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++)
			paragraph.add(new Paragraph(" "));
	}

	public static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory())
				listFilesForFolder(fileEntry);
			else if (fileEntry.isFile())
				filesInDir.add(folder.getAbsolutePath() + "\\" + fileEntry.getName());
		}
	}

	static String trimXML(String output) {
		if (output == null)
			return null;
		if (output.contains("<response><response>")) {
			output = output.replace("<response><response>", "<response>");
		}
		if (output.contains("</response></response>")) {
			output = output.replace("</response></response>", "</response>");
		}
		if (output.contains("<responses><responses>")) {
			output = output.replace("<responses><responses>", "<responses>");
		}
		if (output.contains("</responses></responses>")) {
			output = output.replace("</responses></responses>", "</responses>");
		}
		if (output.contains("<ListofResponseObject><ListofResponseObject>")) {
			output = output.replace("<ListofResponseObject><ListofResponseObject>", "<ListofResponseObject>");
		}

		if (output.contains("</ListofResponseObject></ListofResponseObject>")) {
			output = output.replace("</ListofResponseObject></ListofResponseObject>", "</ListofResponseObject>");
		}
		if (output.contains("</paraType></paraType>")) {
			output = output.replace("</paraType></paraType>", "</paraType>");
		}
		if (output.contains("<paraType><paraType>")) {
			output = output.replace("<paraType><paraType>", "<paraType>");
		}
		return output;
	}

	public static String getClient(String url, String type) {
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.accept(type).get(ClientResponse.class);
		String output = resp.getEntity(String.class);
		// return output;
		return trimXML(output);
	}

}
*/