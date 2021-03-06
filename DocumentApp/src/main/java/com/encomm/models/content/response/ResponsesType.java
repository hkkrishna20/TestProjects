//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.17 at 12:47:28 PM IST 
//


package com.encomm.models.content.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responsesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responsesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="formId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="formTitle" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="paraType" type="{}paraTypeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="versionNo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponsesType {
    protected int fileId;
    @XmlElement(required = true)
    protected String formId;
    @XmlElement(required = true)
    protected String formTitle;
    protected List<ParaTypeType> paraType;
    protected float versionNo;

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
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormId() {
        return formId;
    }

    /**
     * Sets the value of the formId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormId(String value) {
        this.formId = value;
    }

    /**
     * Gets the value of the formTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormTitle() {
        return formTitle;
    }

    /**
     * Sets the value of the formTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormTitle(String value) {
        this.formTitle = value;
    }

    /**
     * Gets the value of the paraType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paraType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParaType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ParaTypeType }
     * 
     * 
     */
    public List<ParaTypeType> getParaType() {
        if (paraType == null) {
            paraType = new ArrayList<ParaTypeType>();
        }
        return this.paraType;
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

}
