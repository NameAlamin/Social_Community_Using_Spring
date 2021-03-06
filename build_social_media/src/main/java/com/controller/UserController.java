package com.controller;

import com.dao.LocationDao;
import com.dao.UserDao;
import com.dto.UserDto;
import com.entity.Location;
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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LocationDao locationDao;

    @GetMapping("/create")
    public String createUser(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);

        List<Location> locations = locationDao.getAll();
        List<String> locationList = new ArrayList<>();
        for (Location location:locations) {
            locationList.add(location.getLocationName());
        }
        model.addAttribute("locationList",locationList);

        return "user/create";
    }
    @PostMapping("/store")
    public String storeUser(Model model, @ModelAttribute("userDto") UserDto userDto){

        Location location = locationDao.getByName(userDto.getLocation()); // create method locationDao
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLocation(location);
        userDao.store(user);
        location.getUserList().add(user);
        locationDao.update(location);
        model.addAttribute("user",user);

//        User user = new User();
//        BeanUtils.copyProperties(userDto,user);
//        userDao.store(user);
//        model.addAttribute("user",user);
        return "user/show";
    }

    @GetMapping("/maintain")
    public String maintain(Model model) {

        List<User> userList = userDao.getAll();
        model.addAttribute("userList", userList);

        return "user/list";
    }
}
