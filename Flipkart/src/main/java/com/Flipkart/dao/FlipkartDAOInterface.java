package com.Flipkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Flipkart.entity.Customer;

@Repository
public interface FlipkartDAOInterface extends JpaRepository<Customer,String> {

}
