package com.rankingEnZymes.model.FinalCAZymes;

import java.io.Serializable;

public class Response implements Serializable {
	protected String genomeCode;
	private String name;
	Long cellulosedegrading = new Long("0");
	Long hemicellulosedegrading = new Long("0");
	Long lignindegrading = new Long("0");
	Long pectindegrading = new Long("0");
	Long starchdegrading = new Long("0");
	Long inulingrading = new Long("0");
	protected Long classifier;
	private String assemblyLength;
	private String genes;
	protected Long totalEnzymes;
	private String published;


	public Long getCellulosedegrading() {
		return cellulosedegrading;
	}

	public void setCellulosedegrading(Long cellulosedegrading) {
		this.cellulosedegrading = cellulosedegrading;
	}

	public Long getHemicellulosedegrading() {
		return hemicellulosedegrading;
	}

	public void setHemicellulosedegrading(Long hemicellulosedegrading) {
		this.hemicellulosedegrading = hemicellulosedegrading;
	}

	public Long getLignindegrading() {
		return lignindegrading;
	}

	public void setLignindegrading(Long lignindegrading) {
		this.lignindegrading = lignindegrading;
	}

	public Long getPectindegrading() {
		return pectindegrading;
	}

	public void setPectindegrading(Long pectindegrading) {
		this.pectindegrading = pectindegrading;
	}

	public Long getStarchdegrading() {
		return starchdegrading;
	}

	public void setStarchdegrading(Long starchdegrading) {
		this.starchdegrading = starchdegrading;
	}

	public Long getInulingrading() {
		return inulingrading;
	}

	public void setInulingrading(Long inulingrading) {
		this.inulingrading = inulingrading;
	}

	protected Long AA2_cyt;
	protected Long AA;
	protected Long AA10;
	protected Long AA11;
	protected Long AA11_dist;
	protected Long AA12;
	protected Long AA12_dist;
	protected Long AA13;
	protected Long AA14;
	protected Long AA1;
	protected Long AA1_1;
	protected Long AA1_2;
	protected Long AA1_3;
	protected Long AA1_dist;
	protected Long AA2;
	protected Long AA2_dist;
	protected Long AA3;
	protected Long AA3_1;
	protected Long AA3_2;
	protected Long AA3_3;
	protected Long AA3_4;
	protected Long AA3_dist;
	protected Long AA4;
	protected Long AA5;
	protected Long AA5_1;
	protected Long AA5_2;
	protected Long AA5_dist;
	protected Long AA6;
	protected Long AA7;
	protected Long AA7_dist;
	protected Long AA8;
	protected Long AA8_dist;
	protected Long AA9;
	protected Long AA9_dist;
	protected Long CBM;
	protected Long CBM10;
	protected Long CBM12;
	protected Long CBM13;
	protected Long CBM14;
	protected Long CBM16;
	protected Long CBM18;
	protected Long CBM19;
	protected Long CBM1;
	protected Long CBM20;
	protected Long CBM21;
	protected Long CBM22;
	protected Long CBM24;
	protected Long CBM25;
	protected Long CBM26;
	protected Long CBM29;
	protected Long CBM2;
	protected Long CBM32;
	protected Long CBM35;
	protected Long CBM38;
	protected Long CBM3;
	protected Long CBM42;
	protected Long CBM43;
	protected Long CBM48;
	protected Long CBM4;
	protected Long CBM50;
	protected Long CBM51;
	protected Long CBM52;
	protected Long CBM5;
	protected Long CBM61;
	protected Long CBM63;
	protected Long CBM66;
	protected Long CBM67;
	protected Long CBM6;
	protected Long CBM71;
	protected Long CBM8;
	protected Long CBM9;
	protected Long CE;
	protected Long CE11;
	protected Long CE12;
	protected Long CE13;
	protected Long CE14;
	protected Long CE15;
	protected Long CE16;
	protected Long CE1;
	protected Long CE2;
	protected Long CE3;
	protected Long CE4;
	protected Long CE5;
	protected Long CE6;
	protected Long CE7;
	protected Long CE8;
	protected Long CE9;
	protected Long DOC;
	protected Long DOC2;
	protected Long EXPN;
	protected Long GH;
	protected Long GH103;
	protected Long GH105;
	protected Long GH106;
	protected Long GH108;
	protected Long GH10;
	protected Long GH110;
	protected Long GH114;
	protected Long GH115;
	protected Long GH116;
	protected Long GH11;
	protected Long GH120;
	protected Long GH121;
	protected Long GH124;
	protected Long GH125;
	protected Long GH127;
	protected Long GH128;
	protected Long GH12;
	protected Long GH130;
	protected Long GH131;
	protected Long GH132;
	protected Long GH133;
	protected Long GH134;
	protected Long GH135;
	protected Long GH136;
	protected Long GH139;
	protected Long GH13;
	protected Long GH13_10;
	protected Long GH13_11;
	protected Long GH13_14;
	protected Long GH13_15;
	protected Long GH13_1;
	protected Long GH13_20;
	protected Long GH13_22;
	protected Long GH13_23;
	protected Long GH13_25;
	protected Long GH13_26;
	protected Long GH13_28;
	protected Long GH13_30;
	protected Long GH13_31;
	protected Long GH13_32;
	protected Long GH13_37;
	protected Long GH13_3;
	protected Long GH13_40;
	protected Long GH13_4;
	protected Long GH13_5;
	protected Long GH13_6;
	protected Long GH13_8;
	protected Long GH13_dist;
	protected Long GH13_m42;
	protected Long GH13_m46;
	protected Long GH140;
	protected Long GH141;
	protected Long GH142;
	protected Long GH143;
	protected Long GH145;
	protected Long GH146;
	protected Long GH14;
	protected Long GH151;
	protected Long GH152;
	protected Long GH15;
	protected Long GH16;
	protected Long GH17;
	protected Long GH18;
	protected Long GH19;
	protected Long GH1;
	protected Long GH20;
	protected Long GH23;
	protected Long GH24;
	protected Long GH25;
	protected Long GH26;
	protected Long GH27;
	protected Long GH28;
	protected Long GH29;
	protected Long GH2;
	protected Long GH30;
	protected Long GH30_1;
	protected Long GH30_3;
	protected Long GH30_5;
	protected Long GH30_7;
	protected Long GH30_dist;
	protected Long GH31;
	protected Long GH32;
	protected Long GH33;
	protected Long GH35;
	protected Long GH36;
	protected Long GH37;
	protected Long GH38;
	protected Long GH39;
	protected Long GH3;
	protected Long GH42;
	protected Long GH43;
	protected Long GH44;
	protected Long GH45;
	protected Long GH46;
	protected Long GH47;
	protected Long GH48;
	protected Long GH49;
	protected Long GH4;
	protected Long GH51;
	protected Long GH52;
	protected Long GH53;
	protected Long GH54;
	protected Long GH55;
	protected Long GH57;
	protected Long GH5;
	protected Long GH5_11;
	protected Long GH5_12;
	protected Long GH5_13;
	protected Long GH5_15;
	protected Long GH5_16;
	protected Long GH5_1;
	protected Long GH5_22;
	protected Long GH5_23;
	protected Long GH5_24;
	protected Long GH5_27;
	protected Long GH5_28;
	protected Long GH5_2;
	protected Long GH5_30;
	protected Long GH5_31;
	protected Long GH5_34;
	protected Long GH5_36;
	protected Long GH5_40;
	protected Long GH5_41;
	protected Long GH5_49;
	protected Long GH5_4;
	protected Long GH5_50;
	protected Long GH5_51;
	protected Long GH5_5;
	protected Long GH5_7;
	protected Long GH5_8;
	protected Long GH5_9;
	protected Long GH5_dist;
	protected Long GH62;
	protected Long GH63;
	protected Long GH64;
	protected Long GH65;
	protected Long GH67;
	protected Long GH6;
	protected Long GH71;
	protected Long GH72;
	protected Long GH73;
	protected Long GH74;
	protected Long GH75;
	protected Long GH76;
	protected Long GH77;
	protected Long GH78;
	protected Long GH79;
	protected Long GH7;
	protected Long GH81;
	protected Long GH84;
	protected Long GH85;
	protected Long GH88;
	protected Long GH89;
	protected Long GH8;
	protected Long GH91;
	protected Long GH92;
	protected Long GH93;
	protected Long GH94;
	protected Long GH95;
	protected Long GH97;
	protected Long GH99;
	protected Long GH9;
	protected Long GT;
	protected Long GT101;
	protected Long GT10;
	protected Long GT11;
	protected Long GT12;
	protected Long GT13;
	protected Long GT14;
	protected Long GT15;
	protected Long GT17;
	protected Long GT18;
	protected Long GT1;
	protected Long GT20;
	protected Long GT21;
	protected Long GT22;
	protected Long GT23;
	protected Long GT24;
	protected Long GT25;
	protected Long GT28;
	protected Long GT2;
	protected Long GT31;
	protected Long GT32;
	protected Long GT33;
	protected Long GT34;
	protected Long GT35;
	protected Long GT37;
	protected Long GT39;
	protected Long GT3;
	protected Long GT41;
	protected Long GT43;
	protected Long GT45;
	protected Long GT47;
	protected Long GT48;
	protected Long GT49;
	protected Long GT4;
	protected Long GT50;
	protected Long GT51;
	protected Long GT54;
	protected Long GT55;
	protected Long GT57;
	protected Long GT58;
	protected Long GT59;
	protected Long GT5;
	protected Long GT60;
	protected Long GT61;
	protected Long GT62;
	protected Long GT64;
	protected Long GT65;
	protected Long GT66;
	protected Long GT68;
	protected Long GT69;
	protected Long GT6;
	protected Long GT71;
	protected Long GT76;
	protected Long GT77;
	protected Long GT7;
	protected Long GT81;
	protected Long GT8;
	protected Long GT90;
	protected Long GT91;
	protected Long GT9;
	protected Long Myosin_motor;
	protected Long PL;
	protected Long PL10;
	protected Long PL10_dist;
	protected Long PL11;
	protected Long PL11_2;
	protected Long PL14;
	protected Long PL14_1;
	protected Long PL14_3;
	protected Long PL14_4;
	protected Long PL14_5;
	protected Long PL14_dist;
	protected Long PL15;
	protected Long PL15_dist;
	protected Long PL1;
	protected Long PL1_10;
	protected Long PL1_2;
	protected Long PL1_4;
	protected Long PL1_6;
	protected Long PL1_7;
	protected Long PL1_9;
	protected Long PL1_dist;
	protected Long PL20;
	protected Long PL20_dist;
	protected Long PL22;
	protected Long PL22_2;
	protected Long PL26;
	protected Long PL27;
	protected Long PL3;
	protected Long PL3_2;
	protected Long PL3_dist;
	protected Long PL4;
	protected Long PL4_1;
	protected Long PL4_3;
	protected Long PL4_5;
	protected Long PL4_dist;
	protected Long PL7;
	protected Long PL7_4;
	protected Long PL7_dist;
	protected Long PL8;
	protected Long PL8_4;
	protected Long PL9;
	protected Long PL9_1;
	protected Long PL9_3;

