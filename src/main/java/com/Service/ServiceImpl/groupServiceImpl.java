package com.Service.ServiceImpl;

import com.Dao.Insert;
import com.Dao.Select;
import com.Dao.Upadate;
import com.Model.Course;
import com.Model.Student;
import org.springframework.stereotype.Service;
import com.Service.groupService;

import java.util.Random;

@Service
public class groupServiceImpl implements groupService{

    Select select = new Select();
    @Override
    //根据学生id将选择course课程的所有学生分为groupNum组
    public void setGroupBySid(Course course, int groupNum){
        System.out.println("将课程所有学生分组");
        Student[] stuList = select.SelectStudent(course);
        Insert insert=new Insert();
        Random random=new Random();
        for (int i=0;i<stuList.length;++i){
            int gid = random.nextInt(groupNum)+1;
            insert.setGroup(stuList[i],course,String.valueOf(gid));
        }
    }
    public void quickAnswer(int groupId){
        System.out.println("小组抢答");
    }

    //展示当前课程分组结果
    public Student[] displayGroup(Course course){
        System.out.println("展示分组");
        Student[] stuList = select.SelectStudent(course);
        return stuList;
    }

    //将当前课程第groupId组的学生平时成绩加上seminarScore
    public void setGroupScoreByGid(Course course,String groupId,String seminarScore){
        System.out.println("给小组成员计分");
        //按照组号查询choose表，将该组所有人的平时成绩加上score再更新表
        Upadate upadate=new Upadate();
        Student[] stuList = select.SelectStudent(course);
        for (int i=0;i<stuList.length;++i){
            if(select.getGroup(stuList[i],course) == groupId){
                double normalScore=Double.parseDouble(select.getNormalScore(stuList[i],course));
                normalScore+=Double.parseDouble(seminarScore);
                upadate.UpdateNormalScore(stuList[i],course,String.valueOf(normalScore));
            }
        }
    }

    public static void main(String args[]){

    }
}
