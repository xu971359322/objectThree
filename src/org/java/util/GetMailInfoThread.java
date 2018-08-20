package org.java.util;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Part;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于获取邮箱中邮件信息的线程
 * @author lupf
 *
 */
public class GetMailInfoThread extends Thread {
    Message message[] = null;
    MailImfo re = null;

    public GetMailInfoThread(Message message[]) {
        this.message = message;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        if (null != message) {
            for (int i = 0; i < message.length; i++) {
                try {
                    System.out.println();
                    List<Map<String, Object>> list = EmailList.getEmailList().getList();
                    Map<String,Object> map = new HashMap<String,Object>();

                    re = new MailImfo((MimeMessage) message[i]);
                    System.out.println("邮件　" + i + "　主题:　" + re.getSubject());
                    System.out.println("邮件　" + i + "　是否需要回复:　" + re.getReplySign());
                    System.out.println("邮件　" + i + "　是否已读:　" + re.isNew());
                    System.out.println("邮件　" + i + "　是否包含附件:　" + re.isContainAttach((Part) message[i]));
                    System.out.println("邮件　" + i + "　发送时间:　" + re.getSentDate());
                    System.out.println("邮件　" + i + "　发送人地址:　" + re.getFrom());
                    System.out.println("邮件　" + i + "　收信人地址:　" + re.getMailAddress("to"));
                    System.out.println("邮件　" + i + "　抄送:　" + re.getMailAddress("cc"));
                    System.out.println("邮件　" + i + "　暗抄:　" + re.getMailAddress("bcc"));
                    //re.setDateFormat("yyyy年MM月dd日");
                    System.out.println("邮件　" + i + "　发送时间:　" + re.getSentDate());
                    System.out.println("邮件　" + i + "　邮件ID:　" + re.getMessageId());
                    re.getMailContent((Part) message[i]);
                    map.put("id",list.size());
                    map.put("title",re.getSubject());
                    map.put("time",re.getSentDate());
                    map.put("sendName",re.getFrom());
                    map.put("content",re.getBodyText());
                    list.add(map);
                    System.out.println("**********************************************************************"+list.size());
                    System.out.println("邮件　" + i + "　正文内容:　\r\n" + re.getBodyText());
                } catch (MessagingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