	public String getGenomeCode() {
		return genomeCode;
	}

	public void setGenomeCode(String genomeCode) {
		this.genomeCode = genomeCode;
	}

	public Long getTotalEnzymes() {
		return totalEnzymes;
	}

	public void setTotalEnzymes(Long totalEnzymes) {
		this.totalEnzymes = totalEnzymes;
	}

	
	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssemblyLength() {
		return assemblyLength;
	}

	public void setAssemblyLength(String assemblyLength) {
		this.assemblyLength = assemblyLength;
	}

	public String getGenes() {
		return genes;
	}

	public void setGenes(String genes) {
		this.genes = genes;
	}

	public Long getAA2_cyt() {
		return AA2_cyt;
	}

	public void setAA2_cyt(Long aA2_cyt) {
		AA2_cyt = aA2_cyt;
	}

	public Long getAA() {
		return AA;
	}

	public void setAA(Long aA) {
		AA = aA;
	}

	public Long getAA10() {
		return AA10;
	}

	public void setAA10(Long aA10) {
		AA10 = aA10;
	}

	public Long getAA11() {
		return AA11;
	}

	public void setAA11(Long aA11) {
		AA11 = aA11;
	}

	public Long getAA11_dist() {
		return AA11_dist;
	}

	public void setAA11_dist(Long aA11_dist) {
		AA11_dist = aA11_dist;
	}

	public Long getAA12() {
		return AA12;
	}

	public void setAA12(Long aA12) {
		AA12 = aA12;
	}

	public Long getAA12_dist() {
		return AA12_dist;
	}

	public void setAA12_dist(Long aA12_dist) {
		AA12_dist = aA12_dist;
	}

	public Long getAA13() {
		return AA13;
	}

	public void setAA13(Long aA13) {
		AA13 = aA13;
	}

	public Long getAA14() {
		return AA14;
	}

	public void setAA14(Long aA14) {
		AA14 = aA14;
	}

	public Long getAA1() {
		return AA1;
	}

	public void setAA1(Long aA1) {
		AA1 = aA1;
	}

	public Long getAA1_1() {
		return AA1_1;
	}

	public void setAA1_1(Long aA1_1) {
		AA1_1 = aA1_1;
	}

	public Long getAA1_2() {
		return AA1_2;
	}

	public void setAA1_2(Long aA1_2) {
		AA1_2 = aA1_2;
	}

	public Long getAA1_3() {
		return AA1_3;
	}

	public void setAA1_3(Long aA1_3) {
		AA1_3 = aA1_3;
	}

	public Long getAA1_dist() {
		return AA1_dist;
	}

	public void setAA1_dist(Long aA1_dist) {
		AA1_dist = aA1_dist;
	}

	public Long getAA2() {
		return AA2;
	}

	public void setAA2(Long aA2) {
		AA2 = aA2;
	}

	public Long getAA2_dist() {
		return AA2_dist;
	}

	public void setAA2_dist(Long aA2_dist) {
		AA2_dist = aA2_dist;
	}

	public Long getAA3() {
		return AA3;
	}

	public void setAA3(Long aA3) {
		AA3 = aA3;
	}

	public Long getAA3_1() {
		return AA3_1;
	}

	public void setAA3_1(Long aA3_1) {
		AA3_1 = aA3_1;
	}

	public Long getAA3_2() {
		return AA3_2;
	}

	public void setAA3_2(Long aA3_2) {
		AA3_2 = aA3_2;
	}

	public Long getAA3_3() {
		return AA3_3;
	}

	public void setAA3_3(Long aA3_3) {
		AA3_3 = aA3_3;
	}

	public Long getAA3_4() {
		return AA3_4;
	}

	public void setAA3_4(Long aA3_4) {
		AA3_4 = aA3_4;
	}

	public Long getAA3_dist() {
		return AA3_dist;
	}

	public void setAA3_dist(Long aA3_dist) {
		AA3_dist = aA3_dist;
	}

	public Long getAA4() {
		return AA4;
	}

	public void setAA4(Long aA4) {
		AA4 = aA4;
	}

	public Long getAA5() {
		return AA5;
	}

