package pers.dwl.lighting.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pers.dwl.lighting.dao.UserDao;
import pers.dwl.lighting.domain.User;
import pers.dwl.lighting.service.UserService;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public boolean userLogin(String userName, String userPwd) {
        User user = userDao.findByName(userName);
        if(null == user)
            return false;
        if(userPwd.equals(user.getUserPwd()))
            return true;
        return false;
    }
}
