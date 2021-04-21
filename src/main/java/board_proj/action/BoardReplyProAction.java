package board_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardReplyService;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		ActionForward forward = null;
		BoardReplyService service = new BoardReplyService();
		
		BoardDTO boardDto = getArticle(request);
		
		if(!service.insertReplyArticle(boardDto)) {
			getMessge(response,"답변등록실패");
			return forward;
		}
		
		
		String page = request.getParameter("page");
		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("boardList.do?page="+page);

		return forward;
	}
	
	private void getMessge(HttpServletResponse response,String str) throws IOException {
		PrintWriter out = response.getWriter();
		out.write("<script>");
		out.write("alert('"+str+"');");
		out.write("history.back();");
		out.write("</script>");
	}

	private BoardDTO getArticle(HttpServletRequest request) {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");    
		String board_subject = request.getParameter("board_subject"); 
		String board_content = request.getParameter("board_content"); 
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));     
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));     
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));     
		
		
		BoardDTO boardDto = new BoardDTO();
		boardDto.setBoard_num(board_num);
		boardDto.setBoard_name(board_name);
		boardDto.setBoard_pass(board_pass);
		boardDto.setBoard_subject(board_subject);
		boardDto.setBoard_content(board_content);
		boardDto.setBoard_re_ref(board_re_ref);
		boardDto.setBoard_re_lev(board_re_lev);
		boardDto.setBoard_re_seq(board_re_seq);
		
		return boardDto;
	}
}
