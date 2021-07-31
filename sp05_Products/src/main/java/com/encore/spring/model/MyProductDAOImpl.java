package com.encore.spring.model;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private static final String NS = "MyproductMapper.";
	
	@Override
	public int addMyproduct(MyProduct myproduct) throws Exception {
		return sqlSession.insert(NS+"addMyproduct", myproduct);
	}

	@Override
	public List<MyProduct> getMyproductList(String key) throws Exception {
		return sqlSession.selectList(NS+"getMyproductList", key);
	}

	@Override
	public MyProduct getMyproduct(Integer id) throws Exception {
		return sqlSession.selectOne(NS+"getMyproduct", id);
	}
	
}
