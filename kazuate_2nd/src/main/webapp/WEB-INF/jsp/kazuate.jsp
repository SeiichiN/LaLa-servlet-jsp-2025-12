<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Kazu" %>
<%
Kazu kasu = (Kazu)request.getAttribute("kazu");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>数当てゲーム</h1>
	<% if (kasu.getResult() != null) { %>
		<p><%= kasu.getResult() %></p>
	<% } %>
	<form action="GameController" method="post">
		<p>1〜99までの数を入力してください</p>
		<input type="text" name="num" value="<%= kasu.getNum() %>">
		<input type="hidden" name="kotae" value="<%= kasu.getKotae() %>">	
		<input type="submit" value="送信">
	</form>
	<p>別の数字で挑戦する場合は<a href="GameController">こちら</a></p>
</body>
</html>