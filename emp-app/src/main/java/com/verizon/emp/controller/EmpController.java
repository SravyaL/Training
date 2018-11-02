package com.verizon.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.verizon.emp.model.Emplyoee;
import com.verizon.emp.service.EmpService;

@Controller
public class EmpController {

	@Autowired
	private EmpService  empService;
	
	@GetMapping({"","/","home"})
	public ModelAndView defaultEmpController(){
		return new ModelAndView("index","emps",empService.getAllEmp());
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addBookAction(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookFormPage");
		mv.addObject("emp",new Emplyoee());
		mv.addObject("possibDept", new String[]{"CSE","ECE","CIVIL"});
		return mv;
	}
	@PostMapping("/saveEmp")
	public String saveEmpAction(@ModelAttribute Emplyoee emp){
		if(empService.getEmpById(emp.getEmpId())==null)
			empService.addEmp(emp);
		else
			
			empService.updateEmp(emp);
		return "redirect:/home";
	}
	@GetMapping("/editEmp")
	public ModelAndView editBookAction(@RequestParam("empId")int empId){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bookFormPage");
		mv.addObject("emp",empService.getEmpById(empId));
		mv.addObject("possibDept", new String[]{"CSE","ECE","CIVIL"});
		return mv;
	}
	@GetMapping("/deleteEmp")
	public String deleteEmpAction(@RequestParam("empId")int empId){
		empService.deleteEmpById(empId);
		return "redirect:/home";
	}
}
