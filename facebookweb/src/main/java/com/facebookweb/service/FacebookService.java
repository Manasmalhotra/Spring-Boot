package com.facebookweb.service;

import java.util.List;

import com.facebookweb.dao.FacebookDAO;
import com.facebookweb.dao.FacebookDAOInterface;
import com.facebookweb.entity.FacebookUser;

public class FacebookService implements FacebookServiceInterface{

	@Override
	public int createProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		int result=fd.createProfileDAO(fb);
		return result;
		
	}

	@Override
	public int checkloginService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		int result=fd.checkloginDAO(fb);
		return result;
	}

	@Override
	public FacebookUser viewProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		FacebookUser res=fd.viewProfileDAO(fb);
		return res;
	}

	@Override
	public List<FacebookUser> viewAllProfileService() {
		FacebookDAOInterface fd= new FacebookDAO();
		List<FacebookUser> res=fd.viewAllProfileDAO();
		if(res.size()>0) {
			return res;
		}
		return null;
	}

	@Override
	public int editProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		int res=fd.editProfileDAO(fb);
		return res;
	}

	@Override
	public List<FacebookUser> searchProfileService(FacebookUser fb) {
		FacebookDAOInterface fd= new FacebookDAO();
		List<FacebookUser> res=fd.searchProfileDAO(fb);
		if(res.size()>0) {
			return res;
		}
		return null;
	}

	@Override
	public int deleteProfileService(FacebookUser fb) {
		FacebookDAOInterface fd=new FacebookDAO();
		int res=fd.deleteProfileDAO(fb);
		return res;
	}
}
