package com.allst.jcore.webservice.server;

import com.allst.jcore.webservice.ws.HelloWSImpl;

import javax.xml.ws.Endpoint;

/**
 * 用于发布web services 服务器端
 * @author June
 * @date 2018/02/23
 */
public class WsServer {

	public static void main(String[] args) {
		String address = "http://192.168.31.72:8989/allst-ws/hellows";
		Endpoint.publish(address, new HelloWSImpl());
		System.out.println("发布webservices成功！");
	}
}
