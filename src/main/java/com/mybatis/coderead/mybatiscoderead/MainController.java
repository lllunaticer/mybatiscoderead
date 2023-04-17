package com.mybatis.coderead.mybatiscoderead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/")
public class MainController {
//    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public Object index(){
        User userParam = new User();
        userParam.setSchoolName("tju");
        return userMapper.queryUserBySchoolName(userParam);
    }
}
