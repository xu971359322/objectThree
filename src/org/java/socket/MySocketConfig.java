package org.java.socket;

import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 该类的作用是用于加载所有的socket服务,在tomcat服务器启动时自动调用
 * @author hp
 *
 */
public class MySocketConfig implements ServerApplicationConfig{
	
	//该方法采用注解的方式加载所有的socket服务
	//参数set集合，存放的就是所有的socket服务
	@Override
	public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> list) {
		System.out.println("服务器加载了，所有的socket服务！"+list.size());
		return list;
	}
	
	//改方法采用编程的方式加载所有的socket服务
	@Override
	public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> arg0) {
		
		return null;
	}

}
