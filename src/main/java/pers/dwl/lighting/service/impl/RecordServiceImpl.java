package pers.dwl.lighting.service.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.dwl.lighting.dao.RecordDao;
import pers.dwl.lighting.domain.Record;
import pers.dwl.lighting.service.RecordService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: lighting
 * @description: 记录接口实现类
 * @author: daiwenlong
 * @create: 2018-04-15 10:40
 **/
@Service
public class RecordServiceImpl implements RecordService{

    @Autowired
    private RecordDao recordDao;


    public Record findTRecordById(String userId) {
        return recordDao.findTRecordById(userId);
    }


    public List<Record> findMRecord(String userId, int first, int size) {
        return recordDao.findMRecordById(userId,first,size);
    }

    public int insertRecord(Record record) {
        record.setDate(new Date());
        return recordDao.insertRecord(record);
    }

    public Map<String, Object> getData(String userId, int first, int size) {
        Map<String, Object> result = new HashMap<>();
        List<Record> list = recordDao.findMRecordById(userId,first,size);
        List<String> date = new ArrayList<>();
        List<Double> weight = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        Collections.reverse(list);
        list.forEach(info->{
            date.add(format.format(info.getDate()));
            weight.add(info.getWeight());
        });
        result.put("date", JSON.toJSONString(date));
        result.put("weight",weight.toString());
        return result;
    }

    public Map<String, Object> getResult(String userId, int first, int size) {

       return null;
    }
}