	public void setAA5(Long aA5) {
		AA5 = aA5;
	}

	public Long getAA5_1() {
		return AA5_1;
	}

	public void setAA5_1(Long aA5_1) {
		AA5_1 = aA5_1;
	}

	public Long getAA5_2() {
		return AA5_2;
	}

	public void setAA5_2(Long aA5_2) {
		AA5_2 = aA5_2;
	}

	public Long getAA5_dist() {
		return AA5_dist;
	}

	public void setAA5_dist(Long aA5_dist) {
		AA5_dist = aA5_dist;
	}

	public Long getAA6() {
		return AA6;
	}

	public void setAA6(Long aA6) {
		AA6 = aA6;
	}

	public Long getAA7() {
		return AA7;
	}

	public void setAA7(Long aA7) {
		AA7 = aA7;
	}

	public Long getAA7_dist() {
		return AA7_dist;
	}

	public void setAA7_dist(Long aA7_dist) {
		AA7_dist = aA7_dist;
	}

	public Long getAA8() {
		return AA8;
	}

	public void setAA8(Long aA8) {
		AA8 = aA8;
	}

	public Long getAA8_dist() {
		return AA8_dist;
	}

	public void setAA8_dist(Long aA8_dist) {
		AA8_dist = aA8_dist;
	}

	public Long getAA9() {
		return AA9;
	}

	public void setAA9(Long aA9) {
		AA9 = aA9;
	}

	public Long getAA9_dist() {
		return AA9_dist;
	}

	public void setAA9_dist(Long aA9_dist) {
		AA9_dist = aA9_dist;
	}

	public Long getCBM() {
		return CBM;
	}

	public void setCBM(Long cBM) {
		CBM = cBM;
	}

	public Long getCBM10() {
		return CBM10;
	}

	public void setCBM10(Long cBM10) {
		CBM10 = cBM10;
	}

	public Long getCBM12() {
		return CBM12;
	}

	public void setCBM12(Long cBM12) {
		CBM12 = cBM12;
	}

	public Long getCBM13() {
		return CBM13;
	}

	public void setCBM13(Long cBM13) {
		CBM13 = cBM13;
	}

	public Long getCBM14() {
		return CBM14;
	}

	public void setCBM14(Long cBM14) {
		CBM14 = cBM14;
	}

	public Long getCBM16() {
		return CBM16;
	}

	public void setCBM16(Long cBM16) {
		CBM16 = cBM16;
	}

	public Long getCBM18() {
		return CBM18;
	}

	public void setCBM18(Long cBM18) {
		CBM18 = cBM18;
	}

	public Long getCBM19() {
		return CBM19;
	}

	public void setCBM19(Long cBM19) {
		CBM19 = cBM19;
	}

	public Long getCBM1() {
		return CBM1;
	}

	public void setCBM1(Long cBM1) {
		CBM1 = cBM1;
	}

	public Long getCBM20() {
		return CBM20;
	}

	public void setCBM20(Long cBM20) {
		CBM20 = cBM20;
	}

	public Long getCBM21() {
		return CBM21;
	}

	public void setCBM21(Long cBM21) {
		CBM21 = cBM21;
	}

	public Long getCBM22() {
		return CBM22;
	}

	public void setCBM22(Long cBM22) {
		CBM22 = cBM22;
	}

	public Long getCBM24() {
		return CBM24;
	}

	public void setCBM24(Long cBM24) {
		CBM24 = cBM24;
	}

	public Long getCBM25() {
		return CBM25;
	}

	public void setCBM25(Long cBM25) {
		CBM25 = cBM25;
	}

	public Long getCBM26() {
		return CBM26;
	}

	public void setCBM26(Long cBM26) {
		CBM26 = cBM26;
	}

	public Long getCBM29() {
		return CBM29;
	}

	public void setCBM29(Long cBM29) {
		CBM29 = cBM29;
	}

	public Long getCBM2() {
		return CBM2;
	}

	public void setCBM2(Long cBM2) {
		CBM2 = cBM2;
	}

	public Long getCBM32() {
		return CBM32;
	}

	public void setCBM32(Long cBM32) {
		CBM32 = cBM32;
	}

	public Long getCBM35() {
		return CBM35;
	}

	public void setCBM35(Long cBM35) {
		CBM35 = cBM35;
	}

	public Long getCBM38() {
		return CBM38;
	}

	public void setCBM38(Long cBM38) {
		CBM38 = cBM38;
	}

	public Long getCBM3() {
		return CBM3;
	}

	public void setCBM3(Long cBM3) {
		CBM3 = cBM3;
	}

	public Long getCBM42() {
		return CBM42;
	}

	public void setCBM42(Long cBM42) {
		CBM42 = cBM42;
	}

	public Long getCBM43() {
		return CBM43;
	}

	public void setCBM43(Long cBM43) {
		CBM43 = cBM43;
	}

	public Long getCBM48() {
		return CBM48;
	}

	public void setCBM48(Long cBM48) {
		CBM48 = cBM48;
	}

	public Long getCBM4() {
		return CBM4;
	}

	public void setCBM4(Long cBM4) {
		CBM4 = cBM4;
	}

	public Long getCBM50() {
		return CBM50;
	}

	public void setCBM50(Long cBM50) {
		CBM50 = cBM50;
	}

	public Long getCBM51() {
		return CBM51;
	}

	public void setCBM51(Long cBM51) {
		CBM51 = cBM51;
	}

	public Long getCBM52() {
		return CBM52;
	}

	public void setCBM52(Long cBM52) {
		CBM52 = cBM52;
	}

	public Long getCBM5() {
		return CBM5;
	}

	public void setCBM5(Long cBM5) {
		CBM5 = cBM5;
	}

	public Long getCBM61() {
		return CBM61;
	}

	public void setCBM61(Long cBM61) {
		CBM61 = cBM61;
	}

	public Long getCBM63() {
		return CBM63;
	}

	public void setCBM63(Long cBM63) {
		CBM63 = cBM63;
	}

	public Long getCBM66() {
		return CBM66;
	}

	public void setCBM66(Long cBM66) {
		CBM66 = cBM66;
	}

	public Long getCBM67() {
		return CBM67;
	}

	public void setCBM67(Long cBM67) {
		CBM67 = cBM67;
	}

	public Long getCBM6() {
		return CBM6;
	}

	public void setCBM6(Long cBM6) {
		CBM6 = cBM6;
	}

	public Long getCBM71() {
		return CBM71;
	}

	public void setCBM71(Long cBM71) {
		CBM71 = cBM71;
	}

	public Long getCBM8() {
		return CBM8;
	}

	public void setCBM8(Long cBM8) {
		CBM8 = cBM8;
	}

	public Long getCBM9() {
		return CBM9;
	}

	public void setCBM9(Long cBM9) {
		CBM9 = cBM9;
	}

	public Long getCE() {
		return CE;
	}

	public void setCE(Long cE) {
		CE = cE;
	}

	public Long getCE11() {
		return CE11;
	}

	public void setCE11(Long cE11) {
		CE11 = cE11;
	}

	public Long getCE12() {
		return CE12;
	}

	public void setCE12(Long cE12) {
		CE12 = cE12;
	}

	public Long getCE13() {
		return CE13;
	}

	public void setCE13(Long cE13) {
		CE13 = cE13;
	}

	public Long getCE14() {
		return CE14;
	}

	public void setCE14(Long cE14) {
		CE14 = cE14;
	}

	public Long getCE15() {
		return CE15;
	}

	public void setCE15(Long cE15) {
		CE15 = cE15;
	}

	public Long getCE16() {
		return CE16;
	}

