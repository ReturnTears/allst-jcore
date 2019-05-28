package com.allst.jcore.net.server;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * websocket服务端核心类
 * @author June 2019/04/20 下午 10:10
 * @version 1.0
 */
@ServerEndpoint("/webSocket/{username}")
public class WebSocketServerDemo1 {
    private static int onlineCount = 0;
    private static Map<String, WebSocketServerDemo1> clients = new ConcurrentHashMap<>();
    private Session session;
    private String username;

    @OnOpen
    public void onOpen(@PathParam("username") String username, Session session) {
        this.username = username;
        this.session = session;
        addOnlineCount();
        clients.put(username, this);
        System.out.println("已连接");
    }

    @OnClose
    public void onClose() {
        clients.remove(username);
        subOnlineCount();
    }

    @OnMessage
    public void onMessage(String message) {
        JSONObject jsonObject = JSONObject.parseObject(message);
        String msg = (String) jsonObject.get("message");
        if (!jsonObject.get("To").equals("All")) {
            sendMessageTo(msg, jsonObject.get("To").toString());
        } else {
            sendMessageAll("给所有人");
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

    public void sendMessageTo(String message, String To) {
        for (WebSocketServerDemo1 item : clients.values()) {
            if (item.username.equals(To)) {
                item.session.getAsyncRemote().sendText(message);
            }
        }
    }

    public void sendMessageAll(String message) {
        for (WebSocketServerDemo1 item : clients.values()) {
            item.session.getAsyncRemote().sendText(message);
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServerDemo1.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServerDemo1.onlineCount--;
    }

    public static synchronized Map<String, WebSocketServerDemo1> getClients() {
        return clients;
    }
}
