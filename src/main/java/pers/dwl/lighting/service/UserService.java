package pers.dwl.lighting.service;

import pers.dwl.lighting.domain.User;

public interface UserService {

    boolean userLogin(String userName,String userPwd);

    User findUserByName(String userName);
}
