package com.app.pojos;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.StudentDaoImple;

@Controller
public class HomeController {
	
	@Autowired
	StudentDaoImple studentdao;
	
	@GetMapping("/")
	public String home(Model map) {
		
		map.addAttribute("liststudent", studentdao.listAll());
		return "index";
	}
	
	@GetMapping("/new")
	public String addStudent(Model map) {
		map.addAttribute("student", new Student());
		return "new";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		studentdao.delete(id);
		return "redirect:/";
		
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student")Student student) {
		studentdao.save(student);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable long id,Model map) {
		System.out.println("in edit student controller");
		 map.addAttribute("student",studentdao.getById(id));
		return "new";
		
	}

}
