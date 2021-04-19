package board_proj.service;

import java.sql.Connection;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDs;
import board_proj.dto.BoardDTO;

public class BoardWriterService {
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDs.getConnection();
	
	public BoardWriterService() {
		dao.setCon(con);
	}
	
	public boolean registerArticle(BoardDTO boardDTO) {
		return dao.insertArticle(boardDTO) == 1 ? true : false;
	}
}
