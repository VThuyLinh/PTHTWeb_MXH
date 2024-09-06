package com.vtl.mail;

import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Address;

public class Email {
	// Email: tungletest1.email@gmail.com
	// Password: nebeekfipcstxcox
	static final String from = "vthuylinh135@gmail.com";
	static final String password = "wulq ykyx cdzj jvkb";

	public static boolean sendEmail(String to, String tieuDe, String noiDung) {
		// Properties : khai báo các thuộc tính
		Properties props = new Properties();
		 props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");

		// create Authenticator
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);
			}
		};

		// Phiên làm việc
		Session session = Session.getInstance(props, auth);

		// Tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);

		try {
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Người gửi
                       
			msg.setFrom(new InternetAddress(from));

			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

			// Tiêu đề email
			msg.setSubject(tieuDe);

			// Quy đinh ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hồi
			// msg.setReplyTo(InternetAddress.parse(from, false))

			// Nội dung
			msg.setContent(noiDung, "text/HTML; charset=UTF-8");

			// Gửi email
			Transport.send(msg);
			System.out.println("Gửi email thành công");
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
            
	Email.sendEmail("Tileen135@gmail.com", "OU4Alumni"
                , "<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"</head>\n" +
"<body>\n" +
"    <h5>Hãy thay đổi mật khẩu trước 24h để tiếp tục sử dụng tài khoản</h5>\n" +
"    <h1>Vui lòng <b>không chia sẻ</b> thông tin sau cho <b>bất cứ ai</b> vì nó sẽ ảnh hưởng đến tài khoản của bạn</h1>\n" +
"    <p>Mật khẩu : ou@123</p>\n" +               
"</body>\n" +
"</html>");
		

	}

}