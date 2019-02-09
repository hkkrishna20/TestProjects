/**
 * 
 */
package com.operationtool.database.models.entity.pmo;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author xx57136
 *
 */
@Entity
@Table(name = "MEMBER_PNC_DETAILS")
public class MemberPNCDetails 
{
	private int pncDetailsId;
	private String pncXXId;
	private String vmId;
	private String pncMailId;
	private String vNet;
	private  MemberDetails memberDetails;
	private String action="create";
	
	@Transient
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the member details
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PSA_ID")
	public MemberDetails getMemberdetails() {
		return memberDetails;
	}
	/**
	 * @param memberdetails the member details to set
	 */
	public void setMemberdetails(MemberDetails memberdetails) {
		this.memberDetails = memberdetails;
	}
	/**
	 * @return the pncDetailsId
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "PNC_DETAILS_ID")
	public int getPncDetailsId() {
		return pncDetailsId;
	}
	/**
	 * @param pncDetailsId the pncDetailsId to set
	 */
	public void setPncDetailsId(int pncDetailsId) {
		this.pncDetailsId = pncDetailsId;
	}
	
	/**
	 * @return the pncXXid
	 */
	@Column(name = "PNC_XXID")
	public String getPncXXId() {
		return pncXXId;
	}
	/**
	 * @param pncXXid the pncXXid to set
	 */
	public void setPncXXId(String pncXXId) {
		this.pncXXId = pncXXId;
	}
	/**
	 * @return the vmId
	 */
	@Column(name = "VM_ID")
	public String getVmId() {
		return vmId;
	}
	/**
	 * @param vmId the vmId to set
	 */
	public void setVmId(String vmId) {
		this.vmId = vmId;
	}
	/**
	 * @return the pncMailId
	 */
	@Column(name = "PNC_Mail_ID")
	public String getPncMailId() {
		return pncMailId;
	}
	/**
	 * @param pncMailId the pncMailId to set
	 */
	public void setPncMailId(String pncMailId) {
		this.pncMailId = pncMailId;
	}
	/**
	 * @return the vNet
	 */
	@Column(name = "Vnet")
	public String getvNet() {
		return vNet;
	}
	/**
	 * @param vNet the vNet to set
	 */
	public void setvNet(String vNet) {
		this.vNet = vNet;
	}
	
	

}
