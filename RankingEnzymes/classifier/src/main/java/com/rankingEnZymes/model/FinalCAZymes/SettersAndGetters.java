package com.rankingEnZymes.model.FinalCAZymes;

public class SettersAndGetters {

	public static FinalCAZvType setValue(String column, String val2, FinalCAZvType finall) {

		Long val = null;
		if (!column.equals("A"))
			val = Long.parseLong(val2);
		switch (column) // nested switch
		{
		case "A": {
			finall.setGenomecode(val2);
			break;
		}
		case "B": {
			finall.setTotalenzymes(val);
			break;
		}
		case "C": {
			finall.set_AA2_cyt(val);
			break;
		}
		case "D": {
			finall.set_AA(val);
			//// finall.setD(val);
			break;
		}

		case "E": {
			finall.set_AA10(val);
			break;
		}
		case "F": {
			finall.set_AA11(val);
			break;
		}
		case "G": {
			finall.set_AA11_dist(val);
			break;
		}
		case "H": {
			finall.set_AA12(val);
			break;
		}
		case "I": {
			finall.set_AA12_dist(val);
			break;
		}
		case "J": {
			finall.set_AA13(val);
			break;
		}
		case "K": {
			finall.set_AA14(val);
			break;
		}
		case "L": {
			finall.set_AA1(val);
			break;
		}
		case "M": {
			finall.set_AA1_1(val);
			break;
		}
		case "N": {
			finall.set_AA1_2(val);
			break;
		}
		case "O": {
			finall.set_AA1_3(val);
			break;
		}
		case "P": {
			finall.set_AA1_dist(val);
			break;
		}
		case "Q": {
			finall.set_AA2(val);
			break;
		}
		case "R": {
			finall.set_AA2_dist(val);
			break;
		}
		case "S": {
			finall.set_AA3(val);
			break;
		}
		case "T": {
			finall.set_AA3_1(val);
			break;
		}
		case "U": {
			finall.set_AA3_2(val);
			break;
		}
		case "V": {
			finall.set_AA3_3(val);
			break;
		}
		case "W": {
			finall.set_AA3_4(val);
			break;
		}
		case "X": {
			finall.set_AA3_dist(val);
			break;
		}
		case "Y": {
			finall.set_AA4(val);
			break;
		}
		case "Z": {
			finall.set_AA5(val);
			break;
		}
		case "AA": {
			finall.set_AA5_1(val);
			break;
		}
		case "AB": {
			finall.set_AA5_2(val);
			break;
		}
		case "AC": {
			finall.set_AA5_dist(val);
			break;
		}
		case "AD": {
			finall.set_AA6(val);
			break;
		}
		case "AE": {
			finall.set_AA7(val);
			break;
		}
		case "AF": {
			finall.set_AA7_dist(val);
			break;
		}
		case "AG": {
			finall.set_AA8(val);
			break;
		}
		case "AH": {
			finall.set_AA8_dist(val);
			break;
		}
		case "AI": {
			finall.set_AA9(val);
			break;
		}
		case "AJ": {
			finall.set_AA9_dist(val);
			break;
		}
		case "AK": {
			finall.set_CBM(val);
			break;
		}
		case "AL": {
			finall.set_CBM10(val);
			break;
		}
		case "AM": {
			finall.set_CBM12(val);
			break;
		}
		case "AN": {
			finall.set_CBM13(val);
			break;
		}
		case "AO": {
			finall.set_CBM14(val);
			break;
		}
		case "AP": {
			finall.set_CBM16(val);
			break;
		}
		case "AQ": {
			finall.set_CBM18(val);
			break;
		}
		case "AR": {
			finall.set_CBM19(val);
			break;
		}
		case "AS": {
			finall.set_CBM1(val);
			break;
		}
		case "AT": {
			finall.set_CBM20(val);
			break;
		}
		case "AU": {
			finall.set_CBM21(val);
			break;
		}
		case "AV": {
			finall.set_CBM22(val);
			break;
		}
		case "AW": {
			finall.set_CBM24(val);
			break;
		}
		case "AX": {
			finall.set_CBM25(val);
			break;
		}
		case "AY": {
			finall.set_CBM26(val);
			break;
		}
		case "AZ": {
			finall.set_CBM29(val);
			break;
		}
		case "BA": {
			finall.set_CBM2(val);
			break;
		}
		case "BB": {
			finall.set_CBM32(val);
			break;
		}
		case "BC": {
			finall.set_CBM35(val);
			break;
		}
		case "BD": {
			finall.set_CBM38(val);
			break;
		}
		case "BE": {
			finall.set_CBM3(val);
			break;
		}
		case "BF": {
			finall.set_CBM42(val);
			break;
		}
		case "BG": {
			finall.set_CBM43(val);
			break;
		}
		case "BH": {
			finall.set_CBM48(val);
			break;
		}
		case "BI": {
			finall.set_CBM4(val);
			break;
		}
		case "BJ": {
			finall.set_CBM50(val);
			break;
		}
		case "BK": {
			finall.set_CBM51(val);
			break;
		}
		case "BL": {
			finall.set_CBM52(val);
			break;
		}
		case "BM": {
			finall.set_CBM5(val);
			break;
		}
		case "BN": {
			finall.set_CBM61(val);
			break;
		}
		case "BO": {
			finall.set_CBM63(val);
			break;
		}
		case "BP": {
			finall.set_CBM66(val);
			break;
		}
		case "BQ": {
			finall.set_CBM67(val);
			break;
		}
		case "BR": {
			finall.set_CBM6(val);
			break;
		}
		case "BS": {
			finall.set_CBM71(val);
			break;
		}
		case "BT": {
			finall.set_CBM8(val);
			break;
		}
		case "BU": {
			finall.set_CBM9(val);
			break;
		}
		case "BV": {
			finall.set_CE(val);
			break;
		}
		case "BW": {
			finall.set_CE11(val);
			break;
		}
		case "BX": {
			finall.set_CE12(val);
			break;
		}
		case "BY": {
			finall.set_CE13(val);
			break;
		}
		case "BZ": {
			finall.set_CE14(val);
			break;
		}
		case "CA": {
			finall.set_CE15(val);
			break;
		}
		case "CB": {
			finall.set_CE16(val);
			break;
		}
		case "CC": {
			finall.set_CE1(val);
			break;
		}
		case "CD": {
			finall.set_CE2(val);
			break;
		}
		case "CE": {
			finall.set_CE3(val);
			break;
		}
		case "CF": {
			finall.set_CE4(val);
			break;
		}
		case "CG": {
			finall.set_CE5(val);
			break;
		}
		case "CH": {
			finall.set_CE6(val);
			break;
		}
		case "CI": {
			finall.set_CE7(val);
			break;
		}
		case "CJ": {
			finall.set_CE8(val);
			break;
		}
		case "CK": {
			finall.set_CE9(val);
			break;
		}
		case "CL": {
			finall.set_DOC(val);
			break;
		}
		case "CM": {
			finall.set_DOC2(val);
			break;
		}
		case "CN": {
			finall.set_EXPN(val);
			break;
		}
		case "CO": {
			finall.set_GH(val);
			break;
		}
		case "CP": {
			finall.set_GH103(val);
			break;
		}
		case "CQ": {
			finall.set_GH105(val);
			break;
		}
		case "CR": {
			finall.set_GH106(val);
			break;
		}
		case "CS": {
			finall.set_GH108(val);
			break;
		}
		case "CT": {
			finall.set_GH10(val);
			break;
		}
		case "CU": {
			finall.set_GH110(val);
			break;
		}
		case "CV": {
			finall.set_GH114(val);
			break;
		}
		case "CW": {
			finall.set_GH115(val);
			break;
		}
		case "CX": {
			finall.set_GH116(val);
			break;
		}
		case "CY": {
			finall.set_GH11(val);
			break;
		}
		case "CZ": {
			finall.set_GH120(val);
			break;
		}
		case "DA": {
			finall.set_GH121(val);
			break;
		}
		case "DB": {
			finall.set_GH124(val);
			break;
		}
		case "DC": {
			finall.set_GH125(val);
			break;
		}
		case "DD": {
			finall.set_GH127(val);
			break;
		}
		case "DE": {
			finall.set_GH128(val);
			break;
		}
		case "DF": {
			finall.set_GH12(val);
			break;
		}
		case "DG": {
			finall.set_GH130(val);
			break;
		}
		case "DH": {
			finall.set_GH131(val);
			break;
		}
		case "DI": {
			finall.set_GH132(val);
			break;
		}
		case "DJ": {
			finall.set_GH133(val);
			break;
		}
		case "DK": {
			finall.set_GH134(val);
			break;
		}
		case "DL": {
			finall.set_GH135(val);
			break;
		}
		case "DM": {
			finall.set_GH136(val);
			break;
		}
		case "DN": {
			finall.set_GH139(val);
			break;
		}
		case "DO": {
			finall.set_GH13(val);
			break;
		}
		case "DP": {
			finall.set_GH13_10(val);
			break;
		}
		case "DQ": {
			finall.set_GH13_11(val);
			break;
		}
		case "DR": {
			finall.set_GH13_14(val);
			break;
		}
		case "DS": {
			finall.set_GH13_15(val);
			break;
		}
		case "DT": {
			finall.set_GH13_1(val);
			break;
		}
		case "DU": {
			finall.set_GH13_20(val);
			break;
		}
		case "DV": {
			finall.set_GH13_22(val);
			break;
		}
		case "DW": {
			finall.set_GH13_23(val);
			break;
		}
		case "DX": {
			finall.set_GH13_25(val);
			break;
		}
		case "DY": {
			finall.set_GH13_26(val);
			break;
		}
		case "DZ": {
			finall.set_GH13_28(val);
			break;
		}
		case "EA": {
			finall.set_GH13_30(val);
			break;
		}
		case "EB": {
			finall.set_GH13_31(val);
			break;
		}
		case "EC": {
			finall.set_GH13_32(val);
			break;
		}
		case "ED": {
			finall.set_GH13_37(val);
			break;
		}
		case "EE": {
			finall.set_GH13_3(val);
			break;
		}
		case "EF": {
			finall.set_GH13_40(val);
			break;
		}
		case "EG": {
			finall.set_GH13_4(val);
			break;
		}
		case "EH": {
			finall.set_GH13_5(val);
			break;
		}
		case "EI": {
			finall.set_GH13_6(val);
			break;
		}
		case "EJ": {
			finall.set_GH13_8(val);
			break;
		}
		case "EK": {
			finall.set_GH13_dist(val);
			break;
		}
		case "EL": {
			finall.set_GH13_m42(val);
			break;
		}
		case "EM": {
			finall.set_GH13_m46(val);
			break;
		}
		case "EN": {
			finall.set_GH140(val);
			break;
		}
		case "EO": {
			finall.set_GH141(val);
			break;
		}
		case "EP": {
			finall.set_GH142(val);
			break;
		}
		case "EQ": {
			finall.set_GH143(val);
			break;
		}
		case "ER": {
			finall.set_GH145(val);
			break;
		}
		case "ES": {
			finall.set_GH146(val);
			break;
		}
		case "ET": {
			finall.set_GH14(val);
			break;
		}
		case "EU": {
			finall.set_GH151(val);
			break;
		}
		case "EV": {
			finall.set_GH152(val);
			break;
		}
		case "EW": {
			finall.set_GH15(val);
			break;
		}
		case "EX": {
			finall.set_GH16(val);
			break;
		}
		case "EY": {
			finall.set_GH17(val);
			break;
		}
		case "EZ": {
			finall.set_GH18(val);
			break;
		}
		case "FA": {
			finall.set_GH19(val);
			break;
		}
		case "FB": {
			finall.set_GH1(val);
			break;
		}
		case "FC": {
			finall.set_GH20(val);
			break;
		}
		case "FD": {
			finall.set_GH23(val);
			break;
		}
		case "FE": {
			finall.set_GH24(val);
			break;
		}
		case "FF": {
			finall.set_GH25(val);
			break;
		}
		case "FG": {
			finall.set_GH26(val);
			break;
		}
		case "FH": {
			finall.set_GH27(val);
			break;
		}
		case "FI": {
			finall.set_GH28(val);
			break;
		}
		case "FJ": {
			finall.set_GH29(val);
			break;
		}
		case "FK": {
			finall.set_GH2(val);
			break;
		}
		case "FL": {
			finall.set_GH30(val);
			break;
		}
		case "FM": {
			finall.set_GH30_1(val);
			break;
		}
		case "FN": {
			finall.set_GH30_3(val);
			break;
		}
		case "FO": {
			finall.set_GH30_5(val);
			break;
		}
		case "FP": {
			finall.set_GH30_7(val);
			break;
		}
		case "FQ": {
			finall.set_GH30_dist(val);
			break;
		}
		case "FR": {
			finall.set_GH31(val);
			break;
		}
		case "FS": {
			finall.set_GH32(val);
			break;
		}
		case "FT": {
			finall.set_GH33(val);
			break;
		}
		case "FU": {
			finall.set_GH35(val);
			break;
		}
		case "FV": {
			finall.set_GH36(val);
			break;
		}
		case "FW": {
			finall.set_GH37(val);
			break;
		}
		case "FX": {
			finall.set_GH38(val);
			break;
		}
		case "FY": {
			finall.set_GH39(val);
			break;
		}
		case "FZ": {
			finall.set_GH3(val);
			break;
		}
		case "GA": {
			finall.set_GH42(val);
			break;
		}
		case "GB": {
			finall.set_GH43(val);
			break;
		}
		case "GC": {
			finall.set_GH44(val);
			break;
		}
		case "GD": {
			finall.set_GH45(val);
			break;
		}
		case "GE": {
			finall.set_GH46(val);
			break;
		}
		case "GF": {
			finall.set_GH47(val);
			break;
		}
		case "GG": {
			finall.set_GH48(val);
			break;
		}
		case "GH": {
			finall.set_GH49(val);
			break;
		}
		case "GI": {
			finall.set_GH4(val);
			break;
		}
		case "GJ": {
			finall.set_GH51(val);
			break;
		}
		case "GK": {
			finall.set_GH52(val);
			break;
		}
		case "GL": {
			finall.set_GH53(val);
			break;
		}
		case "GM": {
			finall.set_GH54(val);
			break;
		}
		case "GN": {
			finall.set_GH55(val);
			break;
		}
		case "GO": {
			finall.set_GH57(val);
			break;
		}
		case "GP": {
			finall.set_GH5(val);
			break;
		}
		case "GQ": {
			finall.set_GH5_11(val);
			break;
		}
		case "GR": {
			finall.set_GH5_12(val);
			break;
		}
		case "GS": {
			finall.set_GH5_13(val);
			break;
		}
		case "GT": {
			finall.set_GH5_15(val);
			break;
		}
		case "GU": {
			finall.set_GH5_16(val);
			break;
		}
		case "GV": {
			finall.set_GH5_1(val);
			break;
		}
		case "GW": {
			finall.set_GH5_22(val);
			break;
		}
		case "GX": {
			finall.set_GH5_23(val);
			break;
		}
		case "GY": {
			finall.set_GH5_24(val);
			break;
		}
		case "GZ": {
			finall.set_GH5_27(val);
			break;
		}
		case "HA": {
			finall.set_GH5_28(val);
			break;
		}
		case "HB": {
			finall.set_GH5_2(val);
			break;
		}
		case "HC": {
			finall.set_GH5_30(val);
			break;
		}
		case "HD": {
			finall.set_GH5_31(val);
			break;
		}
		case "HE": {
			finall.set_GH5_34(val);
			break;
		}
		case "HF": {
			finall.set_GH5_36(val);
			break;
		}
		case "HG": {
			finall.set_GH5_40(val);
			break;
		}
		case "HH": {
			finall.set_GH5_41(val);
			break;
		}
		case "HI": {
			finall.set_GH5_49(val);
			break;
		}
		case "HJ": {
			finall.set_GH5_4(val);
			break;
		}
		case "HK": {
			finall.set_GH5_50(val);
			break;
		}
		case "HL": {
			finall.set_GH5_51(val);
			break;
		}
		case "HM": {
			finall.set_GH5_5(val);
			break;
		}
		case "HN": {
			finall.set_GH5_7(val);
			break;
		}
		case "HO": {
			finall.set_GH5_8(val);
			break;
		}
		case "HP": {
			finall.set_GH5_9(val);
			break;
		}
		case "HQ": {
			finall.set_GH5_dist(val);
			break;
		}
		case "HR": {
			finall.set_GH62(val);
			break;
		}
		case "HS": {
			finall.set_GH63(val);
			break;
		}
		case "HT": {
			finall.set_GH64(val);
			break;
		}
		case "HU": {
			finall.set_GH65(val);
			break;
		}
		case "HV": {
			finall.set_GH67(val);
			break;
		}
		case "HW": {
			finall.set_GH6(val);
			break;
		}
		case "HX": {
			finall.set_GH71(val);
			break;
		}
		case "HY": {
			finall.set_GH72(val);
			break;
		}
		case "HZ": {
			finall.set_GH73(val);
			break;
		}
		case "IA": {
			finall.set_GH74(val);
			break;
		}
		case "IB": {
			finall.set_GH75(val);
			break;
		}
		case "IC": {
			finall.set_GH76(val);
			break;
		}
		case "ID": {
			finall.set_GH77(val);
			break;
		}
		case "IE": {
			finall.set_GH78(val);
			break;
		}
		case "IF": {
			finall.set_GH79(val);
			break;
		}
		case "IG": {
			finall.set_GH7(val);
			break;
		}
		case "IH": {
			finall.set_GH81(val);
			break;
		}
		case "II": {
			finall.set_GH84(val);
			break;
		}
		case "IJ": {
			finall.set_GH85(val);
			break;
		}
		case "IK": {
			finall.set_GH88(val);
			break;
		}
		case "IL": {
			finall.set_GH89(val);
			break;
		}
		case "IM": {
			finall.set_GH8(val);
			break;
		}
		case "IN": {
			finall.set_GH91(val);
			break;
		}
		case "IO": {
			finall.set_GH92(val);
			break;
		}
		case "IP": {
			finall.set_GH93(val);
			break;
		}
		case "IQ": {
			finall.set_GH94(val);
			break;
		}
		case "IR": {
			finall.set_GH95(val);
			break;
		}
		case "IS": {
			finall.set_GH97(val);
			break;
		}
		case "IT": {
			finall.set_GH99(val);
			break;
		}
		case "IU": {
			finall.set_GH9(val);
			break;
		}
		case "IV": {
			finall.set_GT(val);
			break;
		}
		case "IW": {
			finall.set_GT101(val);
			break;
		}
		case "IX": {
			finall.set_GT10(val);
			break;
		}
		case "IY": {
			finall.set_GT11(val);
			break;
		}
		case "IZ": {
			finall.set_GT12(val);
			break;
		}
		case "JA": {
			finall.set_GT13(val);
			break;
		}
		case "JB": {
			finall.set_GT14(val);
			break;
		}
		case "JC": {
			finall.set_GT15(val);
			break;
		}
		case "JD": {
			finall.set_GT17(val);
			break;
		}
		case "JE": {
			finall.set_GT18(val);
			break;
		}
		case "JF": {
			finall.set_GT1(val);
			break;
		}
		case "JG": {
			finall.set_GT20(val);
			break;
		}
		case "JH": {
			finall.set_GT21(val);
			break;
		}
		case "JI": {
			finall.set_GT22(val);
			break;
		}
		case "JJ": {
			finall.set_GT23(val);
			break;
		}
		case "JK": {
			finall.set_GT24(val);
			break;
		}
		case "JL": {
			finall.set_GT25(val);
			break;
		}
		case "JM": {
			finall.set_GT28(val);
			break;
		}
		case "JN": {
			finall.set_GT2(val);
			break;
		}
		case "JO": {
			finall.set_GT31(val);
			break;
		}
		case "JP": {
			finall.set_GT32(val);
			break;
		}
		case "JQ": {
			finall.set_GT33(val);
			break;
		}
		case "JR": {
			finall.set_GT34(val);
			break;
		}
		case "JS": {
			finall.set_GT35(val);
			break;
		}
		case "JT": {
			finall.set_GT37(val);
			break;
		}
		case "JU": {
			finall.set_GT39(val);
			break;
		}
		case "JV": {
			finall.set_GT3(val);
			break;
		}
		case "JW": {
			finall.set_GT41(val);
			break;
		}
		case "JX": {
			finall.set_GT43(val);
			break;
		}
		case "JY": {
			finall.set_GT45(val);
			break;
		}
		case "JZ": {
			finall.set_GT47(val);
			break;
		}
		case "KA": {
			finall.set_GT48(val);
			break;
		}
		case "KB": {
			finall.set_GT49(val);
			break;
		}
		case "KC": {
			finall.set_GT4(val);
			break;
		}
		case "KD": {
			finall.set_GT50(val);
			break;
		}
		case "KE": {
			finall.set_GT51(val);
			break;
		}
		case "KF": {
			finall.set_GT54(val);
			break;
		}
		case "KG": {
			finall.set_GT55(val);
			break;
		}
		case "KH": {
			finall.set_GT57(val);
			break;
		}
		case "KI": {
			finall.set_GT58(val);
			break;
		}
		case "KJ": {
			finall.set_GT59(val);
			break;
		}
		case "KK": {
			finall.set_GT5(val);
			break;
		}
		case "KL": {
			finall.set_GT60(val);
			break;
		}
		case "KM": {
			finall.set_GT61(val);
			break;
		}
		case "KN": {
			finall.set_GT62(val);
			break;
		}
		case "KO": {
			finall.set_GT64(val);
			break;
		}
		case "KP": {
			finall.set_GT65(val);
			break;
		}
		case "KQ": {
			finall.set_GT66(val);
			break;
		}
		case "KR": {
			finall.set_GT68(val);
			break;
		}
		case "KS": {
			finall.set_GT69(val);
			break;
		}
		case "KT": {
			finall.set_GT6(val);
			break;
		}
		case "KU": {
			finall.set_GT71(val);
			break;
		}
		case "KV": {
			finall.set_GT76(val);
			break;
		}
		case "KW": {
			finall.set_GT77(val);
			break;
		}
		case "KX": {
			finall.set_GT7(val);
			break;
		}
		case "KY": {
			finall.set_GT81(val);
			break;
		}
		case "KZ": {
			finall.set_GT8(val);
			break;
		}
		case "LA": {
			finall.set_GT90(val);
			break;
		}
		case "LB": {
			finall.set_GT91(val);
			break;
		}
		case "LC": {
			finall.set_GT9(val);
			break;
		}
		case "LD": {
			finall.set_Myosin_motor(val);
			break;
		}
		case "LE": {
			finall.set_PL(val);
			break;
		}
		case "LF": {
			finall.set_PL10(val);
			break;
		}
		case "LG": {
			finall.set_PL10_dist(val);
			break;
		}
		case "LH": {
			finall.set_PL11(val);
			break;
		}
		case "LI": {
			finall.set_PL11_2(val);
			break;
		}
		case "LJ": {
			finall.set_PL14(val);
			break;
		}
		case "LK": {
			finall.set_PL14_1(val);
			break;
		}
		case "LL": {
			finall.set_PL14_3(val);
			break;
		}
		case "LM": {
			finall.set_PL14_4(val);
			break;
		}
		case "LN": {
			finall.set_PL14_5(val);
			break;
		}
		case "LO": {
			finall.set_PL14_dist(val);
			break;
		}
		case "LP": {
			finall.set_PL15(val);
			break;
		}
		case "LQ": {
			finall.set_PL15_dist(val);
			break;
		}
		case "LR": {
			finall.set_PL1(val);
			break;
		}
		case "LS": {
			finall.set_PL1_10(val);
			break;
		}
		case "LT": {
			finall.set_PL1_2(val);
			break;
		}
		case "LU": {
			finall.set_PL1_4(val);
			break;
		}
		case "LV": {
			finall.set_PL1_6(val);
			break;
		}
		case "LW": {
			finall.set_PL1_7(val);
			break;
		}
		case "LX": {
			finall.set_PL1_9(val);
			break;
		}
		case "LY": {
			finall.set_PL1_dist(val);
			break;
		}
		case "LZ": {
			finall.set_PL20(val);
			break;
		}
		case "MA": {
			finall.set_PL20_dist(val);
			break;
		}
		case "MB": {
			finall.set_PL22(val);
			break;
		}
		case "MC": {
			finall.set_PL22_2(val);
			break;
		}
		case "MD": {
			finall.set_PL26(val);
			break;
		}
		case "ME": {
			finall.set_PL27(val);
			break;
		}
		case "MF": {
			finall.set_PL3(val);
			break;
		}
		case "MG": {
			finall.set_PL3_2(val);
			break;
		}
		case "MH": {
			finall.set_PL3_dist(val);
			break;
		}
		case "MI": {
			finall.set_PL4(val);
			break;
		}
		case "MJ": {
			finall.set_PL4_1(val);
			break;
		}
		case "MK": {
			finall.set_PL4_3(val);
			break;
		}
		case "ML": {
			finall.set_PL4_5(val);
			break;
		}
		case "MM": {
			finall.set_PL4_dist(val);
			break;
		}
		case "MN": {
			finall.set_PL7(val);
			break;
		}
		case "MO": {
			finall.set_PL7_4(val);
			break;
		}
		case "MP": {
			finall.set_PL7_dist(val);
			break;
		}
		case "MQ": {
			finall.set_PL8(val);
			break;
		}
		case "MR": {
			finall.set_PL8_4(val);
			break;
		}
		case "MS": {
			finall.set_PL9(val);
			break;
		}
		case "MT": {
			finall.set_PL9_1(val);
			break;
		}
		case "MU": {
			finall.set_PL9_3(val);
			break;
		}

		/*
		 * case "E" :: { //finall.setE(val); break; } case "F": { //finall.setF(val);
		 * break; } case "G": { //finall.setG(val); break; } case "H": {
		 * //finall.setH(val); break; } case "I": { //finall.setI(val); break; } case
		 * "J": { //finall.setJ(val); break; } case "K": { //finall.setK(val); break; }
		 * case "L": { //finall.setL(val); break; } case "M": { //finall.setM(val);
		 * break; } case "N": { //finall.setN(val); break; } case "O": {
		 * //finall.setO(val); break; } case "P": { //finall.setP(val); break; } case
		 * "Q": { //finall.setQ(val); break; } case "R": { //finall.setR(val); break; }
		 * case "S": { //finall.setS(val); break; } case "T": { //finall.setT(val);
		 * break; } case "U": { //finall.setU(val); break; } case "V": {
		 * //finall.setV(val); break; } case "W": { //finall.setW(val); break; } case
		 * "X": { //finall.setX(val); break; } case "Y": { //finall.setY(val); break; }
		 * case "Z": { //finall.setZ(val); break; } case "AA": { //finall.setAA(val);
		 * break; } case "AB": { //finall.setAB(val); break; } case "AC": {
		 * //finall.setAC(val); break; } case "AD": { //finall.setAD(val); break; } case
		 * "AE": { //finall.setAE(val); break; } case "AF": { //finall.setAF(val);
		 * break; } case "AG": { //finall.setAG(val); break; } case "AH": {
		 * //finall.setAH(val); break; } case "AI": { //finall.setAI(val); break; } case
		 * "AJ": { //finall.setAJ(val); break; } case "AK": { //finall.setAK(val);
		 * break; } case "AL": { //finall.setAL(val); break; } case "AM": {
		 * //finall.setAM(val); break; } case "AN": { //finall.setAN(val); break; } case
		 * "AO": { //finall.setAO(val); break; } case "AP": { //finall.setAP(val);
		 * break; } case "AQ": { //finall.setAQ(val); break; } case "AR": {
		 * //finall.setAR(val); break; } case "AS": { //finall.setAS(val); break; } case
		 * "AT": { //finall.setAT(val); break; } case "AU": { //finall.setAU(val);
		 * break; } case "AV": { //finall.setAV(val); break; } case "AW": {
		 * //finall.setAW(val); break; } case "AX": { //finall.setAX(val); break; } case
		 * "AY": { //finall.setAY(val); break; } case "AZ": { //finall.setAZ(val);
		 * break; } case "BA": { //finall.setBA(val); break; } case "BB": {
		 * //finall.setBB(val); break; } case "BC": { //finall.setBC(val); break; } case
		 * "BD": { //finall.setBD(val); break; } case "BE": { //finall.setBE(val);
		 * break; } case "BF": { //finall.setBF(val); break; } case "BG": {
		 * //finall.setBG(val); break; } case "BH": { //finall.setBH(val); break; } case
		 * "BI": { //finall.setBI(val); break; } case "BJ": { //finall.setBJ(val);
		 * break; } case "BK": { //finall.setBK(val); break; } case "BL": {
		 * //finall.setBL(val); break; } case "BM": { //finall.setBM(val); break; } case
		 * "BN": { //finall.setBN(val); break; } case "BO": { //finall.setBO(val);
		 * break; } case "BP": { //finall.setBP(val); break; } case "BQ": {
		 * //finall.setBQ(val); break; } case "BR": { //finall.setBR(val); break; } case
		 * "BS": { //finall.setBS(val); break; } case "BT": { //finall.setBT(val);
		 * break; } case "BU": { //finall.setBU(val); break; } case "BV": {
		 * //finall.setBV(val); break; } case "BW": { //finall.setBW(val); break; } case
		 * "BX": { //finall.setBX(val); break; } case "BY": { //finall.setBY(val);
		 * break; } case "BZ": { //finall.setBZ(val); break; } case "CA": {
		 * //finall.setCA(val); break; } case "CB": { //finall.setCB(val); break; } case
		 * "CC": { //finall.setCC(val); break; } case "CD": { //finall.setCD(val);
		 * break; } case "CE": { //finall.setCE(val); break; } case "CF": {
		 * //finall.setCF(val); break; } case "CG": { //finall.setCG(val); break; } case
		 * "CH": { //finall.setCH(val); break; } case "CI": { //finall.setCI(val);
		 * break; } case "CJ": { //finall.setCJ(val); break; } case "CK": {
		 * //finall.setCK(val); break; } case "CL": { //finall.setCL(val); break; } case
		 * "CM": { //finall.setCM(val); break; } case "CN": { //finall.setCN(val);
		 * break; } case "CO": { //finall.setCO(val); break; } case "CP": {
		 * //finall.setCP(val); break; } case "CQ": { //finall.setCQ(val); break; } case
		 * "CR": { //finall.setCR(val); break; } case "CS": { //finall.setCS(val);
		 * break; } case "CT": { //finall.setCT(val); break; } case "CU": {
		 * //finall.setCU(val); break; } case "CV": { //finall.setCV(val); break; } case
		 * "CW": { //finall.setCW(val); break; } case "CX": { //finall.setCX(val);
		 * break; } case "CY": { //finall.setCY(val); break; } case "CZ": {
		 * //finall.setCZ(val); break; } case "DA": { //finall.setDA(val); break; } case
		 * "DB": { //finall.setDB(val); break; } case "DC": { //finall.setDC(val);
		 * break; } case "DD": { //finall.setDD(val); break; } case "DE": {
		 * //finall.setDE(val); break; } case "DF": { //finall.setDF(val); break; } case
		 * "DG": { //finall.setDG(val); break; } case "DH": { //finall.setDH(val);
		 * break; } case "DI": { //finall.setDI(val); break; } case "DJ": {
		 * //finall.setDJ(val); break; } case "DK": { //finall.setDK(val); break; } case
		 * "DL": { //finall.setDL(val); break; } case "DM": { //finall.setDM(val);
		 * break; } case "DN": { //finall.setDN(val); break; } case "DO": {
		 * //finall.setDO(val); break; } case "DP": { //finall.setDP(val); break; } case
		 * "DQ": { //finall.setDQ(val); break; } case "DR": { //finall.setDR(val);
		 * break; } case "DS": { //finall.setDS(val); break; } case "DT": {
		 * //finall.setDT(val); break; } case "DU": { //finall.setDU(val); break; } case
		 * "DV": { //finall.setDV(val); break; } case "DW": { //finall.setDW(val);
		 * break; } case "DX": { //finall.setDX(val); break; } case "DY": {
		 * //finall.setDY(val); break; } case "DZ": { //finall.setDZ(val); break; } case
		 * "EA": { //finall.setEA(val); break; } case "EB": { //finall.setEB(val);
		 * break; } case "EC": { //finall.setEC(val); break; } case "ED": {
		 * //finall.setED(val); break; } case "EE": { //finall.setEE(val); break; } case
		 * "EF": { //finall.setEF(val); break; } case "EG": { //finall.setEG(val);
		 * break; } case "EH": { //finall.setEH(val); break; } case "EI": {
		 * //finall.setEI(val); break; } case "EJ": { //finall.setEJ(val); break; } case
		 * "EK": { //finall.setEK(val); break; } case "EL": { //finall.setEL(val);
		 * break; } case "EM": { //finall.setEM(val); break; } case "EN": {
		 * //finall.setEN(val); break; } case "EO": { //finall.setEO(val); break; } case
		 * "EP": { //finall.setEP(val); break; } case "EQ": { //finall.setEQ(val);
		 * break; } case "ER": { //finall.setER(val); break; } case "ES": {
		 * //finall.setES(val); break; } case "ET": { //finall.setET(val); break; } case
		 * "EU": { //finall.setEU(val); break; } case "EV": { //finall.setEV(val);
		 * break; } case "EW": { //finall.setEW(val); break; } case "EX": {
		 * //finall.setEX(val); break; } case "EY": { //finall.setEY(val); break; } case
		 * "EZ": { //finall.setEZ(val); break; } case "FA": { //finall.setFA(val);
		 * break; } case "FB": { //finall.setFB(val); break; } case "FC": {
		 * //finall.setFC(val); break; } case "FD": { //finall.setFD(val); break; } case
		 * "FE": { //finall.setFE(val); break; } case "FF": { //finall.setFF(val);
		 * break; } case "FG": { //finall.setFG(val); break; } case "FH": {
		 * //finall.setFH(val); break; } case "FI": { //finall.setFI(val); break; } case
		 * "FJ": { //finall.setFJ(val); break; } case "FK": { //finall.setFK(val);
		 * break; } case "FL": { //finall.setFL(val); break; } case "FM": {
		 * //finall.setFM(val); break; } case "FN": { //finall.setFN(val); break; } case
		 * "FO": { //finall.setFO(val); break; } case "FP": { //finall.setFP(val);
		 * break; } case "FQ": { //finall.setFQ(val); break; } case "FR": {
		 * //finall.setFR(val); break; } case "FS": { //finall.setFS(val); break; } case
		 * "FT": { //finall.setFT(val); break; } case "FU": { //finall.setFU(val);
		 * break; } case "FV": { //finall.setFV(val); break; } case "FW": {
		 * //finall.setFW(val); break; } case "FX": { //finall.setFX(val); break; } case
		 * "FY": { //finall.setFY(val); break; } case "FZ": { //finall.setFZ(val);
		 * break; } case "GA": { //finall.setGA(val); break; } case "GB": {
		 * //finall.setGB(val); break; } case "GC": { //finall.setGC(val); break; } case
		 * "GD": { //finall.setGD(val); break; } case "GE": { //finall.setGE(val);
		 * break; } case "GF": { //finall.setGF(val); break; } case "GG": {
		 * //finall.setGG(val); break; } case "GH": { //finall.setGH(val); break; } case
		 * "GI": { //finall.setGI(val); break; } case "GJ": { //finall.setGJ(val);
		 * break; } case "GK": { //finall.setGK(val); break; } case "GL": {
		 * //finall.setGL(val); break; } case "GM": { //finall.setGM(val); break; } case
		 * "GN": { //finall.setGN(val); break; } case "GO": { //finall.setGO(val);
		 * break; } case "GP": { //finall.setGP(val); break; } case "GQ": {
		 * //finall.setGQ(val); break; } case "GR": { //finall.setGR(val); break; } case
		 * "GS": { //finall.setGS(val); break; } case "GT": { //finall.setGT(val);
		 * break; } case "GU": { //finall.setGU(val); break; } case "GV": {
		 * //finall.setGV(val); break; } case "GW": { //finall.setGW(val); break; } case
		 * "GX": { //finall.setGX(val); break; } case "GY": { //finall.setGY(val);
		 * break; } case "GZ": { //finall.setGZ(val); break; }
		 * 
		 * case "HA": { //finall.setHA(val); break; } case "HB": { //finall.setHB(val);
		 * break; } case "HC": { //finall.setHC(val); break; } case "HD": {
		 * //finall.setHD(val); break; } case "HE": { //finall.setHE(val); break; } case
		 * "HF": { //finall.setHF(val); break; } case "HG": { //finall.setHG(val);
		 * break; } case "HH": { //finall.setHH(val); break; } case "HI": {
		 * //finall.setHI(val); break; } case "HJ": { //finall.setHJ(val); break; } case
		 * "HK": { //finall.setHK(val); break; } case "HL": { //finall.setHL(val);
		 * break; } case "HM": { //finall.setHM(val); break; } case "HN": {
		 * //finall.setHN(val); break; } case "HO": { //finall.setHO(val); break; } case
		 * "HP": { //finall.setHP(val); break; } case "HQ": { //finall.setHQ(val);
		 * break; } case "HR": { //finall.setHR(val); break; } case "HS": {
		 * //finall.setHS(val); break; } case "HT": { //finall.setHT(val); break; } case
		 * "HU": { //finall.setHU(val); break; } case "HV": { //finall.setHV(val);
		 * break; } case "HW": { //finall.setHW(val); break; } case "HX": {
		 * //finall.setHX(val); break; } case "HY": { //finall.setHY(val); break; } case
		 * "HZ": { //finall.setHZ(val); break; }
		 * 
		 * case "IA": { //finall.setIA(val); break; } case "IB": { //finall.setIB(val);
		 * break; } case "IC": { //finall.setIC(val); break; } case "ID": {
		 * //finall.setID(val); break; } case "IE": { //finall.setIE(val); break; } case
		 * "IF": { //finall.setIF(val); break; } case "IG": { //finall.setIG(val);
		 * break; } case "IH": { //finall.setIH(val); break; } case "II": {
		 * //finall.setII(val); break; } case "IJ": { //finall.setIJ(val); break; } case
		 * "IK": { //finall.setIK(val); break; } case "IL": { //finall.setIL(val);
		 * break; } case "IM": { //finall.setIM(val); break; } case "IN": {
		 * //finall.setIN(val); break; } case "IO": { //finall.setIO(val); break; } case
		 * "IP": { //finall.setIP(val); break; } case "IQ": { //finall.setIQ(val);
		 * break; } case "IR": { //finall.setIR(val); break; } case "IS": {
		 * //finall.setIS(val); break; } case "IT": { //finall.setIT(val); break; } case
		 * "IU": { //finall.setIU(val); break; } case "IV": { //finall.setIV(val);
		 * break; } case "IW": { //finall.setIW(val); break; } case "IX": {
		 * //finall.setIX(val); break; } case "IY": { //finall.setIY(val); break; } case
		 * "IZ": { //finall.setIZ(val); break; } case "JA": { //finall.setJA(val);
		 * break; } case "JB": { //finall.setJB(val); break; } case "JC": {
		 * //finall.setJC(val); break; } case "JD": { //finall.setJD(val); break; } case
		 * "JE": { //finall.setJE(val); break; } case "JF": { //finall.setJF(val);
		 * break; } case "JG": { //finall.setJG(val); break; } case "JH": {
		 * //finall.setJH(val); break; } case "JI": { //finall.setJI(val); break; } case
		 * "JJ": { //finall.setJJ(val); break; } case "JK": { //finall.setJK(val);
		 * break; } case "JL": { //finall.setJL(val); break; } case "JM": {
		 * //finall.setJM(val); break; } case "JN": { //finall.setJN(val); break; } case
		 * "JO": { //finall.setJO(val); break; } case "JP": { //finall.setJP(val);
		 * break; } case "JQ": { //finall.setJQ(val); break; } case "JR": {
		 * //finall.setJR(val); break; } case "JS": { //finall.setJS(val); break; } case
		 * "JT": { //finall.setJT(val); break; } case "JU": { //finall.setJU(val);
		 * break; } case "JV": { //finall.setJV(val); break; } case "JW": {
		 * //finall.setJW(val); break; } case "JX": { //finall.setJX(val); break; } case
		 * "JY": { //finall.setJY(val); break; } case "JZ": { //finall.setJZ(val);
		 * break; } case "KA": { //finall.setKA(val); break; } case "KB": {
		 * //finall.setKB(val); break; } case "KC": { //finall.setKC(val); break; } case
		 * "KD": { //finall.setKD(val); break; } case "KE": { //finall.setKE(val);
		 * break; } case "KF": { //finall.setKF(val); break; } case "KG": {
		 * //finall.setKG(val); break; } case "KH": { //finall.setKH(val); break; } case
		 * "KI": { //finall.setKI(val); break; } case "KJ": { //finall.setKJ(val);
		 * break; } case "KK": { //finall.setKK(val); break; } case "KL": {
		 * //finall.setKL(val); break; } case "KM": { //finall.setKM(val); break; } case
		 * "KN": { //finall.setKN(val); break; } case "KO": { //finall.setKO(val);
		 * break; } case "KP": { //finall.setKP(val); break; } case "KQ": {
		 * //finall.setKQ(val); break; } case "KR": { //finall.setKR(val); break; } case
		 * "KS": { //finall.setKS(val); break; } case "KT": { //finall.setKT(val);
		 * break; } case "KU": { //finall.setKU(val); break; } case "KV": {
		 * //finall.setKV(val); break; } case "KW": { //finall.setKW(val); break; } case
		 * "KX": { //finall.setKX(val); break; } case "KY": { //finall.setKY(val);
		 * break; } case "KZ": { //finall.setKZ(val); break; } case "LA": {
		 * //finall.setLA(val); break; } case "LB": { //finall.setLB(val); break; } case
		 * "LC": { //finall.setLC(val); break; } case "LD": { //finall.setLD(val);
		 * break; } case "LE": { //finall.setLE(val); break; } case "LF": {
		 * //finall.setLF(val); break; } case "LG": { //finall.setLG(val); break; } case
		 * "LH": { //finall.setLH(val); break; } case "LI": { //finall.setLI(val);
		 * break; } case "LJ": { //finall.setLJ(val); break; } case "LK": {
		 * //finall.setLK(val); break; } case "LL": { //finall.setLL(val); break; } case
		 * "LM": { //finall.setLM(val); break; } case "LN": { //finall.setLN(val);
		 * break; } case "LO": { //finall.setLO(val); break; } case "LP": {
		 * //finall.setLP(val); break; } case "LQ": { //finall.setLQ(val); break; } case
		 * "LR": { //finall.setLR(val); break; } case "LS": { //finall.setLS(val);
		 * break; } case "LT": { //finall.setLT(val); break; } case "LU": {
		 * //finall.setLU(val); break; } case "LV": { //finall.setLV(val); break; } case
		 * "LW": { //finall.setLW(val); break; } case "LX": { //finall.setLX(val);
		 * break; } case "LY": { //finall.setLY(val); break; } case "LZ": {
		 * //finall.setLZ(val); break; } case "MA": { //finall.setMA(val); break; } case
		 * "MB": { //finall.setMB(val); break; } case "MC": { //finall.setMC(val);
		 * break; } case "MD": { //finall.setMD(val); break; } case "ME": {
		 * //finall.setME(val); break; } case "MF": { //finall.setMF(val); break; } case
		 * "MG": { //finall.setMG(val); break; } case "MH": { //finall.setMH(val);
		 * break; } case "MI": { //finall.setMI(val); break; } case "MJ": {
		 * //finall.setMJ(val); break; } case "MK": { //finall.setMK(val); break; } case
		 * "ML": { //finall.setML(val); break; } case "MM": { //finall.setMM(val);
		 * break; } case "MN": { //finall.setMN(val); break; } case "MO": {
		 * //finall.setMO(val); break; } case "MP": { //finall.setMP(val); break; } case
		 * "MQ": { //finall.setMQ(val); break; } case "MR": { //finall.setMR(val);
		 * break; } case "MS": { //finall.setMS(val); break; } case "MT": {
		 * //finall.setMT(val); break; } case "MU": { //finall.setMU(val); break; }
		 */ default:
			return finall;
		}

		return finall;

	}

	public static String getValue(String column, FinalCAZvType finall) {

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
		case "GT20": {
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
		case "GT24": {
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
		case "CelluloseDegrading": {
			return "" + finall.getCelluloseDegrading();
		}
		case "hemiCelluloseDegrading": {
			return "" + finall.getHemiCelluloseDegrading();
		}
		case "ligninDegrading": {
			return "" + finall.getLigninDegrading();
		}

		case "pectinDegrading": {
			return "" + finall.getPectinDegrading();
		}

		case "starchDegrading": {
			return "" + finall.getStarchDegrading();
		}

		case "inulin": {
			return "" + finall.getInulin();
		}

		
		default:
			return null;
		}
	}
}
