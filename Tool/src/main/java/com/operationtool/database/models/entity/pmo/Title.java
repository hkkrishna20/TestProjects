package com.operationtool.database.models.entity.pmo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TITLE")
public class Title {

	private Integer titleId;
	private String titleName;
	private String titleDescription;
	
	public Title() {
		
	}
	
	/**
	 * @return the titleId
	 */
	@Id
	@Column(name = "TITLE_ID")
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}
	
	/**
	 * @return the title Name
	 */
	@Column(name = "TITLE_NAME")
	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	/**
	 * @return the title Description
	 */
	@Column(name = "TITLE_DESCRIPTION ") 
	public String getTitleDescription() {
		return titleDescription;
	}
	public void setTitleDescription(String titleDescription) {
		this.titleDescription = titleDescription;
	}
	
}
