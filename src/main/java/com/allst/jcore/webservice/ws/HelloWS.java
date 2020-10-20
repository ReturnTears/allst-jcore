package com.allst.jcore.webservice.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * 使用JDK开发webServices,服务器端定义的访问接口
 * SEI： WebService Endpoint Interface
 * @author June
 * @time
 */
@WebService
public interface HelloWS {
	@WebMethod
	String sayHello(String name);
}
