package org.java.util;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class SendEmailUtil {

    private final static  String SERVICE_HOST = "smtp.qq.com";//QQ服务器

    private final static  int    PORT = 465; //smtp的端口号

    private final static  String PROTOCOL = "smtp"; //协议名称。smtp表示简单邮件传输协议

    private final static  String ACCOUNT = "971359322@qq.com"; //发送邮件的QQ账号

    private final static  String AUTH_CODE = "dyqmkrxtwmghbcbh"; //QQ授权码(需要到https://mail.qq.com/申请)

    private static final JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

    static{

        senderImpl.setHost(SERVICE_HOST); //设置 使用QQ邮箱发送邮件的主机名

        senderImpl.setPort(PORT); //设置端口号

        senderImpl.setProtocol(PROTOCOL); //协议名称

        senderImpl.setUsername(ACCOUNT); // 设置自己的邮箱帐号名称

        senderImpl.setPassword(AUTH_CODE); // 设置对应账号申请到的授权码

        Properties prop = new Properties();

        prop.put(" mail.smtp.auth ", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确

        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //使用ssl协议来保证连接安全

        prop.put(" mail.smtp.timeout ", "25000"); //传输超时时间

        senderImpl.setJavaMailProperties(prop);

    }

    /**

     * 发送简单邮件

     * @param accounts  被发邮件的用户数组

     * @param info      邮件信息

     * @param title     邮件主题

     */

    public static void sendSimpleMail(String[] accounts,String info,String title){

    //创建简单邮件对象aa

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(accounts);  //设置邮件接收者账号数组

        mailMessage.setFrom(ACCOUNT); //设置邮件的发送者

        mailMessage.setSubject(title);//设置邮件的主题

        mailMessage.setText(info);    //设置邮件的内容

        //发送邮件

        senderImpl.send(mailMessage);

    }

}
