package com.coderlong.javamail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Demo1 {

	//在连接smtp服务器的时候 会发生错误
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.transport.protocol","smtp");
//		properties.setProperty(, value);
		Session session = Session.getInstance(properties);
		session.setDebug(true);
		  
		Message  message = new MimeMessage(session);
		message.setText("this is a email");
		message.setFrom(new InternetAddress("coder_long@sohu.com"));
		 
		Transport transport = session.getTransport(); 
		transport.connect("smtp.sina.com",25,"coder_long", "ren862983319");
		transport.sendMessage(message,  new Address[]{new InternetAddress("coder_long@sohu.com")});
//		transport.send(message, new Address[]{new InternetAddress("coder_long@sohu.com")});
		transport.close();
	}

}
