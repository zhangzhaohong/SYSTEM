package com.project.pro.jdbc;

import java.sql.*;

public class SqlSrvDBConn {
    private Statement stmt;            // Statement对象（语句）
    private Connection conn;        // Connection对象（连接）
    ResultSet rs;                // ResultSet对象（结果集）

    //在构造方法中创建数据库连接
    public SqlSrvDBConn() {
        stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("数据库驱动加载成功");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/homework?characterEncoding=UTF-8", "root", "root");
            System.out.println("数据库连接成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs = null;
    }

    public Connection getConn() {
        return this.conn;
    }

    //执行查询类的SQL语句，有返回集
    public ResultSet executeQuery(String sql) {
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    , ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);    //执行查询语句
        } catch (SQLException e) {
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;                    //返回结果集
    }

    public int executeInsert(String sql) {
        int num = 0;
        try {
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE
                    , ResultSet.CONCUR_UPDATABLE);
            num = stmt.executeUpdate(sql);    //执行查询语句
        } catch (SQLException e) {
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return num;                    //返回结果集
    }

    //关闭对象
    public void closeStmt() {
        try {
            stmt.close();                //关闭Statement对象
        } catch (SQLException e) {
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }

    public void closeConn() {
        try {
            conn.close();                //关闭连接
        } catch (SQLException e) {
            System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}

