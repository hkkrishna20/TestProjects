package com.encomm.models.content.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ContentObj {
	
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	public int getParaSeq() {
		return paraSeq;
	}
	public void setParaSeq(int paraSeq) {
		this.paraSeq = paraSeq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	protected int contentId;
	protected int paraSeq;
	protected String content;


}
