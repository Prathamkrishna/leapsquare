package com.example.leapsquar.repositories.impl;

import com.example.leapsquar.dtos.UserInfoDto;
import com.example.leapsquar.repositories.interfaces.UserInfoRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserInfoRepositoryImpl implements UserInfoRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserInfoRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addUser(UserInfoDto userInfoDto) {
        String sql = "Insert into userdetails (username, userage, useradress, machinesowned) values (:userName," +  userInfoDto.getUserAge() + ", :userAddress," + userInfoDto.getMachinesOwned() + ");";
        Map<String , String> map = new HashMap<>();
        map.put("userName", userInfoDto.getUserName());
        map.put("userAddress", userInfoDto.getUserAddress());
        try {
            namedParameterJdbcTemplate.update(sql, map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<UserInfoDto> getUser(String name) {
        String sql = "Select * from userdetails where username = :name;";
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        UserInfoDto userInfoDto = null;
        try {
            userInfoDto = namedParameterJdbcTemplate.queryForObject(sql, map, this::mapRow);
        } catch (Exception e){
            e.printStackTrace();
        }
        UserInfoDto finalUserInfoDto = userInfoDto;
        return new ArrayList<UserInfoDto>(){{add(finalUserInfoDto);}};
    }

    @Override
    public void deleteUser(String name) {
        String sql = "delete from userdetails where username = :name;";
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        try {
            namedParameterJdbcTemplate.update(sql, map);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    protected UserInfoDto mapRow(ResultSet rs, int arg1) throws SQLException {
        System.out.println(arg1);
        UserInfoDto userInfoDto = new UserInfoDto();
        userInfoDto.setUserAge(rs.getInt("userage"));
        userInfoDto.setUserAddress(rs.getString("useradress"));
        userInfoDto.setMachinesOwned(rs.getInt("machinesowned"));
        userInfoDto.setUserName(rs.getString("username"));
        return userInfoDto;
    }
}
