package com.controller;

import com.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/user")
    public String create(Model model) {
        return "/user/create";
    }

    @GetMapping("/user/create")
    public String abc(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        List<String> locationList = new ArrayList<>(List.of("Dhaka","Tangail","Mymenshingh")); /* ekhan theke (locationList) ti /user/create.jsp page er locatoin er option create korbe ja amra dekhte parbo */
        model.addAttribute("locationList",locationList); // (locationList) ti create kore pathiye dilam. Nahole browser ay option show korbe na
        return "/user/create";
    }
}
