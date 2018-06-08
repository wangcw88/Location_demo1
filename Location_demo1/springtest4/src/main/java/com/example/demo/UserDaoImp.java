package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class UserDaoImp {


    public boolean Login(String username,String password){
        boolean b = false;
        GetConn getConn = new GetConn();
        ResultSet rs = null;
        Connection conn = getConn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from user where username=? AND password=? ");
            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();
            if(rs.next()){
                b = true;
            }else{

                b = false;
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return b;
    }



    public boolean Findusername(String username){
        boolean b = false;
        GetConn getConn = new GetConn();
        ResultSet rs = null;
        Connection conn = getConn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from user where username=? ");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if(rs.next()){

                b = true;
            }else{

                b = false;
            }


        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return b;
    }

    //更新数据库
    public void update(String lat, String lng, String username){
        GetConn getConn = new GetConn();
        Connection conn = getConn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("update USER  set lat=? , lng =? where username=?");
            //ps.setLong(1, 11);
            ps.setString(1, lat);
            ps.setString(2, lng);
            //ps.setString(4, "123456");
            ps.setString(3, username);
            ps.executeUpdate();

            System.out.println(username+" "+lat+" "+lng);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    //创建数据库
    public void create(String lat, String lng, String username){
        GetConn getConn = new GetConn();
        Connection conn = getConn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO user(id,lat,lng,password,username)VALUES(?,?,?,?,?)");
            ps.setString(1, null);
            ps.setString(2, lat);
            ps.setString(3, lng);
            ps.setString(4, "123456");
            ps.setString(5, username);
            ps.executeUpdate();

            System.out.println(username+lat+lng+"");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
