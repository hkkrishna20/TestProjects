package com.encomm.models.content.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "preview")
@XmlAccessorType(XmlAccessType.FIELD)
public class Preview {
	@XmlElement(name = "baseFileVersion")
	private String baseFileVersion;
	@XmlElement(name = "versions")
	private List<String> versions = new ArrayList<String>();

	public String getBaseFileVersion() {
		return baseFileVersion;
	}

	public void setBaseFileVersion(String baseFileVersion) {
		this.baseFileVersion = baseFileVersion;
	}

	public List<String> getVersions() {
		return versions;
	}

	public void setVersions(List<String> versions) {
		this.versions = versions;
	}

}
