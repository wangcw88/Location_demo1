package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    Map<String, String> json;
    byte[] jsonBytes;

    //请求url地址映射------用户定位
    @RequestMapping("/location")
    public  Object Location(HttpServletRequest request,HttpServletResponse response){
        try {
            String username = request.getParameter("username");
            //String password = request.getParameter("password");

            User u = userRepository.findByUsername(username);

            System.out.println("<<<<<<<<<<<W O T K~!>>>>>>>>>>>");

            json = new HashMap<String, String>();

            json.put("lng",u.getLng());
            json.put("lat",u.getLat());
            json.put("gps",u.getGps());
            json.put("wifi",u.getWifi());


            jsonBytes = json.toString().getBytes("utf-8");
            response.setContentLength(jsonBytes.length);

            response.getOutputStream().write(jsonBytes);

            response.getOutputStream().flush();
            response.getOutputStream().close();

            //显示时间
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式

            System.out.println("lng = "+u.getLng()+" lat = "+u.getLat()+" time = "+dateFormat.format( now ));

        }catch (Exception e) {
            e.printStackTrace();

        }

        return null;

    }


    // 请求url地址映射，类似Struts的action-mapping-----用户请求登录
    @RequestMapping("/login.action")
    public Object Login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            System.out.println("<<<<<<<<<<<R O T K~!>>>>>>>>>>>");
            System.out.println("username = "+username+" password = "+password);


            json = new HashMap<String, String>();

            UserDaoImp userDaoImp = new UserDaoImp();

            boolean b = userDaoImp.Login(username, password);

            if (b) {
                json.put("login", "登陆成功，欢迎使用机场行李定位系统!");

            } else {
                json.put("login", "登入失败！请重新输入账号及密码!");
            }

            jsonBytes = json.toString().getBytes("utf-8");
            response.setContentLength(jsonBytes.length);

            response.getOutputStream().write(jsonBytes);

            response.getOutputStream().flush();
            response.getOutputStream().close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }



}
