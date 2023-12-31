package com.example.dao;

import java.util.HashMap;
import java.util.List;

import com.example.domain.PayVO;
import com.example.domain.StubVO;

public interface PayDAO {
	public HashMap<String, Object> staffPay(String use_name, int use_work_num);
	public String paySum(int use_work_num);
	public int staffTotal(int use_work_num);
	public String tempPaySum(int use_work_num);
	public List<HashMap<String, Object>> staffType(int use_work_num);
	public List<HashMap<String, Object>> payMonth(int use_work_num);
	public List<HashMap<String, Object>> payInfo(int use_work_num);
	public List<HashMap<String, Object>> payStub(String wtub_name, int use_work_num);
	public int payMore(String use_name, int use_work_num);
	public void insertStub(StubVO vo);
	public void insertPay(PayVO vo);
	public List<HashMap<String, Object>> staffStub(int use_id);
	public List<HashMap<String, Object>> payChart(int use_id);
	public List<HashMap<String, Object>> payToday(int use_id);
	public int payUntill(int use_id, String date);
	public void deleteStub(int stub_id);
	public void deletePay(String pay_name);
}
