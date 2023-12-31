package com.example.dao;

import java.util.HashMap;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.StaffVO;
import com.example.domain.UserVO;
import com.example.domain.WorkplaceVO;

@Repository
public class UserDAOImpl implements UserDAO {
   @Autowired
   SqlSession session;
   String namespace = "com.example.mapper.UserMapper";


   @Override
   public void uinsert(UserVO vo) {
      session.insert(namespace + ".uinsert", vo);
      
   }

   @Override
   public void winsert(WorkplaceVO vo) {
      session.insert(namespace + ".winsert", vo);      
   }

	@Override
	public HashMap<String, Object> wread(String use_login_id) {
		return session.selectOne(namespace + ".wread", use_login_id);
	}

	@Override
	public void sinsert(StaffVO vo) {
		session.insert(namespace + ".sinsert", vo);
		
	}

	@Override
	public HashMap<String, Object> sread(String use_login_id) {
		return session.selectOne(namespace + ".sread", use_login_id);
	}

	@Override
	public HashMap<String, Object> uread(String use_login_id) {
		return session.selectOne(namespace + ".uread", use_login_id);
	}

	@Override
	public void wupdate(UserVO vo) {
		session.update(namespace + ".wupdate", vo);
	}
	
	@Override
	public void supdate(StaffVO vo) {
		session.update(namespace + ".supdate", vo);
		
	}

	@Override
	public int lastnum(String use_login_id) {
		return session.selectOne(namespace+".lastnum", use_login_id);
	}
   
}

