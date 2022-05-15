package com.instagram.dao;

import java.util.List;

import com.instagram.entity.InstagramUser;

public interface InstagramDAOInterface {

	int createProfileDAO(InstagramUser iu);

	InstagramUser viewProfileDAO(InstagramUser iu);

	int editProfile(InstagramUser fb);

	int deleteProfile(InstagramUser fb);

	List<InstagramUser> searchProfile(InstagramUser fb);

	List<InstagramUser> viewAllProfile();

}
