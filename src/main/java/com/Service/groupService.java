package com.Service;

import com.Model.Course;
import com.Model.Student;

public interface groupService {
    void setGroupBySid(Course course, int groupNum);
    void quickAnswer(int groupId);
    Student[] displayGroup(Course course);
    void setGroupScoreByGid(Course course,String groupId,String seminarScore);
}
