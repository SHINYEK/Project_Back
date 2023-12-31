package com.example.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PayVO;
import com.example.domain.StubVO;

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

	@Override
	public List<HashMap<String, Object>> payStub(String stub_name, int use_work_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stub_name", "%"+stub_name+"%");
		map.put("use_work_num", use_work_num);
		return session.selectList(namespace + ".payStub", map);
	}

	@Override
	public HashMap<String, Object> staffPay(String use_name, int use_work_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("use_name", use_name);
		map.put("use_work_num", use_work_num);
		return session.selectOne(namespace + ".staffPay", map);
	}

	@Override
	public int payMore(String use_name, int use_work_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("use_name", use_name);
		map.put("use_work_num", use_work_num);
	    Integer result = session.selectOne(namespace + ".payMore", map);

	    if (result == null) {
	        result = 0;
	    }

	    return result;
	}

	@Override
	public void insertStub(StubVO vo) {
		session.insert(namespace + ".insertStub", vo);
	}

	@Override
	public void insertPay(PayVO vo) {
		session.insert(namespace + ".insertPay", vo);
	}

	@Override
	public List<HashMap<String, Object>> staffStub(int use_id) {
		return session.selectList(namespace + ".staffStub", use_id);
	}

	@Override
	public List<HashMap<String, Object>> payChart(int use_id) {
		return session.selectList(namespace + ".payChart", use_id);
	}

	@Override
	public List<HashMap<String, Object>> payToday(int use_id) {
		return session.selectList(namespace + ".payToday", use_id);
	}

	@Override
	public int payUntill(int use_id, String date) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("use_id", use_id);
		map.put("date", date);
		Integer result = session.selectOne(namespace + ".payUntill", map);
		return result != null ? result.intValue() : 0;
	}

	@Override
	public void deleteStub(int stub_id) {
		session.delete(namespace + ".deleteStub", stub_id);
	}

	@Override
	public void deletePay(String pay_name) {
		session.delete(namespace + ".deletePay", pay_name);
	}

	

}
