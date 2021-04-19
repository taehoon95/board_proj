package board_proj.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.dto.PageInfo;
import board_proj.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardListService service = new BoardListService();
		
		ArrayList<BoardDTO> list = service.getArticleList(page, limit);
		
		//총 리스트 개수
		int listCount = service.getListCount();
		
		int maxPage = (int) Math.ceil(listCount/limit)+1;
		
		//1page 1~5, 2page 6~10, 3page 11~15, 4page 16~20, ...
		// 11page 51~55,
		
		//	[이전] startpage = [1]    [2][3][4][5][6][7][8][9][10] [다음]
		//	[이전] startpage = [11]  [12][13][14][15][16][17][18][19][20] [다음]
		//	[이전] startpage = [21]  [22][23][24][25][26][27][28][29][30] [다음]
//		int startPage = (((int) ((double)page / limit + 0.9))-1)*10+1; 
		int startPage = (int) Math.floor(page/10) * 10+1; 
		int endPage = startPage + 9;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}

//		System.out.println("listCount = " + listCount + " maxPage >> " + maxPage);
//		System.out.println("startPage>>" + startPage);
		
		//생성자
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);		
		request.setAttribute("articleList", list);
		request.setAttribute("pageInfo", pageInfo);
	
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");

		return forward;
	}

}
