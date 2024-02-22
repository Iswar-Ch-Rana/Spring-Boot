package com.iswar.springboot.thymeleafdemo.controller;

import com.iswar.springboot.thymeleafdemo.entity.Employee;
import com.iswar.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model model) {
        // add the employee from db
        List<Employee> employeeList = employeeService.findAll();
        // add to spring model
        model.addAttribute("employees", employeeList);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        // Create model Attribute to Bind form data
        Employee employee = new Employee();

        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee
        employeeService.save(employee);

        // use redirect to prevent duplicate submission
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate (@RequestParam("employeeId") int Id , Model model){
        // get employee from service
        Employee employee = employeeService.findById(Id);
        // set employee in the model to populate the form
        model.addAttribute("employee",employee);
        // send over to the form

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId")int Id){
        employeeService.deleteById(Id);
        return "redirect:/employees/list";
    }
}
