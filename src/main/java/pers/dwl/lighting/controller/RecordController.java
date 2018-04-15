package pers.dwl.lighting.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.dwl.lighting.Constants;
import pers.dwl.lighting.domain.Record;
import pers.dwl.lighting.domain.User;
import pers.dwl.lighting.service.RecordService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @program: lighting
 * @description: 记录控制器
 * @author: daiwenlong
 * @create: 2018-04-15 10:47
 **/
@Controller
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/record/{userId}")
    public String getRecords(@PathVariable("userId")String userId, Model model){
        Map<String,Object> data = recordService.getData(userId,0,7);
        Record record = recordService.findTRecordById(userId);
        model.addAttribute("data",data);
        if(null != record){
            model.addAttribute("re",record.getWeight()+" Kg");
        }else{
            model.addAttribute("re","单位：Kg");
        }
        model.addAttribute("userId",userId);
        model.addAttribute("time",Constants.getWeekOfDate(new Date()));
        return "user_index";
    }

    @PostMapping("/record")
    @ResponseBody
    public int addRecord(@Valid Record record, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return 0;
        }
        User user = (User)session.getAttribute(Constants.USER);
        if(null != recordService.findTRecordById(user.getUserId()))
            return 0;
        record.setUserId(user.getUserId());
        return recordService.insertRecord(record);
    }

    @GetMapping("/record/more/{userId}")
    public String moreRecord(@PathVariable("userId")String userId,Model model){
        Map<String,Object> data = recordService.getData(userId,0,15);
        Map<String,Object> month = recordService.getData(userId,0,30);
        model.addAttribute("data",data);
        model.addAttribute("month",month);
        model.addAttribute("userId",userId);
        return "user_more";
    }

    @GetMapping("/record/home/{userId}")
    public String userRecord(@PathVariable("userId")String userId,Model model){
        List<Record> list = recordService.findMRecord(userId,0,50);
        model.addAttribute("list",list);
        model.addAttribute("userId",userId);
        return "user_home";
    }

    @GetMapping("/record/home/more/{userId}")
    @ResponseBody
    public String userMoreRecord(@PathVariable("userId")String userId,int page,int size){
        List<Record> list = recordService.findMRecord(userId,page*10,size);
        return JSON.toJSONString(list);
    }
}


