package org.java.util;


import org.springframework.stereotype.Component;

import javax.mail.*;
import java.util.Properties;

@Component
public class MailTest {

    public static void selectEmail(){
        try
        {
            String host = "pop.qq.com";
            String username = "971359322@qq.com";
            String password = "rysuklzzeilpbbic";

            Properties p = new Properties();
            p.setProperty("mail.pop3.host", "pop.qq.com"); // 按需要更改
            p.setProperty("mail.pop3.port", "995");
            // SSL安全连接参数
            p.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            p.setProperty("mail.pop3.socketFactory.fallback", "true");
            p.setProperty("mail.pop3.socketFactory.port", "995");

            Session session = Session.getDefaultInstance(p, null);
            Store store = session.getStore("pop3");
            store.connect(host, username, password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);
            Message message[] = folder.getMessages();
            System.out.println("邮件数量:" + message.length);
            new GetMailInfoThread(message).start();
            System.out.println();
        }
        catch (NoSuchProviderException e){
            e.printStackTrace();
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }
    }
}
