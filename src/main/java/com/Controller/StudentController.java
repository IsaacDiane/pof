//package com.Controller;
//
//import com.Model.Teacher;
//import com.service.StudentService;
//import com.utils.resultcode.ResultCode;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.File;
//
//
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//
//    @PostMapping("sendNoty")
//    public ResultCode sendNoty(@RequestBody Teacher teacher, @RequestBody String title, @RequestBody String context){
//        return studentService.sendNotification(teacher, title, context);
//    }
//
//    @PostMapping("sendMater")
//    public ResultCode sendMater(@RequestBody Teacher teacher, @RequestBody String name, @RequestBody String context, @RequestBody File file){
//        return studentService.sendMaterial(teacher, name, context, file);
//    }
//
//    @GetMapping("receiveMaterial")
//    public ResultCode receiveMaterial(Teacher teacher){
//        return studentService.receiveMaterial(teacher);
//    }
//
//    @GetMapping("selectPaper")
//    public ResultCode selectPaper(Teacher teacher){
//        return studentService.selectPaper(teacher);
//    }
//
//}
