package testSuites;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) {
        //1、创建一个property文件对象
        Properties props = new Properties();
        props.put("mail.smtp.host","smtp.263.net");         //设置邮件服务器的信息；
        props.put("mail.smtp.socketFactory.port","465");    //设置socket factory端口
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth","true");     //设置需要进行身份验证
        props.put("mail.smtp.port","25");       //设置SMTP的端口，

        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                // 2、身份验证的实现，第二个参数是开启263邮箱开启SMTP的授权码
                return new PasswordAuthentication("shao_zhen@hoperun.com","9F5760C443e341d4");
            }
        });


        try {
            //3、创建MIMEMESSAGE类示例对象
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shao_zhen@hoperun.com"));//设置发送邮箱
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("daliqinchuanniu@163.com,shao_zhen@hoperun.com"));//设置接收邮箱
            message.setSubject("测试发送邮件4");   //设置邮件主题

            // 4、创建一个mimebodypart对象，用以添加内容
            BodyPart messageBodypart1 = new MimeBodyPart();
            messageBodypart1.setText("this is the payload");//设置正文内容
            // 5、创建mimebodypart对象，用以添加附件
            MimeBodyPart messageBodypart2 = new MimeBodyPart();
            MimeBodyPart messageBodypart3 = new MimeBodyPart();
            MimeBodyPart messageBodypart4 = new MimeBodyPart();
            String filename = "./Log/application.html";
            String filename1 = "./Log/testlog.log";
            String filename2 = "./Log/testlog.log";
            FileDataSource source = new FileDataSource(filename);
            messageBodypart2.setDataHandler(new DataHandler(source));//设置handler
            messageBodypart2.setFileName(filename); //加载文件

            FileDataSource source1 = new FileDataSource(filename1);
            messageBodypart3.setDataHandler(new DataHandler(source1));//设置handler
            messageBodypart3.setFileName(filename1); //加载文件

            FileDataSource source2 = new FileDataSource(filename2);
            messageBodypart4.setDataHandler(new DataHandler(source2));//设置handler
            messageBodypart4.setFileName(filename2); //加载文件

            // 6、创建一个MimeMultipart对象，用以添加征文内容，附件内容
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodypart1);
            multipart.addBodyPart(messageBodypart2);
            multipart.addBodyPart(messageBodypart3);
            multipart.addBodyPart(messageBodypart4);
            // 7、设置内容
            message.setContent(multipart);
            // 8、发送邮件
            Transport.send(message);
            System.out.println("==========邮件已经发送6========");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
