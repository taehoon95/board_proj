package board_proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDs;
import board_proj.dto.BoardDTO;

public class BoardDetailService {
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();
	
	public BoardDetailService() {
		dao.setCon(con);
	}

	public BoardDTO getArticle(int board_num){
		//조회수 증가
		dao.updateReadCount(board_num);
		
		//board_num에 해당하는 BoardDTO return;
		return dao.selectArticle(board_num);
	}
	
	
}
