import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailTool {
    public static void mailTool() throws MessagingException, GeneralSecurityException {
        Properties props = new Properties();

        // 开启debug调试
        props.setProperty("mail.debug", "true");
        // 发送服务器需要身份验证
        props.setProperty("mail.smtp.auth", "true");
        // 设置邮件服务器主机名
        props.setProperty("mail.host", "smtp.qq.com");
        // 发送邮件协议名称
        props.setProperty("mail.transport.protocol", "smtp");

        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.ssl.socketFactory", sf);

        Session session = Session.getInstance(props);

        Message msg = new MimeMessage(session);
        msg.setContent("2569658","text/html;charset=UTF-8");
        msg.setSubject("易睿大傻逼！");
        StringBuilder builder = new StringBuilder();
        builder.append("url = " + "http://blog.csdn.net/never_cxb/article/details/50524571");
        builder.append("\n页面爬虫错误");
     //   builder.append("\n时间 " + TimeTool.getCurrentTime());
        msg.setText(builder.toString());
        msg.setFrom(new InternetAddress("825663094@qq.com"));

        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com", "825663094@qq.com", "akbscgebtvwlbchj");

      //  transport.sendMessage(msg, new Address[] { new InternetAddress("yujiegao520@qq.com") });
        transport.sendMessage(msg, new Address[] { new InternetAddress("825663094@qq.com") });
        transport.close();
    }
}
