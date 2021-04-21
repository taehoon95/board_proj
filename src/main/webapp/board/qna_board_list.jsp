<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 리스트</title>
<link rel="stylesheet" href="/board_proj/css/table.css">
</head>
<body>
	<h2>게시판 목록</h2>
	
	<section id = "list">
	<div class = "container">
		<h3><a href="boardWriteForm.do">게시판 글쓰기</a></h3>
		<table class="tbl_type">
			<tr id=title>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>

			<c:forEach var="board" items="${articleList }">
				<tr>
					<td>${board.board_num}</td>
					<td id="subject">
	 					<c:if test="${board.board_re_lev ne 0}">
	 						<c:forEach var="i" begin="1" end="${board.board_re_lev*2}">
	 							&nbsp;
	 						</c:forEach>
	 						&#8618;
	 					</c:if>
	 						<a href="boardDetail.do?board_num=${board.board_num}&page=${pageInfo.page}">
								${board.board_subject}
							</a>
					</td>
					<td>${board.board_name}</td>
					<td>${board.board_date}</td>
					<td>${board.board_re_readcount}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</section>
<%-- ${pageInfo} --%>
	<section class="pageInfo">
	<c:choose>
		<c:when test="${fn:length(articleList) != 0 && pageInfo.listCount > 0 }">
			<section>
				<c:choose>
					<c:when test="${pageInfo.page <= 1 }">
						[이전]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="boardList.do?page=${pageInfo.page -1}">[이전]</a>&nbsp;
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="a" begin="1" end="${pageInfo.endPage}">
					<c:choose>
						<c:when test="${a == pageInfo.page}">
							<span>[${a}]</span>&nbsp;
						</c:when>
						<c:otherwise>
							<a href="boardList.do?page=${a}">[${a}]</a>&nbsp;
						</c:otherwise>
					</c:choose>
				</c:forEach>
				
				<c:choose>
					<c:when test="${pageInfo.page >= pageInfo.maxPage }">
						[다음]&nbsp;
					</c:when>
					<c:otherwise>
						<a href="boardList.do?page=${pageInfo.page +1}">[다음]</a>&nbsp;
					</c:otherwise>
				</c:choose>
			</section>
		</c:when>
		<c:otherwise>
			<section>등록된 글이 없습니다.</section>
		</c:otherwise>
	</c:choose>
		<%-- <c:if test="${pageInfo.page <= 1 }">
			[이전]&nbsp;
		</c:if>
		<c:if test="${pageInfo.page > 1 }">
			<a href="boardList.do?page=${pageInfo.page -1} ">[이전]</a>&nbsp;
		</c:if>

		<c:forEach var="a" begin="1" end="${pageInfo.endPage}">
			<c:if test="${a  == pageInfo.page}">
				<span>[${a}]</span>&nbsp;
			</c:if>
			<c:if test="${a  ne pageInfo.page }">
				<a href="boardList.do?page=${a} ">[${a}]</a>&nbsp;
			</c:if>
		</c:forEach>
		<c:if test="${pageInfo.page >= pageInfo.maxPage }">
			[다음]&nbsp;
		</c:if>
		<c:if test="${pageInfo.page < pageInfo.maxPage }">
			<a href="boardList.do?page=${pageInfo.page + 1 } ">[다음]</a>&nbsp;
		</c:if> --%>
	</section>
</body>
</html>