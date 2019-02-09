//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.07 at 04:56:06 PM IST 
//

package com.encomm.models.content.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * Java class for fileTableType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="fileTableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="formId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="versionNo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "fileTable")
@Entity(name = "enfiletable")
@Table(name = "enfiletable")
@XmlAccessorType(XmlAccessType.FIELD)
public class FileTableType {

	@Column(name = "fileid", nullable = true, insertable = true, updatable = true,unique = true)
	@Id
	@NotNull
	@XmlElement(required = false)
	protected int fileId;
	@XmlElement
	@Column(name = "formid")
	protected String formId;

	@XmlElement
	@Column(name = "formtitle")
	protected String formTitle;
	@XmlElement
	@Column(name = "versionno")
	protected float versionNo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "enfiletable", cascade = {
			CascadeType.ALL,CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = ParaType.class)
	@ElementCollection(targetClass = ParaType.class)
	
	public List<ParaType> getParas() {
		return paras;
	}

	public void setParas(List<ParaType> paras) {
		this.paras = paras;
	}

	@Transient
	@XmlElement(name="ParaType",required=true)
	private List<ParaType> paras = new ArrayList<ParaType>();
	/**
	 * Gets the value of the fileId property.
	 * 
	 */
	public int getFileId() {
		return fileId;
	}

	/**
	 * Sets the value of the fileId property.
	 * 
	 */
	public void setFileId(int value) {
		this.fileId = value;
	}

	/**
	 * Gets the value of the formId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFormId() {
		return formId;
	}

	/**
	 * Sets the value of the formId property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFormId(String value) {
		this.formId = value;
	}

	/**
	 * Gets the value of the formTitle property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFormTitle() {
		return formTitle;
	}

	/**
	 * Sets the value of the formTitle property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setFormTitle(String value) {
		this.formTitle = value;
	}

	/**
	 * Gets the value of the versionNo property.
	 * 
	 */
	public float getVersionNo() {
		return versionNo;
	}

	/**
	 * Sets the value of the versionNo property.
	 * 
	 */
	public void setVersionNo(float value) {
		this.versionNo = value;
	}
	/*
	 * public List<ParaType> getContents() { return contentTable; }
	 * 
	 * public void setContents(List<ParaType> contentTable) {
	 * this.contentTable = contentTable; }
	 */

}
