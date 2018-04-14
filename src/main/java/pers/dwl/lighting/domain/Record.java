package pers.dwl.lighting.domain;

import java.util.Date;

/**
 * @program: lighting
 * @description: 体重记录实体
 * @author: daiwenlong
 * @create: 2018-04-14 17:15
 **/
public class Record {

    /*主键*/
    private int id;
    /*体重数*/
    private double weight;
    /*记录日期*/
    private Date date;
    /*用户id*/
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}


