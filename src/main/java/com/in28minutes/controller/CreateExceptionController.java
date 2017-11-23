package com.in28minutes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CreateExceptionController {


	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String showWecomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/createException", method = RequestMethod.POST)
	public String throwException(ModelMap model) {
		System.out.println("Error : here....");
		String exception = null;
		exception.toCharArray();

		return "error";
	}
}