	public void setCE16(Long cE16) {
		CE16 = cE16;
	}

	public Long getCE1() {
		return CE1;
	}

	public void setCE1(Long cE1) {
		CE1 = cE1;
	}

	public Long getCE2() {
		return CE2;
	}

	public void setCE2(Long cE2) {
		CE2 = cE2;
	}

	public Long getCE3() {
		return CE3;
	}

	public void setCE3(Long cE3) {
		CE3 = cE3;
	}

	public Long getCE4() {
		return CE4;
	}

	public void setCE4(Long cE4) {
		CE4 = cE4;
	}

	public Long getCE5() {
		return CE5;
	}

	public void setCE5(Long cE5) {
		CE5 = cE5;
	}

	public Long getCE6() {
		return CE6;
	}

	public void setCE6(Long cE6) {
		CE6 = cE6;
	}

	public Long getCE7() {
		return CE7;
	}

	public void setCE7(Long cE7) {
		CE7 = cE7;
	}

	public Long getCE8() {
		return CE8;
	}

	public void setCE8(Long cE8) {
		CE8 = cE8;
	}

	public Long getCE9() {
		return CE9;
	}

	public void setCE9(Long cE9) {
		CE9 = cE9;
	}

	public Long getDOC() {
		return DOC;
	}

	public void setDOC(Long dOC) {
		DOC = dOC;
	}

	public Long getDOC2() {
		return DOC2;
	}

	public void setDOC2(Long dOC2) {
		DOC2 = dOC2;
	}

	public Long getEXPN() {
		return EXPN;
	}

	public void setEXPN(Long eXPN) {
		EXPN = eXPN;
	}

	public Long getGH() {
		return GH;
	}

	public void setGH(Long gH) {
		GH = gH;
	}

	public Long getGH103() {
		return GH103;
	}

	public void setGH103(Long gH103) {
		GH103 = gH103;
	}

	public Long getGH105() {
		return GH105;
	}

	public void setGH105(Long gH105) {
		GH105 = gH105;
	}

	public Long getGH106() {
		return GH106;
	}

	public void setGH106(Long gH106) {
		GH106 = gH106;
	}

	public Long getGH108() {
		return GH108;
	}

	public void setGH108(Long gH108) {
		GH108 = gH108;
	}

	public Long getGH10() {
		return GH10;
	}

	public void setGH10(Long gH10) {
		GH10 = gH10;
	}

	public Long getGH110() {
		return GH110;
	}

	public void setGH110(Long gH110) {
		GH110 = gH110;
	}

	public Long getGH114() {
		return GH114;
	}

	public void setGH114(Long gH114) {
		GH114 = gH114;
	}

	public Long getGH115() {
		return GH115;
	}

	public void setGH115(Long gH115) {
		GH115 = gH115;
	}

	public Long getGH116() {
		return GH116;
	}

	public void setGH116(Long gH116) {
		GH116 = gH116;
	}

	public Long getGH11() {
		return GH11;
	}

	public void setGH11(Long gH11) {
		GH11 = gH11;
	}

	public Long getGH120() {
		return GH120;
	}

	public void setGH120(Long gH120) {
		GH120 = gH120;
	}

	public Long getGH121() {
		return GH121;
	}

	public void setGH121(Long gH121) {
		GH121 = gH121;
	}

	public Long getGH124() {
		return GH124;
	}

	public void setGH124(Long gH124) {
		GH124 = gH124;
	}

	public Long getGH125() {
		return GH125;
	}

	public void setGH125(Long gH125) {
		GH125 = gH125;
	}

	public Long getGH127() {
		return GH127;
	}

	public void setGH127(Long gH127) {
		GH127 = gH127;
	}

	public Long getGH128() {
		return GH128;
	}

	public void setGH128(Long gH128) {
		GH128 = gH128;
	}

	public Long getGH12() {
		return GH12;
	}

	public void setGH12(Long gH12) {
		GH12 = gH12;
	}

	public Long getGH130() {
		return GH130;
	}

	public void setGH130(Long gH130) {
		GH130 = gH130;
	}

	public Long getGH131() {
		return GH131;
	}

	public void setGH131(Long gH131) {
		GH131 = gH131;
	}

	public Long getGH132() {
		return GH132;
	}

	public void setGH132(Long gH132) {
		GH132 = gH132;
	}

	public Long getGH133() {
		return GH133;
	}

	public void setGH133(Long gH133) {
		GH133 = gH133;
	}

	public Long getGH134() {
		return GH134;
	}

	public void setGH134(Long gH134) {
		GH134 = gH134;
	}

	public Long getGH135() {
		return GH135;
	}

	public void setGH135(Long gH135) {
		GH135 = gH135;
	}

	public Long getGH136() {
		return GH136;
	}

	public void setGH136(Long gH136) {
		GH136 = gH136;
	}

	public Long getGH139() {
		return GH139;
	}

	public void setGH139(Long gH139) {
		GH139 = gH139;
	}

	public Long getGH13() {
		return GH13;
	}

	public void setGH13(Long gH13) {
		GH13 = gH13;
	}

	public Long getGH13_10() {
		return GH13_10;
	}

	public void setGH13_10(Long gH13_10) {
		GH13_10 = gH13_10;
	}

	public Long getGH13_11() {
		return GH13_11;
	}

	public void setGH13_11(Long gH13_11) {
		GH13_11 = gH13_11;
	}

	public Long getGH13_14() {
		return GH13_14;
	}

	public void setGH13_14(Long gH13_14) {
		GH13_14 = gH13_14;
	}

	public Long getGH13_15() {
		return GH13_15;
	}

	public void setGH13_15(Long gH13_15) {
		GH13_15 = gH13_15;
	}

	public Long getGH13_1() {
		return GH13_1;
	}

	public void setGH13_1(Long gH13_1) {
		GH13_1 = gH13_1;
	}

	public Long getGH13_20() {
		return GH13_20;
	}

	public void setGH13_20(Long gH13_20) {
		GH13_20 = gH13_20;
	}

	public Long getGH13_22() {
		return GH13_22;
	}

	public void setGH13_22(Long gH13_22) {
		GH13_22 = gH13_22;
	}

	public Long getGH13_23() {
		return GH13_23;
	}

	public void setGH13_23(Long gH13_23) {
		GH13_23 = gH13_23;
	}

	public Long getGH13_25() {
		return GH13_25;
	}

	public void setGH13_25(Long gH13_25) {
		GH13_25 = gH13_25;
	}

	public Long getGH13_26() {
		return GH13_26;
	}

	public void setGH13_26(Long gH13_26) {
		GH13_26 = gH13_26;
	}

	public Long getGH13_28() {
		return GH13_28;
	}

	public void setGH13_28(Long gH13_28) {
		GH13_28 = gH13_28;
	}

	public Long getGH13_30() {
		return GH13_30;
	}

	public void setGH13_30(Long gH13_30) {
		GH13_30 = gH13_30;
	}

	public Long getGH13_31() {
		return GH13_31;
	}

	public void setGH13_31(Long gH13_31) {
		GH13_31 = gH13_31;
	}

	public Long getGH13_32() {
		return GH13_32;
	}

	public void setGH13_32(Long gH13_32) {
		GH13_32 = gH13_32;
	}

	public Long getGH13_37() {
		return GH13_37;
	}

	public void setGH13_37(Long gH13_37) {
		GH13_37 = gH13_37;
	}

	public Long getGH13_3() {
		return GH13_3;
	}

	public void setGH13_3(Long gH13_3) {
		GH13_3 = gH13_3;
	}

	public Long getGH13_40() {
		return GH13_40;
	}

