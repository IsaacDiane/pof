package com.Dao;

import com.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
    private Connection connection=Driver.getConnnection();
    private PreparedStatement ps=null;
    public void InsertStudent(Student student)  {
        String name =student.getName();
        String age=student.getAge();
        String sql= "INSERT INTO STUDENT (NAME ,AGE) VALUES('"+name+"','"+age+"');";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void InsertCourse(Course course){
        String name=course.getName();
        String sql="INSERT INTO COURSE (NAME ) VALUES('"+name+"');";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void InsertTeacher(Teacher teacher){
        String name =teacher.getName();
        String age=teacher.getAge();
        String sql= "INSERT INTO TEACHER (NAME ,AGE) VALUES('"+name+"','"+age+"');";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void InsertChooseLesson(Course course , Student student){
        int courseId=course.getId();
        int studentId=student.getId();
        String sql="INSERT INTO CHOOSE (sid,cid) VALUES("+studentId+","+courseId+");";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void InsertTeachLesson(Course course, Teacher teacher){
        System.out.print("InsertStudent");
    }
    public void setGroup(Student student,Course course,String groupName){
        int sid= student.getId();
        int cid=course.getId();
        String sql="UPDATE CHOOSE SET groupNO ='"+groupName+"' WHERE sid="+sid+" AND cid ="+cid+";";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void setNormalScore(Course course , Student student,String nScore){
        int sid= student.getId();
        int cid=course.getId();
        String sql="UPDATE CHOOSE SET score_regular ='"+nScore+"' WHERE sid="+sid+" AND cid ="+cid+";";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void setFinalScore(Course course, Student student ,String fScore){
        int sid= student.getId();
        int cid=course.getId();
        String sql="UPDATE CHOOSE SET score_final ='"+fScore+"' WHERE sid="+sid+" AND cid ="+cid+";";
        try {
            ps=connection.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void InsertMaterial(Materials materials){
        System.out.print("InsertStudent");
    }
    public void submitMaterial(Student student ,Teacher teacher ,Materials materials ,String status ,String log){
        System.out.print("InsertStudent");
    }
    public void InsertPaper(Paper paper){
        System.out.print("InsertStudent");
    }
    public void submitPaper(Student student,Teacher teacher,Paper paper ,String status,String log){
        System.out.print("InsertStudent");
    }

    public static void main(String [] args){
        Insert insert=new Insert();
        Student student=new Student();
        student.setName("徐宇钦");
        //insert.InsertStudent(student);
        Course course=new Course();
        course.setName("离散数学");
        //insert.InsertCourse(course);
        Teacher teacher=new Teacher();
        teacher.setName("曹敏");
        //insert.InsertTeacher(teacher);
        Select select=new Select();
        student=select.SelectStudent(student.getName());
        course.setId(2);
        //insert.InsertChooseLesson(course,student);
        //insert.setGroup(student,course,"5");
        insert.setNormalScore(course,student,"20");
        insert.setFinalScore(course,student,"80");
    }

}
