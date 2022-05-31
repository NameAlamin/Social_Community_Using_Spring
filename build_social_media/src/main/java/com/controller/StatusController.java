package com.controller;

import com.dao.LocationDao;
import com.dao.StatusDao;
import com.dto.StatusDto;
import com.entity.Location;
import com.entity.Status;
import com.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private StatusDao statusDao;

    @GetMapping("/create")
    public String formSubmit(Model model){
        StatusDto statusDto = new StatusDto();
        model.addAttribute("statusDto",statusDto);

        List<Location> locations = locationDao.getAll();
        List<String> locationList = new ArrayList<>();
        for (Location location:locations) {
            locationList.add(location.getLocationName());
        }
        model.addAttribute("locationList",locationList);

        List<String> privacyList = new ArrayList<>(List.of("public","private"));
        model.addAttribute("privacyList",privacyList);
        return "status/create";
    }

    @PostMapping("/store")
    public String storeStatus(Model model, @ModelAttribute("statusDto") StatusDto statusDto){
        Status status = new Status();
        BeanUtils.copyProperties(statusDto,status);
        statusDao.store(status);
        model.addAttribute("status",status);
        return "status/show";
    }

    @GetMapping("/list")
    public String maintain(Model model) {

        List<Status> statusList = statusDao.getAll();
        model.addAttribute("statusList", statusList);

        return "status/list";
    }
}
