package com.cvnchina.emsquartz.service.business.impl;

import com.cvnchina.emsquartz.report.dataaccess.UserMapper;
import com.cvnchina.emsquartz.report.domain.User;
import com.cvnchina.emsquartz.service.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by Primo on 2016/8/24.
 * project: EMSQuartz
 * package: com.cvnchina.emsquartz.service.business
 * COPYRIGHT BY CVNCHINA 2016.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    public void add() {
        try{
            Random random = new Random(10);
            String name = "name"+random.nextInt();
            User user = new User();
            user.setName(name);
            userMapper.addUser(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int getUserNum() {
        return userMapper.getUserNum();
    }
}
