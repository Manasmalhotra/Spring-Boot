package com.instagram.service;

import java.util.List;

import com.instagram.dao.InstagramDAO;
import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;


public class InstagramService implements InstagramServiceInterface {

	public int createProfileService(InstagramUser iu) {
		InstagramDAOInterface id=new InstagramDAO();
		int i=id.createProfileDAO(iu);
		return i;
	}

	public InstagramUser viewProfileService(InstagramUser iu) {
		InstagramDAOInterface id=new InstagramDAO();
		InstagramUser w=id.viewProfileDAO(iu);
		return w;
	}

	public int editProfileService(InstagramUser fb) {
		InstagramDAOInterface fd=new InstagramDAO();
		int result=fd.editProfile(fb);
		return result;
	}

	public int deleteProfile(InstagramUser fb) {
		InstagramDAOInterface fd=new InstagramDAO();
		int result=fd.deleteProfile(fb);
		return result;
	}

	public List<InstagramUser> searchProfile(InstagramUser fb) {
		InstagramDAOInterface fd=new InstagramDAO();
		List<InstagramUser> result=fd.searchProfile(fb);
		return result;
	}

	public List<InstagramUser> viewAllProfile() {
		InstagramDAOInterface fd=new InstagramDAO();
		List<InstagramUser> result=fd.viewAllProfile();
		return result;
	}

}
