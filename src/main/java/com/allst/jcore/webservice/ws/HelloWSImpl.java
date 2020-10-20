package com.allst.jcore.webservice.ws;

import javax.jws.WebService;

/**
 * sei的实现类
 * @author June
 * @date 2018/02/23
 */
@WebService
public class HelloWSImpl implements HelloWS {

	@Override
	public String sayHello(String name) {
		System.out.println("server sayHello()" + name);
		return "hello your " + name;
	}

}
