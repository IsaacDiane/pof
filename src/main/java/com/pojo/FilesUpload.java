package com.pojo;

import java.util.Date;

/**
 * @date: 2021/4/19
 * @author: wangyg
 * @description:学生作业和教师资料上传接口
 */

public interface FilesUpload {
    // 获取文件上传时间
    Date getWorksTime();
    // 获取文件上传的路径
    String getUploadPath();
    // 生成在服务器端存放的文件名字
    String generateWoksName(String saveRootPath);
    // 添加文件的描述信息
    String descriptionOfFile(String description);
    // 判断是否存在同样的文件
    boolean existsSameWorks(String uploadFileName);
    // 开始上传
    void uploadFile();
    // 上传进度显示
    void showProgress();

}
