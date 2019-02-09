package com.operationtool.database.models.entity.pmo;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

/**
 * @author xx45604
 *
 */
@Entity
@Table(name = "USER_DETAILS")
@Lazy(value=false)
public class User {

	private int userId;
	private String userName;
	private String password;
	private String emailId;
	private String firstName;
	private String lastName;
	private Role role;
	private Date lastUpdatedTS;
	
	public User() {
		
	}
	
	/**
	 * @return the userID
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the password
	 */
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailID
	 */
	@Column(name = "EMAIL_ID")
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the firstName
	 */
	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the role
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ROLE_ID")
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * @return the lastUpdatedTS
	 */
	@Column(name = "LAST_UPDATED_TS")
	public Date getLastUpdatedTS() {
		return lastUpdatedTS;
	}

	/**
	 * @param lastUpdatedTS
	 *            the lastUpdatedTS to set
	 */
	public void setLastUpdatedTS(Date lastUpdatedTS) {
		this.lastUpdatedTS = lastUpdatedTS;
	}
}