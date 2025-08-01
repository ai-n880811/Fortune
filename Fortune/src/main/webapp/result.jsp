<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Bean.Fortune" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>運勢結果</title>
<link rel="stylesheet" href="./style.css">
</head>
<body>


<!-- ここでfortuneを受け取る -->
 
 <%
Fortune f = (Fortune) request.getAttribute("fortune");
%>


<!-- ここでfortuneの中身を取り出す -->

<p style="color:<%= ((Fortune)request.getAttribute("fortune")).getColor() %>;">
    今日の運勢は <strong><%= ((Fortune)request.getAttribute("fortune")).getResult() %></strong> です！<br>
    <%= ((Fortune)request.getAttribute("fortune")).getMessage() %>
</p>


<br>
<p>	もう一度占う</p>
<form action="./FortuneAction" method="post">
		<button type="submit" name="type" value="love">恋愛運</button>
		<button type="submit" name="type" value="work">仕事運</button>
		<button type="submit" name="type" value="money">金運</button>
	</form>

</body>
</html>