<%@page import="board_proj.ds.JndiDs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
<link rel="stylesheet" href="/board_proj/css/btn.css">
</head>
<body>
<%-- 방가~~~~~~~~!!!<br>
<%=JndiDs.getConnection() %> --%>
<div class="bluelight">
	<a href="boardWriterForm.do">게시판 글쓰기</a>
</div>
</body>
</html>