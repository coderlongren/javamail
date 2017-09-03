package com.coderlong.javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Demo2 {

	//验证成功的邮件发送  可以群发
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.transport.protocol","smtp");	
		properties.setProperty("mail.host", "smtp.sina.com");
		Session session = Session.getInstance(properties,
				new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("coder_long", "ren862983319");
			}
				});
		
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("coder_long@sina.com"));
		message.setSubject("中文主题");
		message.setContent("<p style='color:red'>呵呵哈哈，，，，，，，，"
				+ "</p>", "text/html;charset=utf-8");
		message.setRecipients(RecipientType.TO, new Address[]{new InternetAddress("862983319@qq.com")});
		
		Transport.send(message);
	}

}
