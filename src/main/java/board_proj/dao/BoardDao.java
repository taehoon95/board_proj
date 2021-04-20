package board_proj.dao;

import java.util.ArrayList;

import board_proj.dto.BoardDTO;

public interface BoardDao {

	int selectListCount();//카운트

	ArrayList<BoardDTO> selectArticleList(int page, int limit);

	BoardDTO selectArticle(int borad_num);

	int insertArticle(BoardDTO article); //글쓰기

	int insertReplyArticle(BoardDTO article);

	int updateReplyArticle(BoardDTO article);

	int deleteArticle(int board_num);

	int updateReadCount(int board_num);

	boolean isArticleBoardWriter(int board_num, String pass);
	
	int nextBoardNum();

	int updateArticle(BoardDTO article);
}
