package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDAOInterface;
import com.example.demo.entity.User;

@Service
@Transactional
public class UserService implements UserServiceInterface {
    @Autowired
    UserDAOInterface fd;
    
	@Override
	public User viewProfileService(User u) {
		Optional<User> w=fd.findById(u.getEmail());
		return w.get();
	}

	@Override
	public List<User> viewAllProfileService() {		
		return fd.findAll();
	}

	@Override
	public int createProfileService(User ff) {
		int i=0;
		fd.save(ff);
		i=1;
		return i;
	}

	@Override
	public String editProfileService(User u) {
		String res="Profile not edited";
		fd.saveAndFlush(u);
		res="Profile Edited Successfully";
		return res;
	}

	@Override
	public String deleteProfileService(User u) {
		String res="Profile not deleted";
		fd.deleteById(u.getEmail());
		res="Profile Deleted";
		return res;
	}

	@Override
	public List<User> viewByName(User u) {
		
		return fd.viewByNameDAO(u.getName());
	}

}
