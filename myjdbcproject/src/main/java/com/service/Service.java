package com.service;

import java.util.List;

import com.dao.DAO;
import com.dao.DAOInterface;
import com.entity.User;

public class Service implements ServiceInterface{

	public int createProfileService(User u) {
		DAOInterface ud=new DAO();
		int i=ud.createProfileDAO(u);
		return i;
	}

	public User viewProfileService(User u) {
		DAOInterface ud=new DAO();
		User f=ud.viewProfileDAO(u);
		return f;
	}

	public int editProfile(User u) {
		DAOInterface ud=new DAO();
		int i=ud.editProfileDAO(u);
		return i;
	}

	public int deleteProfile(User u) {
		DAOInterface ud=new DAO();
		int i=ud.deleteProfileDAO(u);
		return i;
	}

	public List<User> viewAllProfile() {
		DAOInterface ud=new DAO();
		List<User>ll=ud.viewAllProfileDAO();
		return ll;
	}

}
