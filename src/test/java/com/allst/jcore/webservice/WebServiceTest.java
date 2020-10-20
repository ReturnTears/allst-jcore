package com.allst.jcore.webservice;

import com.allst.jcore.webservice.ws.HelloWSImpl;
import org.junit.Test;

import javax.xml.ws.Endpoint;

/**
 * @author YiYa
 * @since 2020-10-20 下午 11:57
 */
public class WebServiceTest {

    @Test
    public void test() {
        String address = "http://192.168.31.72:8989/allst-ws/hellows";
        Endpoint.publish(address, new HelloWSImpl());
        System.out.println("发布webservices成功！");
    }

}
