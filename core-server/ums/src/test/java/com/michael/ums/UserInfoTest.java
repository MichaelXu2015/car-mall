package com.michael.ums;

import com.alibaba.nacos.common.util.Md5Utils;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;
import com.michael.api.server.ums.entity.UserInfo;
import com.michael.ums.mapper.UserInfoMapper;
import com.michael.ums.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.plaf.synth.SynthPasswordFieldUI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class UserInfoTest {


    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    IUserInfoService userInfoService;


    @Test
    public void testGuava(){
        List<String> list = Lists.newArrayList();
        Set<String> set = Sets.newHashSet();

        Multimap<String,Integer> map = ArrayListMultimap.create();
        map.put("aa",1);
        map.put("bb",2);
        //System.out.println(map.get("aa"));

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("a","a");
        biMap.put("a","a");
        //System.out.println(biMap.size());

        List<String> listStr = Lists.list("a","b","c");
        String result = Joiner.on(",").join(listStr);
        //System.out.println(result);

        String str = "A-B-C";
        List<String> stringList = Splitter.on("-").splitToList(str);
        stringList.forEach(str2-> System.out.println(str2));

    }

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
