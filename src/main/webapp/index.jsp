<%@page import="board_proj.ds.JndiDs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC게시판</title>
<link rel="stylesheet" href="/board_proj/css/logo.css">

<style>

</style>
</head>
<body>
<div class="logo">
  <a>게시판</a>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <a href="boardWriteForm.do" >글쓰기</a>
  <br>
  <br>
  <br>
  <br>
  <a href="boardList.do">목록으로</a>
</div>
<%-- 방가~~~~~~~~!!!<br>
<%=JndiDs.getConnection() %> --%>
</body>
</html>