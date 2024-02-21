package com.iswar.thymeleafdemo.controller;

import com.iswar.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    List<String> countries ;

    @Value("${os}")
    List<String> os ;

    @Value("${languages}")
    List<String> languages ;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries",countries);
        theModel.addAttribute("languages",languages);
        theModel.addAttribute("os",os);
        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm (@ModelAttribute Student theStudent){
        // logging the data
        System.out.println("Student " + "firstName= " + theStudent.getFirstName() + " lastName= " + theStudent.getLastName() + " Country= " + theStudent.getCountry());
        return "student-conformation";
    }
}
