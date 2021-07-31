package com.encore.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductDAO;

@Repository
public class MyProductDAOImpl implements MyProductDAO{

	@Autowired
	private SqlSession sqlSession;
	
	private final String NS = "ProductMapper.";
	
	@Override
	public void addProduct(MyProduct vo) throws Exception {
		sqlSession.insert(NS+"addProduct", vo);
		
	}

	@Override
	public List<MyProduct> findByProductName(String name) throws Exception {
		
		return sqlSession.selectList(NS+"findByProductName", name);
	}

	@Override
	public List<MyProduct> findProducts() throws Exception {
		return sqlSession.selectList(NS+"findProducts");
	}

	@Override
	public List<MyProduct> findByProductMaker(String maker) throws Exception {
		return sqlSession.selectList(NS+"findByProductMaker",maker);
	}

	@Override
	public boolean updateProduct(MyProduct vo) throws Exception {
		int result=sqlSession.update(NS+"updateProduct", vo);
		if(result>0) return true;
		return false;
	}

	@Override
	public boolean deleteProduct(int id) throws Exception {
		int result=sqlSession.delete(NS+"deleteProduct", id);
		if(result>0) return true;
		return false;	
	}

}
