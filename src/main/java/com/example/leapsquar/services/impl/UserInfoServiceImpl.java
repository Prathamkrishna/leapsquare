package com.example.leapsquar.services.impl;

import com.example.leapsquar.dtos.UserInfoDto;
import com.example.leapsquar.repositories.interfaces.UserInfoRepository;
import com.example.leapsquar.services.interfaces.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void addUser(UserInfoDto userInfoDto) {
        userInfoRepository.addUser(userInfoDto);
    }

    @Override
    public List<UserInfoDto> getAllUsers(String name) {
        return userInfoRepository.getUser(name);
    }

    @Override
    public void deleteUser(String name) {
        userInfoRepository.deleteUser(name);
    }
}