	public void setGH13_40(Long gH13_40) {
		GH13_40 = gH13_40;
	}

	public Long getGH13_4() {
		return GH13_4;
	}

	public void setGH13_4(Long gH13_4) {
		GH13_4 = gH13_4;
	}

	public Long getGH13_5() {
		return GH13_5;
	}

	public void setGH13_5(Long gH13_5) {
		GH13_5 = gH13_5;
	}

	public Long getGH13_6() {
		return GH13_6;
	}

	public void setGH13_6(Long gH13_6) {
		GH13_6 = gH13_6;
	}

	public Long getGH13_8() {
		return GH13_8;
	}

	public void setGH13_8(Long gH13_8) {
		GH13_8 = gH13_8;
	}

	public Long getGH13_dist() {
		return GH13_dist;
	}

	public void setGH13_dist(Long gH13_dist) {
		GH13_dist = gH13_dist;
	}

	public Long getGH13_m42() {
		return GH13_m42;
	}

	public void setGH13_m42(Long gH13_m42) {
		GH13_m42 = gH13_m42;
	}

	public Long getGH13_m46() {
		return GH13_m46;
	}

	public void setGH13_m46(Long gH13_m46) {
		GH13_m46 = gH13_m46;
	}

	public Long getGH140() {
		return GH140;
	}

	public void setGH140(Long gH140) {
		GH140 = gH140;
	}

	public Long getGH141() {
		return GH141;
	}

	public void setGH141(Long gH141) {
		GH141 = gH141;
	}

	public Long getGH142() {
		return GH142;
	}

	public void setGH142(Long gH142) {
		GH142 = gH142;
	}

	public Long getGH143() {
		return GH143;
	}

	public void setGH143(Long gH143) {
		GH143 = gH143;
	}

	public Long getGH145() {
		return GH145;
	}

	public void setGH145(Long gH145) {
		GH145 = gH145;
	}

	public Long getGH146() {
		return GH146;
	}

	public void setGH146(Long gH146) {
		GH146 = gH146;
	}

	public Long getGH14() {
		return GH14;
	}

	public void setGH14(Long gH14) {
		GH14 = gH14;
	}

	public Long getGH151() {
		return GH151;
	}

	public void setGH151(Long gH151) {
		GH151 = gH151;
	}

	public Long getGH152() {
		return GH152;
	}

	public void setGH152(Long gH152) {
		GH152 = gH152;
	}

	public Long getGH15() {
		return GH15;
	}

	public void setGH15(Long gH15) {
		GH15 = gH15;
	}

	public Long getGH16() {
		return GH16;
	}

	public void setGH16(Long gH16) {
		GH16 = gH16;
	}

	public Long getGH17() {
		return GH17;
	}

	public void setGH17(Long gH17) {
		GH17 = gH17;
	}

	public Long getGH18() {
		return GH18;
	}

	public void setGH18(Long gH18) {
		GH18 = gH18;
	}

	public Long getGH19() {
		return GH19;
	}

	public void setGH19(Long gH19) {
		GH19 = gH19;
	}

	public Long getGH1() {
		return GH1;
	}

	public void setGH1(Long gH1) {
		GH1 = gH1;
	}

	public Long getGH20() {
		return GH20;
	}

	public void setGH20(Long gH20) {
		GH20 = gH20;
	}

	public Long getGH23() {
		return GH23;
	}

	public void setGH23(Long gH23) {
		GH23 = gH23;
	}

	public Long getGH24() {
		return GH24;
	}

	public void setGH24(Long gH24) {
		GH24 = gH24;
	}

	public Long getGH25() {
		return GH25;
	}

	public void setGH25(Long gH25) {
		GH25 = gH25;
	}

	public Long getGH26() {
		return GH26;
	}

	public void setGH26(Long gH26) {
		GH26 = gH26;
	}

	public Long getGH27() {
		return GH27;
	}

	public void setGH27(Long gH27) {
		GH27 = gH27;
	}

	public Long getGH28() {
		return GH28;
	}

	public void setGH28(Long gH28) {
		GH28 = gH28;
	}

	public Long getGH29() {
		return GH29;
	}

	public void setGH29(Long gH29) {
		GH29 = gH29;
	}

	public Long getGH2() {
		return GH2;
	}

	public void setGH2(Long gH2) {
		GH2 = gH2;
	}

	public Long getGH30() {
		return GH30;
	}

	public void setGH30(Long gH30) {
		GH30 = gH30;
	}

	public Long getGH30_1() {
		return GH30_1;
	}

	public void setGH30_1(Long gH30_1) {
		GH30_1 = gH30_1;
	}

	public Long getGH30_3() {
		return GH30_3;
	}

	public void setGH30_3(Long gH30_3) {
		GH30_3 = gH30_3;
	}

	public Long getGH30_5() {
		return GH30_5;
	}

	public void setGH30_5(Long gH30_5) {
		GH30_5 = gH30_5;
	}

	public Long getGH30_7() {
		return GH30_7;
	}

	public void setGH30_7(Long gH30_7) {
		GH30_7 = gH30_7;
	}

	public Long getGH30_dist() {
		return GH30_dist;
	}

	public void setGH30_dist(Long gH30_dist) {
		GH30_dist = gH30_dist;
	}

	public Long getGH31() {
		return GH31;
	}

	public void setGH31(Long gH31) {
		GH31 = gH31;
	}

	public Long getGH32() {
		return GH32;
	}

	public void setGH32(Long gH32) {
		GH32 = gH32;
	}

	public Long getGH33() {
		return GH33;
	}

	public void setGH33(Long gH33) {
		GH33 = gH33;
	}

	public Long getGH35() {
		return GH35;
	}

	public void setGH35(Long gH35) {
		GH35 = gH35;
	}

	public Long getGH36() {
		return GH36;
	}

	public void setGH36(Long gH36) {
		GH36 = gH36;
	}

	public Long getGH37() {
		return GH37;
	}

	public void setGH37(Long gH37) {
		GH37 = gH37;
	}

	public Long getGH38() {
		return GH38;
	}

	public void setGH38(Long gH38) {
		GH38 = gH38;
	}

	public Long getGH39() {
		return GH39;
	}

	public void setGH39(Long gH39) {
		GH39 = gH39;
	}

	public Long getGH3() {
		return GH3;
	}

	public void setGH3(Long gH3) {
		GH3 = gH3;
	}

	public Long getGH42() {
		return GH42;
	}

	public void setGH42(Long gH42) {
		GH42 = gH42;
	}

	public Long getGH43() {
		return GH43;
	}

	public void setGH43(Long gH43) {
		GH43 = gH43;
	}

	public Long getGH44() {
		return GH44;
	}

	public void setGH44(Long gH44) {
		GH44 = gH44;
	}

	public Long getGH45() {
		return GH45;
	}

	public void setGH45(Long gH45) {
		GH45 = gH45;
	}

	public Long getGH46() {
		return GH46;
	}

	public void setGH46(Long gH46) {
		GH46 = gH46;
	}

	public Long getGH47() {
		return GH47;
	}

	public void setGH47(Long gH47) {
		GH47 = gH47;
	}

	public Long getGH48() {
		return GH48;
	}

	public void setGH48(Long gH48) {
		GH48 = gH48;
	}

	public Long getGH49() {
		return GH49;
	}

	public void setGH49(Long gH49) {
		GH49 = gH49;
	}

	public Long getGH4() {
		return GH4;
	}

	public void setGH4(Long gH4) {
		GH4 = gH4;
	}

	public Long getGH51() {
		return GH51;
	}

	public void setGH51(Long gH51) {
		GH51 = gH51;
	}

	public Long getGH52() {
		return GH52;
	}

