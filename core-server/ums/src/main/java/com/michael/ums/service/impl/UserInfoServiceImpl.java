package com.michael.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.michael.api.server.ums.entity.UserInfo;
import com.michael.ums.mapper.UserInfoMapper;
import com.michael.ums.service.IUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper,UserInfo> implements IUserInfoService {


}
