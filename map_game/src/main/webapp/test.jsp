<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test</h1>
	<table>
	<c:forEach var="y" begin="0" end="4" step="1">
		<tr>
		<c:forEach var="x" begin="0" end="4" step="1">
			<td><c:out value="${test.map[y][x]}" /></td>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>		
</body>
</html>