package com.dawndream.MailTwoStep.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class send {
    public static int SendMailInt(String to, String from, String host, String password, String head){
        int codeint1 = Integer.parseInt(new StepCode().code());
        // 收件人电子邮箱


        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(from, password); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(head + "验证码");



            // 设置消息体
            message.setText(head + "你的验证码是: " + codeint1);

            // 发送消息
            Transport.send(message);
            System.out.println("new code : " + codeint1);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return codeint1;
    }

    public static void SendMail(String to,String from,String host,String password,String head){
        // 收件人电子邮箱


        // 获取系统属性
        Properties properties = System.getProperties();

        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(from, password); //发件人邮件用户名、授权码
            }
        });

        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: 头部头字段
            message.setSubject(head + "验证码");

            int codeint1 = Integer.parseInt(new StepCode().code());

            // 设置消息体
            message.setText(head + "你的验证码是: " + codeint1);

            // 发送消息
            Transport.send(message);
            System.out.println("new code : " + codeint1);
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }





}

