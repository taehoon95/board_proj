package board_proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.action.Action;
import board_proj.action.BoardDeleteFormAction;
import board_proj.action.BoardDeleteProAction;
import board_proj.action.BoardDetailAction;
import board_proj.action.BoardListAction;
import board_proj.action.BoardModifyProAction;
import board_proj.action.BoardModifyFormAction;
import board_proj.action.BoardReplyFormAction;
import board_proj.action.BoardReplyProAction;
import board_proj.action.BoardWriteFormAction;
import board_proj.action.BoardWriteProAction;
import board_proj.action.fileDownAction;
import board_proj.dto.ActionForward;

@WebServlet("*.do")
public class boardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String RequestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = RequestURI.substring(contextPath.length());

		String command = request.getServletPath();

		ActionForward forward = null;
		Action action = null;

		try {
			/////// 게시판 글쓰기
			if (command.equals("/boardWriteForm.do")) {
//			request.getRequestDispatcher(/board/qna_board_write.jsp).forward(request, response);
				action = new BoardWriteFormAction();
				forward = action.execute(request, response);
			} else if (command.equals("/boardWritePro.do")) {
//			board_name=aaa&board_pass=aaa&board_subject=aaa&board_content=aaa&board_file=image.png
				action = new BoardWriteProAction();
				forward = action.execute(request, response);

				/////// 게시판 목록
			} else if (command.equals("/boardList.do")) {
				action = new BoardListAction();
				forward = action.execute(request, response);

				/////// 글 들어가서 보기
			} else if (command.equals("/boardDetail.do")) {
				action = new BoardDetailAction();
				forward = action.execute(request, response);

				/////// 파일 다운로드 하기
			} else if (command.equals("/file_down.do")) {
				action = new fileDownAction();
				forward = action.execute(request, response);

				////// 삭제하기
			} else if (command.equals("/boardDeleteForm.do")) {
				// board_num=36&page=1
				action = new BoardDeleteFormAction();
				forward = action.execute(request, response);
			} else if (command.equals("/boardDelete.do")) {
//			boardDeleteForm.do?board_num=36&page=1
				action = new BoardDeleteProAction();
				forward = action.execute(request, response);

				// 글 수정하기
			} else if (command.equals("/boardModifyForm.do")) {
				action = new BoardModifyFormAction();
				forward = action.execute(request, response);
			} else if (command.equals("/boardModify.do")) {
				action = new BoardModifyProAction();
				forward = action.execute(request, response);

				////// 답변하기
			} else if (command.equals("/boardReplyForm.do")) {
				action = new BoardReplyFormAction();
				forward = action.execute(request, response);
			} else if (command.equals("/boardReplyPro.do")) {
				action = new BoardReplyProAction();
				forward = action.execute(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
}
