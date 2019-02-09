


package com.operationtool.database.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.RateCardView;
import com.operationtool.database.models.entity.RateCardViewTrackerId;



@Repository
public interface RateCardViewRepository extends CrudRepository<RateCardView, RateCardViewTrackerId> {

	@Query(value = "    select " + "    views.member_id," + "    views.member_name," + "    views.billable_status,"
			+ "    	views.hrbu_status," + "    views.base_currency," + "    views.standard_rate_modified,"
			+ "    	views.engagement_director," + "    views.project_manager," + "    views.dept_id,"
			+ "    	views.project_name," + "    views.account_group," + "    views.billing_end_date,"
			+ "    	views.billing_start_date," + "    views.cgi_onsite_eng_manager," + "    views.vacation_date,"
			+ "    	views.vacation_type    , calendarpcb.month," + "    calendarpcb.pcb_days,"
			+ "    	calendarpcb.start_date," + "    calendarpcb.end_date" + "    from ("
			+ "    	SELECT	  ratecard.* ,  " + "    billable.resource_id,     " + "    billable.billing_start_date,   "
			+ "    	billable.billing_end_date, " + "    leavetracker.*" + "	from integration.rate_card ratecard"
			+ "    	INNER JOIN integration.billable billable on billable.resource_id = ratecard.member_id"
			+ "		INNER JOIN integration.forecastleavetracker leavetracker on leavetracker.resourceid = ratecard.member_id) as views,"
			+ "    	integration.pcbcalendar calendarpcb"
			+ "    	WHERE views.vacation_date BETWEEN calendarpcb.start_date AND calendarpcb.end_date;" + "    "
			+ "", nativeQuery = true)
	Set<RateCardView> retrieveRateCardView();
	
	
	

}
