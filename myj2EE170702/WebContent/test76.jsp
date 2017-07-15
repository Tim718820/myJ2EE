<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page errorPage="error.jsp" %>
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
<sql:query sql="select * from member" var="result"/>
<c:forEach items="${result.rows }" var="row">
${row.id}:${row.account}:${row.passwd}:${row.realname}<br>
</c:forEach>
<hr>
<sql:query var="result2">
select * from member
</sql:query>
<c:forEach items="${result2.rows }" var="row">
${row.id}:${row.account}:${row.passwd}:${row.realname}<br>
</c:forEach>
<hr>
<sql:query var="result3">
select * from member where account = ?
<sql:param>Tim</sql:param>
</sql:query>
<c:forEach items="${result3.rows }" var="row">
${row.id}:${row.account}:${row.passwd}:${row.realname}<br>
</c:forEach>

</body>
</html>