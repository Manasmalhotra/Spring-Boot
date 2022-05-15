package com.facebookweb.service;

import java.util.List;

import com.facebookweb.entity.FacebookUser;

public interface FacebookServiceInterface {
    int createProfileService(FacebookUser fb);

	int checkloginService(FacebookUser fb);

	FacebookUser viewProfileService(FacebookUser fb);

	List<FacebookUser> viewAllProfileService();

	int editProfileService(FacebookUser fb);

	List<FacebookUser> searchProfileService(FacebookUser fb);

	int deleteProfileService(FacebookUser fb);
}
