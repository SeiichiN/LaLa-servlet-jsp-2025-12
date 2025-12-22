<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Kazu" %>
<%
Kazu kazu = (Kazu) session.getAttribute("kazu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= kazu.getKotae() %>
</body>
</html>