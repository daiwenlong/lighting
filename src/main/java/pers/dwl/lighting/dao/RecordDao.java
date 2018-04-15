package pers.dwl.lighting.dao;

import org.apache.ibatis.annotations.*;
import pers.dwl.lighting.domain.Record;

import java.util.List;

/**
* @Description:记录接口
* @Date: 2018/4/15
*/
@Mapper
public interface RecordDao {
    /**
    * @Description:获取当天数据
    * @Param: [userId]
    * @return: pers.dwl.lighting.domain.Record
    * @Date: 2018/4/15
    */ 
    @Select("select * from  t_record_info where user_id = #{userId} and date(date) = curdate()")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "weight", column = "weight"),
            @Result(property = "date", column = "date"),
            @Result(property = "userId", column = "user_id")
    })
    Record findTRecordById(String userId);

    /**
    * @Description:获取更多数据
    * @Param: [userId, first, size]
    * @return: java.util.List<pers.dwl.lighting.domain.Record>
    * @Date: 2018/4/15
    */
    @Select("select * from  t_record_info where user_id = #{userId} order by date desc limit #{first},#{size}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "weight", column = "weight"),
            @Result(property = "date", column = "date"),
            @Result(property = "userId", column = "user_id")
    })
    List<Record> findMRecordById(@Param("userId")String userId,@Param("first")int first,@Param("size")int size);

    /**
    * @Description: 插入新纪录
    * @Param: [record]
    * @return: int
    * @Date: 2018/4/15
    */ 
    @Insert("insert into t_record_info (weight,date,user_id)values(#{weight},#{date},#{userId})")
    int insertRecord(Record record);


}
