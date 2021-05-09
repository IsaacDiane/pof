package com.Model.pojo;

/**
 * @date: 2021/4/19
 * @author: wangyg
 * @description:学生资料下载和教师作业下载接口
 */

public interface FilesDownload {
    // 获取所要下载的文件名字
    String getDataName();
    // 查询数据库判断该文件是否存在
    boolean existInDB(String downloadFileName);
    // 如果在数据库中存在该文件则合成下载路径
    String getFullPath(String downloadFileName);
    // 请求下载链接
    void downloadFile(String downloadFilePath);
    //显示下载进度条
    void showDownloadProgress();
}
