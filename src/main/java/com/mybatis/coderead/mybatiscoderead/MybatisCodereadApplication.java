package com.mybatis.coderead.mybatiscoderead;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisCodereadApplication {

    public static void main(String[] args) {

        //1 第一阶段：MyBatis 初始化阶段
        String resource = "mybatis-configuration.xml";
        //1 得到配置文件的输入流
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Session Factory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //11 第二阶段：数据读写阶段
        try (SqlSession session = sqlSessionFactory.openSession()) {
            //1 找到接口对应的实现
            UserMapper userMapper = session.getMapper(UserMapper.class);
            //1 / 组建查询参数
            User userParam = new User();
            userParam.setSchoolName("tju");//调用接口展开数据库操作
            List<User> userList = userMapper.queryUserBySchoolName(userParam);
            // 打印查询结果
            for (User user : userList) {
                System.out.println("name : " + user.getName() + " ; email : " + user.getEmail());
                SpringApplication.run(MybatisCodereadApplication.class, args);
            }
        }

    }
}
