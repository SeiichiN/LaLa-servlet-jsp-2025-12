<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header>
		<h1><a href="startGame">Game</a></h1>
	</header>
	<div class="container">
		<section class="map-area">
			<table>
				<c:forEach var="y" begin="0" end="${gm.ysize - 1}" step="1">
					<tr>
						<c:forEach var="x" begin="0" end="${gm.xsize - 1}" step="1">
							<c:choose>
								<c:when test="${y == player.py && x == player.px}">
									<td>@</td>	
								</c:when>
								<c:otherwise>
									<td><c:out value="${gm.map[y][x]}" /></td>
								</c:otherwise>
							</c:choose>	
						</c:forEach>
					</tr>
				</c:forEach>
			</table>
		</section>
		<section class="info-area">
			<p><c:out value="${message}" /></p>
		</section>
		<section class="control-area">
			<div class="action-area">
				<form action="action" method="post">
					<div class="battle-btn">
						<button type="submit" id="battle" name="action" value="battle">戦う</button>
						<button type="submit" id="escape" name="action" value="escape">逃げる</button>
					</div>
					<div class="item-btn">
						<button type="submit" id="take" name="action" value="take">取る</button>
						<button type="submit" id="use" name="action" value="use">使う</button>
					</div>
					<button type="submit" id="end" name="action" value="end">終了する</button>
				</form>
			</div><!--  .action-area end -->
			<div class="move-area">
				<form action="move" method="post">
					<div class="up-btn">
						<button type="submit" id="up" name="dir" value="up">↑</button>
					</div>
					<div class="left-right-btn">			
						<button type="submit" id="left" name="dir" value="left">←</button>
						<button type="submit" id="right" name="dir" value="right">→</button>
					</div>
					<div class="down-btn">
						<button type="submit" id="down" name="dir" value="down">↓</button>
					</div>
				</form>
			</div>
		</section>	
	</div>
	<!--  .container end -->
	<footer>
		<small>&copy; 2025 Seiichi Nukayama</small>
	</footer>
</body>
</html>