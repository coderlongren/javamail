package com.coderlong.javamail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.FileHandler;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Session;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.mail.handlers.multipart_mixed;

public class Demo3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Session session = Session.getInstance(new Properties());
		MimeMessage message = new MimeMessage(session);
		message.setSubject("javamail");
		
		MimeMultipart mimeMultipart = new MimeMultipart("mixed");
		message.setContent(mimeMultipart);
		//���� ��Ҫ����ͼƬ
		MimeBodyPart content = new MimeBodyPart();
		//����һ
		MimeBodyPart attch1 = new MimeBodyPart();
		//������
		MimeBodyPart attch2 = new MimeBodyPart();
		
		
		//������������һ�����ļ���ȥ
		mimeMultipart.addBodyPart(attch1);
		mimeMultipart.addBodyPart(attch2);
		mimeMultipart.addBodyPart(content);
		
		DataSource ds1 = new FileDataSource("E:\\�ҵ�713\\Ҫ��.txt");
		DataHandler dataHandler1 = new DataHandler(ds1);
		attch1.setDataHandler(dataHandler1);
		attch1.setFileName("java.txt");
		
		DataSource ds2 = new FileDataSource("E:\\�ҵ�713\\Ҫ��.txt");
		DataHandler dataHandler2 = new DataHandler(ds2);
		attch2.setDataHandler(dataHandler2);
		attch2.setFileName("logo.gif");
		
		//		attch1.setDataHandler(); 
		MimeMultipart bodyMultipart  = new  MimeMultipart("related");
		content.setContent(bodyMultipart);
		MimeBodyPart htmlPart = new MimeBodyPart();
		MimeBodyPart gifPart = new MimeBodyPart();
		bodyMultipart.addBodyPart(htmlPart);
		bodyMultipart.addBodyPart(gifPart);
		
		DataSource gifds = new FileDataSource("D:\\Log\\yingtai.jpg");
		DataHandler gifDataHandler = new DataHandler(gifds);
		gifPart.setDataHandler(gifDataHandler);
		gifPart.setHeader("Content-Location", "logo.gif");
		
		htmlPart.setContent("java�ʼ�����ͼƬ:<img src='logo.gif'></img>","text/html;charset=gbk");
		
		message.saveChanges();//�ʼ����� ���
		OutputStream os = new FileOutputStream("D:\\javamail.eml");  
		message.writeTo(os);
		os.close();
	}

}
