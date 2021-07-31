package com.encore.spring.model;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.encore.spring.domain.MyProduct;

//Transaction 처리는 1)설정문서  2)인터페이스 3)~impl 클래스 4)처리하고자하는 메소드에 지정하면 된다. 

@Transactional
public interface MyProductCatalog {
	void addMyproduct(MyProduct myproduct) throws Exception;
	List<MyProduct> getMyproductList(String key) throws Exception;
	MyProduct getMyproduct(Integer id) throws Exception;
	
}
