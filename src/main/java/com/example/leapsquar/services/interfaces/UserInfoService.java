package com.example.leapsquar.services.interfaces;

import com.example.leapsquar.dtos.UserInfoDto;

import java.util.List;

public interface UserInfoService {
    void addUser(UserInfoDto userInfoDto);
    List<UserInfoDto> getAllUsers(String name);
    void deleteUser(String name);
}
