package com.coderlong.javamail_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.coderlong.javamail.Demo2;

public class SendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 * com.coderlong.javamail_servlet.SendServlet
	 */
	public SendServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//使用JNDI的方式  实现
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			Session session = (Session) envCtx.lookup("mail/Session");

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("coder_long@sina.com"));
			InternetAddress to[] = new InternetAddress[1];
			to[0] = new InternetAddress("coder_long@sina.com");
			message.setRecipients(Message.RecipientType.TO, to);
			message.setSubject("ha");
			message.setText("hehe");
//			Transport.send(message);
			Transport transport = session.getTransport();
			transport.connect("smtp.sina.com", "coder_long","ren862983319");
			transport.sendMessage(message, to);
			transport.close();
			
//			Demo2.main(new String[]{});
			response.getWriter().write("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(response.getWriter());
			
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
