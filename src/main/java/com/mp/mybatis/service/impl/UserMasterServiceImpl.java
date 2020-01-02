package com.mp.mybatis.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.mp.mybatis.config.TargetDataSource;
import com.mp.mybatis.entity.SysUser;
import com.mp.mybatis.mapper.SysUserMapper;
import com.mp.mybatis.service.UserMasterService;
import com.mp.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserMasterServiceImpl implements UserMasterService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    @TargetDataSource("datasource2")
    public List<SysUser> listAll() {
        return sysUserMapper.findAll();
    }
}
