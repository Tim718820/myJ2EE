<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Locale locale = request.getLocale();
%>
Locale: <%=locale.getCountry() %><br>
DisplayName: <%=locale.getDisplayCountry() %><br>
Language: <%=locale.getLanguage() %><br>
<hr>
<fmt:setBundle basename="res"/>
<fmt:message key="Hello"/>,<fmt:message key="World"/>
<hr>
<fmt:message key="CompanyName"/>
<hr>
<%
	Date now = new Date();
	out.print(now);
	pageContext.setAttribute("now", now);
%>
<hr>
<fmt:setTimeZone value="Africa/Kampala"/>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>
<fmt:setTimeZone value="Asia/Taipei"/>
<fmt:formatDate value="${now }" type="both" dateStyle="long"/>
<hr>
Default:<fmt:formatNumber value="${1234567.343678}"/><br>
沒千分位:<fmt:formatNumber value="${1234567.343678}" groupingUsed="false"/><br>
Max4:<fmt:formatNumber value="${1234567.343678}" maxIntegerDigits="5"/><br>
Min2:<fmt:formatNumber value="${1234567.343678}" minIntegerDigits="8"/><br>
Fraction Max 2 digit:
<fmt:formatNumber value="${1234567.343678}" maxFractionDigits="2"/><br>
<fmt:formatNumber value="${123}" type="currency" currencyCode="JPY"/>
</body>
</html>