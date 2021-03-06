package com.integration.wc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "audit")
public class IntegrationAudit extends DocumentModel {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 255)
	private String reqid;
	@Column(length = 255)
	private String sourcecorelid;
	@Column(length = 255)private String processfamily;
	@Lob
	@Column(columnDefinition = "LONGTEXT")
	private String content;

	public String getReqid() {
		return reqid;
	}

	public void setReqid(String reqid) {
		this.reqid = reqid;
	}

	public String getSourcecorelid() {
		return sourcecorelid;
	}

	public void setSourcecorelid(String sourcecorelid) {
		this.sourcecorelid = sourcecorelid;
	}

	public String getProcessfamily() {
		return processfamily;
	}

	public void setProcessfamily(String processfamily) {
		this.processfamily = processfamily;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}