package com.rankingEnZymes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;
import com.rankingEnZymes.model.FinalCAZymes.Response;
import com.rankingEnZymes.model.FinalCAZymes.ResponseObj;
import com.rankingEnZymes.service.FinalCAZSortService;
import com.rankingEnZymes.service.FinalCAZvService;
import com.rankingEnZymes.service.FungiCAZSortService;
import com.rankingEnZymes.service.FungiCAZymesService;

@RestController
public class BusinessLogicController {

	
	@Autowired
	FinalCAZvService finalCAZvService;

	@Autowired
	FungiCAZymesService FungiCAZymesService;

	@Autowired
	FinalCAZSortService finalCAZsortService;

	@Autowired
	FungiCAZSortService FungiCAZSortService;

	static private List<String> fungi = new ArrayList<String>();
	static private List<String> classeEnzymes = new ArrayList<String>();

	// public static <T> Comparator<T> createComparator(Function<T, R extends
	// Comparable> getter)
	// {
	// return (obj1, obj2) -> getter.apply(obj1).compareTo(getter.apply(obj2);
	// }
/*	private Function<FinalCAZvType, Comparable> reflectiveGetter(String fieldName) throws NoSuchFieldException {
		Field field = FinalCAZvType.class.getDeclaredField(fieldName);
		field.setAccessible(true);

		return (customer) -> {
			try {
				return (Comparable) field.get(customer);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		};
	}*/

	public static List<String> getFungi() {
		return fungi;
	}

	public static void setFungi(List<String> fungi) {
		BusinessLogicController.fungi = fungi;
	}

	public static List<String> getClasseEnzymes() {
		return classeEnzymes;
	}

	public static void setClasseEnzymes(List<String> classeEnzymes) {
		BusinessLogicController.classeEnzymes = classeEnzymes;
	}

	void logicMethod() {

	}

	@RequestMapping("/sort/fetchAll")
	public List<FinalCAZvType> findAll() {
		List<FinalCAZvType> response = finalCAZsortService.findAllResponse();
		return response;
	}

