package com.operationtool.database.service;

import java.util.List;
import java.util.Set;

import com.operationtool.database.models.entity.Candidate;

public interface CandidateService extends GenericCandidateService<Candidate, String> {

	Candidate getById(String id);

	Set<Candidate> findByPyramidaccounthrbu(String string);

	Set<String> findDistinctDirectordept10inthehrtreeAndPyramidaccounthrbu(String description);

	Set<String> findDistinctResourcename(String designation, String pyramidaccounthrbu);

	Set<String> findDistinctReportingmanagerAndPyramidaccounthrbu(String dirName, String pyramidaccounthrbu);

	Set<String> findDistinctProjectAndPyramidaccounthrbu(String managerNamesList, String pyramidaccounthrbu);

}
