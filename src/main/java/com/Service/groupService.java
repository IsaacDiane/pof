package com.Service;

import com.Model.Course;

public interface groupService {
    void setGroupBySid(Course course, int groupNum);
    void quickAnswer(int groupId);
    void setGroupScoreByGid(Course course,String groupId,String seminarScore);
}
