package com.rankingEnZymes.service;

import com.rankingEnZymes.model.FinalCAZymes.FinalCAZvType;

public interface FinalCAZvService extends GenericFinalCAZvService<FinalCAZvType, String> {
	FinalCAZvType getById(String id);
}
