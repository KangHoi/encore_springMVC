package com.encore.spring.model;

import java.util.List;


import com.encore.spring.domain.MyProduct;

public interface MyProductDAO {
	int addMyproduct(MyProduct myproduct) throws Exception;
	List<MyProduct> getMyproductList(String key) throws Exception;
	MyProduct getMyproduct(Integer id) throws Exception;
	
}
