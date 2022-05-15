package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;

@Repository
public interface UserDAOInterface extends JpaRepository<User,String> {

	@Query("from com.example.demo.entity.User u where u.name=:nnn")
	List<User> viewByNameDAO(@Param("nnn") String name);
   
}
