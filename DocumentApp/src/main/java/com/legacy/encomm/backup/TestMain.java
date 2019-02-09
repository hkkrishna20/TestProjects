package com.legacy.encomm.backup;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.codec.Charsets;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.bind.annotation.RequestParam;

import com.encomm.models.content.entity.ResponseObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class TestMain {
	public static void main(String[] args) throws IOException, JAXBException, URISyntaxException {
		/*
		 * String url = "http://localhost:2018/IntegrationRest/genFile/" +
		 * "ACCOPN01_AccountOpeningForm_V1.1~1.24"; String output = getClient(url,
		 * "application/xml"); System.out.println(output);
		 */
		String urlSave = "http://localhost:2018/IntegrationRest/encomm/save";

		byte[] encoded = Files.readAllBytes(Paths.get("C:\\Users\\Public\\POC files\\text.txt"));
		String content = new String(encoded, Charsets.UTF_8);
		postClient(urlSave, content);

		// listFilesr();
		/*
		 * String url = "http://localhost:2018/IntegrationRest/encomm/getAll"; String
		 * output = getClient(url, "application/xml"); System.out.println(output);
		 */
	}

	public static String convertObjectToXML(Object object) {
		try {
			StringWriter stringWriter = new StringWriter();
			JAXBContext context = JAXBContext.newInstance(object.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(object, stringWriter);
			return stringWriter.toString();
		} catch (JAXBException e) {
			System.err.println(String.format("Exception while marshalling: %s", e.getMessage()));
		}
		return null;
	}

	protected static <T> T convertXMLToObject(Class<T> clazz, String xml) throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		return unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), clazz).getValue();
	}

	public <T> T unMarshal(String content, Class<T> clasz) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clasz);
			Unmarshaller u = jc.createUnmarshaller();
			return u.unmarshal(new StreamSource(new StringReader(content)), clasz).getValue();
		} catch (JAXBException e) {
		}
		return null;
	}

	public static String marshal(Object object) throws JAXBException {
		StringWriter stringWriter = new StringWriter();
		JAXBContext jc = JAXBContext.newInstance(object.getClass());
		Marshaller m = jc.createMarshaller();
		m.marshal(object, stringWriter);
		System.out.println(stringWriter.toString());
		return stringWriter.toString();
	}

	public static String marshalToJson(Object o) throws JAXBException {

		ObjectMapper mapper = new ObjectMapper();
		String jsonVal = "";
		try {
			jsonVal = mapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonVal;
	}

	static String postClient(String url, String object) {

		System.out.println("-----------" + object.trim());
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource.type("application/xml").post(ClientResponse.class, object);
		if (resp.getStatus() != 200 || resp.getStatus() != 201) {
			System.err.println("" + resp);
		}
		String output = resp.getEntity(String.class);
		System.out.println(output);
		return trimXML(output);
	}

	static String trimXML(String output) {
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
		return trimXML(output);
		// return output;
		// return trimXML(output);
	}

	public static List<String> listFilesr() {
		String path = "C:\\Users\\Public\\POC Files\\11 July DB Spring backup\\IntegrationRestServ\\IntegrationRestServ\\";
		File dir = new File(path);
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

}
