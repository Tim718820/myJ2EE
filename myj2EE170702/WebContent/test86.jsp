<%@page import="java.util.Enumeration"%>
<%@page import="java.io.*"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String uploadPath = 
	pageContext.getServletContext().getInitParameter("upload-path");
MultipartRequest req = new MultipartRequest(request,uploadPath,"UTF-8");
Enumeration items = req.getFileNames();
while (items.hasMoreElements()){
	String strFile = (String)items.nextElement();
	File file = req.getFile(strFile);
	String FSName = req.getFilesystemName(strFile);
	String orgName = req.getOriginalFileName(strFile);
	out.println(FSName + ":" + orgName + "<br>");
}
out.println("<hr>");
Enumeration params =  req.getParameterNames();
while (params.hasMoreElements()){
	String param = (String)params.nextElement();
	String value = req.getParameter(param);
	out.println(param + ":" + value + "<br>");
}
%>


</body>
</html>