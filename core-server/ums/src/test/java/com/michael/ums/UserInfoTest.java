package com.michael.ums;

import com.alibaba.nacos.common.util.Md5Utils;
import com.michael.api.server.entity.UserInfo;
import com.michael.ums.mapper.UserInfoMapper;
import com.michael.ums.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserInfoTest {

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    IUserInfoService userInfoService;


    @Test
    public void testInsert(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString().toLowerCase());
        userInfo.setUserName("michael001");
        userInfo.setPassword(""+Md5Utils.getMD5("123456".getBytes()));
        userInfo.setPhone("13928463906");
        userInfo.setNikeName("michael");
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());
        boolean save = userInfoService.save(userInfo);
        System.out.println(save);
    }


    /**
     * 通过自定义SQL查询
     */
    @Test
    public void testGetUserById(){
        log.info("  ======= "+userInfoMapper.getUserById(1));
    }


    @Test
    public void selectLit(){

        log.info(" data : "+userInfoService.list());
    }
}
