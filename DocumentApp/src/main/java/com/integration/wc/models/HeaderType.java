//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.23 at 07:53:49 PM IST 
//


package com.integration.wc.models;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for headerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="headerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contentTs" type="{}contentTsType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerType", propOrder = {
    "contents"
})
public class HeaderType {

    protected List<ContentTsType> contentTs;

    /**
     * Gets the value of the contentTs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentTs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentTs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentTsType }
     * 
     * 
     */
    public List<ContentTsType> getContentTs() {
        if (contentTs == null) {
            contentTs = new ArrayList<ContentTsType>();
        }
        return this.contentTs;
    }

	public void setContentTs(List<ContentTsType> contentTs) {
		
		 if (contentTs == null) {
	            contentTs = new ArrayList<ContentTsType>();
	        }
		this.contentTs = contentTs;
	}

}