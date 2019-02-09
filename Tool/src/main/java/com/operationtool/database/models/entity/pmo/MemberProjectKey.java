package com.operationtool.database.models.entity.pmo;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MemberProjectKey implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Column(name = "PSA_ID")
	    private Integer psaId;

	    @Column(name = "PROJECT_ID")
	    private Integer projectId;
	    
	    /**
		 * @return the psaId
		 */
		public Integer getPsaId() {
			return psaId;
		}

		/**
		 * @param psaId the psaId to set
		 */
		public void setPsaId(Integer psaId) {
			this.psaId = psaId;
		}

		/**
		 * @return the projectId
		 */
		public Integer getProjectId() {
			return projectId;
		}

		/**
		 * @param projectId the projectId to set
		 */
		public void setProjectId(Integer projectId) {
			this.projectId = projectId;
		}

}
