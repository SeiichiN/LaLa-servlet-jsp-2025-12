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
<title>数当てゲーム</title>
</head>
<body>
	<h1>数当てゲーム</h1>
	<form action="GameController" method="post">
		<p>1～99の数を入力してください</p>
		<input type="text" name="user"><br>
		<input type="hidden" name="kotae" value="<%= kazu.getKotae() %>">
		<input type="submit" value="送信">
	</form>
	<% if (kazu.getUser() > 0) { %>
		<p>あなたの数：<%= kazu.getUser() %></p>
		<p><%= kazu.getResult() %></p>
	<% } %>
	<p><a href="GameController">別の数字で挑戦</a></p>
</body>
</html>