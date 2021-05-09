package com.Service;

import com.Service.ServiceImpl.groupServiceImpl;

public class testGroupService {
    public static void main(String[] args){
        groupService test=new groupServiceImpl();
        test.setGroupBySid(null,5);

        test.quickAnswer(0);

        test.setGroupScoreByGid(null,null,null);
    }

}
