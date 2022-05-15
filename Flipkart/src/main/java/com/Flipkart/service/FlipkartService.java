package com.Flipkart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Flipkart.dao.FlipkartDAOInterface;
import com.Flipkart.entity.Customer;

@Service
@Transactional
public class FlipkartService implements FlipkartServiceInterface {

	@Autowired
	FlipkartDAOInterface fd;
	@Override
	public Customer viewProfileService(Customer u) {
		Optional<Customer> c=fd.findById(u.getEmail());
		return c.get();
	}
	@Override
	public List<Customer> viewAllProfileService() {
		
		return fd.findAll();
	}
	@Override
	public int createProfileService(Customer u) {
		int i=0;
		fd.save(u);
		i=1;
		return i;
	}
	@Override
	public int editProfileService(Customer u) {
		int i=0;
		fd.saveAndFlush(u);
		i=1;
		return i;
	}
	@Override
	public String deleteProfileService(Customer c) {
		String res="Profile not Deleted";
		fd.deleteById(c.getEmail());
		res="Profile Deleted Successfully";
		return res;
	}

}
