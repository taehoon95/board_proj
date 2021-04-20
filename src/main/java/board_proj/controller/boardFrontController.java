package board_proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.action.Action;
import board_proj.action.BoardDeleteProAction;
import board_proj.action.BoardDetailAction;
import board_proj.action.BoardListAction;
import board_proj.action.BoardModifyProAction;
import board_proj.action.BoardModifyFormAction;
import board_proj.action.BoardReplyFormAction;
import board_proj.action.BoardWriterProAction;
import board_proj.action.fileDownAction;
import board_proj.dto.ActionForward;


@WebServlet("*.do")
public class boardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	private void doProcess(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {	
//		String RequestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
//		String command = RequestURI.substring(contextPath.length());
		
		String command = request.getServletPath();
		
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/boardWriterForm.do")) {
//			request.getRequestDispatcher(/board/qna_board_write.jsp).forward(request, response);
			forward = new ActionForward();
			forward.setPath("/board/qna_board_write.jsp");
		}else if(command.equals("/boardWritePro.do")) {
//			board_name=aaa&board_pass=aaa&board_subject=aaa&board_content=aaa&board_file=image.png

			action = new BoardWriterProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		///////게시판 목록
		}else if(command.equals("/boardList.do")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		/////// 글 들어가서 보기
		}else if(command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		/////// 파일 다운로드 하기
		}else if(command.equals("/file_down.do")) {
			action = new fileDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		////// 답변하기
		}else if(command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		////// 삭제하기
		}else if(command.equals("/boardDeleteForm.do")) {
			//board_num=36&page=1
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);
			
			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);
			
			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		}else if(command.equals("/boardDelete.do")) {
//			boardDeleteForm.do?board_num=36&page=1
			action = new BoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		// 글 수정하기	
		}else if(command.equals("/boardModifyForm.do")) {
			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardModify.do")) {
			action = new BoardModifyProAction();
			try {
			forward = action.execute(request, response);
			} catch (Exception e) {
			e.printStackTrace();
			}
		}
		
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
}
