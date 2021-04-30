package com.Dao;

import com.Model.Course;
import com.Model.Student;
import com.Model.Teacher;

public class Select {
    public Student SelectStudent(String name){
        System.out.print("SelectStudent with name");
        Student student=new Student();
        student.setName("demo");
        return student;
    }
    public Student SelectStudent(int id){
        System.out.print("SelectStudent with id" );
        Student student=new Student();
        student.setName("demoid is "+ id);
        return student;
    }
    public Student[] SelectStudent(Course course){
        System.out.print("SelectStudent with course");
        Student student=new Student();
        student.setName("democourse is "+ course);
        Student[] students=new Student[1];
        students[0]=student;
        return students;
    }

    public String getNormalScore(Student student ,Course course){
        System.out.print("getNormalScore");
        return  "80分";
    }
    public String getFinalScore(Student student,Course course){
        System.out.print("getFinalScore");
        return  "80分";
    }
    public String getGroup(Student student,Course course){
        System.out.print("getGroup");
        return student.getName() +" is in group 1";
    }

    public Teacher[] findMaterials(String status){
        System.out.print("findMaterials");
        Teacher teacher=new Teacher();
        teacher.setName("demo material");
        Teacher[] teachers=new Teacher[1];
        teachers[0]=teacher;
        return teachers;
    } //搜索所有status状态（如待审核）的材料，返回材料对应的教师（没有审核的教师）
    public Teacher[] findPapers(String status){
        System.out.print("findPapers");
        Teacher teacher=new Teacher();
        teacher.setName("demo paper");
        Teacher[] teachers=new Teacher[1];
        teachers[0]=teacher;
        return teachers;
    } // 同上 论文



}
