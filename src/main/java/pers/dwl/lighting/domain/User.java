package pers.dwl.lighting.domain;

import javax.validation.constraints.NotEmpty;

/**
 * 用户实体类
 */
public class User {
    /*用户主键*/
    private String userId;
    /*用户名*/
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    /*密码*/
    @NotEmpty(message = "密码不能为空")
    private String userPwd;
    /*性别*/
    private String sex;
    /*状态*/
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
