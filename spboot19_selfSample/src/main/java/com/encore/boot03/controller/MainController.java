package com.encore.boot03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("sample.do")
	public String sample(Model model) {
		model.addAttribute("msg", "SampleSample~");
		return "find_good";
	}
}
