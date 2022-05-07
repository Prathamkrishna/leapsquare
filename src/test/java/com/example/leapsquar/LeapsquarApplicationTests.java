package com.example.leapsquar;

import com.example.leapsquar.controllers.UserInfoController;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.leapsquar.repositories.interfaces.UserInfoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LeapsquarApplicationTests {

    @Autowired
    private UserInfoController userInfoController;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void checkEndpoint(){
        assertThat(userInfoController).isNotNull();
    }

    @Test
    void findByUserTest(){
        String name = "p";
        assertThat(userInfoRepository.getUser(name).get(0).getUserName()).isEqualTo("p");
    }

}
