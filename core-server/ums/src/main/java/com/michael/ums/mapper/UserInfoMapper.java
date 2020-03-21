package com.michael.ums.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.michael.api.server.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {


    UserInfo getUserById(Integer id);

}
