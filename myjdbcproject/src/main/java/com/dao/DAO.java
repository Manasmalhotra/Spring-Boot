package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.User;

public class DAO implements DAOInterface {

	public int createProfileDAO(User u) {
		int i=0;
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Manas@65");
			PreparedStatement ps=conn.prepareStatement("insert into myuser values(?,?,?,?)");
			ps.setString(1, u.getName());
			ps.setString(2,u.getEmail());
			ps.setString(3, u.getAddress());
			ps.setString(4, u.getMobile());
			
			i=ps.executeUpdate();
		}
		catch(Exception e){
			e.getStackTrace();
		}
		return i;
	}

	public User viewProfileDAO(User u) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Manas@65");
			PreparedStatement ps=conn.prepareStatement("select * from myuser where email=?");
			ps.setString(1,u.getEmail());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				User j=new User();
				j.setName(res.getString(1));
				j.setEmail(res.getString(2));
				j.setAddress(res.getString(3));
				j.setMobile(res.getString(4));
				return j;
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return null;
	}

	public int editProfileDAO(User u) {
		int i=0;
		try {
	    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Manas@65");
		PreparedStatement ps=conn.prepareStatement("update myuser set name=?,address=?,mobile=? where email=?");
		ps.setString(1,u.getName());
		ps.setString(2,u.getAddress());
		ps.setString(3, u.getMobile());
		ps.setString(4, u.getEmail());
		i=ps.executeUpdate();
		}
		
		catch(Exception e) {
			e.getStackTrace();
		}
		return i;
	}

	public int deleteProfileDAO(User u) {
		int i=0;
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Manas@65");
			PreparedStatement ps=conn.prepareStatement("delete from myuser where email=?");
			ps.setString(1,u.getEmail());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return i;
	}

	public List<User> viewAllProfileDAO(){
		List<User>ll=new ArrayList<User>();
		try {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata","root","Manas@65");
		PreparedStatement ps=conn.prepareStatement("select * from myuser");
		ResultSet res=ps.executeQuery();

		while(res.next()) {
		  	User u=new User();
		  	u.setName(res.getString(1));
		  	u.setEmail(res.getString(2));
		  	u.setAddress(res.getString(3));
		  	u.setMobile(res.getString(4));
		  	ll.add(u);
		}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		return ll;
	}

}
