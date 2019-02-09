package com.rankingEnZymes.model.FinalCAZymes;

public class ResponseObj {

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

	public String getGenomeCode() {
		return genomeCode;
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

	public void setGenomeCode(String genomeCode) {
		this.genomeCode = genomeCode;
	}

	public Long getTotalEnzymes() {
		return totalEnzymes;
	}

	public void setTotalEnzymes(Long totalEnzymes) {
		this.totalEnzymes = totalEnzymes;
	}

	public Long getClassifier() {
		return classifier;
	}

	public void setClassifier(Long classifier) {
		this.classifier = classifier;
	}
}
