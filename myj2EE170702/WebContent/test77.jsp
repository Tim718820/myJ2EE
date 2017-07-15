<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1/brad"
	user="root" password="root"/>
<sql:update var="count">
insert into member (account,passwd,realname) values (?,?,?)
<sql:param>Hello</sql:param>
<sql:param>12345</sql:param>
<sql:param>Hello HH</sql:param>
</sql:update>
${count }
</body>
</html>