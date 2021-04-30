package com.Dao;

import com.Model.*;

public class Delete {
    public void DeleteStudent(Student student){
        System.out.print("UpadatePaper");
    }
    public void DeleteCourse(Course course){
        System.out.print("DeleteCourse");
    }
    public void DeleteTeacher(Teacher teacher){
        System.out.print("DeleteTeacher");
    }
    public void DeleteChooseLesson(Course course , Student student){
        System.out.print("DeleteChooseLesson");
    }
    public void DeleteTeachLesson(Course course, Teacher teacher){
        System.out.print("DeleteTeachLesson");
    }
    public void DeleteMaterial(Materials materials){
        System.out.print("DeleteMaterial");
    }
    public void DeletePaper(Paper paper){
        System.out.print("DeletePaper");
    }
}
