package com.example.leapsquar.repositories.interfaces;

import com.example.leapsquar.dtos.UserInfoDto;

import java.util.List;

public interface UserInfoRepository {
    void addUser(UserInfoDto userInfoDto);
    List<UserInfoDto> getUser(String name);
    void deleteUser(String name);
}
