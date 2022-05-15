package com.service;

import java.util.List;

import com.entity.User;

public interface ServiceInterface {
    int createProfileService(User u);

	User viewProfileService(User u);

	int editProfile(User u);

	int deleteProfile(User u);

	List<User> viewAllProfile();
}
