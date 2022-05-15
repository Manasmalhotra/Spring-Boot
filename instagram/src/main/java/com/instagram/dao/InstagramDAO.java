package com.instagram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.instagram.entity.InstagramUser;



public class InstagramDAO implements InstagramDAOInterface {

	public int createProfileDAO(InstagramUser iu) {
		int i=0;
		/*try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into deloiteinstagram values(?,?,?,?)");
			ps.setString(1,iu.getName());
			ps.setString(2,iu.getPassword());
			ps.setString(3,iu.getEmail());
			ps.setString(4,iu.getAddress());
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
			s.save(iu);
		et.commit();
		i=1;
		return i;
	}

	public InstagramUser viewProfileDAO(InstagramUser iu) {
		InstagramUser ss=null;
		/*try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "Manas@65");
			PreparedStatement ps=con.prepareStatement("select * from deloiteinstagram where email=?");
			
			ps.setString(1,iu.getEmail());
		
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				ss=new InstagramUser();
				ss.setName(n);
				ss.setPassword(p);
				ss.setEmail(e);
				ss.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ss;
		*/
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.instagram.entity.InstagramUser u where u.email=:em");
		q.setParameter("em", iu.getEmail());
		
		ss=(InstagramUser)q.getSingleResult();
		return ss;
	}

	public int editProfile(InstagramUser fb) {
		int i=0;
		   /*try {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "Manas@65");
		   
		 //step 3 create query
			PreparedStatement ps=con.prepareStatement("update deloitinstagram set name=?,password=?,address=? where email=?");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3, fb.getAddress());
			ps.setString(4, fb.getEmail());
			
			//execute query
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
		Query q=s.createQuery("update com.instagram.entity.InstagramUser u set u.name=:nm,u.password=:pass,u.address=:add where u.email=:em");
		q.setParameter("nm", fb.getName());
		q.setParameter("pass", fb.getPassword());
		q.setParameter("add", fb.getAddress());
		q.setParameter("em", fb.getEmail());
		int status=q.executeUpdate();  
		System.out.println(status);  
		et.commit();  
		i=1;
		return i;
	}

	public int deleteProfile(InstagramUser fb) {
		 int i=0;
		   
		 /*try {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "Manas@65");
		   
		 //step 3 create query
			PreparedStatement ps=con.prepareStatement("delete from deloitinstagram where email=?");
			ps.setString(1, fb.getEmail());
		
			
			//execute query
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		EntityTransaction et=s.getTransaction();
		et.begin();
		Query q=s.createQuery("delete from com.instagram.entity.InstagramUser u where u.email=:em");
		q.setParameter("em", fb.getEmail());
		q.executeUpdate(); 
		et.commit();
		i=1;
		return i;
		}
		

	public List<InstagramUser> searchProfile(InstagramUser fb) {
		List<InstagramUser> ss=null;
		
		/*try {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "Manas@65");
		   
		 //step 3 create query
			PreparedStatement ps=con.prepareStatement("select * from deloitinstagram where email=?");
		
			ps.setString(1, fb.getEmail());
	
			
			//execute query
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				String n=res.getString(1);
				String p=res.getString(2);
				String e=res.getString(3);
				String a=res.getString(4);
				
				ss=new InstagramUser();
				ss.setName(n);
				ss.setPassword(p);
				ss.setEmail(e);
				ss.setAddress(a);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.instagram.entity.InstagramUser u where u.name=:nm");
		q.setParameter("nm", fb.getName());			
		ss=q.getResultList();
		return ss;
	}

	public List<InstagramUser> viewAllProfile() {
		/*List<InstagramUser>fb=new ArrayList<InstagramUser>();
		try {
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "Manas@65");
		   
			   PreparedStatement ps=con.prepareStatement("select * from deloitinstagram");
			   ResultSet res=ps.executeQuery();
			   while(res.next()) {
				   InstagramUser user= new InstagramUser();
				   user.setName(res.getString(1));
				   user.setPassword(res.getString(2));
				   user.setEmail(res.getString(3));
				   user.setAddress(res.getString(4));
				   fb.add(user);
			   }
	}
		catch(Exception e) {
			e.printStackTrace();
		}
		return fb;
		*/
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Query q=s.createQuery("from com.instagram.entity.InstagramUser u");
				
		List<InstagramUser> ss=q.getResultList();
		return ss;
	}

}
