package com.training.jdbc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.training.jdbc.model.Employee;
import com.training.jdbc.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerIntegrationTest {

private MockMvc mockMvc;
    
    @Autowired
    private WebApplicationContext webapplicationcontext;
    
    @MockBean
    private EmployeeService empService;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webapplicationcontext).build();
    }

    @After
    public void tearDown() throws Exception {
        mockMvc=null;
    }

    @Test
    public void testListEmployees() throws Exception{
        assertThat(this.empService).isNotNull();
        
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee());
        empList.get(0).setId(3);
        empList.get(0).setName("Demo");
        empList.get(0).setSalary(47348.85);
        empList.get(0).setDateOfJoining(LocalDate.now());
        
        when(empService.listEmployees()).thenReturn(empList);
        
        mockMvc.perform(get("/listEmps"))
        .andExpect(status().isOk())
        .andExpect(view().name("empList"))
        .andExpect(model().attributeExists("emps"))
        .andExpect(model().attribute("emps", empList))
        .andDo(print());
        
//      mockMvc.perform(post("/addEmp", empList.get(0)))
//      .andDo(print());
        
    }
    
    @Test
    public void testAddEmployee() throws Exception{
        assertThat(this.empService).isNotNull();
        
        Employee emp = new Employee();
        emp.setId(3);
        emp.setName("Demo");
        emp.setSalary(47348.85);
        emp.setDateOfJoining(LocalDate.now());
        
        when(empService.addEmployee(emp)).thenReturn(emp);
        
        mockMvc.perform(get("/addEmp"))
        .andExpect(status().isOk())
        .andExpect(view().name("addEmp"))
        .andExpect(model().attributeExists("emp"))
        .andDo(print());
        
        mockMvc.perform(post("/addEmp", emp))
        .andDo(print());
        
    }
    

}
