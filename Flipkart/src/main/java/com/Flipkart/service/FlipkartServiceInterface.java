package com.Flipkart.service;

import java.util.List;

import com.Flipkart.entity.Customer;

public interface FlipkartServiceInterface {

	Customer viewProfileService(Customer u);

	List<Customer> viewAllProfileService();

	int createProfileService(Customer u);

	int editProfileService(Customer u);

	String deleteProfileService(Customer c);

}
