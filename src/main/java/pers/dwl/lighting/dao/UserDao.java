package pers.dwl.lighting.dao;

import org.apache.ibatis.annotations.Mapper;
import pers.dwl.lighting.domain.User;

/**
 * 用户dao接口
 */
@Mapper
public interface UserDao {

    User findByName(String userName);
}
