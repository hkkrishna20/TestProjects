package com.encomm.service;

import com.encomm.models.content.entity.ParaType;

public interface EncommContentService extends GenericEncommContentService<ParaType, Integer> {
	ParaType getById(Integer id);
}
