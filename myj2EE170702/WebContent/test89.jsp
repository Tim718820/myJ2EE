<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="me" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<me:test1/>
<hr>
<me:test2 user="Tim"/>
<hr>
<me:test3 x="10" y="3">
	10 + 3 = ${add }<br>
	10 - 3 = ${sub }<br>
	10 x 3 = ${multiply }<br>
	10 / 3 = ${divide }<br>
</me:test3>
<hr>
<me:test4 name="xxx" id="1" price="100" xxx="111"></me:test4>
</body>
</html>