	public void setGH52(Long gH52) {
		GH52 = gH52;
	}

	public Long getGH53() {
		return GH53;
	}

	public void setGH53(Long gH53) {
		GH53 = gH53;
	}

	public Long getGH54() {
		return GH54;
	}

	public void setGH54(Long gH54) {
		GH54 = gH54;
	}

	public Long getGH55() {
		return GH55;
	}

	public void setGH55(Long gH55) {
		GH55 = gH55;
	}

	public Long getGH57() {
		return GH57;
	}

	public void setGH57(Long gH57) {
		GH57 = gH57;
	}

	public Long getGH5() {
		return GH5;
	}

	public void setGH5(Long gH5) {
		GH5 = gH5;
	}

	public Long getGH5_11() {
		return GH5_11;
	}

	public void setGH5_11(Long gH5_11) {
		GH5_11 = gH5_11;
	}

	public Long getGH5_12() {
		return GH5_12;
	}

	public void setGH5_12(Long gH5_12) {
		GH5_12 = gH5_12;
	}

	public Long getGH5_13() {
		return GH5_13;
	}

	public void setGH5_13(Long gH5_13) {
		GH5_13 = gH5_13;
	}

	public Long getGH5_15() {
		return GH5_15;
	}

	public void setGH5_15(Long gH5_15) {
		GH5_15 = gH5_15;
	}

	public Long getGH5_16() {
		return GH5_16;
	}

	public void setGH5_16(Long gH5_16) {
		GH5_16 = gH5_16;
	}

	public Long getGH5_1() {
		return GH5_1;
	}

	public void setGH5_1(Long gH5_1) {
		GH5_1 = gH5_1;
	}

	public Long getGH5_22() {
		return GH5_22;
	}

	public void setGH5_22(Long gH5_22) {
		GH5_22 = gH5_22;
	}

	public Long getGH5_23() {
		return GH5_23;
	}

	public void setGH5_23(Long gH5_23) {
		GH5_23 = gH5_23;
	}

	public Long getGH5_24() {
		return GH5_24;
	}

	public void setGH5_24(Long gH5_24) {
		GH5_24 = gH5_24;
	}

	public Long getGH5_27() {
		return GH5_27;
	}

	public void setGH5_27(Long gH5_27) {
		GH5_27 = gH5_27;
	}

	public Long getGH5_28() {
		return GH5_28;
	}

	public void setGH5_28(Long gH5_28) {
		GH5_28 = gH5_28;
	}

	public Long getGH5_2() {
		return GH5_2;
	}

	public void setGH5_2(Long gH5_2) {
		GH5_2 = gH5_2;
	}

	public Long getGH5_30() {
		return GH5_30;
	}

	public void setGH5_30(Long gH5_30) {
		GH5_30 = gH5_30;
	}

	public Long getGH5_31() {
		return GH5_31;
	}

	public void setGH5_31(Long gH5_31) {
		GH5_31 = gH5_31;
	}

	public Long getGH5_34() {
		return GH5_34;
	}

	public void setGH5_34(Long gH5_34) {
		GH5_34 = gH5_34;
	}

	public Long getGH5_36() {
		return GH5_36;
	}

	public void setGH5_36(Long gH5_36) {
		GH5_36 = gH5_36;
	}

	public Long getGH5_40() {
		return GH5_40;
	}

	public void setGH5_40(Long gH5_40) {
		GH5_40 = gH5_40;
	}

	public Long getGH5_41() {
		return GH5_41;
	}

	public void setGH5_41(Long gH5_41) {
		GH5_41 = gH5_41;
	}

	public Long getGH5_49() {
		return GH5_49;
	}

	public void setGH5_49(Long gH5_49) {
		GH5_49 = gH5_49;
	}

	public Long getGH5_4() {
		return GH5_4;
	}

	public void setGH5_4(Long gH5_4) {
		GH5_4 = gH5_4;
	}

	public Long getGH5_50() {
		return GH5_50;
	}

	public void setGH5_50(Long gH5_50) {
		GH5_50 = gH5_50;
	}

	public Long getGH5_51() {
		return GH5_51;
	}

	public void setGH5_51(Long gH5_51) {
		GH5_51 = gH5_51;
	}

	public Long getGH5_5() {
		return GH5_5;
	}

	public void setGH5_5(Long gH5_5) {
		GH5_5 = gH5_5;
	}

	public Long getGH5_7() {
		return GH5_7;
	}

	public void setGH5_7(Long gH5_7) {
		GH5_7 = gH5_7;
	}

	public Long getGH5_8() {
		return GH5_8;
	}

	public void setGH5_8(Long gH5_8) {
		GH5_8 = gH5_8;
	}

	public Long getGH5_9() {
		return GH5_9;
	}

	public void setGH5_9(Long gH5_9) {
		GH5_9 = gH5_9;
	}

	public Long getGH5_dist() {
		return GH5_dist;
	}

	public void setGH5_dist(Long gH5_dist) {
		GH5_dist = gH5_dist;
	}

	public Long getGH62() {
		return GH62;
	}

	public void setGH62(Long gH62) {
		GH62 = gH62;
	}

	public Long getGH63() {
		return GH63;
	}

	public void setGH63(Long gH63) {
		GH63 = gH63;
	}

	public Long getGH64() {
		return GH64;
	}

	public void setGH64(Long gH64) {
		GH64 = gH64;
	}

	public Long getGH65() {
		return GH65;
	}

	public void setGH65(Long gH65) {
		GH65 = gH65;
	}

	public Long getGH67() {
		return GH67;
	}

	public void setGH67(Long gH67) {
		GH67 = gH67;
	}

	public Long getGH6() {
		return GH6;
	}

	public void setGH6(Long gH6) {
		GH6 = gH6;
	}

	public Long getGH71() {
		return GH71;
	}

	public void setGH71(Long gH71) {
		GH71 = gH71;
	}

	public Long getGH72() {
		return GH72;
	}

	public void setGH72(Long gH72) {
		GH72 = gH72;
	}

	public Long getGH73() {
		return GH73;
	}

	public void setGH73(Long gH73) {
		GH73 = gH73;
	}

	public Long getGH74() {
		return GH74;
	}

	public void setGH74(Long gH74) {
		GH74 = gH74;
	}

	public Long getGH75() {
		return GH75;
	}

	public void setGH75(Long gH75) {
		GH75 = gH75;
	}

	public Long getGH76() {
		return GH76;
	}

	public void setGH76(Long gH76) {
		GH76 = gH76;
	}

	public Long getGH77() {
		return GH77;
	}

	public void setGH77(Long gH77) {
		GH77 = gH77;
	}

	public Long getGH78() {
		return GH78;
	}

	public void setGH78(Long gH78) {
		GH78 = gH78;
	}

	public Long getGH79() {
		return GH79;
	}

	public void setGH79(Long gH79) {
		GH79 = gH79;
	}

	public Long getGH7() {
		return GH7;
	}

	public void setGH7(Long gH7) {
		GH7 = gH7;
	}

	public Long getGH81() {
		return GH81;
	}

	public void setGH81(Long gH81) {
		GH81 = gH81;
	}

	public Long getGH84() {
		return GH84;
	}

	public void setGH84(Long gH84) {
		GH84 = gH84;
	}

	public Long getGH85() {
		return GH85;
	}

	public void setGH85(Long gH85) {
		GH85 = gH85;
	}

	public Long getGH88() {
		return GH88;
	}

	public void setGH88(Long gH88) {
		GH88 = gH88;
	}

	public Long getGH89() {
		return GH89;
	}

	public void setGH89(Long gH89) {
		GH89 = gH89;
	}

	public Long getGH8() {
		return GH8;
	}

