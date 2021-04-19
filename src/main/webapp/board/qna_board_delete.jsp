<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 글 삭제하기</title>
<link rel="stylesheet" href="/board_proj/css/qna_board_delete.css">
</head>
<body>
	<section id = "passForm">
		<form name="deleteForm" action="boardDelete.do?board_num=${board_num }" method="post">
			<input type="hidden" name="page" value="${page }"/>
			<fieldset class="deleteform">
			<legend>게시글 삭제하기</legend>
			<table>
				<tr>
					<td>
						<label>글 비밀번호 : </label>
					</td>
					<td>
						<input name="board_pass" type="password"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="삭제">&nbsp;&nbsp;
						<input type="button" value="돌아가기" onclick="javascript:history.go(-1)"/>
					</td>
				</tr>
			</table>
			</fieldset>
		</form>
	</section>
</body>
</html>