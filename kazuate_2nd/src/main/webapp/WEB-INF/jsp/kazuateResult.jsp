<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Kazu" %>
<%
Kazu kazu = (Kazu) request.getAttribute("kazu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>結果</h1>
	<p>あなたの数字：<%= kazu.getUser() %></p>
	<p><%= kazu.getResult() %></p>
	<p><a href="kazuate.jsp">もう一回</a></p>
</body>
</html>