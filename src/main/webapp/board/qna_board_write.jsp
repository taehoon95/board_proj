<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<link rel="stylesheet" href="/board_proj/css/qna_board_write.css">
</head>
<body>
		${article }
		<h2>게시판 글등록</h2>
		<form action="boardWritePro.do" method="post"
			enctype="multipart/form-data" name="boardform">
			<section id="writeForm">
			<table>
				<tr>
					<td class="td_left"><label for="board_name">글쓴이</label></td>
					<td class="td_right"><input type="text" name="board_name"
						id="board_name" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_pass">비밀번호</label></td>
					<td class="td_right"><input type="text" name="board_pass"
						id="board_pass" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_subject">제목</label></td>
					<td class="td_right"><input type="text" name="board_subject"
						id="board_subject" required></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_content">내용</label></td>
					<td class="td_right"><textarea name="board_content"
							id="board_content" cols="40" rows="15" required>
						</textarea></td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_file">파일첨부</label></td>
					<td class="td_right"><input type="file" name="board_file"
						id="board_file" required></td>
				</tr>
			</table>
	</section>
	<section id="commandCell">
		<input type="submit" value="등록">&nbsp;&nbsp; <input
			type="reset" value="다시쓰기">
	</section>
	</form>
</body>
</html>