package com.iread.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *项目名称: iread
 *类名称: SendCodeToEmail
 *类描述:  邮箱验证码工具类
 *创建人: Administrator
 *创建时间: 2017年12月24日下午4:46:05
 * @version 1.0.0
 * @author 方秋都
 *
 */
public final class SendCodeToEmail {
	private static Properties emails = new Properties();
	private static String from;
	private static String host;
	private static String pass;
	private static String auth;
	private static String ssl;
	
	private SendCodeToEmail(){}
	
	static{
		try {
			//EMAIL_PRO.load(new FileInputStream("D:/Program Files/eclipse/workspace/iread/src/main/resources/email.properties"));
			emails.load(SendCodeToEmail.class.getResourceAsStream("/email.properties"));
			from = emails.getProperty("reg.email.form");
			host = emails.getProperty("reg.email.host");
			pass = emails.getProperty("reg.email.pass");
			auth = emails.getProperty("mail.smtp.auth");
			ssl = emails.getProperty("mail.smtp.ssl.enable");
		} catch (IOException e) {
			e.printStackTrace();//暂不处理异常的具体操作
		}
	}
	
	//to:接受邮箱；code:验证码
	public static void sendEmail(String to, int code){
			Properties pros = System.getProperties();
			
			pros.setProperty("mail.smtp.host", host);
			pros.put("mail.smtp.auth", auth);
			pros.put("mail.smtp.ssl.enable", ssl);
			/*pros.setProperty("mail.transport.protocol", "smtp");
			pros.setProperty("mail.smtp.auth", "true");*/
			
			Session session = Session.getDefaultInstance(pros,new Authenticator(){
		        public PasswordAuthentication getPasswordAuthentication()
		        {
		         return new PasswordAuthentication(from, pass); //发件人邮件用户名、密码
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
	         message.setSubject("iread注册邮箱验证");
	 
	         // 设置消息体
	         message.setText("你的验证码为" + code + "，为了您的账号安全，请不要告诉任何人！");
	 
	         // 发送消息
	         Transport.send(message);
	         System.out.println("测试成功," + "code:" +code+";form:" + from + "TO:" + to);
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
	
	
	/*public static void main(String[] args){
		sendEmail("1582957944@qq.com",123456);
	}*/
	
}