	public void setGH8(Long gH8) {
		GH8 = gH8;
	}

	public Long getGH91() {
		return GH91;
	}

	public void setGH91(Long gH91) {
		GH91 = gH91;
	}

	public Long getGH92() {
		return GH92;
	}

	public void setGH92(Long gH92) {
		GH92 = gH92;
	}

	public Long getGH93() {
		return GH93;
	}

	public void setGH93(Long gH93) {
		GH93 = gH93;
	}

	public Long getGH94() {
		return GH94;
	}

	public void setGH94(Long gH94) {
		GH94 = gH94;
	}

	public Long getGH95() {
		return GH95;
	}

	public void setGH95(Long gH95) {
		GH95 = gH95;
	}

	public Long getGH97() {
		return GH97;
	}

	public void setGH97(Long gH97) {
		GH97 = gH97;
	}

	public Long getGH99() {
		return GH99;
	}

	public void setGH99(Long gH99) {
		GH99 = gH99;
	}

	public Long getGH9() {
		return GH9;
	}

	public void setGH9(Long gH9) {
		GH9 = gH9;
	}

	public Long getGT() {
		return GT;
	}

	public void setGT(Long gT) {
		GT = gT;
	}

	public Long getGT101() {
		return GT101;
	}

	public void setGT101(Long gT101) {
		GT101 = gT101;
	}

	public Long getGT10() {
		return GT10;
	}

	public void setGT10(Long gT10) {
		GT10 = gT10;
	}

	public Long getGT11() {
		return GT11;
	}

	public void setGT11(Long gT11) {
		GT11 = gT11;
	}

	public Long getGT12() {
		return GT12;
	}

	public void setGT12(Long gT12) {
		GT12 = gT12;
	}

	public Long getGT13() {
		return GT13;
	}

	public void setGT13(Long gT13) {
		GT13 = gT13;
	}

	public Long getGT14() {
		return GT14;
	}

	public void setGT14(Long gT14) {
		GT14 = gT14;
	}

	public Long getGT15() {
		return GT15;
	}

	public void setGT15(Long gT15) {
		GT15 = gT15;
	}

	public Long getGT17() {
		return GT17;
	}

	public void setGT17(Long gT17) {
		GT17 = gT17;
	}

	public Long getGT18() {
		return GT18;
	}

	public void setGT18(Long gT18) {
		GT18 = gT18;
	}

	public Long getGT1() {
		return GT1;
	}

	public void setGT1(Long gT1) {
		GT1 = gT1;
	}

	public Long getGT20() {
		return GT20;
	}

	public void setGT20(Long gT20) {
		GT20 = gT20;
	}

	public Long getGT21() {
		return GT21;
	}

	public void setGT21(Long gT21) {
		GT21 = gT21;
	}

	public Long getGT22() {
		return GT22;
	}

	public void setGT22(Long gT22) {
		GT22 = gT22;
	}

	public Long getGT23() {
		return GT23;
	}

	public void setGT23(Long gT23) {
		GT23 = gT23;
	}

	public Long getGT24() {
		return GT24;
	}

	public void setGT24(Long gT24) {
		GT24 = gT24;
	}

	public Long getGT25() {
		return GT25;
	}

	public void setGT25(Long gT25) {
		GT25 = gT25;
	}

	public Long getGT28() {
		return GT28;
	}

	public void setGT28(Long gT28) {
		GT28 = gT28;
	}

	public Long getGT2() {
		return GT2;
	}

	public void setGT2(Long gT2) {
		GT2 = gT2;
	}

	public Long getGT31() {
		return GT31;
	}

	public void setGT31(Long gT31) {
		GT31 = gT31;
	}

	public Long getGT32() {
		return GT32;
	}

	public void setGT32(Long gT32) {
		GT32 = gT32;
	}

	public Long getGT33() {
		return GT33;
	}

	public void setGT33(Long gT33) {
		GT33 = gT33;
	}

	public Long getGT34() {
		return GT34;
	}

	public void setGT34(Long gT34) {
		GT34 = gT34;
	}

	public Long getGT35() {
		return GT35;
	}

	public void setGT35(Long gT35) {
		GT35 = gT35;
	}

	public Long getGT37() {
		return GT37;
	}

	public void setGT37(Long gT37) {
		GT37 = gT37;
	}

	public Long getGT39() {
		return GT39;
	}

	public void setGT39(Long gT39) {
		GT39 = gT39;
	}

	public Long getGT3() {
		return GT3;
	}

	public void setGT3(Long gT3) {
		GT3 = gT3;
	}

	public Long getGT41() {
		return GT41;
	}

	public void setGT41(Long gT41) {
		GT41 = gT41;
	}

	public Long getGT43() {
		return GT43;
	}

	public void setGT43(Long gT43) {
		GT43 = gT43;
	}

	public Long getGT45() {
		return GT45;
	}

	public void setGT45(Long gT45) {
		GT45 = gT45;
	}

	public Long getGT47() {
		return GT47;
	}

	public void setGT47(Long gT47) {
		GT47 = gT47;
	}

	public Long getGT48() {
		return GT48;
	}

	public void setGT48(Long gT48) {
		GT48 = gT48;
	}

	public Long getGT49() {
		return GT49;
	}

	public void setGT49(Long gT49) {
		GT49 = gT49;
	}

	public Long getGT4() {
		return GT4;
	}

	public void setGT4(Long gT4) {
		GT4 = gT4;
	}

	public Long getGT50() {
		return GT50;
	}

	public void setGT50(Long gT50) {
		GT50 = gT50;
	}

	public Long getGT51() {
		return GT51;
	}

	public void setGT51(Long gT51) {
		GT51 = gT51;
	}

	public Long getGT54() {
		return GT54;
	}

	public void setGT54(Long gT54) {
		GT54 = gT54;
	}

	public Long getGT55() {
		return GT55;
	}

	public void setGT55(Long gT55) {
		GT55 = gT55;
	}

	public Long getGT57() {
		return GT57;
	}

	public void setGT57(Long gT57) {
		GT57 = gT57;
	}

	public Long getGT58() {
		return GT58;
	}

	public void setGT58(Long gT58) {
		GT58 = gT58;
	}

	public Long getGT59() {
		return GT59;
	}

	public void setGT59(Long gT59) {
		GT59 = gT59;
	}

	public Long getGT5() {
		return GT5;
	}

	public void setGT5(Long gT5) {
		GT5 = gT5;
	}

	public Long getGT60() {
		return GT60;
	}

	public void setGT60(Long gT60) {
		GT60 = gT60;
	}

	public Long getGT61() {
		return GT61;
	}

	public void setGT61(Long gT61) {
		GT61 = gT61;
	}

	public Long getGT62() {
		return GT62;
	}

	public void setGT62(Long gT62) {
		GT62 = gT62;
	}

	public Long getGT64() {
		return GT64;
	}

	public void setGT64(Long gT64) {
		GT64 = gT64;
	}

	public Long getGT65() {
		return GT65;
	}

	public void setGT65(Long gT65) {
		GT65 = gT65;
	}

	public Long getGT66() {
		return GT66;
	}

	public void setGT66(Long gT66) {
		GT66 = gT66;
	}

	public Long getGT68() {
		return GT68;
	}

	public void setGT68(Long gT68) {
		GT68 = gT68;
	}

	public Long getGT69() {
		return GT69;
	}

	public void setGT69(Long gT69) {
		GT69 = gT69;
	}

	public Long getGT6() {
		return GT6;
	}

	public void setGT6(Long gT6) {
		GT6 = gT6;
	}

	public Long getGT71() {
		return GT71;
	}

