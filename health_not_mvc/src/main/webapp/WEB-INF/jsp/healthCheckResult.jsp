<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Double bmi = (Double) request.getAttribute("bmi");
String bodyType = (String) request.getAttribute("bodyType");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>結果</h1>
	<p><%= bmi %></p>
	<p><%= bodyType %></p>
</body>
</html>