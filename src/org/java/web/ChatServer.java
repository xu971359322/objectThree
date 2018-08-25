package org.java.web;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;
/**
 * 聊天服务器类
 * @author SilverLining
 */
@ServerEndpoint("/websocket")
public class ChatServer {
    // 日期格式化
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private static Set<Session> sets = new HashSet<Session>();

    @OnOpen
    public void open(Session session) {
        sets.add(session);
    }

    /**
     * 接受客户端的消息，并把消息发送给所有连接的会话
     * @param message 客户端发来的消息
     * @param session 客户端的会话
     */
    @OnMessage
    public void getMessage(String message, Session session) {
        // 把客户端的消息解析为JSON对象
        JSONObject jsonObject = JSONObject.fromObject(message);
        // 在消息中添加发送日期
        jsonObject.put("date", DATE_FORMAT.format(new Date()));
        // 把消息发送给所有连接的会话
        for (Session openSession : sets) {
            // 添加本条消息是否为当前会话本身发的标志
            jsonObject.put("isSelf", openSession.equals(session));
            // 发送JSON格式的消息
            openSession.getAsyncRemote().sendText(jsonObject.toString());
        }
    }

    @OnClose
    public void close() {
        // 添加关闭会话时的操作
    }

    @OnError
    public void error(Throwable t) {
        // 添加处理错误的操作
    }
    
    
    /**
     * 其中不能使用session.getOpenSession()方法获取链接，这样无法获取到其他的Session实例，导致只能“自言自语”。
     * 正确的方法是在ChatServer类中定义成员变量private static Set<Session> sets = new HashSet<Session>();
     * 在OnOpen方法中将所有session存入set中，在OnMessage方法中遍历set发送消息。
     */
}