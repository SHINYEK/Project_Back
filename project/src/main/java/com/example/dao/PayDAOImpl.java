package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PayVO;

@Repository
public class PayDAOImpl implements PayDAO {
	@Autowired
	SqlSession session;
	String namespace = "com.example.mapper.PayMapper";

	@Override
	public String paySum(int use_work_num) {
		return session.selectOne(namespace + ".paySum", use_work_num);
	}

	@Override
	public int staffTotal(int use_work_num) {
		return session.selectOne(namespace + ".staffTotal", use_work_num);
	}

	@Override
	public String tempPaySum(int use_work_num) {
		return session.selectOne(namespace + ".tempPaySum", use_work_num);
	}

	@Override
	public List<HashMap<String, Object>> staffType(int use_work_num) {
		return session.selectList(namespace + ".staffType", use_work_num);
	}

	@Override
	public List<HashMap<String, Object>> payMonth(int use_work_num) {
		return session.selectList(namespace + ".payMonth", use_work_num);
	}

	@Override
	public List<HashMap<String, Object>> payInfo(int use_work_num) {
		return session.selectList(namespace + ".payInfo", use_work_num);
	}

	

}
