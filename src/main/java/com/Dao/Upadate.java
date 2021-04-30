package com.Dao;

import com.Model.Course;
import com.Model.Materials;
import com.Model.Paper;
import com.Model.Student;

public class Upadate {
    public void UpdatePaper(Paper paper,String newStatus,String newLog){
        System.out.print("UpadatePaper");
    }//修改论文的审核状态和添加日志
    public void UpdateNormalScore(Student student, Course course,String newNormalScore){
        System.out.print("UpdateNormalScore");
    }
    public void UpdateFinalScore(Student student,Course course,String newFinalScore)
    {
        System.out.print("UpdateFinalScore");
    }
    public void UpdateMaterial(Materials materials ,String newStatus,String newLog){
        System.out.print("UpdateMaterial");
    }//修改材料的审核状态和添加日志
}
