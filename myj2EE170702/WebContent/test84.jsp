<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.util.*" %>
<%@page import="java.io.*" %>
<%@ page import = "org.apache.commons.fileupload.*" %>
<%@ page import = "org.apache.commons.fileupload.disk.*" %>
<%@ page import = "org.apache.commons.fileupload.servlet.*" %>
<%@ page import = "org.apache.commons.io.output.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int maxFileSize = 5000 * 1024;
	int maxMemSize = 5000 * 1024;
	
	String uploadPath = 
		pageContext.getServletContext().getInitParameter("upload-path");
	
    DiskFileItemFactory factory = new DiskFileItemFactory();
    // maximum size that will be stored in memory
    factory.setSizeThreshold(maxMemSize);
    
    // Location to save data that is larger than maxMemSize.
    factory.setRepository(new File("c:\\temp"));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	List<FileItem> items = upload.parseRequest(request);
	int i = 0;
	for (FileItem item : items){
		String name = item.getName();
		long size = item.getSize();
		String fname = item.getFieldName();
		boolean isMem = item.isInMemory();
		out.print(name + ":" + size + ":" + fname + ":" + isMem + "<br>");
		
		item.write(new File(uploadPath, "my" + i++ + ".png"));
		
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