<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%
for(int i=1; i<=10 ; i++){
final String username = "tim511718820@gmail.com";
final String password = "Tim50166";

Properties props = new Properties();
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.starttls.enable", "true");
props.put("mail.smtp.host", "smtp.gmail.com");
props.put("mail.smtp.port", "587");

Session session2 = Session.getInstance(props,
  new javax.mail.Authenticator() {
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}
  });

try {

	Message message = new MimeMessage(session2);
	message.setFrom(new InternetAddress("tim511718820@gmail.com"));
	message.setRecipients(Message.RecipientType.TO,
		InternetAddress.parse("u6923036@gmail.com"));
	message.setSubject("Testing Subject");
	message.setText("Dear Mail Crawler,"
		+ "\n\n No spam to my email, please!");

	Transport.send(message);

	System.out.println("Done");

} catch (MessagingException e) {
	out.print(e);
}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     


</body>
</html>