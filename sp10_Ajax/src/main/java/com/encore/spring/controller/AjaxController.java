package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.Person;

@Controller
public class AjaxController {
	
	@RequestMapping("/") //contextPath로 요청을 한다면... http://127.0.0.1:8888/spring
	public String index() {
		System.out.println("/....calling..");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("synchro")
	public String synchro(Model model) {
		model.addAttribute("info", "우와~~ 동기통신!!");
		System.out.println("동기 통신.. synchro() calling...");
		
		return "synchro_result";
	}
	
	@RequestMapping("asynch")
	public String asynch(Model model) {
		System.out.println("비동기 통신... asynchro() calling...");
		//비즈니스 로직 수행 결과로.. Service 호출 결과... person 객체가 리턴되었다고 가정하자.
		model.addAttribute("person", new Person("강호이", "서초동"));
		return "JsonView";
	}
}


