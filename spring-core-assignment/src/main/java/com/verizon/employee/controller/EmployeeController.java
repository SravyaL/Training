package com.verizon.employee.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.verizon.employee.model.Employee;
import com.verizon.employee.service.EmployeeService;
 
@Controller
public class EmployeeController {
 
    @Autowired
    private EmployeeService  empService;
    
    @GetMapping({"","/","home"})
    public ModelAndView defaultEmpController(){
        return new ModelAndView("index","emps",empService.getAllEmployees());
    }
    
    @GetMapping("/addEmp")
    public ModelAndView addBookAction(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeForm");
        mv.addObject("emp",new Employee());
        mv.addObject("possibDept", new String[]{"VES","VBS","VCM","NTIT"});
        return mv;
    }
    @PostMapping("/saveEmp")
    public String saveEmpAction(@ModelAttribute Employee emp){
        if(empService.getEmpById(emp.getEid())==null)
            empService.addEmp(emp);
        else
            
            empService.updateEmp(emp);
        return "redirect:/home";
    }
    @GetMapping("/editEmp")
    public ModelAndView editBookAction(@RequestParam("empId")int empId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employeeForm");
        mv.addObject("emp",empService.getEmpById(empId));
        mv.addObject("possibDept", new String[]{"VES","VBS","VCM","NTIT"});
        return mv;
    }
    @GetMapping("/deleteEmp")
    public String deleteEmpAction(@RequestParam("empId")int empId){
        empService.deleteEmpById(empId);
        return "redirect:/home";
    }
}
