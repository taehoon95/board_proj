package board_proj.dao.impl;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board_proj.JdbcUtil;
import board_proj.dto.BoardDTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoImplTest {

	private static Connection con = JdbcUtil.getConnection();
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testNextBoardNum() {
		System.out.println("testNextBoardNum");

		int res = dao.nextBoardNum();
		Assert.assertNotEquals(0, res);
		System.out.println("next Number >> " + res);
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void test01SelectListCount() {
		System.out.println("testSelectListCount");
		int res = dao.selectListCount();
		Assert.assertNotEquals(-1, res);

		System.out.println("ListCount >> " + res);
	}

	@Test
	public void test03SelectArticleList() {
		System.out.println("testSelectArticleList");
		int page = 1;
		int limit = 10;

		List<BoardDTO> list = dao.selectArticleList(page, limit);
		Assert.assertNotNull(list);

		list.stream().forEach(System.out::println);
		System.out.println("=======================");
		dao.selectArticleList(2, 10).stream().forEach(System.out::println);
	}

	@Test
	public void testSelectArticle() {
		System.out.println("testSelectArticle");
		int board_num = 4;
		BoardDTO article = dao.selectArticle(board_num);

		Assert.assertNotNull(article);
		System.out.println(article);
	}

	// @Test
	public void test02InsertArticle() {
		System.out.println("testInsertArticle");

		BoardDTO article = new BoardDTO("이태훈", "1111", "끝날시간", "4시", "test.txt");
		int res = dao.insertArticle(article);
		Assert.assertEquals(1, res);
		System.out.println(article);
	}

	@Test
	public void testInsertReplyArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReplyArticle() {
		fail("Not yet implemented");
	}

	// @Test
	public void test06updateReadCount() {
		System.out.println("testupdateReadCount");
		int board_num = 32;

		int res = dao.updateReadCount(board_num);
		Assert.assertEquals(1, res);
		System.out.println("res >>" + res);
	}

	@Test
	public void test07IsArticleBoardWriter() {
		System.out.println("test07IsArticleBoardWriter");
		int board_num = 22;
		boolean res = dao.isArticleBoardWriter(board_num, "1111");
		
		Assert.assertEquals(true, res);
		System.out.println("res >> " + res);
	}

	 @Test
		public void test08updateArticle() {
			System.out.println("test08updateArticle");
			int board_num = 22;
			BoardDTO article = dao.selectArticle(board_num);
			int res = dao.updateArticle(article);
			Assert.assertEquals(1, res);
			
			System.out.println(article);
		}
	
	@Test
	public void test09DeleteArticle() {
		System.out.println("testDeleteArticle");
		int board_num = dao.nextBoardNum() - 1;

		int res = dao.deleteArticle(board_num);
		Assert.assertEquals(1, res);
		System.out.println("delete  " + res);

	}

}
