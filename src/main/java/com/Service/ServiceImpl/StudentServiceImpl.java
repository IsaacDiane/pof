//package com.Service.ServiceImpl;
//
//import com.Dao.Insert;
//import com.Dao.Select;
//import com.Model.Materials;
//import com.Model.Notification;
//import com.Model.Paper;
//import com.Model.Student;
//import com.Model.Teacher;
//import com.service.StudentService;
//import com.utils.resultcode.ResultCode;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//import java.sql.Date;
//import java.text.SimpleDateFormat;
//
//public class StudentServiceImpl implements StudentService {
//    @Autowired
//    private Insert insert;
//    private Select select;
//
//    @Override
//    public ResultCode sendNotification(Teacher teacher, String title, String context) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date sendtime = new Date(System.currentTimeMillis());
//        Notification noty = new Notification(title, context, teacher.getId(), sendtime, 0);
//        insert.insertNoty(noty);
//        return ResultCode.success();
//    }
//    //老师发布资料发给所选学生
//    @Override
//    public ResultCode sendMaterial(Teacher teacher, Student student, String name, String context, File file) {
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date updatetime = new Date(System.currentTimeMillis());
//        Materials materials = new Materials(name, context, file, updatetime);
//        insert.insertMater(materials);
//        return ResultCode.success();
//    }
//    //老师审核学生提交的资料
//    @Override
//    public ResultCode receiveMaterial(Teacher teacher) {
//        Materials materials[] = select.selectMater(teacher);
//        return ResultCode.success(materials,100);
//    }
//
//    @Override
//    public ResultCode selectPaper(Teacher teacher) {
//        Paper papers[] = select.selectPaper(teacher);
//        return ResultCode.success(papers,100);
//    }
//}
