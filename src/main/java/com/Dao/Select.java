package com.Dao;

import com.Model.Course;
import com.Model.Student;
import com.Model.Teacher;
import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    private Connection connection=Driver.getConnnection();
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    public Student SelectStudent(String name){
        Student student=new Student();
        String sql="SELECT * FROM STUDENT WHERE NAME='"+name+"';";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int id=rs.getInt("id");
                String sname=rs.getString("name");
                String age = rs.getString("age");
                student.setId(id);
                student.setName(sname);
                student.setAge(age);
            }
        } catch (SQLException throwables) {

        }
        return student;
    }
    public Student SelectStudent(int id){
        Student student=new Student();
        String sql="SELECT * FROM STUDENT WHERE id='"+id+"';";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int sid=rs.getInt("id");
                String sname=rs.getString("name");
                String age = rs.getString("age");
                student.setId(sid);
                student.setName(sname);
                student.setAge(age);
            }
        } catch (SQLException throwables) {

        }
        return student;
    }

    public Course SelectCourse(int id){
        Course course=new Course();
        String sql="SELECT * FROM COURSE WHERE id='"+id+"';";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int cid=rs.getInt("id");
                String cname=rs.getString("name");
                course.setId(cid);
                course.setName(cname);
            }
        } catch (SQLException throwables) {

        }
        return course;
    }
    public Student[] SelectStudent(Course course){
        int cid=course.getId();
        List<Student> studentList=new ArrayList<Student>();
        String sql="SELECT STUDENT.id ,STUDENT.age,STUDENT.name FROM STUDENT,CHOOSE,COURSE WHERE  COURSE.ID="+cid+" AND Course.id=choose.cid AND student.id=choose.sid;";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                int sid=rs.getInt("id");
                String sname=rs.getString("name");
                String age=rs.getString("age");
                Student student=new Student();
                student.setId(sid);
                student.setName(sname);
                student.setAge(age);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Student[] students=new Student[studentList.size()];
            studentList.toArray(students);
            return students;
        }

    }

    public String getNormalScore(Student student ,Course course){
        int sid=student.getId();
        int cid=course.getId();
        String regularScore="";
        String sql="SELECT score_regular FROM STUDENT,CHOOSE,COURSE WHERE  COURSE.ID="+cid+" AND student.id="+sid+" AND Course.id=choose.cid AND student.id=choose.sid;";
        try{
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                regularScore = rs.getString("score_regular");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regularScore;
    }
    public String getFinalScore(Student student,Course course){
        int sid=student.getId();
        int cid=course.getId();
        String finalScore="";
        String sql="SELECT score_final FROM STUDENT,CHOOSE,COURSE WHERE  COURSE.ID="+cid+" AND student.id="+sid+" AND Course.id=choose.cid AND student.id=choose.sid;";
        try{
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()) {
                finalScore = rs.getString("score_final");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return finalScore;
    }
    public String getGroup(Student student,Course course){
        int cid= course.getId();
        int sid=student.getId();
        String groupNo="";
        String sql = "SELECT GROUPNO FROM CHOOSE WHERE SID="+sid+" AND CID="+cid+";";
        try{
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                groupNo=rs.getString("groupNo");
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return groupNo;
    }

    public String[] getGroup(Course course){
        int cid=course.getId();
        String sql= "SELECT student.name,groupNo FROM student , choose WHERE cid="+cid+" AND sid=id ORDER BY groupNo";
        List<String> result=new ArrayList<>();
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();

            while(rs.next()){
                JSONObject jobj=new JSONObject();
                String sname=rs.getString("student.name");
                String groupNo=rs.getString("groupNo");
                jobj.put("name",sname);
                jobj.put("groupNo",groupNo);
                result.add(jobj.toJSONString());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String[] fin=new String[result.size()];
        result.toArray(fin);
        return fin;
    }
    public int getGroupNumber(Course course,String groupName){
        int memberNo=0;
        int cid=course.getId();
        String sql= "SELECT COUNT(1) AS memberNo FROM CHOOSE WHERE CID="+cid+" AND GROUPNO="+groupName+";";
        try {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                memberNo=rs.getInt("memberNo");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return memberNo;
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

    public static void main(String args[]){
        Select select=new Select();
        Student student=select.SelectStudent(1);
        System.out.println(student.toString());
        Course course=new Course();
        course.setId(2);
        Student[]students=select.SelectStudent(course);
        for(int i=0;i<students.length;i++){
            System.out.println(students[i].toString());
        }
        System.out.println(select.getNormalScore(student,course));
        System.out.println(select.getFinalScore(student,course));
        System.out.println(select.getGroup(student,course));
        System.out.println(select.getGroupNumber(course,"5"));
        String[] group=select.getGroup(course);
        for(int i=0;i<group.length;i++){
            System.out.println(group[i]);
        }
    }

}
