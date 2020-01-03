package com.mp.mybatis.service.impl;

import com.mp.mybatis.config.TargetDataSource;
import com.mp.mybatis.datasource.DataSourceType;
import com.mp.mybatis.entity.SysUser;
import com.mp.mybatis.mapper.SysUserMapper;
import com.mp.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    @TargetDataSource(DataSourceType.MASTER)
    public List<SysUser> listAll() {

        return sysUserMapper.findAll();
    }
}
