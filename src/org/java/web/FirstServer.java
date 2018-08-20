package org.java.web;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;
import org.java.entity.Info;
import org.java.entity.Message;

import com.google.gson.Gson;
import com.sun.org.apache.bcel.internal.generic.NEW;

@ServerEndpoint("/first")
public class FirstServer{
	//存放所有连接到服务器的管道
	private static List<Session> list=new ArrayList<Session>();
	private String name=null;
	private static List<String> nameList=new ArrayList<String>();//用户列表
	private Gson gson=new Gson();
	private static Map<String,Session> map=new HashMap<String, Session>();//该集合用于存放用户的对应的管道
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	@OnOpen
	public void myOpen(Session session) throws Exception{
		name=session.getQueryString().split("=")[1];
		System.out.println("当前管道对应的用户是"+name+",正在建立连接管道::::"+session.getId());
		list.add(session);
		//将当前用户登录的信息，存放到集合中
		nameList.add(name);
		//指定欢迎消息
		String info="欢迎【"+name+"】来到聊天室！！！";
		
		map.put(name,session);//////////////////////////////////////存放用户对应的管道
		
		Message message=new Message();
		message.setMsg(info);
		message.setName(nameList);
		
		sendMsg(list,message.toJson());
	}
	
	//该方法用于给每个管道发送消息
	public void sendMsg(List<Session> session,String json) throws Exception{
		for (Session s:list){
			s.getBasicRemote().sendText(json);
		}
	}
	
	//退出管道
	@OnClose
	public void closeSession(Session session) throws Exception{
		session.close();
		list.remove(session);//移除管道
		//指定欢迎消息
		String info="【"+name+"】离开聊天室！！！...";
		
		Message message=new Message();
		message.setMsg(info);
		nameList.remove(name);
		message.setName(nameList);
		
		sendMsg(list,message.toJson());
	}
	
	@OnMessage
	public void showMessage(Session session,String json) throws Exception{

		/*String str="【"+name+"】"+"说"+msg+" "+new SimpleDateFormat("HH:mm:ss").format(new Date());
		Message message=new Message();
		message.setContent(str);
		///message.setMsg==如果不设置,会在页面中为null		message.setMsg(msg);
		sendMsg(list,message.toJson());*/
		/***************************************************************************/
		//将json格式的字符串，转换成对应的实体对象
		Info info=gson.fromJson(json,Info.class);
		if(info.getType()==1){
		//	String str="【"+name+"】"+"说"++" "+new SimpleDateFormat("HH:mm:ss").format(new Date());
			Message message=new Message();
			message.setPersonName(name);
			message.setContent(info.getMsg());
			message.setTime(DATE_FORMAT.format(new Date()));
			for (Session openSession : list) {
				//message.setSelf(openSession.equals(session));
				message.setFlag(openSession.equals(session));
			}
			sendMsg(list,message.toJson());
		}else{
			String user=info.getToUser();
			Session toSession=map.get(user);
			//String str="【"+name+"】[<b>悄悄</b>]"+"说"+info.getMsg()+" "+new SimpleDateFormat("HH:mm:ss").format(new Date());
			Message message=new Message();
			message.setPersonName(name);
			message.setContent(info.getMsg());
			message.setTime(DATE_FORMAT.format(new Date()));
			for (Session openSession : list) {
				message.setFlag(openSession.equals(session));
			}
			toSession.getBasicRemote().sendText(message.toJson());
			session.getBasicRemote().sendText(message.toJson());
		}
	}
}