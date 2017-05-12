package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.sort.NumberSorting;

@Controller
public class EmpController {
	
	@RequestMapping("/sortform")  
	public ModelAndView showform(){  
	   //command is a reserved request attribute name, now use <form> tag to show object data  
	        return new ModelAndView("sortform","command", null);  
	}   

	@RequestMapping(value="/sorting", method = RequestMethod.POST)
	public ModelAndView sorting(@RequestParam("enteredValue") int enteredValue){
		NumberSorting numberSorting = new NumberSorting();
		return new ModelAndView("viewresult","sorting",numberSorting.sortingNumber(enteredValue));
	}
}
