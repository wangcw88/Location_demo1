package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import com.example.demo.SocketServer;
import com.example.demo.GpsServer;
@SpringBootApplication
@ComponentScan("com.example.demo")
public class DemoApplication {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(DemoApplication.class, args);


		//服务端在10006端口监听客户端请求的TCP连接
		ServerSocket server = new ServerSocket(10006);
		Socket client = null;
		boolean f = true;
		//循环监听等待客户端的连接
		while(f){
			//等待客户端的连接，如果没有获取连接
			client = server.accept();
			//String ip=client.getLocalAddress().getHostAddress();;
			System.out.println("与客户端连接成功！");
			//为每个客户端连接开启一个线程
			new Thread(new SocketServer(client)).start();
			//System.out.println("连接设备的ip为:"+ip);
		}
		server.close();
	}
}
