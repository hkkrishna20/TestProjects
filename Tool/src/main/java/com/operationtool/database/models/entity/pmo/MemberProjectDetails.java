/**
 * 
 */
package com.operationtool.database.models.entity.pmo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author xx56104
 *
 */
@Entity
@Table(name="MEMBER_PROJECT_DETAILS")
public class MemberProjectDetails {

	@EmbeddedId
	private MemberProjectKey memberProjectKey;
	private Character IS_Billable = 'Y';
	private Date LAST_UPDATED_TS;
	private Integer STATUS_ID;
	@Transient
	private String action = "create"; 
	
	/**
	 * @return the memberProjectKey
	 */
	public MemberProjectKey getMemberProjectKey() {
		return memberProjectKey;
	}

	/**
	 * @param memberProjectKey the memberProjectKey to set
	 */
	public void setMemberProjectKey(MemberProjectKey memberProjectKey) {
		this.memberProjectKey = memberProjectKey;
	}
	
	/**
	 * @return the isBillable
	 */
	@Column(name = "IS_Billable")
	public Character getIsBillable() {
		return IS_Billable;
	}

	/**
	 * @param isBillable the isBillable to set
	 */
	public void setIsBillable(Character IS_Billable) {
		this.IS_Billable = IS_Billable;
	}

	/**
	 * @return the lastUpdatedts
	 */
	@Column(name="LAST_UPDATED_TS")
	public Date getLastUpdatedts() {
		return LAST_UPDATED_TS;
	}
	/**
	 * @param lastUpdatedts the lastUpdatedts to set
	 */
	public void setLastUpdatedts(Date LAST_UPDATED_TS) {
		this.LAST_UPDATED_TS = LAST_UPDATED_TS;
	}
	
	/**
	 * @return the statusId
	 */
	//@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@Column(name = "STATUS_ID")
	public Integer getStatus() {
		return STATUS_ID;
	}

	/**
	 * @param statusId
	 *            the statusId to set
	 */
	public void setStatus(Integer status) {
		this.STATUS_ID = status;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	
	
}
