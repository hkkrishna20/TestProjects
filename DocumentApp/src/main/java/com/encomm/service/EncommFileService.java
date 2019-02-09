package com.encomm.service;

import com.encomm.models.content.entity.FileTableType;

public interface EncommFileService extends GenericEncommFileService<FileTableType,Integer> {

	FileTableType getById(Integer id);

}