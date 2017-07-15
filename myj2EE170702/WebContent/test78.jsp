<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<sql:setDataSource driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://127.0.0.1/brad"
	user="root" password="root"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty param.delid}">
	<sql:update var="count">
		delete from member where id = ?
		<sql:param>${param.delid }</sql:param>
	</sql:update>
</c:if>

<sql:query sql="select * from member" var="result"/>
<table border="1" width="100%">
	<tr>
		<th>id</th>
		<th>Account</th>
		<th>Password</th>
		<th>Real Name</th>
		<th>Delete</th>
		<th>Edit</th>
	</tr>
	<c:forEach items="${result.rows }" var="row">
	<tr>
		<td>${row.id}</td>
		<td>${row.account}</td>
		<td>${row.passwd}</td>
		<td>${row.realname}</td>
		<td><a href="?delid=${row.id}">Delete</a></td>
		<td><a href="test79.jsp?editid=${row.id}">Edit</a></td>
	</tr>
	</c:forEach>
</table>

</body>
</html>