package com.controller;

import com.entity.Status;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StatusController {
    @GetMapping("/status")
    public String statusForm(Model model){
        return "/status/create";
    }
    @GetMapping("/status/create")
    public String formSubmit(Model model){
        Status status = new Status();
        model.addAttribute("status",status);

        List<String> locationList = new ArrayList<>(List.of("Dhaka","Tangail","Mymenshingh")); /* ekhan theke (locationList) ti /user/create.jsp page er locatoin er option create korbe ja amra dekhte parbo */
        model.addAttribute("locationList",locationList); // (locationList) ti create kore pathiye dilam. Nahole browser ay option show korbe na

        List<String> privacyList = new ArrayList<>(List.of("public","private"));
        model.addAttribute("privacyList",privacyList);
        return "/status/create";
    }
}
