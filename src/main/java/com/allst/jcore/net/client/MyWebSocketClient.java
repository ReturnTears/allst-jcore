package com.allst.jcore.net.client;


import javax.websocket.*;
import javax.ws.rs.client.Client;
import java.io.IOException;

/**
 * @author June 2019/04/20 下午 11:16
 * @version 1.0
 */
@ClientEndpoint
public class MyWebSocketClient {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected to endpoint: " + session.getBasicRemote());
        try {
//            MyWebSocketClient.session=session;
//            System.out.println(Client.session);
            String name = "Duke";
            System.out.println("Sending message to endpoint: " + name);
            session.getBasicRemote().sendText(name);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnMessage
    public void processMessage(String message) {
        System.out.println("Received message in client: " + message);
    }

    @OnError
    public void processError(Throwable t) {
        t.printStackTrace();
    }
}
