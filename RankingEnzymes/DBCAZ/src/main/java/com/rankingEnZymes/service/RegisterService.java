package com.rankingEnZymes.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rankingEnZymes.dao.LoginDAO;
import com.rankingEnZymes.model.RegisterBean;
import com.rankingEnZymes.repository.RegisterRepository;

@Service
public class RegisterService {
	@Autowired
	private LoginDAO registerDAO;

	@Autowired
	private RegisterRepository registerRepository;

	public Object save(Object entity) {
		// TODO Auto-generated method stub
		RegisterBean registerBean = (RegisterBean) entity;
		registerRepository.save(registerBean);
		return registerBean;
	}

	public Object getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Serializable id) {
		// TODO Auto-generated method stub

	}
}