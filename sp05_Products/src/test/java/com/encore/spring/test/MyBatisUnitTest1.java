package com.encore.spring.test;

import java.io.Reader;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.encore.spring.domain.MyProduct;

//MyBatisFramework 단위 테스트 
public class MyBatisUnitTest1 {

	public static void main(String[] args) throws Exception{
		//1. 설정문서 읽어들여서
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. Sql Session
		SqlSession session = factory.openSession();
		
		//4. 쿼리문 실행
		MyProduct product = new MyProduct("공기청정기","LG", 350000);
		session.insert("MyproductMapper.addMyproduct", product);
		
		List<MyProduct> list = session.selectList("MyproductMapper.getMyproductList","");
		for(MyProduct vo : list) System.out.println(vo);
		
		System.out.println("\n===========================================\n");
		
		MyProduct myproduct = session.selectOne("MyproductMapper.getMyproduct", 2);
		System.out.println(myproduct);

	}

}
