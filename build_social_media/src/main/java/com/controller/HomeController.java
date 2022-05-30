package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
//    @Autowired
//    private StudentDao studentDao;

    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
//    @GetMapping("/createForm")
//    public String getFormValueHere(Model model){
//        Student student = new Student();
//        model.addAttribute("student",student);
//        List<String> sectionList = new ArrayList<>(List.of("A","B","C","D","E"));
//        model.addAttribute("sectionList",sectionList);
//        return "createForm";
//    }
//    @PostMapping("/successMsg")
//    public String saveDataInDatabase(Model model, @ModelAttribute("student") Student student){
//        System.out.printf(student.toString());
//        studentDao.createUser(student);
//        return "successMsg";
//    }
}
