package com.dao;

import java.util.List;

import com.entity.User;

public interface DAOInterface {

	int createProfileDAO(User u);

	User viewProfileDAO(User u);

	int editProfileDAO(User u);

	int deleteProfileDAO(User u);

	List<User> viewAllProfileDAO();

}
