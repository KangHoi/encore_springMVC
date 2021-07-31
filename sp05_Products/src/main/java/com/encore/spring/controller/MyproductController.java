package com.encore.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductCatalog;

@Controller
public class MyproductController {
	
	@Autowired
	private MyProductCatalog myProductCatalog;
	
//	@RequestMapping(value = "myProduct.do", method=RequestMethod.POST) //원래 정석
	@RequestMapping("myProduct.do")
	public ModelAndView myProduct(String name, String maker, int price) throws Exception{
		MyProduct product = new MyProduct(name,maker, price);
		myProductCatalog.addMyproduct(product);
		return new ModelAndView("WEB-INF/results/myProductView.jsp");
	}
	
//	@RequestMapping("myProduct.do")
//	public ModelAndView insert(MyProduct pvo) throws Exception{
//		System.out.println("폼으로부터 받은 데이터" + pvo.getId()); // 0
//		myProductCatalog.addMyproduct(pvo);
//		
//		System.out.println("폼으로부터 받은 데이터" + pvo.getId()); // 6,7...
//		return new ModelAndView("WEB-INF/views/myProductView.jsp", "info", pvo);
//	}
	
	@RequestMapping("mySearch.do")
	public ModelAndView mySearch(String word) throws Exception{
		if(word.matches("[0-9]+")){
			MyProduct myproduct = myProductCatalog.getMyproduct(Integer.parseInt(word));
			return new ModelAndView("WEB-INF/results/mySearchView.jsp","myproduct", myproduct);	
		}
		else {
			List<MyProduct> list = myProductCatalog.getMyproductList(word);
			System.out.println(list);
			return new ModelAndView("WEB-INF/results/mySearchListView.jsp","list", list);	
		}
	}
	

}