	public void setGT71(Long gT71) {
		GT71 = gT71;
	}

	public Long getGT76() {
		return GT76;
	}

	public void setGT76(Long gT76) {
		GT76 = gT76;
	}

	public Long getGT77() {
		return GT77;
	}

	public void setGT77(Long gT77) {
		GT77 = gT77;
	}

	public Long getGT7() {
		return GT7;
	}

	public void setGT7(Long gT7) {
		GT7 = gT7;
	}

	public Long getGT81() {
		return GT81;
	}

	public void setGT81(Long gT81) {
		GT81 = gT81;
	}

	public Long getGT8() {
		return GT8;
	}

	public void setGT8(Long gT8) {
		GT8 = gT8;
	}

	public Long getGT90() {
		return GT90;
	}

	public void setGT90(Long gT90) {
		GT90 = gT90;
	}

	public Long getGT91() {
		return GT91;
	}

	public void setGT91(Long gT91) {
		GT91 = gT91;
	}

	public Long getGT9() {
		return GT9;
	}

	public void setGT9(Long gT9) {
		GT9 = gT9;
	}

	public Long getMyosin_motor() {
		return Myosin_motor;
	}

	public void setMyosin_motor(Long myosin_motor) {
		Myosin_motor = myosin_motor;
	}

	public Long getPL() {
		return PL;
	}

	public void setPL(Long pL) {
		PL = pL;
	}

	public Long getPL10() {
		return PL10;
	}

	public void setPL10(Long pL10) {
		PL10 = pL10;
	}

	public Long getPL10_dist() {
		return PL10_dist;
	}

	public void setPL10_dist(Long pL10_dist) {
		PL10_dist = pL10_dist;
	}

	public Long getPL11() {
		return PL11;
	}

	public void setPL11(Long pL11) {
		PL11 = pL11;
	}

	public Long getPL11_2() {
		return PL11_2;
	}

	public void setPL11_2(Long pL11_2) {
		PL11_2 = pL11_2;
	}

	public Long getPL14() {
		return PL14;
	}

	public void setPL14(Long pL14) {
		PL14 = pL14;
	}

	public Long getPL14_1() {
		return PL14_1;
	}

	public void setPL14_1(Long pL14_1) {
		PL14_1 = pL14_1;
	}

	public Long getPL14_3() {
		return PL14_3;
	}

	public void setPL14_3(Long pL14_3) {
		PL14_3 = pL14_3;
	}

	public Long getPL14_4() {
		return PL14_4;
	}

	public void setPL14_4(Long pL14_4) {
		PL14_4 = pL14_4;
	}

	public Long getPL14_5() {
		return PL14_5;
	}

	public void setPL14_5(Long pL14_5) {
		PL14_5 = pL14_5;
	}

	public Long getPL14_dist() {
		return PL14_dist;
	}

	public void setPL14_dist(Long pL14_dist) {
		PL14_dist = pL14_dist;
	}

	public Long getPL15() {
		return PL15;
	}

	public void setPL15(Long pL15) {
		PL15 = pL15;
	}

	public Long getPL15_dist() {
		return PL15_dist;
	}

	public void setPL15_dist(Long pL15_dist) {
		PL15_dist = pL15_dist;
	}

	public Long getPL1() {
		return PL1;
	}

	public void setPL1(Long pL1) {
		PL1 = pL1;
	}

	public Long getPL1_10() {
		return PL1_10;
	}

	public void setPL1_10(Long pL1_10) {
		PL1_10 = pL1_10;
	}

	public Long getPL1_2() {
		return PL1_2;
	}

	public void setPL1_2(Long pL1_2) {
		PL1_2 = pL1_2;
	}

	public Long getPL1_4() {
		return PL1_4;
	}

	public void setPL1_4(Long pL1_4) {
		PL1_4 = pL1_4;
	}

	public Long getPL1_6() {
		return PL1_6;
	}

	public void setPL1_6(Long pL1_6) {
		PL1_6 = pL1_6;
	}

	public Long getPL1_7() {
		return PL1_7;
	}

	public void setPL1_7(Long pL1_7) {
		PL1_7 = pL1_7;
	}

	public Long getPL1_9() {
		return PL1_9;
	}

	public void setPL1_9(Long pL1_9) {
		PL1_9 = pL1_9;
	}

	public Long getPL1_dist() {
		return PL1_dist;
	}

	public void setPL1_dist(Long pL1_dist) {
		PL1_dist = pL1_dist;
	}

	public Long getPL20() {
		return PL20;
	}

	public void setPL20(Long pL20) {
		PL20 = pL20;
	}

	public Long getPL20_dist() {
		return PL20_dist;
	}

	public void setPL20_dist(Long pL20_dist) {
		PL20_dist = pL20_dist;
	}

	public Long getPL22() {
		return PL22;
	}

	public void setPL22(Long pL22) {
		PL22 = pL22;
	}

	public Long getPL22_2() {
		return PL22_2;
	}

	public void setPL22_2(Long pL22_2) {
		PL22_2 = pL22_2;
	}

	public Long getPL26() {
		return PL26;
	}

	public void setPL26(Long pL26) {
		PL26 = pL26;
	}

	public Long getPL27() {
		return PL27;
	}

	public void setPL27(Long pL27) {
		PL27 = pL27;
	}

	public Long getPL3() {
		return PL3;
	}

	public void setPL3(Long pL3) {
		PL3 = pL3;
	}

	public Long getPL3_2() {
		return PL3_2;
	}

	public void setPL3_2(Long pL3_2) {
		PL3_2 = pL3_2;
	}

	public Long getPL3_dist() {
		return PL3_dist;
	}

	public void setPL3_dist(Long pL3_dist) {
		PL3_dist = pL3_dist;
	}

	public Long getPL4() {
		return PL4;
	}

	public void setPL4(Long pL4) {
		PL4 = pL4;
	}

	public Long getPL4_1() {
		return PL4_1;
	}

	public void setPL4_1(Long pL4_1) {
		PL4_1 = pL4_1;
	}

	public Long getPL4_3() {
		return PL4_3;
	}

	public void setPL4_3(Long pL4_3) {
		PL4_3 = pL4_3;
	}

	public Long getPL4_5() {
		return PL4_5;
	}

	public void setPL4_5(Long pL4_5) {
		PL4_5 = pL4_5;
	}

	public Long getPL4_dist() {
		return PL4_dist;
	}

	public void setPL4_dist(Long pL4_dist) {
		PL4_dist = pL4_dist;
	}

	public Long getPL7() {
		return PL7;
	}

	public void setPL7(Long pL7) {
		PL7 = pL7;
	}

	public Long getPL7_4() {
		return PL7_4;
	}

	public void setPL7_4(Long pL7_4) {
		PL7_4 = pL7_4;
	}

	public Long getPL7_dist() {
		return PL7_dist;
	}

	public void setPL7_dist(Long pL7_dist) {
		PL7_dist = pL7_dist;
	}

	public Long getPL8() {
		return PL8;
	}

	public void setPL8(Long pL8) {
		PL8 = pL8;
	}

	public Long getPL8_4() {
		return PL8_4;
	}

	public void setPL8_4(Long pL8_4) {
		PL8_4 = pL8_4;
	}

	public Long getPL9() {
		return PL9;
	}

	public void setPL9(Long pL9) {
		PL9 = pL9;
	}

	public Long getPL9_1() {
		return PL9_1;
	}

	public void setPL9_1(Long pL9_1) {
		PL9_1 = pL9_1;
	}

	public Long getPL9_3() {
		return PL9_3;
	}

	public void setPL9_3(Long pL9_3) {
		PL9_3 = pL9_3;
	}

}