package com.michael.ums;

import com.alibaba.nacos.common.util.Md5Utils;
import com.michael.api.server.ums.entity.UserInfo;
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
    public void testR(){
        /*UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setNikeName("michael");

        System.out.println(new Gson().toJson(R.data(userInfo)));
        System.out.println(new Gson().toJson(R.data(300,userInfo)));
        System.out.println(new Gson().toJson(R.data(300,userInfo,"这个用户太好了")));
        System.out.println(new Gson().toJson(R.data(userInfo,"哈哈")));
        System.out.println(new Gson().toJson(R.success("修改成功")));
        System.out.println(new Gson().toJson(R.success(RespEnum.SUCCESS,"更新成功")));
        System.out.println(new Gson().toJson(R.fail("修改失败")));
        System.out.println(new Gson().toJson(R.success(RespEnum.FAIL,"更新失败")));
        System.out.println(new Gson().toJson(R.status(true)));
        System.out.println(new Gson().toJson(R.status(false)));*/
    }


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
