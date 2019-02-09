package com.operationtool.database.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.CandidateBillPCBAmountTracker;
import com.operationtool.database.models.entity.CandidateBillPCBAmountTrackerId;

@Repository
public interface CandiatePCBAmountRepository
		extends CrudRepository<CandidateBillPCBAmountTracker, CandidateBillPCBAmountTrackerId> {

	// Director Metadata

	@Query(value = "select integration.candidatebillpcb.engagement_director"
			+ "	from integration.candidatebillpcb where "
			+ " integration.candidatebillpcb.account_group =?;", nativeQuery = true)
	Set<String> getDirectorNames(String accountGroup);

	@Query(value = "SELECT a.pcbmonth  as pcbmonth ,sum(a.bill_amount) as bill, a.engagement_director as director"
			+ "	 FROM candidatebillpcb a  " + "" + "	 where a.account_group =? and a.engagement_director =?"
			+ "	  group by a.pcbmonth;", nativeQuery = true)
	List<Object[]> retrieveIndividualDirectorSum(String accountGroup, String engagementDirector);

	@Query(value = " SELECT `integration`.`candidatebillpcb`.pcbmonth ,Sum(bill_amount) as bill, `integration`.`candidatebillpcb`.engagement_director as director"
			+ "	 FROM `integration`.`candidatebillpcb`	 where account_group =?"
			+ "	  group by pcbmonth, engagement_director", nativeQuery = true)
	List<Object[]> retreiveAllDirectorbasedonPCBMonth(String accountGroup);

	// Manager Metadata
	@Query(value = "select integration.candidatebillpcb.engagement_director,  integration.candidatebillpcb.project_manger"
			+ "	from integration.candidatebillpcb where integration.candidatebillpcb.engagement_director = ? and"
			+ " integration.candidatebillpcb.account_group =?;", nativeQuery = true)
	Set<String> getManagerNames(String engagementDirector, String accountGroup);

	@Query(value = "SELECT `integration`.`candidatebillpcb`.pcbmonth ,Sum(bill_amount) as bill,  integration.candidatebillpcb.project_manger  "
			+ "	 FROM `integration`.`candidatebillpcb`" + "" + "	 where account_group =? and project_manger =?"
			+ "	  group by pcbmonth;", nativeQuery = true)
	List<Object[]> retrieveIndividualManagerSum(String accountGroup, String projectManager);

	@Query(value = " SELECT `integration`.`candidatebillpcb`.pcbmonth ,Sum(bill_amount) as bill, `integration`.`candidatebillpcb`.project_manger"
			+ "FROM `integration`.`candidatebillpcb`" + "where account_group =? and engagement_director =?"
			+ " group by pcbmonth, project_manger;" + "", nativeQuery = true)
	Set<Object[]> getManagerSum(String accountGroup, String engagementDirector);

	// Project Metadata
	@Query(value = "select integration.candidatebillpcb.project,  integration.candidatebillpcb.project_manger"
			+ "	from integration.candidatebillpcb where integration.candidatebillpcb.project_manger = ? and"
			+ " integration.candidatebillpcb.account_group =?;", nativeQuery = true)
	Set<String> getProjectNames(String projectManager, String accountGroup);

	@Query(value = "SELECT `integration`.`candidatebillpcb`.pcbmonth ,Sum(bill_amount) as bill "
			+ "	 FROM `integration`.`candidatebillpcb`" + "" + "	 where account_group =? and project =?"
			+ "	  group by pcbmonth;", nativeQuery = true)
	List<Object[]> retrieveIndividualProjectSum(String accountGroup, String project);

	@Query(value = " SELECT `integration`.`candidatebillpcb`.pcbmonth ,Sum(bill_amount) as bill, `integration`.`candidatebillpcb`.project"
			+ "FROM `integration`.`candidatebillpcb`" + "where account_group =? and project_manger =?"
			+ " group by pcbmonth, project;" + "", nativeQuery = true)
	Set<Object[]> getProjectSum(String accountGroup, String projectManager);

}