	@RequestMapping(value = "/sort/pages/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public List<ResponseObj> viewPagesofFinalCAZ(@PathVariable(name = "pageNumber", value = "1") int pageNumber,
			@PathVariable int pageSize) {

		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();

		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();

		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}
		List<FinalCAZvType> customers = finalCAZsortService.getPagevalue(pageNumber, pageSize);
		List<ResponseObj> response = new ArrayList<ResponseObj>();
		for (FinalCAZvType customer : customers) {
			ResponseObj responseObj = new ResponseObj();
			responseObj.setGenomeCode(customer.getGenomecode());
			responseObj.setTotalEnzymes(customer.getTotalenzymes());
			responseObj.setClassifier(Long.parseLong(getValue("totalEnzymes", customer)));
			responseObj.setAssemblyLength(assemblyLength.get(customer.getGenomecode()));
			responseObj.setGenes(genes.get(customer.getGenomecode()));
			responseObj.setName(name.get(customer.getGenomecode()));
			responseObj.setPublished(published.get(customer.getGenomecode()));
			response.add(responseObj);
		}
		return response;
	}

	@RequestMapping(value = "/sort/findSortBy/{orderBy}/{val}", method = RequestMethod.GET)
	public List<ResponseObj> findSortBy(@PathVariable String orderBy, @PathVariable String val) {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();

		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();

		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}
		List<FinalCAZvType> customers = finalCAZsortService.findAll(orderBy, val);
		List<ResponseObj> response = new ArrayList<ResponseObj>();
		for (FinalCAZvType customer : customers) {
			ResponseObj responseObj = new ResponseObj();
			responseObj.setGenomeCode(customer.getGenomecode());
			responseObj.setTotalEnzymes(customer.getTotalenzymes());
			responseObj.setClassifier(Long.parseLong(getValue("totalEnzymes", customer)));
			responseObj.setAssemblyLength(assemblyLength.get(customer.getGenomecode()));
			responseObj.setGenes(genes.get(customer.getGenomecode()));
			responseObj.setName(name.get(customer.getGenomecode()));
			responseObj.setPublished(published.get(customer.getGenomecode()));
			response.add(responseObj);
		}
		return response;
	}

	@RequestMapping(value = "/sort/fetchAllSort/{orderBy}/{val}", method = RequestMethod.GET)
	public List<FinalCAZvType> findSortByValAll(@PathVariable String orderBy, @PathVariable String val) {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();

		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();

		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}
		List<FinalCAZvType> customers = finalCAZsortService.findAll(orderBy, val);
		List<FinalCAZvType> response = new ArrayList<FinalCAZvType>();
		for (FinalCAZvType customer : customers) {
			response.add(customer);
		}
		return response;
	}

	public String getValue(String column, FinalCAZvType finall) {
		switch (column) // nested switch
		{
		case "genomeCode": {
			return "" + finall.getGenomecode();

		}
		case "totalEnzymes": {
			return "" + finall.getTotalenzymes();
		}

		case "AA2_cyt": {
			return "" + finall.get_AA2_cyt();

		}
		case "AA": {
			return "" + finall.get_AA();
			//// finall.setD();

		}

		case "AA10": {
			return "" + finall.get_AA10();

		}
		case "AA11": {
			return "" + finall.get_AA11();

		}
		case "AA11_dist": {
			return "" + finall.get_AA11_dist();

		}
		case "AA12": {
			return "" + finall.get_AA12();

		}
		case "AA12_dist": {
			return "" + finall.get_AA12_dist();

		}
		case "AA13": {
			return "" + finall.get_AA13();

		}
		case "AA14": {
			return "" + finall.get_AA14();

		}
		case "AA1": {
			return "" + finall.get_AA1();

		}
		case "AA1_1": {
			return "" + finall.get_AA1_1();

		}
		case "AA1_2": {
			return "" + finall.get_AA1_2();

		}
		case "AA1_3": {
			return "" + finall.get_AA1_3();

		}
		case "AA1_dist": {
			return "" + finall.get_AA1_dist();

		}
		case "AA2": {
			return "" + finall.get_AA2();

		}
		case "AA2_dist": {
			return "" + finall.get_AA2_dist();

		}
		case "AA3": {
			return "" + finall.get_AA3();

		}
		case "AA3_1": {
			return "" + finall.get_AA3_1();

		}
		case "AA3_2": {
			return "" + finall.get_AA3_2();

		}
		case "AA3_3": {
			return "" + finall.get_AA3_3();

		}
		case "AA3_4": {
			return "" + finall.get_AA3_4();

		}
		case "AA3_dist": {
			return "" + finall.get_AA3_dist();

		}
		case "AA4": {
			return "" + finall.get_AA4();

		}
		case "AA5": {
			return "" + finall.get_AA5();

		}
		case "AA5_1": {
			return "" + finall.get_AA5_1();

		}
		case "AA5_2": {
			return "" + finall.get_AA5_2();

		}
		case "AA5_dist": {
			return "" + finall.get_AA5_dist();

		}
		case "AA6": {
			return "" + finall.get_AA6();

		}
		case "AA7": {
			return "" + finall.get_AA7();

		}
		case "AA7_dist": {
			return "" + finall.get_AA7_dist();

		}
		case "AA8": {
			return "" + finall.get_AA8();

		}
		case "AA8_dist": {
			return "" + finall.get_AA8_dist();

		}
		case "AA9": {
			return "" + finall.get_AA9();

		}
		case "AA9_dist": {
			return "" + finall.get_AA9_dist();

		}
		case "CBM": {
			return "" + finall.get_CBM();

		}
		case "CBM10": {
			return "" + finall.get_CBM10();

		}
		case "CBM12": {
			return "" + finall.get_CBM12();

		}
		case "CBM13": {
			return "" + finall.get_CBM13();

		}
		case "CBM14": {
			return "" + finall.get_CBM14();

		}
		case "CBM16": {
			return "" + finall.get_CBM16();

		}
		case "CBM18": {
			return "" + finall.get_CBM18();

		}
		case "CBM19": {
			return "" + finall.get_CBM19();

		}
		case "CBM1": {
			return "" + finall.get_CBM1();

		}
		case "CBM20": {
			return "" + finall.get_CBM20();

		}
		case "CBM21": {
			return "" + finall.get_CBM21();

		}
		case "CBM22": {
			return "" + finall.get_CBM22();

		}
		case "CBM24": {
			return "" + finall.get_CBM24();

		}
		case "CBM25": {
			return "" + finall.get_CBM25();

		}
		case "CBM26": {
			return "" + finall.get_CBM26();

		}
		case "CBM29": {
			return "" + finall.get_CBM29();

		}
		case "CBM2": {
			return "" + finall.get_CBM2();

		}
		case "CBM32": {
			return "" + finall.get_CBM32();

		}
		case "CBM35": {
			return "" + finall.get_CBM35();

		}
		case "CBM38": {
			return "" + finall.get_CBM38();

		}
		case "CBM3": {
			return "" + finall.get_CBM3();

		}
		case "CBM42": {
			return "" + finall.get_CBM42();

		}
		case "CBM43": {
			return "" + finall.get_CBM43();

		}
		case "CBM48": {
			return "" + finall.get_CBM48();

		}
		case "CBM4": {
			return "" + finall.get_CBM4();

		}
		case "CBM50": {
			return "" + finall.get_CBM50();

		}
		case "CBM51": {
			return "" + finall.get_CBM51();

		}
		case "CBM52": {
			return "" + finall.get_CBM52();

		}
		case "CBM5": {
			return "" + finall.get_CBM5();

		}
		case "CBM61": {
			return "" + finall.get_CBM61();

		}
		case "CBM63": {
			return "" + finall.get_CBM63();

		}
		case "CBM66": {
			return "" + finall.get_CBM66();

		}
		case "CBM67": {
			return "" + finall.get_CBM67();

		}
		case "CBM6": {
			return "" + finall.get_CBM6();

		}
		case "CBM71": {
			return "" + finall.get_CBM71();

		}
		case "CBM8": {
			return "" + finall.get_CBM8();

		}
		case "CBM9": {
			return "" + finall.get_CBM9();

		}
		case "CE": {
			return "" + finall.get_CE();

		}
		case "CE11": {
			return "" + finall.get_CE11();

		}
		case "CE12": {
			return "" + finall.get_CE12();

		}
		case "CE13": {
			return "" + finall.get_CE13();

		}
		case "CE14": {
			return "" + finall.get_CE14();

		}
		case "CE15": {
			return "" + finall.get_CE15();

		}
		case "CE16": {
			return "" + finall.get_CE16();

		}
		case "CE1": {
			return "" + finall.get_CE1();

		}
		case "CE2": {
			return "" + finall.get_CE2();

		}
		case "CE3": {
			return "" + finall.get_CE3();

		}
		case "CE4": {
			return "" + finall.get_CE4();

		}
		case "CE5": {
			return "" + finall.get_CE5();

		}
		case "CE6": {
			return "" + finall.get_CE6();

		}
		case "CE7": {
			return "" + finall.get_CE7();

		}
		case "CE8": {
			return "" + finall.get_CE8();

		}
		case "CE9": {
			return "" + finall.get_CE9();

		}
		case "DOC": {
			return "" + finall.get_DOC();

		}
		case "DOC2": {
			return "" + finall.get_DOC2();

		}
		case "EXPN": {
			return "" + finall.get_EXPN();

		}
		case "GH": {
			return "" + finall.get_GH();

		}
		case "GH103": {
			return "" + finall.get_GH103();

		}
		case "GH105": {
			return "" + finall.get_GH105();

		}
		case "GH106": {
			return "" + finall.get_GH106();

		}
		case "GH108": {
			return "" + finall.get_GH108();

		}
		case "GH10": {
			return "" + finall.get_GH10();

		}
		case "GH110": {
			return "" + finall.get_GH110();

		}
		case "GH114": {
			return "" + finall.get_GH114();

		}
		case "GH115": {
			return "" + finall.get_GH115();

		}
		case "GH116": {
			return "" + finall.get_GH116();

		}
		case "GH11": {
			return "" + finall.get_GH11();

		}
		case "GH120": {
			return "" + finall.get_GH120();

		}
		case "GH121": {
			return "" + finall.get_GH121();

		}
		case "GH124": {
			return "" + finall.get_GH124();

		}
		case "GH125": {
			return "" + finall.get_GH125();

		}
		case "GH127": {
			return "" + finall.get_GH127();

		}
		case "GH128": {
			return "" + finall.get_GH128();

		}
		case "GH12": {
			return "" + finall.get_GH12();

		}
		case "GH130": {
			return "" + finall.get_GH130();

		}
		case "GH131": {
			return "" + finall.get_GH131();

		}
		case "GH132": {
			return "" + finall.get_GH132();

		}
		case "GH133": {
			return "" + finall.get_GH133();

		}
		case "GH134": {
			return "" + finall.get_GH134();

		}
		case "GH135": {
			return "" + finall.get_GH135();

		}
		case "GH136": {
			return "" + finall.get_GH136();

		}
		case "GH139": {
			return "" + finall.get_GH139();

		}
		case "GH13": {
			return "" + finall.get_GH13();

		}
		case "GH13_10": {
			return "" + finall.get_GH13_10();

		}
		case "GH13_11": {
			return "" + finall.get_GH13_11();

		}
		case "GH13_14": {
			return "" + finall.get_GH13_14();

		}
		case "GH13_15": {
			return "" + finall.get_GH13_15();

		}
		case "GH13_1": {
			return "" + finall.get_GH13_1();

		}
		case "GH13_20": {
			return "" + finall.get_GH13_20();

		}
		case "GH13_22": {
			return "" + finall.get_GH13_22();

		}
		case "GH13_23": {
			return "" + finall.get_GH13_23();

		}
		case "GH13_25": {
			return "" + finall.get_GH13_25();

		}
		case "GH13_26": {
			return "" + finall.get_GH13_26();

		}
		case "GH13_28": {
			return "" + finall.get_GH13_28();

		}
		case "GH13_30": {
			return "" + finall.get_GH13_30();

		}
		case "GH13_31": {
			return "" + finall.get_GH13_31();

		}
		case "GH13_32": {
			return "" + finall.get_GH13_32();

		}
		case "GH13_37": {
			return "" + finall.get_GH13_37();

		}
		case "GH13_3": {
			return "" + finall.get_GH13_3();

		}
		case "GH13_40": {
			return "" + finall.get_GH13_40();

		}
		case "GH13_4": {
			return "" + finall.get_GH13_4();

		}
		case "GH13_5": {
			return "" + finall.get_GH13_5();

		}
		case "GH13_6": {
			return "" + finall.get_GH13_6();

		}
		case "GH13_8": {
			return "" + finall.get_GH13_8();

		}
		case "GH13_dist": {
			return "" + finall.get_GH13_dist();

		}
		case "GH13_m42": {
			return "" + finall.get_GH13_m42();

		}
		case "GH13_m46": {
			return "" + finall.get_GH13_m46();

		}
		case "GH140": {
			return "" + finall.get_GH140();

		}
		case "GH141": {
			return "" + finall.get_GH141();

		}
		case "GH142": {
			return "" + finall.get_GH142();

		}
		case "GH143": {
			return "" + finall.get_GH143();

		}
		case "GH145": {
			return "" + finall.get_GH145();

		}
		case "GH146": {
			return "" + finall.get_GH146();

		}
		case "GH14": {
			return "" + finall.get_GH14();

		}
		case "GH151": {
			return "" + finall.get_GH151();

		}
		case "GH152": {
			return "" + finall.get_GH152();

		}
		case "GH15": {
			return "" + finall.get_GH15();

		}
		case "GH16": {
			return "" + finall.get_GH16();

		}
		case "GH17": {
			return "" + finall.get_GH17();

		}
		case "GH18": {
			return "" + finall.get_GH18();

		}
		case "GH19": {
			return "" + finall.get_GH19();

		}
		case "GH1": {
			return "" + finall.get_GH1();

		}
		case "GH20": {
			return "" + finall.get_GH20();

		}
		case "GH23": {
			return "" + finall.get_GH23();

		}
		case "GH24": {
			return "" + finall.get_GH24();

		}
		case "GH25": {
			return "" + finall.get_GH25();

		}
		case "GH26": {
			return "" + finall.get_GH26();

		}
		case "GH27": {
			return "" + finall.get_GH27();

		}
		case "GH28": {
			return "" + finall.get_GH28();

		}
		case "GH29": {
			return "" + finall.get_GH29();

		}
		case "GH2": {
			return "" + finall.get_GH2();

		}
		case "GH30": {
			return "" + finall.get_GH30();

		}
		case "GH30_1": {
			return "" + finall.get_GH30_1();

		}
		case "GH30_3": {
			return "" + finall.get_GH30_3();

		}
		case "GH30_5": {
			return "" + finall.get_GH30_5();

		}
		case "GH30_7": {
			return "" + finall.get_GH30_7();

		}
		case "GH30_dist": {
			return "" + finall.get_GH30_dist();

		}
		case "GH31": {
			return "" + finall.get_GH31();

		}
		case "GH32": {
			return "" + finall.get_GH32();

		}
		case "GH33": {
			return "" + finall.get_GH33();

		}
		case "GH35": {
			return "" + finall.get_GH35();

		}
		case "GH36": {
			return "" + finall.get_GH36();

		}
		case "GH37": {
			return "" + finall.get_GH37();

		}
		case "GH38": {
			return "" + finall.get_GH38();

		}
		case "GH39": {
			return "" + finall.get_GH39();

		}
		case "GH3": {
			return "" + finall.get_GH3();

		}
		case "GH42": {
			return "" + finall.get_GH42();

		}
		case "GH43": {
			return "" + finall.get_GH43();

		}
		case "GH44": {
			return "" + finall.get_GH44();

		}
		case "GH45": {
			return "" + finall.get_GH45();

		}
		case "GH46": {
			return "" + finall.get_GH46();

		}
		case "GH47": {
			return "" + finall.get_GH47();

		}
		case "GH48": {
			return "" + finall.get_GH48();

		}
		case "GH49": {
			return "" + finall.get_GH49();

		}
		case "GH4": {
			return "" + finall.get_GH4();

		}
		case "GH51": {
			return "" + finall.get_GH51();

		}
		case "GH52": {
			return "" + finall.get_GH52();

		}
		case "GH53": {
			return "" + finall.get_GH53();

		}
		case "GH54": {
			return "" + finall.get_GH54();

		}
		case "GH55": {
			return "" + finall.get_GH55();

		}
		case "GH57": {
			return "" + finall.get_GH57();

		}
		case "GH5": {
			return "" + finall.get_GH5();

		}
		case "GH5_11": {
			return "" + finall.get_GH5_11();

		}
		case "GH5_12": {
			return "" + finall.get_GH5_12();

		}
		case "GH5_13": {
			return "" + finall.get_GH5_13();

		}
		case "GH5_15": {
			return "" + finall.get_GH5_15();

		}
		case "GH5_16": {
			return "" + finall.get_GH5_16();

		}
		case "GH5_1": {
			return "" + finall.get_GH5_1();

		}
		case "GH5_22": {
			return "" + finall.get_GH5_22();

		}
		case "GH5_23": {
			return "" + finall.get_GH5_23();

		}
		case "GH5_24": {
			return "" + finall.get_GH5_24();

		}
		case "GH5_27": {
			return "" + finall.get_GH5_27();

		}
		case "GH5_28": {
			return "" + finall.get_GH5_28();

		}
		case "GH5_2": {
			return "" + finall.get_GH5_2();

		}
		case "GH5_30": {
			return "" + finall.get_GH5_30();

		}
		case "GH5_31": {
			return "" + finall.get_GH5_31();

		}
		case "GH5_34": {
			return "" + finall.get_GH5_34();

		}
		case "GH5_36": {
			return "" + finall.get_GH5_36();

		}
		case "GH5_40": {
			return "" + finall.get_GH5_40();

		}
		case "GH5_41": {
			return "" + finall.get_GH5_41();

		}
		case "GH5_49": {
			return "" + finall.get_GH5_49();

		}
		case "GH5_4": {
			return "" + finall.get_GH5_4();

		}
		case "GH5_50": {
			return "" + finall.get_GH5_50();

		}
		case "GH5_51": {
			return "" + finall.get_GH5_51();

		}
		case "GH5_5": {
			return "" + finall.get_GH5_5();

		}
		case "GH5_7": {
			return "" + finall.get_GH5_7();

		}
		case "GH5_8": {
			return "" + finall.get_GH5_8();

		}
		case "GH5_9": {
			return "" + finall.get_GH5_9();

		}
		case "GH5_dist": {
			return "" + finall.get_GH5_dist();

		}
		case "GH62": {
			return "" + finall.get_GH62();

		}
		case "GH63": {
			return "" + finall.get_GH63();

		}
		case "GH64": {
			return "" + finall.get_GH64();

		}
		case "GH65": {
			return "" + finall.get_GH65();

		}
		case "GH67": {
			return "" + finall.get_GH67();

		}
		case "GH6": {
			return "" + finall.get_GH6();

		}
		case "GH71": {
			return "" + finall.get_GH71();

		}
		case "GH72": {
			return "" + finall.get_GH72();

		}
		case "GH73": {
			return "" + finall.get_GH73();

		}
		case "GH74": {
			return "" + finall.get_GH74();

		}
		case "GH75": {
			return "" + finall.get_GH75();

		}
		case "GH76": {
			return "" + finall.get_GH76();

		}
		case "GH77": {
			return "" + finall.get_GH77();

		}
		case "GH78": {
			return "" + finall.get_GH78();

		}
		case "GH79": {
			return "" + finall.get_GH79();

		}
		case "GH7": {
			return "" + finall.get_GH7();

		}
		case "GH81": {
			return "" + finall.get_GH81();

		}
		case "GH84": {
			return "" + finall.get_GH84();

		}
		case "GH85": {
			return "" + finall.get_GH85();

		}
		case "GH88": {
			return "" + finall.get_GH88();

		}
		case "GH89": {
			return "" + finall.get_GH89();

		}
		case "GH8": {
			return "" + finall.get_GH8();

		}
		case "GH91": {
			return "" + finall.get_GH91();

		}
		case "GH92": {
			return "" + finall.get_GH92();

		}
		case "GH93": {
			return "" + finall.get_GH93();

		}
		case "GH94": {
			return "" + finall.get_GH94();

		}
		case "GH95": {
			return "" + finall.get_GH95();

		}
		case "GH97": {
			return "" + finall.get_GH97();

		}
		case "GH99": {
			return "" + finall.get_GH99();

		}
		case "GH9": {
			return "" + finall.get_GH9();

		}
		case "GT": {
			return "" + finall.get_GT();

		}
		case "GT101": {
			return "" + finall.get_GT101();

		}
		case "GT10": {
			return "" + finall.get_GT10();

		}
		case "GT11": {
			return "" + finall.get_GT11();

		}
		case "GT12": {
			return "" + finall.get_GT12();

		}
		case "GT13": {
			return "" + finall.get_GT13();

		}
		case "GT14": {
			return "" + finall.get_GT14();

		}
		case "GT15": {
			return "" + finall.get_GT15();

		}
		case "GT17": {
			return "" + finall.get_GT17();

		}
		case "GT18": {
			return "" + finall.get_GT18();

		}
		case "GT1": {
			return "" + finall.get_GT1();

		}
		case "20": {
			return "" + finall.get_GT20();

		}
		case "GT21": {
			return "" + finall.get_GT21();

		}
		case "GT22": {
			return "" + finall.get_GT22();

		}
		case "GT23": {
			return "" + finall.get_GT23();

		}
		case "24": {
			return "" + finall.get_GT24();

		}
		case "GT25": {
			return "" + finall.get_GT25();

		}
		case "GT28": {
			return "" + finall.get_GT28();

		}
		case "GT2": {
			return "" + finall.get_GT2();

		}
		case "GT31": {
			return "" + finall.get_GT31();

		}
		case "GT32": {
			return "" + finall.get_GT32();

		}
		case "GT33": {
			return "" + finall.get_GT33();

		}
		case "GT34": {
			return "" + finall.get_GT34();

		}
		case "GT35": {
			return "" + finall.get_GT35();

		}
		case "GT37": {
			return "" + finall.get_GT37();

		}
		case "GT39": {
			return "" + finall.get_GT39();

		}
		case "GT3": {
			return "" + finall.get_GT3();

		}
		case "GT41": {
			return "" + finall.get_GT41();

		}
		case "GT43": {
			return "" + finall.get_GT43();

		}
		case "GT45": {
			return "" + finall.get_GT45();

		}
		case "GT47": {
			return "" + finall.get_GT47();

		}
		case "GT48": {
			return "" + finall.get_GT48();

		}
		case "GT49": {
			return "" + finall.get_GT49();

		}
		case "GT4": {
			return "" + finall.get_GT4();

		}
		case "GT50": {
			return "" + finall.get_GT50();

		}
		case "GT51": {
			return "" + finall.get_GT51();

		}
		case "GT54": {
			return "" + finall.get_GT54();

		}
		case "GT55": {
			return "" + finall.get_GT55();

		}
		case "GT57": {
			return "" + finall.get_GT57();

		}
		case "GT58": {
			return "" + finall.get_GT58();

		}
		case "GT59": {
			return "" + finall.get_GT59();

		}
		case "GT5": {
			return "" + finall.get_GT5();

		}
		case "GT60": {
			return "" + finall.get_GT60();

		}
		case "GT61": {
			return "" + finall.get_GT61();

		}
		case "GT62": {
			return "" + finall.get_GT62();

		}
		case "GT64": {
			return "" + finall.get_GT64();

		}
		case "GT65": {
			return "" + finall.get_GT65();

		}
		case "GT66": {
			return "" + finall.get_GT66();

		}
		case "GT68": {
			return "" + finall.get_GT68();

		}
		case "GT69": {
			return "" + finall.get_GT69();

		}
		case "GT6": {
			return "" + finall.get_GT6();

		}
		case "GT71": {
			return "" + finall.get_GT71();

		}
		case "GT76": {
			return "" + finall.get_GT76();

		}
		case "GT77": {
			return "" + finall.get_GT77();

		}
		case "GT7": {
			return "" + finall.get_GT7();

		}
		case "GT81": {
			return "" + finall.get_GT81();

		}
		case "GT8": {
			return "" + finall.get_GT8();

		}
		case "GT90": {
			return "" + finall.get_GT90();

		}
		case "GT91": {
			return "" + finall.get_GT91();

		}
		case "GT9": {
			return "" + finall.get_GT9();

		}
		case "Myosin_motor": {
			return "" + finall.get_Myosin_motor();

		}
		case "PL": {
			return "" + finall.get_PL();

		}
		case "PL10": {
			return "" + finall.get_PL10();

		}
		case "PL10_dist": {
			return "" + finall.get_PL10_dist();

		}
		case "PL11": {
			return "" + finall.get_PL11();

		}
		case "PL11_2": {
			return "" + finall.get_PL11_2();

		}
		case "PL14": {
			return "" + finall.get_PL14();

		}
		case "PL14_1": {
			return "" + finall.get_PL14_1();

		}
		case "PL14_3": {
			return "" + finall.get_PL14_3();

		}
		case "PL14_4": {
			return "" + finall.get_PL14_4();

		}
		case "PL14_5": {
			return "" + finall.get_PL14_5();

		}
		case "PL14_dist": {
			return "" + finall.get_PL14_dist();

		}
		case "PL15": {
			return "" + finall.get_PL15();

		}
		case "PL15_dist": {
			return "" + finall.get_PL15_dist();

		}
		case "PL1": {
			return "" + finall.get_PL1();

		}
		case "PL1_10": {
			return "" + finall.get_PL1_10();

		}
		case "PL1_2": {
			return "" + finall.get_PL1_2();

		}
		case "PL1_4": {
			return "" + finall.get_PL1_4();

		}
		case "PL1_6": {
			return "" + finall.get_PL1_6();

		}
		case "PL1_7": {
			return "" + finall.get_PL1_7();

		}
		case "PL1_9": {
			return "" + finall.get_PL1_9();

		}
		case "PL1_dist": {
			return "" + finall.get_PL1_dist();

		}
		case "PL20": {
			return "" + finall.get_PL20();

		}
		case "PL20_dist": {
			return "" + finall.get_PL20_dist();

		}
		case "PL22": {
			return "" + finall.get_PL22();

		}
		case "PL22_2": {
			return "" + finall.get_PL22_2();

		}
		case "PL26": {
			return "" + finall.get_PL26();

		}
		case "PL27": {
			return "" + finall.get_PL27();

		}
		case "PL3": {
			return "" + finall.get_PL3();

		}
		case "PL3_2": {
			return "" + finall.get_PL3_2();

		}
		case "PL3_dist": {
			return "" + finall.get_PL3_dist();

		}
		case "PL4": {
			return "" + finall.get_PL4();

		}
		case "PL4_1": {
			return "" + finall.get_PL4_1();

		}
		case "PL4_3": {
			return "" + finall.get_PL4_3();

		}
		case "PL4_5": {
			return "" + finall.get_PL4_5();

		}
		case "PL4_dist": {
			return "" + finall.get_PL4_dist();

		}
		case "PL7": {
			return "" + finall.get_PL7();

		}
		case "PL7_4": {
			return "" + finall.get_PL7_4();

		}
		case "PL7_dist": {
			return "" + finall.get_PL7_dist();

		}
		case "PL8Q": {
			return "" + finall.get_PL8();

		}
		case "PL8_4": {
			return "" + finall.get_PL8_4();

		}
		case "PL9": {
			return "" + finall.get_PL9();

		}
		case "PL9_1": {
			return "" + finall.get_PL9_1();

		}
		case "PL9_3": {
			return "" + finall.get_PL9_3();

		}
		
		
		case "CelluloseDegrading": {return ""+ finall.getCelluloseDegrading();}

		

		case "ligninDegrading": {return ""+ finall. getLigninDegrading();}

		
		case "pectinDegrading": {return ""+ finall. getPectinDegrading();}


		case "starchDegrading": {return ""+  finall.getStarchDegrading() ;}


		case "inulin": {return ""+finall.getInulin();}

		case "hemiCelluloseDegrading": {return ""+ finall.getHemiCelluloseDegrading();} 
		
		/*
		public void setCelluloseDegrading(Long celluloseDegrading) {
			this.celluloseDegrading = celluloseDegrading;
		}
		public void setHemiCelluloseDegrading(Long hemiCelluloseDegrading) {
			this.hemiCelluloseDegrading = hemiCelluloseDegrading;
		}
		public void setLigninDegrading(Long ligninDegrading) {
			this.ligninDegrading = ligninDegrading;
		}

		public void setPectinDegrading(Long pectinDegrading) {
			this.pectinDegrading = pectinDegrading;
		}
		public void setStarchDegrading(Long starchDegrading) {
			this.starchDegrading = starchDegrading;
		}
		public void setInulin(Long inulin) {
			this.inulin = inulin;
		}
*/


		default:
			return null;
		}
	}

	private Response setResponseObject(FungiCAZymes fi, FinalCAZvType fina, Response responseObj) {
		responseObj.setName(fi.getName());
		responseObj.setPublished(fi.getPublished());
		responseObj.setGenomeCode(fi.getGenomecode());
		responseObj.setAssemblyLength(fi.getAssemblylength());
		responseObj.setGenes(fi.getGenes());
		if(fina==null) {
			return responseObj;
		}
		responseObj.setHemicellulosedegrading(fina.getHemiCelluloseDegrading());
		responseObj.setCellulosedegrading(fina.getCelluloseDegrading());
		responseObj.setLignindegrading(fina.getLigninDegrading());
		responseObj.setPectindegrading(fina.getPectinDegrading());
		responseObj.setStarchdegrading(fina.getStarchDegrading());
		responseObj.setInulingrading(fina.getInulin());
		responseObj.setTotalEnzymes(fina.getTotalenzymes());
		responseObj.setAA2_cyt(fina.get_AA2_cyt());
		responseObj.setAA(fina.get_AA());
		responseObj.setAA10(fina.get_AA10());
		responseObj.setAA11(fina.get_AA11());
		responseObj.setAA11_dist(fina.get_AA11_dist());
		responseObj.setAA12(fina.get_AA12());
		responseObj.setAA12_dist(fina.get_AA12_dist());
		responseObj.setAA13(fina.get_AA13());
		responseObj.setAA14(fina.get_AA14());
		responseObj.setAA1(fina.get_AA1());
		responseObj.setAA1_1(fina.get_AA1_1());
		responseObj.setAA1_2(fina.get_AA1_2());
		responseObj.setAA1_3(fina.get_AA1_3());
		responseObj.setAA1_dist(fina.get_AA1_dist());
		responseObj.setAA2(fina.get_AA2());
		responseObj.setAA2_dist(fina.get_AA2_dist());
		responseObj.setAA3(fina.get_AA3());
		responseObj.setAA3_1(fina.get_AA3_1());
		responseObj.setAA3_2(fina.get_AA3_2());
		responseObj.setAA3_3(fina.get_AA3_3());
		responseObj.setAA3_4(fina.get_AA3_4());
		responseObj.setAA3_dist(fina.get_AA3_dist());
		responseObj.setAA4(fina.get_AA4());
		responseObj.setAA5(fina.get_AA5());
		responseObj.setAA5_1(fina.get_AA5_1());
		responseObj.setAA5_2(fina.get_AA5_2());
		responseObj.setAA5_dist(fina.get_AA5_dist());
		responseObj.setAA6(fina.get_AA6());
		responseObj.setAA7(fina.get_AA7());
		responseObj.setAA7_dist(fina.get_AA7_dist());
		responseObj.setAA8(fina.get_AA8());
		responseObj.setAA8_dist(fina.get_AA8_dist());
		responseObj.setAA9(fina.get_AA9());
		responseObj.setAA9_dist(fina.get_AA9_dist());
		responseObj.setCBM(fina.get_CBM());
		responseObj.setCBM10(fina.get_CBM10());
		responseObj.setCBM12(fina.get_CBM12());
		responseObj.setCBM13(fina.get_CBM13());
		responseObj.setCBM14(fina.get_CBM14());
		responseObj.setCBM16(fina.get_CBM16());
		responseObj.setCBM18(fina.get_CBM18());
		responseObj.setCBM19(fina.get_CBM19());
		responseObj.setCBM1(fina.get_CBM1());
		responseObj.setCBM20(fina.get_CBM20());
		responseObj.setCBM21(fina.get_CBM21());
		responseObj.setCBM22(fina.get_CBM22());
		responseObj.setCBM24(fina.get_CBM24());
		responseObj.setCBM25(fina.get_CBM25());
		responseObj.setCBM26(fina.get_CBM26());
		responseObj.setCBM29(fina.get_CBM29());
		responseObj.setCBM2(fina.get_CBM2());
		responseObj.setCBM32(fina.get_CBM32());
		responseObj.setCBM35(fina.get_CBM35());
		responseObj.setCBM38(fina.get_CBM38());
		responseObj.setCBM3(fina.get_CBM3());
		responseObj.setCBM42(fina.get_CBM42());
		responseObj.setCBM43(fina.get_CBM43());
		responseObj.setCBM48(fina.get_CBM48());
		responseObj.setCBM4(fina.get_CBM4());
		responseObj.setCBM50(fina.get_CBM50());
		responseObj.setCBM51(fina.get_CBM51());
		responseObj.setCBM52(fina.get_CBM52());
		responseObj.setCBM5(fina.get_CBM5());
		responseObj.setCBM61(fina.get_CBM61());
		responseObj.setCBM63(fina.get_CBM63());
		responseObj.setCBM66(fina.get_CBM66());
		responseObj.setCBM67(fina.get_CBM67());
		responseObj.setCBM6(fina.get_CBM6());
		responseObj.setCBM71(fina.get_CBM71());
		responseObj.setCBM8(fina.get_CBM8());
		responseObj.setCBM9(fina.get_CBM9());
		responseObj.setCE(fina.get_CE());
		responseObj.setCE11(fina.get_CE11());
		responseObj.setCE12(fina.get_CE12());
		responseObj.setCE13(fina.get_CE13());
		responseObj.setCE14(fina.get_CE14());
		responseObj.setCE15(fina.get_CE15());
		responseObj.setCE16(fina.get_CE16());
		responseObj.setCE1(fina.get_CE1());
		responseObj.setCE2(fina.get_CE2());
		responseObj.setCE3(fina.get_CE3());
		responseObj.setCE4(fina.get_CE4());
		responseObj.setCE5(fina.get_CE5());
		responseObj.setCE6(fina.get_CE6());
		responseObj.setCE7(fina.get_CE7());
		responseObj.setCE8(fina.get_CE8());
		responseObj.setCE9(fina.get_CE9());
		responseObj.setDOC(fina.get_DOC());
		responseObj.setDOC2(fina.get_DOC2());
		responseObj.setEXPN(fina.get_EXPN());
		responseObj.setGH(fina.get_GH());
		responseObj.setGH103(fina.get_GH103());
		responseObj.setGH105(fina.get_GH105());
		responseObj.setGH106(fina.get_GH106());
		responseObj.setGH108(fina.get_GH108());
		responseObj.setGH10(fina.get_GH10());
		responseObj.setGH110(fina.get_GH110());
		responseObj.setGH114(fina.get_GH114());
		responseObj.setGH115(fina.get_GH115());
		responseObj.setGH116(fina.get_GH116());
		responseObj.setGH11(fina.get_GH11());
		responseObj.setGH120(fina.get_GH120());
		responseObj.setGH121(fina.get_GH121());
		responseObj.setGH124(fina.get_GH124());
		responseObj.setGH125(fina.get_GH125());
		responseObj.setGH127(fina.get_GH127());
		responseObj.setGH128(fina.get_GH128());
		responseObj.setGH12(fina.get_GH12());
		responseObj.setGH130(fina.get_GH130());
		responseObj.setGH131(fina.get_GH131());
		responseObj.setGH132(fina.get_GH132());
		responseObj.setGH133(fina.get_GH133());
		responseObj.setGH134(fina.get_GH134());
		responseObj.setGH135(fina.get_GH135());
		responseObj.setGH136(fina.get_GH136());
		responseObj.setGH139(fina.get_GH139());
		responseObj.setGH13(fina.get_GH13());
		responseObj.setGH13_10(fina.get_GH13_10());
		responseObj.setGH13_11(fina.get_GH13_11());
		responseObj.setGH13_14(fina.get_GH13_14());
		responseObj.setGH13_15(fina.get_GH13_15());
		responseObj.setGH13_1(fina.get_GH13_1());
		responseObj.setGH13_20(fina.get_GH13_20());
		responseObj.setGH13_22(fina.get_GH13_22());
		responseObj.setGH13_23(fina.get_GH13_23());
		responseObj.setGH13_25(fina.get_GH13_25());
		responseObj.setGH13_26(fina.get_GH13_26());
		responseObj.setGH13_28(fina.get_GH13_28());
		responseObj.setGH13_30(fina.get_GH13_30());
		responseObj.setGH13_31(fina.get_GH13_31());
		responseObj.setGH13_32(fina.get_GH13_32());
		responseObj.setGH13_37(fina.get_GH13_37());
		responseObj.setGH13_3(fina.get_GH13_3());
		responseObj.setGH13_40(fina.get_GH13_40());
		responseObj.setGH13_4(fina.get_GH13_4());
		responseObj.setGH13_5(fina.get_GH13_5());
		responseObj.setGH13_6(fina.get_GH13_6());
		responseObj.setGH13_8(fina.get_GH13_8());
		responseObj.setGH13_dist(fina.get_GH13_dist());
		responseObj.setGH13_m42(fina.get_GH13_m42());
		responseObj.setGH13_m46(fina.get_GH13_m46());
		responseObj.setGH140(fina.get_GH140());
		responseObj.setGH141(fina.get_GH141());
		responseObj.setGH142(fina.get_GH142());
		responseObj.setGH143(fina.get_GH143());
		responseObj.setGH145(fina.get_GH145());
		responseObj.setGH146(fina.get_GH146());
		responseObj.setGH14(fina.get_GH14());
		responseObj.setGH151(fina.get_GH151());
		responseObj.setGH152(fina.get_GH152());
		responseObj.setGH15(fina.get_GH15());
		responseObj.setGH16(fina.get_GH16());
		responseObj.setGH17(fina.get_GH17());
		responseObj.setGH18(fina.get_GH18());
		responseObj.setGH19(fina.get_GH19());
		responseObj.setGH1(fina.get_GH1());
		responseObj.setGH20(fina.get_GH20());
		responseObj.setGH23(fina.get_GH23());
		responseObj.setGH24(fina.get_GH24());
		responseObj.setGH25(fina.get_GH25());
		responseObj.setGH26(fina.get_GH26());
		responseObj.setGH27(fina.get_GH27());
		responseObj.setGH28(fina.get_GH28());
		responseObj.setGH29(fina.get_GH29());
		responseObj.setGH2(fina.get_GH2());
		responseObj.setGH30(fina.get_GH30());
		responseObj.setGH30_1(fina.get_GH30_1());
		responseObj.setGH30_3(fina.get_GH30_3());
		responseObj.setGH30_5(fina.get_GH30_5());
		responseObj.setGH30_7(fina.get_GH30_7());
		responseObj.setGH30_dist(fina.get_GH30_dist());
		responseObj.setGH31(fina.get_GH31());
		responseObj.setGH32(fina.get_GH32());
		responseObj.setGH33(fina.get_GH33());
		responseObj.setGH35(fina.get_GH35());
		responseObj.setGH36(fina.get_GH36());
		responseObj.setGH37(fina.get_GH37());
		responseObj.setGH38(fina.get_GH38());
		responseObj.setGH39(fina.get_GH39());
		responseObj.setGH3(fina.get_GH3());
		responseObj.setGH42(fina.get_GH42());
		responseObj.setGH43(fina.get_GH43());
		responseObj.setGH44(fina.get_GH44());
		responseObj.setGH45(fina.get_GH45());
		responseObj.setGH46(fina.get_GH46());
		responseObj.setGH47(fina.get_GH47());
		responseObj.setGH48(fina.get_GH48());
		responseObj.setGH49(fina.get_GH49());
		responseObj.setGH4(fina.get_GH4());
		responseObj.setGH51(fina.get_GH51());
		responseObj.setGH52(fina.get_GH52());
		responseObj.setGH53(fina.get_GH53());
		responseObj.setGH54(fina.get_GH54());
		responseObj.setGH55(fina.get_GH55());
		responseObj.setGH57(fina.get_GH57());
		responseObj.setGH5(fina.get_GH5());
		responseObj.setGH5_11(fina.get_GH5_11());
		responseObj.setGH5_12(fina.get_GH5_12());
		responseObj.setGH5_13(fina.get_GH5_13());
		responseObj.setGH5_15(fina.get_GH5_15());
		responseObj.setGH5_16(fina.get_GH5_16());
		responseObj.setGH5_1(fina.get_GH5_1());
		responseObj.setGH5_22(fina.get_GH5_22());
		responseObj.setGH5_23(fina.get_GH5_23());
		responseObj.setGH5_24(fina.get_GH5_24());
		responseObj.setGH5_27(fina.get_GH5_27());
		responseObj.setGH5_28(fina.get_GH5_28());
		responseObj.setGH5_2(fina.get_GH5_2());
		responseObj.setGH5_30(fina.get_GH5_30());
		responseObj.setGH5_31(fina.get_GH5_31());
		responseObj.setGH5_34(fina.get_GH5_34());
		responseObj.setGH5_36(fina.get_GH5_36());
		responseObj.setGH5_40(fina.get_GH5_40());
		responseObj.setGH5_41(fina.get_GH5_41());
		responseObj.setGH5_49(fina.get_GH5_49());
		responseObj.setGH5_4(fina.get_GH5_4());
		responseObj.setGH5_50(fina.get_GH5_50());
		responseObj.setGH5_51(fina.get_GH5_51());
		responseObj.setGH5_5(fina.get_GH5_5());
		responseObj.setGH5_7(fina.get_GH5_7());
		responseObj.setGH5_8(fina.get_GH5_8());
		responseObj.setGH5_9(fina.get_GH5_9());
		responseObj.setGH5_dist(fina.get_GH5_dist());
		responseObj.setGH62(fina.get_GH62());
		responseObj.setGH63(fina.get_GH63());
		responseObj.setGH64(fina.get_GH64());
		responseObj.setGH65(fina.get_GH65());
		responseObj.setGH67(fina.get_GH67());
		responseObj.setGH6(fina.get_GH6());
		responseObj.setGH71(fina.get_GH71());
		responseObj.setGH72(fina.get_GH71());
		responseObj.setGH73(fina.get_GH73());
		responseObj.setGH74(fina.get_GH74());
		responseObj.setGH75(fina.get_GH75());
		responseObj.setGH76(fina.get_GH76());
		responseObj.setGH77(fina.get_GH77());
		responseObj.setGH78(fina.get_GH78());
		responseObj.setGH79(fina.get_GH79());
		responseObj.setGH7(fina.get_GH7());
		responseObj.setGH81(fina.get_GH81());
		responseObj.setGH84(fina.get_GH84());
		responseObj.setGH85(fina.get_GH85());
		responseObj.setGH88(fina.get_GH88());
		responseObj.setGH89(fina.get_GH89());
		responseObj.setGH8(fina.get_GH8());
		responseObj.setGH91(fina.get_GH91());
		responseObj.setGH92(fina.get_GH92());
		responseObj.setGH93(fina.get_GH93());
		responseObj.setGH94(fina.get_GH94());
		responseObj.setGH95(fina.get_GH95());
		responseObj.setGH97(fina.get_GH97());
		responseObj.setGH99(fina.get_GH99());
		responseObj.setGH9(fina.get_GH9());
		responseObj.setGT(fina.get_GT());
		responseObj.setGT101(fina.get_GT101());
		responseObj.setGT10(fina.get_GT10());
		responseObj.setGT11(fina.get_GT11());
		responseObj.setGT12(fina.get_GT12());
		responseObj.setGT13(fina.get_GT13());
		responseObj.setGT14(fina.get_GT14());
		responseObj.setGT15(fina.get_GT15());
		responseObj.setGT17(fina.get_GT17());
		responseObj.setGT18(fina.get_GT18());
		responseObj.setGT1(fina.get_GT1());
		responseObj.setGT20(fina.get_GT20());
		responseObj.setGT21(fina.get_GT21());
		responseObj.setGT22(fina.get_GT22());
		responseObj.setGT23(fina.get_GT23());
		responseObj.setGT24(fina.get_GT24());
		responseObj.setGT25(fina.get_GT25());
		responseObj.setGT28(fina.get_GT28());
		responseObj.setGT2(fina.get_GT2());
		responseObj.setGT31(fina.get_GT31());
		responseObj.setGT32(fina.get_GT32());
		responseObj.setGT33(fina.get_GT33());
		responseObj.setGT34(fina.get_GT34());
		responseObj.setGT35(fina.get_GT35());
		responseObj.setGT37(fina.get_GT37());
		responseObj.setGT39(fina.get_GT39());
		responseObj.setGT3(fina.get_GT3());
		responseObj.setGT41(fina.get_GT41());
		responseObj.setGT43(fina.get_GT43());
		responseObj.setGT45(fina.get_GT45());
		responseObj.setGT47(fina.get_GT47());
		responseObj.setGT48(fina.get_GT48());
		responseObj.setGT49(fina.get_GT49());
		responseObj.setGT4(fina.get_GT4());
		responseObj.setGT50(fina.get_GT50());
		responseObj.setGT51(fina.get_GT51());
		responseObj.setGT54(fina.get_GT54());
		responseObj.setGT55(fina.get_GT55());
		responseObj.setGT57(fina.get_GT57());
		responseObj.setGT58(fina.get_GT58());
		responseObj.setGT59(fina.get_GT59());
		responseObj.setGT5(fina.get_GT5());
		responseObj.setGT60(fina.get_GT60());
		responseObj.setGT61(fina.get_GT61());
		responseObj.setGT62(fina.get_GT62());
		responseObj.setGT64(fina.get_GT64());
		responseObj.setGT65(fina.get_GT65());
		responseObj.setGT66(fina.get_GT66());
		responseObj.setGT68(fina.get_GT68());
		responseObj.setGT69(fina.get_GT69());
		responseObj.setGT6(fina.get_GT6());
		responseObj.setGT71(fina.get_GT71());
		responseObj.setGT76(fina.get_GT76());
		responseObj.setGT77(fina.get_GT77());
		responseObj.setGT7(fina.get_GT7());
		responseObj.setGT81(fina.get_GT81());
		responseObj.setGT8(fina.get_GT8());
		responseObj.setGT90(fina.get_GT90());
		responseObj.setGT91(fina.get_GT91());
		responseObj.setGT9(fina.get_GT9());
		responseObj.setMyosin_motor(fina.get_Myosin_motor());
		responseObj.setPL(fina.get_PL());
		responseObj.setPL10_dist(fina.get_PL10_dist());
		responseObj.setPL11(fina.get_PL11());
		responseObj.setPL11_2(fina.get_PL11_2());
		responseObj.setPL14(fina.get_PL14());
		responseObj.setPL14_1(fina.get_PL14_1());
		responseObj.setPL14_3(fina.get_PL14_3());
		responseObj.setPL14_4(fina.get_PL14_4());
		responseObj.setPL14_5(fina.get_PL14_5());
		responseObj.setPL14_dist(fina.get_PL14_dist());
		responseObj.setPL15(fina.get_PL15());
		responseObj.setPL15_dist(fina.get_PL15_dist());
		responseObj.setPL1(fina.get_PL1());
		responseObj.setPL1_10(fina.get_PL1_10());
		responseObj.setPL1_2(fina.get_PL1_2());
		responseObj.setPL1_4(fina.get_PL1_4());
		responseObj.setPL1_6(fina.get_PL1_6());
		responseObj.setPL1_7(fina.get_PL1_7());
		responseObj.setPL1_9(fina.get_PL1_9());
		responseObj.setPL1_dist(fina.get_PL1_dist());
		responseObj.setPL20(fina.get_PL20());
		responseObj.setPL20_dist(fina.get_PL20_dist());
		responseObj.setPL22(fina.get_PL22());
		responseObj.setPL22_2(fina.get_PL22_2());
		responseObj.setPL26(fina.get_PL26());
		responseObj.setPL27(fina.get_PL27());
		responseObj.setPL3(fina.get_PL3());
		responseObj.setPL3_2(fina.get_PL3_2());
		responseObj.setPL3_dist(fina.get_PL3_dist());
		responseObj.setPL4(fina.get_PL4());
		responseObj.setPL4_1(fina.get_PL4_1());
		responseObj.setPL4_3(fina.get_PL4_3());
		responseObj.setPL4_5(fina.get_PL4_5());
		responseObj.setPL4_dist(fina.get_PL4_dist());
		responseObj.setPL7(fina.get_PL7());
		responseObj.setPL7_4(fina.get_PL7_4());
		responseObj.setPL7_dist(fina.get_PL7_dist());
		responseObj.setPL8(fina.get_PL8());
		responseObj.setPL8_4(fina.get_PL8_4());
		responseObj.setPL9(fina.get_PL9());
		responseObj.setPL9_1(fina.get_PL9_1());
		responseObj.setPL9_3(fina.get_PL9_3());
		return responseObj;
		// TODO Auto-generated method stub

	}

	@RequestMapping(value = "/searchGenome/All", method = RequestMethod.GET)
	public List<Response> searchGenomeAll() throws IOException {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();
		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();
		
		String orderCriteria = "ASC";
		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}

		Iterable<FungiCAZymes> customers = FungiCAZSortService.findAll(orderCriteria, "name");
		List<Response> responses = new ArrayList<Response>();
		for (FungiCAZymes customer : customers) {
			FinalCAZvType fina = finalCAZvService.get(customer.getGenomecode());
			Response responseObj = new Response();
			responseObj = setResponseObject(customer, fina, responseObj);
			responses.add(responseObj);
		}
		return responses;
	}

	@RequestMapping(value = "/searchGenome/{orderCriteria}/{genome}", method = RequestMethod.GET)
	public List<Response> testSearchCazymes(@PathVariable String orderCriteria, @PathVariable String genome)
			throws IOException {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();

		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();
		if (orderCriteria.equals("asc")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("ASC")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("ascending")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("Ascending")) {
			orderCriteria = "ASC";
		} else {
			orderCriteria = "DESC";
		}
		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}
		String genomeCode = nameToGenomeCodeMap.get(genome);
		FungiCAZymes fi = FungiCAZymesService.get(genomeCode);
		FinalCAZvType fina = finalCAZvService.get(genomeCode);
		Response responseObj = new Response();
		responseObj = setResponseObject(fi, fina, responseObj);
		List<Response> responses = new ArrayList<Response>();
		responses.add(responseObj);
		return responses;

	}

	@RequestMapping(value = "/searchClassifier/All", method = RequestMethod.GET)
	public List<List<ResponseObj>> searchClassifierAll() throws IOException {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();
		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();
		String orderCriteria = "ASC";
		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());
			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());
			published.put(customer.getGenomecode(), customer.getPublished());
			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());
			genes.put(customer.getGenomecode(), customer.getGenes());
		}

		String[] thisIsAStringArray = { "AA2_cyt", "AA", "AA10", "AA11", "AA11_dist", "AA12", "AA12_dist", "AA13",
				"AA14", "AA1", "AA1_1", "AA1_2", "AA1_3", "AA1_dist", "AA2", "AA2_dist", "AA3", "AA3_1", "AA3_2",
				"AA3_3", "AA3_4", "AA3_dist", "AA4", "AA5", "AA5_1", "AA5_2", "AA5_dist", "AA6", "AA7", "AA7_dist",
				"AA8", "AA8_dist", "AA9", "AA9_dist", "CBM", "CBM10", "CBM12", "CBM13", "CBM14", "CBM16", "CBM18",
				"CBM19", "CBM1", "CBM20", "CBM21", "CBM22", "CBM24", "CBM25", "CBM26", "CBM29", "CBM2", "CBM32",
				"CBM35", "CBM38", "CBM3", "CBM42", "CBM43", "CBM48", "CBM4", "CBM50", "CBM51", "CBM52", "CBM5", "CBM61",
				"CBM63", "CBM66", "CBM67", "CBM6", "CBM71", "CBM8", "CBM9", "CE", "CE11", "CE12", "CE13", "CE14",
				"CE15", "CE16", "CE1", "CE2", "CE3", "CE4", "CE5", "CE6", "CE7", "CE8", "CE9", "DOC", "DOC2", "EXPN",
				"GH", "GH103", "GH105", "GH106", "GH108", "GH10", "GH110", "GH114", "GH115", "GH116", "GH11", "GH120",
				"GH121", "GH124", "GH125", "GH127", "GH128", "GH12", "GH130", "GH131", "GH132", "GH133", "GH134",
				"GH135", "GH136", "GH139", "GH13", "GH13_10", "GH13_11", "GH13_14", "GH13_15", "GH13_1", "GH13_20",
				"GH13_22", "GH13_23", "GH13_25", "GH13_26", "GH13_28", "GH13_30", "GH13_31", "GH13_32", "GH13_37",
				"GH13_3", "GH13_40", "GH13_4", "GH13_5", "GH13_6", "GH13_8", "GH13_dist", "GH13_m42", "GH13_m46",
				"GH140", "GH141", "GH142", "GH143", "GH145", "GH146", "GH14", "GH151", "GH152", "GH15", "GH16", "GH17",
				"GH18", "GH19", "GH1", "GH20", "GH23", "GH24", "GH25", "GH26", "GH27", "GH28", "GH29", "GH2", "GH30",
				"GH30_1", "GH30_3", "GH30_5", "GH30_7", "GH30_dist", "GH31", "GH32", "GH33", "GH35", "GH36", "GH37",
				"GH38", "GH39", "GH3", "GH42", "GH43", "GH44", "GH45", "GH46", "GH47", "GH48", "GH49", "GH4", "GH51",
				"GH52", "GH53", "GH54", "GH55", "GH57", "GH5", "GH5_11", "GH5_12", "GH5_13", "GH5_15", "GH5_16",
				"GH5_1", "GH5_22", "GH5_23", "GH5_24", "GH5_27", "GH5_28", "GH5_2", "GH5_30", "GH5_31", "GH5_34",
				"GH5_36", "GH5_40", "GH5_41", "GH5_49", "GH5_4", "GH5_50", "GH5_51", "GH5_5", "GH5_7", "GH5_8", "GH5_9",
				"GH5_dist", "GH62", "GH63", "GH64", "GH65", "GH67", "GH6", "GH71", "GH72", "GH73", "GH74", "GH75",
				"GH76", "GH77", "GH78", "GH79", "GH7", "GH81", "GH84", "GH85", "GH88", "GH89", "GH8", "GH91", "GH92",
				"GH93", "GH94", "GH95", "GH97", "GH99", "GH9", "GT", "GT101", "GT10", "GT11", "GT12", "GT13", "GT14",
				"GT15", "GT17", "GT18", "GT1", "GT20", "GT21", "GT22", "GT23", "GT24", "GT25", "GT28", "GT2", "GT31",
				"GT32", "GT33", "GT34", "GT35", "GT37", "GT39", "GT3", "GT41", "GT43", "GT45", "GT47", "GT48", "GT49",
				"GT4", "GT50", "GT51", "GT54", "GT55", "GT57", "GT58", "GT59", "GT5", "GT60", "GT61", "GT62", "GT64",
				"GT65", "GT66", "GT68", "GT69", "GT6", "GT71", "GT76", "GT77", "GT7", "GT81", "GT8", "GT90", "GT91",
				"GT9", "Myosin_motor", "PL", "PL10", "PL10_dist", "PL11", "PL11_2", "PL14", "PL14_1", "PL14_3",
				"PL14_4", "PL14_5", "PL14_dist", "PL15", "PL15_dist", "PL1", "PL1_10", "PL1_2", "PL1_4", "PL1_6",
				"PL1_7", "PL1_9", "PL1_dist", "PL20", "PL20_dist", "PL22", "PL22_2", "PL26", "PL27", "PL3", "PL3_2",
				"PL3_dist", "PL4", "PL4_1", "PL4_3", "PL4_5", "PL4_dist", "PL7", "PL7_4", "PL7_dist", "PL8", "PL8_4",
				"PL9", "PL9_1", "PL9_3" };
		List<List<ResponseObj>> response = new ArrayList<List<ResponseObj>>();
		for (int i = 0; i < thisIsAStringArray.length; i++) {
			String classifer = thisIsAStringArray[i];
			List<ResponseObj> responseP = new ArrayList<ResponseObj>();
			List<FinalCAZvType> customers = finalCAZsortService.findAll(orderCriteria, classifer);
			for (FinalCAZvType customer : customers) {
				ResponseObj responseObj = new ResponseObj();
				responseObj.setGenomeCode(customer.getGenomecode());
				responseObj.setName(name.get(customer.getGenomecode()));
				responseObj.setHemicellulosedegrading(customer.getHemiCelluloseDegrading());
				responseObj.setCellulosedegrading(customer.getCelluloseDegrading());
				responseObj.setLignindegrading(customer.getLigninDegrading());
				responseObj.setPectindegrading(customer.getPectinDegrading());
				responseObj.setStarchdegrading(customer.getStarchDegrading());
				responseObj.setInulingrading(customer.getInulin());
				responseObj.setTotalEnzymes(customer.getTotalenzymes());
				responseObj.setClassifier(Long.parseLong(getValue(classifer, customer)));
				responseObj.setAssemblyLength(assemblyLength.get(customer.getGenomecode()));
				responseObj.setGenes(genes.get(customer.getGenomecode()));
				responseObj.setPublished(published.get(customer.getGenomecode()));

				responseP.add(responseObj);
			}
			response.add(responseP);
		}
		return response;
	}

	@RequestMapping(value = "/searchClassifier/{orderCriteria}/{classifer}", method = RequestMethod.GET)
	public List<ResponseObj> testsearchFungiCazymes(@PathVariable String orderCriteria, @PathVariable String classifer)
			throws IOException {
		Map<String, String> name = new HashMap<String, String>();
		Map<String, String> published = new HashMap<String, String>();
		Map<String, String> assemblyLength = new HashMap<String, String>();
		Map<String, String> genes = new HashMap<String, String>();
		if (classifer.equals("Cellulose Degrading")) {
			classifer ="CelluloseDegrading";
		}
		if (classifer.equals("Hemicellulose Degrading")) {
			classifer ="hemiCelluloseDegrading";
		}
		if (classifer.equals("Lignin Degrading")) {
			classifer ="ligninDegrading";
		}
		if (classifer.equals("Pectin Degrading")) {
			classifer ="pectinDegrading";
		}
		if (classifer.equals("Starch Degrading")) {
			classifer ="starchDegrading";
		}
		if (classifer.equals("Inulin")) {
			classifer ="inulin";
		}
		Map<String, String> nameToGenomeCodeMap = new HashMap<String, String>();
		if (orderCriteria.equals("asc")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("ASC")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("ascending")) {
			orderCriteria = "ASC";
		} else if (orderCriteria.equals("Ascending")) {
			orderCriteria = "ASC";
		} else {
			orderCriteria = "DESC";
		}
		// Collections.sort(employees, createComparator((employee) ->
		// employee.getName()));
		List<FungiCAZymes> metadata = FungiCAZymesService.getAll();
		for (FungiCAZymes customer : metadata) {
			name.put(customer.getGenomecode(), customer.getName());

			nameToGenomeCodeMap.put(customer.getName(), customer.getGenomecode());

			published.put(customer.getGenomecode(), customer.getPublished());

			assemblyLength.put(customer.getGenomecode(), customer.getAssemblylength());

			genes.put(customer.getGenomecode(), customer.getGenes());
		}
		List<FinalCAZvType> customers = finalCAZsortService.findAllResponse();
		List<ResponseObj> response = new ArrayList<ResponseObj>();
		for (FinalCAZvType customer : customers) {
			ResponseObj responseObj = new ResponseObj();
			responseObj.setGenomeCode(customer.getGenomecode());
			responseObj.setTotalEnzymes(customer.getTotalenzymes());
			responseObj.setClassifier(Long.parseLong(getValue(classifer, customer)));
			responseObj.setAssemblyLength(assemblyLength.get(customer.getGenomecode()));
			responseObj.setGenes(genes.get(customer.getGenomecode()));
			responseObj.setName(name.get(customer.getGenomecode()));
			responseObj.setPublished(published.get(customer.getGenomecode()));
			responseObj.setHemicellulosedegrading(customer.getHemiCelluloseDegrading());
			responseObj.setCellulosedegrading(customer.getCelluloseDegrading());
			responseObj.setLignindegrading(customer.getLigninDegrading());
			responseObj.setPectindegrading(customer.getPectinDegrading());
			responseObj.setStarchdegrading(customer.getStarchDegrading());
			responseObj.setInulingrading(customer.getInulin());
			response.add(responseObj);
		}
		if (orderCriteria.equals("ASC")) {
			Collections.sort(response, new Comparator<ResponseObj>() {
				public int compare(ResponseObj o1, ResponseObj o2) {
					return (int) (o1.getClassifier() - o2.getClassifier());
				}
			});
		} else {
			Collections.sort(response, new CompareObj.ClassifierComparator());
			Collections.sort(response, Collections.reverseOrder(new CompareObj.ClassifierComparator()));
		}
		return response;
	}

}
