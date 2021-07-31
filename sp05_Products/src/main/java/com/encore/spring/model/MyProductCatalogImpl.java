package com.encore.spring.model;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.MyProduct;

@Service
@Transactional
public class MyProductCatalogImpl implements MyProductCatalog{

	@Autowired
	private MyProductDAO myproductDAO;
	
	@Transactional
	@Override
	public void addMyproduct(MyProduct myproduct) throws Exception {
		int result = myproductDAO.addMyproduct(myproduct);
		if(result==1) System.out.println("상품을 추가했습니다!");
	}

	@Override
	public List<MyProduct> getMyproductList(String key) throws Exception {
		return myproductDAO.getMyproductList(key);
		
	}

	@Override
	public MyProduct getMyproduct(Integer id) throws Exception {
		return myproductDAO.getMyproduct(id);
	}
	
}
