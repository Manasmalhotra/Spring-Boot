package com.amazonwebapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonwebapp.dao.AmazonDAOInterface;
import com.amazonwebapp.entity.AmazonUser;

@Service
@Transactional
public class AmazonService implements AmazonServiceInterface {
    @Autowired
    private AmazonDAOInterface fd;
	@Override
	public int createProfile(AmazonUser am) {
		int i=0;
		fd.save(am);
		i=1;
		return i;
	}

}
