package com.encomm.models.content.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity(name = "ContentPercentageTable")
@Table(name = "ContentPercentageTable")
public class ContentPercentageTable {

	@Column(name = "contentid", nullable = true, insertable = true, updatable = true,unique = true)
	@Id
	@NotNull
	@XmlElement(required = false)
	protected int contentid;
	
	@XmlElement
	@Column(name = "versionno")
	protected float versionno;
	
	@XmlElement
	@Column(name = "paraseq")
	protected int paraseq;
	
	@Column(name = "fileid")
	protected int fileId;
	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST,
			CascadeType.MERGE }, targetEntity = FileTableType.class, optional = false, fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "fileid", referencedColumnName = "fileid", insertable = false, updatable = false)
	private FileTableType fileTableType;

	
	@Column(name = "content", columnDefinition = "TEXT")
	@org.hibernate.annotations.Type(type = "text")
	@Lob
	@XmlElement
	protected String content;
	
	public int getContentid() {
		return contentid;
	}

	public void setContentid(int contentid) {
		this.contentid = contentid;
	}

	public float getVersionno() {
		return versionno;
	}

	public void setVersionno(float versionno) {
		this.versionno = versionno;
	}

	public int getParaseq() {
		return paraseq;
	}

	public void setParaseq(int paraseq) {
		this.paraseq = paraseq;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public FileTableType getFileTableType() {
		return fileTableType;
	}

	public void setFileTableType(FileTableType fileTableType) {
		this.fileTableType = fileTableType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPercentile() {
		return percentile;
	}

	public void setPercentile(Integer percentile) {
		this.percentile = percentile;
	}

	@Column(name = "percentile", columnDefinition = "Integer")
	@XmlElement
	protected Integer percentile;
	
}
