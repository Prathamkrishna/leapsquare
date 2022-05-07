package com.example.leapsquar.controllers;

import com.example.leapsquar.dtos.UserInfoDto;
import com.example.leapsquar.services.interfaces.UserInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody UserInfoDto userInfoDto){
        userInfoService.addUser(userInfoDto);
    }

    @GetMapping("/getUser/{name}")
    public List<UserInfoDto> getUser(@PathVariable String name){
        return userInfoService.getAllUsers(name);
    }

    @DeleteMapping("/deleteUser/{name}")
    public void deleteUser(@PathVariable String name){
        userInfoService.deleteUser(name);
    }

    @PostMapping("updateUser/{name}")
    public void updateUser(@PathVariable String name, @RequestBody UserInfoDto userInfoDto){
        userInfoService.deleteUser(name);
        userInfoService.addUser(userInfoDto);
    }
}
