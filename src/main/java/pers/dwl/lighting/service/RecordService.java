package pers.dwl.lighting.service;

import pers.dwl.lighting.domain.Record;

import java.util.List;
import java.util.Map;

/**
* @Description:记录
* @Date: 2018/4/15
*/ 
public interface RecordService {

    Record findTRecordById(String userId);

    List<Record> findMRecord(String userId,int first,int size);

    int insertRecord(Record record);

    Map<String,Object> getData(String userId,int first,int size);

    Map<String,Object> getResult(String userId,int first,int size);
}
