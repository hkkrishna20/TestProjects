package com.rankingEnZymes.service;

import com.rankingEnZymes.model.FungiCAZymes;

public interface FungiCAZymesService extends GenericFungiCAZymesService<FungiCAZymes,String> {

	FungiCAZymes getById(String id);

}