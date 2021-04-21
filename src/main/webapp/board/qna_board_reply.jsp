<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 답변</title>
<link rel="stylesheet" href="/board_proj/css/qna_board_write.css">
</head>
<body>
	${article }
	${page }
	<section id="writeForm">
		<h2>답변글 등록</h2>
		<form action="boardReplyPro.do" method="post" name="boardform">
		<input type="hidden" name="page" value="${page }">
		<input type="hidden" name="board_num" value="${article.board_num }">
		<input type="hidden" name="board_re_ref" value="${article.board_re_ref }">
		<input type="hidden" name="board_re_lev" value="${article.board_re_lev }">
		<input type="hidden" name="board_re_seq" value="${article.board_re_seq }">
			<table>
				<tr>
					<td class="td_left"><label for="board_name">글쓴이</label></td>
					<td class="td_right"><input type="text" name="board_name"
						id="board_name" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_pass">비밀번호</label></td>
					<td class="td_right"><input type="password" name="board_pass"
						id="board_pass" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_subject">제목</label></td>
					<td class="td_right"><input type="text" name="board_subject"
						id="board_subject" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_content">내 용</label></td>
					<td class="td_right"><textarea cols="40" rows="15"
							name="board_content" id="board_content" required> </textarea></td>
				</tr>
			</table>
			<section id = "commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기">
			</section>
		</form>
	</section>
</body>
</html>