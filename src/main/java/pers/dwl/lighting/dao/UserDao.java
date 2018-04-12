package pers.dwl.lighting.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pers.dwl.lighting.domain.User;

/**
 * 用户dao接口
 */
@Mapper
public interface UserDao {

    @Select("SELECT * FROM T_USER_INFO WHERE USER_NAME = #{userName}")
    @Results({
            @Result(property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPwd",column = "user_pwd"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "status",column = "status"),
    })
    User findByName(String userName);
}
