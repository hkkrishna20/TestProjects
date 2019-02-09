/*import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.rankingEnZymes.model.FungiCAZymes;
import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

public class Java8Demo {
	private static List<FungiCAZymes> list = new ArrayList<FungiCAZymes>();

	public static List<FungiCAZymes> getList() {
		return list;
	}

	public static void setList(List<FungiCAZymes> list) {
		Java8Demo.list = list;
	}

	public static void main(String[] args) throws IOException {
		new Java8Demo().readFinalCAZvTypeExcel();
		// new Java8Demo().readFungiCAZymesExcel();
	}

	FinalCAZvType setValue(String column, String val, FinalCAZvType finall) {

		switch (column) // nested switch
		{
		case "A": {
			finall.setGenomeCodev(val);
			break;
		}
		case "B": {
			finall.setTotalEnzymesv(val);
			break;
		}
		case "C": {
			finall.setC(val);
			break;
		}
		case "D": {
			finall.setD(val);
			break;
		}
		case "E": {
			finall.setE(val);
			break;
		}
		case "F": {
			finall.setF(val);
			break;
		}
		case "G": {
			finall.setG(val);
			break;
		}
		case "H": {
			finall.setH(val);
			break;
		}
		case "I": {
			finall.setI(val);
			break;
		}
		case "J": {
			finall.setJ(val);
			break;
		}
		case "K": {
			finall.setK(val);
			break;
		}
		case "L": {
			finall.setL(val);
			break;
		}
		case "M": {
			finall.setM(val);
			break;
		}
		case "N": {
			finall.setN(val);
			break;
		}
		case "O": {
			finall.setO(val);
			break;
		}
		case "P": {
			finall.setP(val);
			break;
		}
		case "Q": {
			finall.setQ(val);
			break;
		}
		case "R": {
			finall.setR(val);
			break;
		}
		case "S": {
			finall.setS(val);
			break;
		}
		case "T": {
			finall.setT(val);
			break;
		}
		case "U": {
			finall.setU(val);
			break;
		}
		case "V": {
			finall.setV(val);
			break;
		}
		case "W": {
			finall.setW(val);
			break;
		}
		case "X": {
			finall.setX(val);
			break;
		}
		case "Y": {
			finall.setY(val);
			break;
		}
		case "Z": {
			finall.setZ(val);
			break;
		}
		case "AA": {
			finall.setAA(val);
			break;
		}
		case "AB": {
			finall.setAB(val);
			break;
		}
		case "AC": {
			finall.setAC(val);
			break;
		}
		case "AD": {
			finall.setAD(val);
			break;
		}
		case "AE": {
			finall.setAE(val);
			break;
		}
		case "AF": {
			finall.setAF(val);
			break;
		}
		case "AG": {
			finall.setAG(val);
			break;
		}
		case "AH": {
			finall.setAH(val);
			break;
		}
		case "AI": {
			finall.setAI(val);
			break;
		}
		case "AJ": {
			finall.setAJ(val);
			break;
		}
		case "AK": {
			finall.setAK(val);
			break;
		}
		case "AL": {
			finall.setAL(val);
			break;
		}
		case "AM": {
			finall.setAM(val);
			break;
		}
		case "AN": {
			finall.setAN(val);
			break;
		}
		case "AO": {
			finall.setAO(val);
			break;
		}
		case "AP": {
			finall.setAP(val);
			break;
		}
		case "AQ": {
			finall.setAQ(val);
			break;
		}
		case "AR": {
			finall.setAR(val);
			break;
		}
		case "AS": {
			finall.setAS(val);
			break;
		}
		case "AT": {
			finall.setAT(val);
			break;
		}
		case "AU": {
			finall.setAU(val);
			break;
		}
		case "AV": {
			finall.setAV(val);
			break;
		}
		case "AW": {
			finall.setAW(val);
			break;
		}
		case "AX": {
			finall.setAX(val);
			break;
		}
		case "AY": {
			finall.setAY(val);
			break;
		}
		case "AZ": {
			finall.setAZ(val);
			break;
		}
		case "BA": {
			finall.setBA(val);
			break;
		}
		case "BB": {
			finall.setBB(val);
			break;
		}
		case "BC": {
			finall.setBC(val);
			break;
		}
		case "BD": {
			finall.setBD(val);
			break;
		}
		case "BE": {
			finall.setBE(val);
			break;
		}
		case "BF": {
			finall.setBF(val);
			break;
		}
		case "BG": {
			finall.setBG(val);
			break;
		}
		case "BH": {
			finall.setBH(val);
			break;
		}
		case "BI": {
			finall.setBI(val);
			break;
		}
		case "BJ": {
			finall.setBJ(val);
			break;
		}
		case "BK": {
			finall.setBK(val);
			break;
		}
		case "BL": {
			finall.setBL(val);
			break;
		}
		case "BM": {
			finall.setBM(val);
			break;
		}
		case "BN": {
			finall.setBN(val);
			break;
		}
		case "BO": {
			finall.setBO(val);
			break;
		}
		case "BP": {
			finall.setBP(val);
			break;
		}
		case "BQ": {
			finall.setBQ(val);
			break;
		}
		case "BR": {
			finall.setBR(val);
			break;
		}
		case "BS": {
			finall.setBS(val);
			break;
		}
		case "BT": {
			finall.setBT(val);
			break;
		}
		case "BU": {
			finall.setBU(val);
			break;
		}
		case "BV": {
			finall.setBV(val);
			break;
		}
		case "BW": {
			finall.setBW(val);
			break;
		}
		case "BX": {
			finall.setBX(val);
			break;
		}
		case "BY": {
			finall.setBY(val);
			break;
		}
		case "BZ": {
			finall.setBZ(val);
			break;
		}
		case "CA": {
			finall.setCA(val);
			break;
		}
		case "CB": {
			finall.setCB(val);
			break;
		}
		case "CC": {
			finall.setCC(val);
			break;
		}
		case "CD": {
			finall.setCD(val);
			break;
		}
		case "CE": {
			finall.setCE(val);
			break;
		}
		case "CF": {
			finall.setCF(val);
			break;
		}
		case "CG": {
			finall.setCG(val);
			break;
		}
		case "CH": {
			finall.setCH(val);
			break;
		}
		case "CI": {
			finall.setCI(val);
			break;
		}
		case "CJ": {
			finall.setCJ(val);
			break;
		}
		case "CK": {
			finall.setCK(val);
			break;
		}
		case "CL": {
			finall.setCL(val);
			break;
		}
		case "CM": {
			finall.setCM(val);
			break;
		}
		case "CN": {
			finall.setCN(val);
			break;
		}
		case "CO": {
			finall.setCO(val);
			break;
		}
		case "CP": {
			finall.setCP(val);
			break;
		}
		case "CQ": {
			finall.setCQ(val);
			break;
		}
		case "CR": {
			finall.setCR(val);
			break;
		}
		case "CS": {
			finall.setCS(val);
			break;
		}
		case "CT": {
			finall.setCT(val);
			break;
		}
		case "CU": {
			finall.setCU(val);
			break;
		}
		case "CV": {
			finall.setCV(val);
			break;
		}
		case "CW": {
			finall.setCW(val);
			break;
		}
		case "CX": {
			finall.setCX(val);
			break;
		}
		case "CY": {
			finall.setCY(val);
			break;
		}
		case "CZ": {
			finall.setCZ(val);
			break;
		}
		case "DA": {
			finall.setDA(val);
			break;
		}
		case "DB": {
			finall.setDB(val);
			break;
		}
		case "DC": {
			finall.setDC(val);
			break;
		}
		case "DD": {
			finall.setDD(val);
			break;
		}
		case "DE": {
			finall.setDE(val);
			break;
		}
		case "DF": {
			finall.setDF(val);
			break;
		}
		case "DG": {
			finall.setDG(val);
			break;
		}
		case "DH": {
			finall.setDH(val);
			break;
		}
		case "DI": {
			finall.setDI(val);
			break;
		}
		case "DJ": {
			finall.setDJ(val);
			break;
		}
		case "DK": {
			finall.setDK(val);
			break;
		}
		case "DL": {
			finall.setDL(val);
			break;
		}
		case "DM": {
			finall.setDM(val);
			break;
		}
		case "DN": {
			finall.setDN(val);
			break;
		}
		case "DO": {
			finall.setDO(val);
			break;
		}
		case "DP": {
			finall.setDP(val);
			break;
		}
		case "DQ": {
			finall.setDQ(val);
			break;
		}
		case "DR": {
			finall.setDR(val);
			break;
		}
		case "DS": {
			finall.setDS(val);
			break;
		}
		case "DT": {
			finall.setDT(val);
			break;
		}
		case "DU": {
			finall.setDU(val);
			break;
		}
		case "DV": {
			finall.setDV(val);
			break;
		}
		case "DW": {
			finall.setDW(val);
			break;
		}
		case "DX": {
			finall.setDX(val);
			break;
		}
		case "DY": {
			finall.setDY(val);
			break;
		}
		case "DZ": {
			finall.setDZ(val);
			break;
		}
		case "EA": {
			finall.setEA(val);
			break;
		}
		case "EB": {
			finall.setEB(val);
			break;
		}
		case "EC": {
			finall.setEC(val);
			break;
		}
		case "ED": {
			finall.setED(val);
			break;
		}
		case "EE": {
			finall.setEE(val);
			break;
		}
		case "EF": {
			finall.setEF(val);
			break;
		}
		case "EG": {
			finall.setEG(val);
			break;
		}
		case "EH": {
			finall.setEH(val);
			break;
		}
		case "EI": {
			finall.setEI(val);
			break;
		}
		case "EJ": {
			finall.setEJ(val);
			break;
		}
		case "EK": {
			finall.setEK(val);
			break;
		}
		case "EL": {
			finall.setEL(val);
			break;
		}
		case "EM": {
			finall.setEM(val);
			break;
		}
		case "EN": {
			finall.setEN(val);
			break;
		}
		case "EO": {
			finall.setEO(val);
			break;
		}
		case "EP": {
			finall.setEP(val);
			break;
		}
		case "EQ": {
			finall.setEQ(val);
			break;
		}
		case "ER": {
			finall.setER(val);
			break;
		}
		case "ES": {
			finall.setES(val);
			break;
		}
		case "ET": {
			finall.setET(val);
			break;
		}
		case "EU": {
			finall.setEU(val);
			break;
		}
		case "EV": {
			finall.setEV(val);
			break;
		}
		case "EW": {
			finall.setEW(val);
			break;
		}
		case "EX": {
			finall.setEX(val);
			break;
		}
		case "EY": {
			finall.setEY(val);
			break;
		}
		case "EZ": {
			finall.setEZ(val);
			break;
		}
		case "FA": {
			finall.setFA(val);
			break;
		}
		case "FB": {
			finall.setFB(val);
			break;
		}
		case "FC": {
			finall.setFC(val);
			break;
		}
		case "FD": {
			finall.setFD(val);
			break;
		}
		case "FE": {
			finall.setFE(val);
			break;
		}
		case "FF": {
			finall.setFF(val);
			break;
		}
		case "FG": {
			finall.setFG(val);
			break;
		}
		case "FH": {
			finall.setFH(val);
			break;
		}
		case "FI": {
			finall.setFI(val);
			break;
		}
		case "FJ": {
			finall.setFJ(val);
			break;
		}
		case "FK": {
			finall.setFK(val);
			break;
		}
		case "FL": {
			finall.setFL(val);
			break;
		}
		case "FM": {
			finall.setFM(val);
			break;
		}
		case "FN": {
			finall.setFN(val);
			break;
		}
		case "FO": {
			finall.setFO(val);
			break;
		}
		case "FP": {
			finall.setFP(val);
			break;
		}
		case "FQ": {
			finall.setFQ(val);
			break;
		}
		case "FR": {
			finall.setFR(val);
			break;
		}
		case "FS": {
			finall.setFS(val);
			break;
		}
		case "FT": {
			finall.setFT(val);
			break;
		}
		case "FU": {
			finall.setFU(val);
			break;
		}
		case "FV": {
			finall.setFV(val);
			break;
		}
		case "FW": {
			finall.setFW(val);
			break;
		}
		case "FX": {
			finall.setFX(val);
			break;
		}
		case "FY": {
			finall.setFY(val);
			break;
		}
		case "FZ": {
			finall.setFZ(val);
			break;
		}
		case "GA": {
			finall.setGA(val);
			break;
		}
		case "GB": {
			finall.setGB(val);
			break;
		}
		case "GC": {
			finall.setGC(val);
			break;
		}
		case "GD": {
			finall.setGD(val);
			break;
		}
		case "GE": {
			finall.setGE(val);
			break;
		}
		case "GF": {
			finall.setGF(val);
			break;
		}
		case "GG": {
			finall.setGG(val);
			break;
		}
		case "GH": {
			finall.setGH(val);
			break;
		}
		case "GI": {
			finall.setGI(val);
			break;
		}
		case "GJ": {
			finall.setGJ(val);
			break;
		}
		case "GK": {
			finall.setGK(val);
			break;
		}
		case "GL": {
			finall.setGL(val);
			break;
		}
		case "GM": {
			finall.setGM(val);
			break;
		}
		case "GN": {
			finall.setGN(val);
			break;
		}
		case "GO": {
			finall.setGO(val);
			break;
		}
		case "GP": {
			finall.setGP(val);
			break;
		}
		case "GQ": {
			finall.setGQ(val);
			break;
		}
		case "GR": {
			finall.setGR(val);
			break;
		}
		case "GS": {
			finall.setGS(val);
			break;
		}
		case "GT": {
			finall.setGT(val);
			break;
		}
		case "GU": {
			finall.setGU(val);
			break;
		}
		case "GV": {
			finall.setGV(val);
			break;
		}
		case "GW": {
			finall.setGW(val);
			break;
		}
		case "GX": {
			finall.setGX(val);
			break;
		}
		case "GY": {
			finall.setGY(val);
			break;
		}
		case "GZ": {
			finall.setGZ(val);
			break;
		}

		case "HA": {
			finall.setHA(val);
			break;
		}
		case "HB": {
			finall.setHB(val);
			break;
		}
		case "HC": {
			finall.setHC(val);
			break;
		}
		case "HD": {
			finall.setHD(val);
			break;
		}
		case "HE": {
			finall.setHE(val);
			break;
		}
		case "HF": {
			finall.setHF(val);
			break;
		}
		case "HG": {
			finall.setHG(val);
			break;
		}
		case "HH": {
			finall.setHH(val);
			break;
		}
		case "HI": {
			finall.setHI(val);
			break;
		}
		case "HJ": {
			finall.setHJ(val);
			break;
		}
		case "HK": {
			finall.setHK(val);
			break;
		}
		case "HL": {
			finall.setHL(val);
			break;
		}
		case "HM": {
			finall.setHM(val);
			break;
		}
		case "HN": {
			finall.setHN(val);
			break;
		}
		case "HO": {
			finall.setHO(val);
			break;
		}
		case "HP": {
			finall.setHP(val);
			break;
		}
		case "HQ": {
			finall.setHQ(val);
			break;
		}
		case "HR": {
			finall.setHR(val);
			break;
		}
		case "HS": {
			finall.setHS(val);
			break;
		}
		case "HT": {
			finall.setHT(val);
			break;
		}
		case "HU": {
			finall.setHU(val);
			break;
		}
		case "HV": {
			finall.setHV(val);
			break;
		}
		case "HW": {
			finall.setHW(val);
			break;
		}
		case "HX": {
			finall.setHX(val);
			break;
		}
		case "HY": {
			finall.setHY(val);
			break;
		}
		case "HZ": {
			finall.setHZ(val);
			break;
		}

		case "IA": {
			finall.setIA(val);
			break;
		}
		case "IB": {
			finall.setIB(val);
			break;
		}
		case "IC": {
			finall.setIC(val);
			break;
		}
		case "ID": {
			finall.setID(val);
			break;
		}
		case "IE": {
			finall.setIE(val);
			break;
		}
		case "IF": {
			finall.setIF(val);
			break;
		}
		case "IG": {
			finall.setIG(val);
			break;
		}
		case "IH": {
			finall.setIH(val);
			break;
		}
		case "II": {
			finall.setII(val);
			break;
		}
		case "IJ": {
			finall.setIJ(val);
			break;
		}
		case "IK": {
			finall.setIK(val);
			break;
		}
		case "IL": {
			finall.setIL(val);
			break;
		}
		case "IM": {
			finall.setIM(val);
			break;
		}
		case "IN": {
			finall.setIN(val);
			break;
		}
		case "IO": {
			finall.setIO(val);
			break;
		}
		case "IP": {
			finall.setIP(val);
			break;
		}
		case "IQ": {
			finall.setIQ(val);
			break;
		}
		case "IR": {
			finall.setIR(val);
			break;
		}
		case "IS": {
			finall.setIS(val);
			break;
		}
		case "IT": {
			finall.setIT(val);
			break;
		}
		case "IU": {
			finall.setIU(val);
			break;
		}
		case "IV": {
			finall.setIV(val);
			break;
		}
		case "IW": {
			finall.setIW(val);
			break;
		}
		case "IX": {
			finall.setIX(val);
			break;
		}
		case "IY": {
			finall.setIY(val);
			break;
		}
		case "IZ": {
			finall.setIZ(val);
			break;
		}
		case "JA": {
			finall.setJA(val);
			break;
		}
		case "JB": {
			finall.setJB(val);
			break;
		}
		case "JC": {
			finall.setJC(val);
			break;
		}
		case "JD": {
			finall.setJD(val);
			break;
		}
		case "JE": {
			finall.setJE(val);
			break;
		}
		case "JF": {
			finall.setJF(val);
			break;
		}
		case "JG": {
			finall.setJG(val);
			break;
		}
		case "JH": {
			finall.setJH(val);
			break;
		}
		case "JI": {
			finall.setJI(val);
			break;
		}
		case "JJ": {
			finall.setJJ(val);
			break;
		}
		case "JK": {
			finall.setJK(val);
			break;
		}
		case "JL": {
			finall.setJL(val);
			break;
		}
		case "JM": {
			finall.setJM(val);
			break;
		}
		case "JN": {
			finall.setJN(val);
			break;
		}
		case "JO": {
			finall.setJO(val);
			break;
		}
		case "JP": {
			finall.setJP(val);
			break;
		}
		case "JQ": {
			finall.setJQ(val);
			break;
		}
		case "JR": {
			finall.setJR(val);
			break;
		}
		case "JS": {
			finall.setJS(val);
			break;
		}
		case "JT": {
			finall.setJT(val);
			break;
		}
		case "JU": {
			finall.setJU(val);
			break;
		}
		case "JV": {
			finall.setJV(val);
			break;
		}
		case "JW": {
			finall.setJW(val);
			break;
		}
		case "JX": {
			finall.setJX(val);
			break;
		}
		case "JY": {
			finall.setJY(val);
			break;
		}
		case "JZ": {
			finall.setJZ(val);
			break;
		}
		case "KA": {
			finall.setKA(val);
			break;
		}
		case "KB": {
			finall.setKB(val);
			break;
		}
		case "KC": {
			finall.setKC(val);
			break;
		}
		case "KD": {
			finall.setKD(val);
			break;
		}
		case "KE": {
			finall.setKE(val);
			break;
		}
		case "KF": {
			finall.setKF(val);
			break;
		}
		case "KG": {
			finall.setKG(val);
			break;
		}
		case "KH": {
			finall.setKH(val);
			break;
		}
		case "KI": {
			finall.setKI(val);
			break;
		}
		case "KJ": {
			finall.setKJ(val);
			break;
		}
		case "KK": {
			finall.setKK(val);
			break;
		}
		case "KL": {
			finall.setKL(val);
			break;
		}
		case "KM": {
			finall.setKM(val);
			break;
		}
		case "KN": {
			finall.setKN(val);
			break;
		}
		case "KO": {
			finall.setKO(val);
			break;
		}
		case "KP": {
			finall.setKP(val);
			break;
		}
		case "KQ": {
			finall.setKQ(val);
			break;
		}
		case "KR": {
			finall.setKR(val);
			break;
		}
		case "KS": {
			finall.setKS(val);
			break;
		}
		case "KT": {
			finall.setKT(val);
			break;
		}
		case "KU": {
			finall.setKU(val);
			break;
		}
		case "KV": {
			finall.setKV(val);
			break;
		}
		case "KW": {
			finall.setKW(val);
			break;
		}
		case "KX": {
			finall.setKX(val);
			break;
		}
		case "KY": {
			finall.setKY(val);
			break;
		}
		case "KZ": {
			finall.setKZ(val);
			break;
		}
		case "LA": {
			finall.setLA(val);
			break;
		}
		case "LB": {
			finall.setLB(val);
			break;
		}
		case "LC": {
			finall.setLC(val);
			break;
		}
		case "LD": {
			finall.setLD(val);
			break;
		}
		case "LE": {
			finall.setLE(val);
			break;
		}
		case "LF": {
			finall.setLF(val);
			break;
		}
		case "LG": {
			finall.setLG(val);
			break;
		}
		case "LH": {
			finall.setLH(val);
			break;
		}
		case "LI": {
			finall.setLI(val);
			break;
		}
		case "LJ": {
			finall.setLJ(val);
			break;
		}
		case "LK": {
			finall.setLK(val);
			break;
		}
		case "LL": {
			finall.setLL(val);
			break;
		}
		case "LM": {
			finall.setLM(val);
			break;
		}
		case "LN": {
			finall.setLN(val);
			break;
		}
		case "LO": {
			finall.setLO(val);
			break;
		}
		case "LP": {
			finall.setLP(val);
			break;
		}
		case "LQ": {
			finall.setLQ(val);
			break;
		}
		case "LR": {
			finall.setLR(val);
			break;
		}
		case "LS": {
			finall.setLS(val);
			break;
		}
		case "LT": {
			finall.setLT(val);
			break;
		}
		case "LU": {
			finall.setLU(val);
			break;
		}
		case "LV": {
			finall.setLV(val);
			break;
		}
		case "LW": {
			finall.setLW(val);
			break;
		}
		case "LX": {
			finall.setLX(val);
			break;
		}
		case "LY": {
			finall.setLY(val);
			break;
		}
		case "LZ": {
			finall.setLZ(val);
			break;
		}
		case "MA": {
			finall.setMA(val);
			break;
		}
		case "MB": {
			finall.setMB(val);
			break;
		}
		case "MC": {
			finall.setMC(val);
			break;
		}
		case "MD": {
			finall.setMD(val);
			break;
		}
		case "ME": {
			finall.setME(val);
			break;
		}
		case "MF": {
			finall.setMF(val);
			break;
		}
		case "MG": {
			finall.setMG(val);
			break;
		}
		case "MH": {
			finall.setMH(val);
			break;
		}
		case "MI": {
			finall.setMI(val);
			break;
		}
		case "MJ": {
			finall.setMJ(val);
			break;
		}
		case "MK": {
			finall.setMK(val);
			break;
		}
		case "ML": {
			finall.setML(val);
			break;
		}
		case "MM": {
			finall.setMM(val);
			break;
		}
		case "MN": {
			finall.setMN(val);
			break;
		}
		case "MO": {
			finall.setMO(val);
			break;
		}
		case "MP": {
			finall.setMP(val);
			break;
		}
		case "MQ": {
			finall.setMQ(val);
			break;
		}
		case "MR": {
			finall.setMR(val);
			break;
		}
		case "MS": {
			finall.setMS(val);
			break;
		}
		case "MT": {
			finall.setMT(val);
			break;
		}
		case "MU": {
			finall.setMU(val);
			break;
		}
		default:
			return finall;
		}

		return finall;
	}

	private static String getCellName(Cell cell) {
		return "" + CellReference.convertNumToColString(cell.getColumnIndex()) + (cell.getRowIndex() + 1);
	}

	public void readFinalCAZvTypeExcel() throws IOException {

		// File file = new File(filePath + "\\" + fileName);
		String path = System.getProperty("user.dir") + "\\Final_CAZymes.xlsx";
		File file = new File(path);
		// File file = new File("/Final_CAZymes.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		DataFormatter df = new DataFormatter();
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		
		 * List<String> sheetNames = new ArrayList<String>(); for (int i = 0; i <
		 * wb.getNumberOfSheets(); i++) { sheetNames.add(wb.getSheetName(i)); }
		 
		Sheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		Row row0 = sheet.getRow(1);
		int maxColumns = 0;
		String lastCellValue="";
		String lastRowCellValue="";
		
		for (int j = 0; j < row0.getLastCellNum(); j++) {
			if (row0.getCell(j) != null) {
				String value = "";
				value = df.formatCellValue(row0.getCell(j));
				if(!value.trim().isEmpty()) {
					maxColumns = j;
					lastCellValue = value;
				}

			}
		}

		int mamxRows = 0;
		for (int j = 1; j < sheet.getLastRowNum(); j++) {
			Row rown=sheet.getRow(j);
			if (rown.getCell(0) != null) {
				String value = "";
				value = df.formatCellValue(rown.getCell(0));
				if(!value.trim().isEmpty()) {
					mamxRows = j;
					lastRowCellValue =value;
				}
				
			}
		}
		System.out.println(maxColumns + lastCellValue);
		System.out.println(mamxRows + lastRowCellValue);
	
		List<Map<Integer, List<String>>> map= new ArrayList<Map<Integer, List<String>>>();
		String[][] arr = new String[mamxRows][maxColumns];
		for (int i = 2; i < maxColumns; i++) {
			Map<Integer, List<String>> multimap = new HashMap<Integer, List<String>>();
			for (int j = 2; j < mamxRows; j++) {
				if (null != sheet.getRow(j).getCell(i)) {
					String value = df.formatCellValue(sheet.getRow(j).getCell(i));
					if (value != null) {
						arr[j-2][i-2] = "" + value;
						multimap.get(value).add(sheet.getRow(j).getCell(0).getStringCellValue());
					}
				}

			}
			Object[] keys = multimap.keySet().toArray();
			Arrays.sort(keys);
			for(Object key : keys) {
				  System.out.println(multimap.get(key));
				}
			map.add(multimap);
		}

		for (int i = 0; i < map.size(); i++) {
			
		}
		System.out.println();
		for (int i = 0; i < maxColumns; i++) {

				int idxOfEle = 5;
				for (int j = 0; j < mamxRows; j++) {
					System.out.print(" row: "+i +" "+arr[j][i] +"  ");					
				}
				System.out.println();
		}
		
		
		 * List<List<String>> list = new ArrayList<List<String>>(); Sheet sheets =
		 * wb.getSheetAt(0); // Get Your Sheet. for (int i = 2; i <
		 * sheet.getRow(1).getLastCellNum(); i++) { List<String> testList = new
		 * ArrayList<String>(); List<Integer> myList = new ArrayList<Integer>(); //
		 * row0.getCell(2) -> enzyme class Name for (int j = 2; j <
		 * sheet.getLastRowNum(); j++) { // for (Row row : sheet) { Row row =
		 * sheet.getRow(j);// For each Row. Cell cell2 = row.getCell(0); //
		 * System.out.println(cell2); testList.add(value + "-" + cell2);
		 * System.out.print(value + "  "); // myList.add(value) // Get the Cell at the
		 * Index / Column you want. } System.out.println(); Collections.sort(testList);
		 * 
		 * for (int k = 0; k < testList.size(); k++) {
		 * System.out.println(testList.get(k)); }
		 * 
		 * list.add(testList); int[] integers = new int[myList.size()]; for (int k = 0;
		 * k < integers.length; k++) { integers[k] = myList.get(k); } }
		 * System.out.println(); int arr[] = { 3, 4, 3, 5, 2, 3, 4, 3, 1, 5 }; int n =
		 * arr.length; int idxOfEle = 5; System.out.println(getIndexInSortedArray(arr,
		 * n, idxOfEle));
		 
		
		 * System.out.println(maxColumns + " " + rowCount); for (int i = 1; i <
		 * rowCount; i++) { FinalCAZvType finall = new FinalCAZvType(); if (null !=
		 * sheet.getRow(i)) { Row row = sheet.getRow(i); row0 = sheet.getRow(1); for
		 * (int j = 0; j < maxColumns; j++) { String value = ""; try { if
		 * (row.getCell(j) != null) { value = df.formatCellValue(row.getCell(j)); } if
		 * ((!value.trim().isEmpty()) && value != null) { String cellName =
		 * getCellName(row0.getCell(j)); cellName = cellName.replaceAll("2", ""); value
		 * = value.trim() + ""; list.get(j).set(i, value+"-"+row.getCell(0)); //
		 * System.out.println(value+"-"+row.getCell(0)); setValue(cellName, value,
		 * finall); } } catch (Exception e) { String cellName =
		 * getCellName(row0.getCell(j)); System.out.println("<Exception Block>");
		 * System.out.println(cellName + "    " + value +" "+row.getCell(0));
		 * System.out.println(value); list.get(j).set(i, value+"-"+row.getCell(0));
		 * System.out.println(value+"-"+row.getCell(0));
		 * System.out.println("</Exception Block>"); value = "" + value;
		 * setValue(cellName, value, finall); } } // finalCAZvService.add(finall);
		 * System.out.println(); } else { System.out.println(i);
		 * 
		 * }
		 * 
		 * }
		 

	}

	public void readFinalC() throws IOException {
		String path = System.getProperty("user.dir") + "\\Final_CAZymes.xlsx";
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		DataFormatter df = new DataFormatter();
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		Sheet sheet = wb.getSheetAt(0);
		Row row0 = sheet.getRow(1);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
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

		Sheet sheets = wb.getSheetAt(0); // Get Your Sheet.

	}

	public void readFungiCAZymes() throws IOException {
		// File file = new File(filePath + "\\" + fileName);
		String path = System.getProperty("user.dir") + "\\Ranking Fungi_CAZymes.xlsx";
		System.out.println(path);
		File file = new File(path);

		// File file = new File("/Final_CAZymes.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		DataFormatter df = new DataFormatter();
		List<String> sheetNames = new ArrayList<String>();
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
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
						if (row.getCell(j) != null)
							value = df.formatCellValue(row.getCell(j));
						if ((!value.trim().isEmpty()) && value != null) {
							value = value.trim();
							String cellName = getCellName(row0.getCell(j));
							cellName = cellName.replaceAll("2", "");
							if (j == 0)
								genomeCode = value;
							if (j == 1)
								name = value;
							if (j == 2)
								published = value;
							if (j == 3)
								assemblyLength = value;
							if (j == 4)
								genes = value;
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
				finall.setAssemblyLength(assemblyLength);
				finall.setGenomeCode(genomeCode);
				finall.setName(name);
				finall.setPublished(published);
				list.add(finall);
				// FungiCAZymesService.add(finall);
				System.out.println();
			} else {
				System.out.println(i);

			}

		}
	}

	static int getIndexInSortedArray(int arr[], int n, int idx) {
		
		 * Count of elements smaller than current element plus the equal element
		 * occurring before given index
		 
		int result = 0;
		for (int i = 0; i < n; i++) {

			// If element is smaller then
			// increase the smaller count
			if (arr[i] < arr[idx])
				result++;

			// If element is equal then increase
			// count only if it occurs before
			if (arr[i] == arr[idx] && i < idx)
				result++;
		}
		return result;
	}

	public static void pigeonhole_sort(int arr[], int n) {
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (int a = 0; a < n; a++) {
			if (arr[a] > max)
				max = arr[a];
			if (arr[a] < min)
				min = arr[a];
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < n; i++)
			phole[arr[i] - min]++;

		index = 0;

		for (j = 0; j < range; j++)
			while (phole[j]-- > 0)
				arr[index++] = j + min;

	}

	public String getValue(String column, FinalCAZvType finall) {

		switch (column) // nested switch
		{
		case "A": {
			return "" + finall.getGenomeCodev();
		}
		case "B": {
			return "" + finall.getTotalEnzymesv();
		}

		case "C": {
			return "" + finall.getC();
		}
		case "D": {
			return "" + finall.getD();
		}
		case "E": {
			return "" + finall.getE();
		}
		case "F": {
			return "" + finall.getF();
		}
		case "G": {
			return "" + finall.getG();
		}
		case "H": {
			return "" + finall.getH();
		}
		case "I": {
			return "" + finall.getI();
		}
		case "J": {
			return "" + finall.getJ();
		}
		case "K": {
			return "" + finall.getK();
		}
		case "L": {
			return "" + finall.getL();
		}
		case "M": {
			return "" + finall.getM();
		}
		case "N": {
			return "" + finall.getN();
		}
		case "O": {
			return "" + finall.getO();
		}
		case "P": {
			return "" + finall.getP();
		}
		case "Q": {
			return "" + finall.getQ();
		}
		case "R": {
			return "" + finall.getR();
		}
		case "S": {
			return "" + finall.getS();
		}
		case "T": {
			return "" + finall.getT();
		}
		case "U": {
			return "" + finall.getU();

		}
		case "V": {
			return "" + finall.getV();

		}
		case "W": {
			return "" + finall.getW();

		}
		case "X": {
			return "" + finall.getX();

		}
		case "Y": {
			return "" + finall.getY();

		}
		case "Z": {
			return "" + finall.getZ();

		}
		case "AA": {
			return "" + finall.getAA();

		}
		case "AB": {
			return "" + finall.getAB();

		}
		case "AC": {
			return "" + finall.getAC();

		}
		case "AD": {
			return "" + finall.getAD();

		}
		case "AE": {
			return "" + finall.getAE();

		}
		case "AF": {
			return "" + finall.getAF();

		}
		case "AG": {
			return "" + finall.getAG();

		}
		case "AH": {
			return "" + finall.getAH();

		}
		case "AI": {
			return "" + finall.getAI();

		}
		case "AJ": {
			return "" + finall.getAJ();

		}
		case "AK": {
			return "" + finall.getAK();

		}
		case "AL": {
			return "" + finall.getAL();

		}
		case "AM": {
			return "" + finall.getAM();

		}
		case "AN": {
			return "" + finall.getAN();

		}
		case "AO": {
			return "" + finall.getAO();

		}
		case "AP": {
			return "" + finall.getAP();

		}
		case "AQ": {
			return "" + finall.getAQ();

		}
		case "AR": {
			return "" + finall.getAR();

		}
		case "AS": {
			return "" + finall.getAS();

		}
		case "AT": {
			return "" + finall.getAT();

		}
		case "AU": {
			return "" + finall.getAU();

		}
		case "AV": {
			return "" + finall.getAV();

		}
		case "AW": {
			return "" + finall.getAW();

		}
		case "AX": {
			return "" + finall.getAX();

		}
		case "AY": {
			return "" + finall.getAY();

		}
		case "AZ": {
			return "" + finall.getAZ();

		}
		case "BA": {
			return "" + finall.getBA();

		}
		case "BB": {
			return "" + finall.getBB();

		}
		case "BC": {
			return "" + finall.getBC();

		}
		case "BD": {
			return "" + finall.getBD();

		}
		case "BE": {
			return "" + finall.getBE();

		}
		case "BF": {
			return "" + finall.getBF();

		}
		case "BG": {
			return "" + finall.getBG();

		}
		case "BH": {
			return "" + finall.getBH();

		}
		case "BI": {
			return "" + finall.getBI();

		}
		case "BJ": {
			return "" + finall.getBJ();

		}
		case "BK": {
			return "" + finall.getBK();

		}
		case "BL": {
			return "" + finall.getBL();

		}
		case "BM": {
			return "" + finall.getBM();

		}
		case "BN": {
			return "" + finall.getBN();

		}
		case "BO": {
			return "" + finall.getBO();

		}
		case "BP": {
			return "" + finall.getBP();

		}
		case "BQ": {
			return "" + finall.getBQ();

		}
		case "BR": {
			return "" + finall.getBR();

		}
		case "BS": {
			return "" + finall.getBS();

		}
		case "BT": {
			return "" + finall.getBT();

		}
		case "BU": {
			return "" + finall.getBU();

		}
		case "BV": {
			return "" + finall.getBV();

		}
		case "BW": {
			return "" + finall.getBW();

		}
		case "BX": {
			return "" + finall.getBX();

		}
		case "BY": {
			return "" + finall.getBY();

		}
		case "BZ": {
			return "" + finall.getBZ();

		}
		case "CA": {
			return "" + finall.getCA();

		}
		case "CB": {
			return "" + finall.getCB();

		}
		case "CC": {
			return "" + finall.getCC();

		}
		case "CD": {
			return "" + finall.getCD();

		}
		case "CE": {
			return "" + finall.getCE();

		}
		case "CF": {
			return "" + finall.getCF();

		}
		case "CG": {
			return "" + finall.getCG();

		}
		case "CH": {
			return "" + finall.getCH();

		}
		case "CI": {
			return "" + finall.getCI();

		}
		case "CJ": {
			return "" + finall.getCJ();

		}
		case "CK": {
			return "" + finall.getCK();

		}
		case "CL": {
			return "" + finall.getCL();

		}
		case "CM": {
			return "" + finall.getCM();

		}
		case "CN": {
			return "" + finall.getCN();

		}
		case "CO": {
			return "" + finall.getCO();

		}
		case "CP": {
			return "" + finall.getCP();

		}
		case "CQ": {
			return "" + finall.getCQ();

		}
		case "CR": {
			return "" + finall.getCR();

		}
		case "CS": {
			return "" + finall.getCS();

		}
		case "CT": {
			return "" + finall.getCT();

		}
		case "CU": {
			return "" + finall.getCU();

		}
		case "CV": {
			return "" + finall.getCV();

		}
		case "CW": {
			return "" + finall.getCW();

		}
		case "CX": {
			return "" + finall.getCX();

		}
		case "CY": {
			return "" + finall.getCY();

		}
		case "CZ": {
			return "" + finall.getCZ();

		}
		case "DA": {
			return "" + finall.getDA();

		}
		case "DB": {
			return "" + finall.getDB();

		}
		case "DC": {
			return "" + finall.getDC();

		}
		case "DD": {
			return "" + finall.getDD();

		}
		case "DE": {
			return "" + finall.getDE();

		}
		case "DF": {
			return "" + finall.getDF();

		}
		case "DG": {
			return "" + finall.getDG();

		}
		case "DH": {
			return "" + finall.getDH();

		}
		case "DI": {
			return "" + finall.getDI();

		}
		case "DJ": {
			return "" + finall.getDJ();

		}
		case "DK": {
			return "" + finall.getDK();

		}
		case "DL": {
			return "" + finall.getDL();

		}
		case "DM": {
			return "" + finall.getDM();

		}
		case "DN": {
			return "" + finall.getDN();

		}
		case "DO": {
			return "" + finall.getDO();

		}
		case "DP": {
			return "" + finall.getDP();

		}
		case "DQ": {
			return "" + finall.getDQ();

		}
		case "DR": {
			return "" + finall.getDR();

		}
		case "DS": {
			return "" + finall.getDS();

		}
		case "DT": {
			return "" + finall.getDT();

		}
		case "DU": {
			return "" + finall.getDU();

		}
		case "DV": {
			return "" + finall.getDV();

		}
		case "DW": {
			return "" + finall.getDW();

		}
		case "DX": {
			return "" + finall.getDX();

		}
		case "DY": {
			return "" + finall.getDY();

		}
		case "DZ": {
			return "" + finall.getDZ();

		}
		case "EA": {
			return "" + finall.getEA();

		}
		case "EB": {
			return "" + finall.getEB();

		}
		case "EC": {
			return "" + finall.getEC();

		}
		case "ED": {
			return "" + finall.getED();

		}
		case "EE": {
			return "" + finall.getEE();

		}
		case "EF": {
			return "" + finall.getEF();

		}
		case "EG": {
			return "" + finall.getEG();

		}
		case "EH": {
			return "" + finall.getEH();

		}
		case "EI": {
			return "" + finall.getEI();

		}
		case "EJ": {
			return "" + finall.getEJ();

		}
		case "EK": {
			return "" + finall.getEK();

		}
		case "EL": {
			return "" + finall.getEL();

		}
		case "EM": {
			return "" + finall.getEM();

		}
		case "EN": {
			return "" + finall.getEN();

		}
		case "EO": {
			return "" + finall.getEO();

		}
		case "EP": {
			return "" + finall.getEP();

		}
		case "EQ": {
			return "" + finall.getEQ();

		}
		case "ER": {
			return "" + finall.getER();

		}
		case "ES": {
			return "" + finall.getES();

		}
		case "ET": {
			return "" + finall.getET();

		}
		case "EU": {
			return "" + finall.getEU();

		}
		case "EV": {
			return "" + finall.getEV();

		}
		case "EW": {
			return "" + finall.getEW();

		}
		case "EX": {
			return "" + finall.getEX();

		}
		case "EY": {
			return "" + finall.getEY();

		}
		case "EZ": {
			return "" + finall.getEZ();

		}
		case "FA": {
			return "" + finall.getFA();

		}
		case "FB": {
			return "" + finall.getFB();

		}
		case "FC": {
			return "" + finall.getFC();

		}
		case "FD": {
			return "" + finall.getFD();

		}
		case "FE": {
			return "" + finall.getFE();

		}
		case "FF": {
			return "" + finall.getFF();

		}
		case "FG": {
			return "" + finall.getFG();

		}
		case "FH": {
			return "" + finall.getFH();

		}
		case "FI": {
			return "" + finall.getFI();

		}
		case "FJ": {
			return "" + finall.getFJ();

		}
		case "FK": {
			return "" + finall.getFK();

		}
		case "FL": {
			return "" + finall.getFL();

		}
		case "FM": {
			return "" + finall.getFM();

		}
		case "FN": {
			return "" + finall.getFN();

		}
		case "FO": {
			return "" + finall.getFO();

		}
		case "FP": {
			return "" + finall.getFP();

		}
		case "FQ": {
			return "" + finall.getFQ();

		}
		case "FR": {
			return "" + finall.getFR();

		}
		case "FS": {
			return "" + finall.getFS();

		}
		case "FT": {
			return "" + finall.getFT();

		}
		case "FU": {
			return "" + finall.getFU();

		}
		case "FV": {
			return "" + finall.getFV();

		}
		case "FW": {
			return "" + finall.getFW();

		}
		case "FX": {
			return "" + finall.getFX();

		}
		case "FY": {
			return "" + finall.getFY();

		}
		case "FZ": {
			return "" + finall.getFZ();

		}
		case "GA": {
			return "" + finall.getGA();

		}
		case "GB": {
			return "" + finall.getGB();

		}
		case "GC": {
			return "" + finall.getGC();

		}
		case "GD": {
			return "" + finall.getGD();

		}
		case "GE": {
			return "" + finall.getGE();

		}
		case "GF": {
			return "" + finall.getGF();

		}
		case "GG": {
			return "" + finall.getGG();

		}
		case "GH": {
			return "" + finall.getGH();

		}
		case "GI": {
			return "" + finall.getGI();

		}
		case "GJ": {
			return "" + finall.getGJ();

		}
		case "GK": {
			return "" + finall.getGK();

		}
		case "GL": {
			return "" + finall.getGL();

		}
		case "GM": {
			return "" + finall.getGM();

		}
		case "GN": {
			return "" + finall.getGN();

		}
		case "GO": {
			return "" + finall.getGO();

		}
		case "GP": {
			return "" + finall.getGP();

		}
		case "GQ": {
			return "" + finall.getGQ();

		}
		case "GR": {
			return "" + finall.getGR();

		}
		case "GS": {
			return "" + finall.getGS();

		}
		case "GT": {
			return "" + finall.getGT();

		}
		case "GU": {
			return "" + finall.getGU();

		}
		case "GV": {
			return "" + finall.getGV();

		}
		case "GW": {
			return "" + finall.getGW();

		}
		case "GX": {
			return "" + finall.getGX();

		}
		case "GY": {
			return "" + finall.getGY();

		}
		case "GZ": {
			return "" + finall.getGZ();

		}

		case "HA": {
			return "" + finall.getHA();

		}
		case "HB": {
			return "" + finall.getHB();

		}
		case "HC": {
			return "" + finall.getHC();

		}
		case "HD": {
			return "" + finall.getHD();

		}
		case "HE": {
			return "" + finall.getHE();

		}
		case "HF": {
			return "" + finall.getHF();

		}
		case "HG": {
			return "" + finall.getHG();

		}
		case "HH": {
			return "" + finall.getHH();

		}
		case "HI": {
			return "" + finall.getHI();

		}
		case "HJ": {
			return "" + finall.getHJ();

		}
		case "HK": {
			return "" + finall.getHK();

		}
		case "HL": {
			return "" + finall.getHL();

		}
		case "HM": {
			return "" + finall.getHM();

		}
		case "HN": {
			return "" + finall.getHN();

		}
		case "HO": {
			return "" + finall.getHO();

		}
		case "HP": {
			return "" + finall.getHP();

		}
		case "HQ": {
			return "" + finall.getHQ();

		}
		case "HR": {
			return "" + finall.getHR();

		}
		case "HS": {
			return "" + finall.getHS();

		}
		case "HT": {
			return "" + finall.getHT();

		}
		case "HU": {
			return "" + finall.getHU();

		}
		case "HV": {
			return "" + finall.getHV();

		}
		case "HW": {
			return "" + finall.getHW();

		}
		case "HX": {
			return "" + finall.getHX();

		}
		case "HY": {
			return "" + finall.getHY();

		}
		case "HZ": {
			return "" + finall.getHZ();

		}

		case "IA": {
			return "" + finall.getIA();

		}
		case "IB": {
			return "" + finall.getIB();

		}
		case "IC": {
			return "" + finall.getIC();

		}
		case "ID": {
			return "" + finall.getID();

		}
		case "IE": {
			return "" + finall.getIE();

		}
		case "IF": {
			return "" + finall.getIF();

		}
		case "IG": {
			return "" + finall.getIG();

		}
		case "IH": {
			return "" + finall.getIH();

		}
		case "II": {
			return "" + finall.getII();

		}
		case "IJ": {
			return "" + finall.getIJ();

		}
		case "IK": {
			return "" + finall.getIK();

		}
		case "IL": {
			return "" + finall.getIL();

		}
		case "IM": {
			return "" + finall.getIM();

		}
		case "IN": {
			return "" + finall.getIN();

		}
		case "IO": {
			return "" + finall.getIO();

		}
		case "IP": {
			return "" + finall.getIP();

		}
		case "IQ": {
			return "" + finall.getIQ();

		}
		case "IR": {
			return "" + finall.getIR();

		}
		case "IS": {
			return "" + finall.getIS();

		}
		case "IT": {
			return "" + finall.getIT();

		}
		case "IU": {
			return "" + finall.getIU();

		}
		case "IV": {
			return "" + finall.getIV();

		}
		case "IW": {
			return "" + finall.getIW();

		}
		case "IX": {
			return "" + finall.getIX();

		}
		case "IY": {
			return "" + finall.getIY();

		}
		case "IZ": {
			return "" + finall.getIZ();

		}
		case "JA": {
			return "" + finall.getJA();

		}
		case "JB": {
			return "" + finall.getJB();

		}
		case "JC": {
			return "" + finall.getJC();

		}
		case "JD": {
			return "" + finall.getJD();

		}
		case "JE": {
			return "" + finall.getJE();

		}
		case "JF": {
			return "" + finall.getJF();

		}
		case "JG": {
			return "" + finall.getJG();

		}
		case "JH": {
			return "" + finall.getJH();

		}
		case "JI": {
			return "" + finall.getJI();

		}
		case "JJ": {
			return "" + finall.getJJ();

		}
		case "JK": {
			return "" + finall.getJK();

		}
		case "JL": {
			return "" + finall.getJL();

		}
		case "JM": {
			return "" + finall.getJM();

		}
		case "JN": {
			return "" + finall.getJN();

		}
		case "JO": {
			return "" + finall.getJO();

		}
		case "JP": {
			return "" + finall.getJP();

		}
		case "JQ": {
			return "" + finall.getJQ();

		}
		case "JR": {
			return "" + finall.getJR();

		}
		case "JS": {
			return "" + finall.getJS();

		}
		case "JT": {
			return "" + finall.getJT();

		}
		case "JU": {
			return "" + finall.getJU();

		}
		case "JV": {
			return "" + finall.getJV();

		}
		case "JW": {
			return "" + finall.getJW();

		}
		case "JX": {
			return "" + finall.getJX();

		}
		case "JY": {
			return "" + finall.getJY();

		}
		case "JZ": {
			return "" + finall.getJZ();

		}
		case "KA": {
			return "" + finall.getKA();

		}
		case "KB": {
			return "" + finall.getKB();

		}
		case "KC": {
			return "" + finall.getKC();

		}
		case "KD": {
			return "" + finall.getKD();

		}
		case "KE": {
			return "" + finall.getKE();

		}
		case "KF": {
			return "" + finall.getKF();

		}
		case "KG": {
			return "" + finall.getKG();

		}
		case "KH": {
			return "" + finall.getKH();

		}
		case "KI": {
			return "" + finall.getKI();

		}
		case "KJ": {
			return "" + finall.getKJ();

		}
		case "KK": {
			return "" + finall.getKK();

		}
		case "KL": {
			return "" + finall.getKL();

		}
		case "KM": {
			return "" + finall.getKM();

		}
		case "KN": {
			return "" + finall.getKN();

		}
		case "KO": {
			return "" + finall.getKO();

		}
		case "KP": {
			return "" + finall.getKP();

		}
		case "KQ": {
			return "" + finall.getKQ();

		}
		case "KR": {
			return "" + finall.getKR();

		}
		case "KS": {
			return "" + finall.getKS();

		}
		case "KT": {
			return "" + finall.getKT();

		}
		case "KU": {
			return "" + finall.getKU();

		}
		case "KV": {
			return "" + finall.getKV();

		}
		case "KW": {
			return "" + finall.getKW();

		}
		case "KX": {
			return "" + finall.getKX();

		}
		case "KY": {
			return "" + finall.getKY();

		}
		case "KZ": {
			return "" + finall.getKZ();

		}
		case "LA": {
			return "" + finall.getLA();

		}
		case "LB": {
			return "" + finall.getLB();

		}
		case "LC": {
			return "" + finall.getLC();

		}
		case "LD": {
			return "" + finall.getLD();

		}
		case "LE": {
			return "" + finall.getLE();

		}
		case "LF": {
			return "" + finall.getLF();

		}
		case "LG": {
			return "" + finall.getLG();

		}
		case "LH": {
			return "" + finall.getLH();

		}
		case "LI": {
			return "" + finall.getLI();

		}
		case "LJ": {
			return "" + finall.getLJ();

		}
		case "LK": {
			return "" + finall.getLK();

		}
		case "LL": {
			return "" + finall.getLL();

		}
		case "LM": {
			return "" + finall.getLM();

		}
		case "LN": {
			return "" + finall.getLN();

		}
		case "LO": {
			return "" + finall.getLO();

		}
		case "LP": {
			return "" + finall.getLP();

		}
		case "LQ": {
			return "" + finall.getLQ();

		}
		case "LR": {
			return "" + finall.getLR();

		}
		case "LS": {
			return "" + finall.getLS();

		}
		case "LT": {
			return "" + finall.getLT();

		}
		case "LU": {
			return "" + finall.getLU();

		}
		case "LV": {
			return "" + finall.getLV();

		}
		case "LW": {
			return "" + finall.getLW();

		}
		case "LX": {
			return "" + finall.getLX();

		}
		case "LY": {
			return "" + finall.getLY();

		}
		case "LZ": {
			return "" + finall.getLZ();

		}
		case "MA": {
			return "" + finall.getMA();

		}
		case "MB": {
			return "" + finall.getMB();

		}
		case "MC": {
			return "" + finall.getMC();

		}
		case "MD": {
			return "" + finall.getMD();

		}
		case "ME": {
			return "" + finall.getME();

		}
		case "MF": {
			return "" + finall.getMF();

		}
		case "MG": {
			return "" + finall.getMG();

		}
		case "MH": {
			return "" + finall.getMH();

		}
		case "MI": {
			return "" + finall.getMI();

		}
		case "MJ": {
			return "" + finall.getMJ();

		}
		case "MK": {
			return "" + finall.getMK();

		}
		case "ML": {
			return "" + finall.getML();

		}
		case "MM": {
			return "" + finall.getMM();

		}
		case "MN": {
			return "" + finall.getMN();

		}
		case "MO": {
			return "" + finall.getMO();

		}
		case "MP": {
			return "" + finall.getMP();

		}
		case "MQ": {
			return "" + finall.getMQ();

		}
		case "MR": {
			return "" + finall.getMR();

		}
		case "MS": {
			return "" + finall.getMS();

		}
		case "MT": {
			return "" + finall.getMT();

		}
		case "MU": {
			return "" + finall.getMU();

		}
		default:
			return null;
		}
	}
	
}*/