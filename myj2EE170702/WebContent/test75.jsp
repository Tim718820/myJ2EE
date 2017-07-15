<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection
			("jdbc:mysql://127.0.0.1/brad","root","root");
	Statement stmt = conn.createStatement();
	String sql = "INSERT INTO member (account,passwd,realname) VALUES ('iii','123','III')";
	stmt.execute(sql);
%>
</body>
</html>