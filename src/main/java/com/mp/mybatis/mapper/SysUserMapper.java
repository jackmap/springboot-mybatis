package com.mp.mybatis.mapper;

import com.mp.mybatis.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;



@Mapper
public interface SysUserMapper {

    List<SysUser>   findAll() ;
}
