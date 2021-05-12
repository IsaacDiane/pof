package com.Dao;

import com.Model.Course;
import com.Model.Materials;
import com.Model.Paper;
import com.Model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Upadate {
    private Connection connection=Driver.getConnnection();
    private PreparedStatement ps=null;
    public void UpdatePaper(Paper paper,String newStatus,String newLog){
        System.out.print("UpadatePaper");
    }//修改论文的审核状态和添加日志
    public void UpdateNormalScore(Student student, Course course,String newNormalScore){
        int sid= student.getId();
        int cid=course.getId();
        String sql="UPDATE CHOOSE SET score_regular ='"+newNormalScore+"' WHERE sid="+sid+" AND cid ="+cid+";";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void UpdateFinalScore(Student student,Course course,String newFinalScore)
    {
        int sid= student.getId();
        int cid=course.getId();
        String sql="UPDATE CHOOSE SET score_regular ='"+newFinalScore+"' WHERE sid="+sid+" AND cid ="+cid+";";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void UpdateMaterial(Materials materials ,String newStatus,String newLog){
        System.out.print("UpdateMaterial");
    }//修改材料的审核状态和添加日志
}
