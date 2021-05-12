package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
    private static final String  url="jdbc:mysql://localhost/pof";

    private static final String USER="root";
    private static final String PASSWORD="123";
    private static Connection conn=null;
    static{

        try {
            //1.加载驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库连接
            conn= DriverManager.getConnection(url, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    protected static Connection getConnnection(){
        return conn;
    }
}
