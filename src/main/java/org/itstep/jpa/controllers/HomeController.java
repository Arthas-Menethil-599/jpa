package org.itstep.jpa.controllers;

import lombok.extern.slf4j.Slf4j;
import org.itstep.jpa.entities.Student;
import org.itstep.jpa.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class HomeController {

    private final StudentService service;

    public HomeController(final StudentService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        List<Student> students = service.getAllStudent();
        model.addAttribute("student", new Student());
        model.addAttribute("students", students);
        return "index";
    }

    @PostMapping(value = "/add-student")
    public String addStudent(@ModelAttribute Student student) {
        service.addStudent(student);
        return "redirect:/";
    }

    @GetMapping(value="/search/{id}")
    public String searchStudent(@PathVariable("id") Long id, Model model) {
        Student student = service.getStudent(id);
        model.addAttribute("studentData", student);
        return "student";
    }

    @DeleteMapping(value="/delete-student/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        service.deleteStudent(id);
        return "redirect:/";
    }

    @PutMapping(value="/update-student/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute Student student) {
        student.setId(id);
        service.updateStudent(student);
        return "redirect:/";
    }

}
