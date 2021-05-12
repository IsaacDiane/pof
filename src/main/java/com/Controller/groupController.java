package com.Controller;

import com.Model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Service.groupService;

@RestController
@RequestMapping("group")
public class groupController {
    @Autowired
    private groupService gService;

    @RequestMapping("displayGroup")
    public String display(Course course){
        //将分组结果在页面展示，每行包括学生学号 姓名 平时成绩
        gService.displayGroup(course);
        return "";
    }

    @PostMapping("setGroupBySid")
    public String setGroup(Course course,@RequestBody int groupNum){
        gService.setGroupBySid(course,groupNum);
        gService.displayGroup(course);
        return "displayGroup";
    }

    @PostMapping("setGroupScoreByGid")
    public  String setGroupScore(Course course,@RequestBody String groupId,@RequestBody String seminarScore){
        gService.setGroupScoreByGid(course,groupId,seminarScore);
        return "displayGroup";
    }
}
