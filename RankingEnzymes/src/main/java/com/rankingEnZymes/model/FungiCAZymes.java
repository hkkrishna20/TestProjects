package com.rankingEnZymes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "FungiCAZymes")
@Entity(name = "FungiCAZymes")
@Table(name = "FungiCAZymes")
@XmlAccessorType(XmlAccessType.FIELD)
public class FungiCAZymes implements Serializable{
	@Column(name = "genomecode")
	@Id
	@NotNull
	@XmlElement
	private String genomecode;
	@Column(name = "name")
	@XmlElement
	private String name;
	@Column(name = "published")
	@XmlElement
	private String published;
	@Column(name = "assemblylength")
	@XmlElement
	private String assemblylength;
	@Column(name = "genes")
	@XmlElement
	private String genes;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	
	public String getGenes() {
		return genes;
	}

	public void setGenes(String genes) {
		this.genes = genes;
	}

	public String getGenomecode() {
		return genomecode;
	}

	public void setGenomecode(String genomecode) {
		this.genomecode = genomecode;
	}

	public String getAssemblylength() {
		return assemblylength;
	}

	public void setAssemblylength(String assemblylength) {
		this.assemblylength = assemblylength;
	}

}
