package com.operationtool.database.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.SqlResultSetMappings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.operationtool.database.models.entity.Candidate;

@Repository
public interface CandidateRepository extends CrudRepository<Candidate, String> {
	Long countByResourceID(String name);

	long count();

	Set<Candidate> findByPyramidaccounthrbu(String string);

	// long countByTenantName(String tenantName);

	@Query(value = "select Distinct directordept10inthehrtree FROM candidate t where (t.designation = ?)  and  (t.pyramidaccounthrbu = ?)", nativeQuery = true)
	Set<String> findDistinctResourcename(String designation,String pyramidaccounthrbu);

	@Query(value = "SELECT Distinct t.directordept10inthehrtree FROM candidate t where t.directordept10inthehrtree IS NOT null and t.directordept10inthehrtree != '' and t.pyramidaccounthrbu = ?", nativeQuery = true)
	Set<String> findDistinctDirectordept10inthehrtreeAndPyramidaccounthrbu(String description);
	
	@Query(value = "SELECT Distinct reportingmanager FROM candidate t where (t.directordept10inthehrtree = ?)  and  (t.pyramidaccounthrbu = ?)", nativeQuery = true)
	Set<String> findDistinctReportingmanagerAndPyramidaccounthrbu(String dirName, String pyramidaccounthrbu);
	
	@Query(value = "SELECT Distinct departmentdescription FROM candidate t where (t.reportingmanager = ?)  and  (t.pyramidaccounthrbu = ?)", nativeQuery = true)
	Set<String> findDistinctProjectAndPyramidaccounthrbu(String dirName, String pyramidaccounthrbu);

	
	
}