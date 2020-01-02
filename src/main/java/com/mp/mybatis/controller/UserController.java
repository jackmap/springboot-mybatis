package com.mp.mybatis.controller;

import com.mp.mybatis.config.TargetDataSource;
import com.mp.mybatis.datasource.DataSourceType;
import com.mp.mybatis.entity.SysUser;
import com.mp.mybatis.service.UserMasterService;
import com.mp.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMasterService userMasterService;

    @GetMapping("/user")
   // @TargetDataSource(DataSourceType.MASTER)
    public ResponseEntity<Object> listAll(){
        List<SysUser> result = userService.listAll();
        return ResponseEntity.ok(result);

    }

    @GetMapping("/user1")
  //  @TargetDataSource(DataSourceType.SLAVE)
    public ResponseEntity<Object> listAlla() {
        List<SysUser> result = userMasterService.listAll();
        return ResponseEntity.ok(result);
    }
}