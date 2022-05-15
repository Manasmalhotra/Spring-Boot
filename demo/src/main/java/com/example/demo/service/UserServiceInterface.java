package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserServiceInterface {
   User viewProfileService(User u);

List<User> viewAllProfileService();

int createProfileService(User ff);

String editProfileService(User u);

String deleteProfileService(User u);

List<User> viewByName(User u);
}
