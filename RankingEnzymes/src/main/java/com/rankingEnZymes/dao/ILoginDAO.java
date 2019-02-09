package com.rankingEnZymes.dao;

import com.rankingEnZymes.model.UserBean;

public interface ILoginDAO {
	public abstract boolean authenticateUser(UserBean userBean);
}