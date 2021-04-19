package board_proj.dto;

import java.sql.Date;

public class BoardDTO {

	private int board_num;
	private String board_name;
	private String board_pass;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int board_re_ref;
	private int board_re_lev;
	private int board_re_seq;
	private int board_re_readcount;
	private Date board_date;

	public BoardDTO(int board_num, String board_name, String board_pass, String board_subject, String board_content,
			String board_file, int board_re_ref, int board_re_lev, int board_re_seq, int board_re_readcount,
			Date board_date) {
		super();
		this.board_num = board_num;
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_file = board_file;
		this.board_re_ref = board_re_ref;
		this.board_re_lev = board_re_lev;
		this.board_re_seq = board_re_seq;
		this.board_re_readcount = board_re_readcount;
		this.board_date = board_date;
	}

	public BoardDTO(String board_name, String board_pass, String board_subject, String board_content,
			String board_file) {
		super();
		this.board_name = board_name;
		this.board_pass = board_pass;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_file = board_file;
	}

	public BoardDTO() {
		super();
	}


	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	public String getBoard_pass() {
		return board_pass;
	}

	public void setBoard_pass(String board_pass) {
		this.board_pass = board_pass;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_file() {
		return board_file;
	}

	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}

	public int getBoard_re_ref() {
		return board_re_ref;
	}

	public void setBoard_re_ref(int board_re_ref) {
		this.board_re_ref = board_re_ref;
	}

	public int getBoard_re_lev() {
		return board_re_lev;
	}

	public void setBoard_re_lev(int board_re_lev) {
		this.board_re_lev = board_re_lev;
	}

	public int getBoard_re_seq() {
		return board_re_seq;
	}

	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}

	public int getBoard_re_readcount() {
		return board_re_readcount;
	}

	public void setBoard_re_readcount(int board_re_readcount) {
		this.board_re_readcount = board_re_readcount;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	@Override
	public String toString() {
		return String.format(
				"BoardDTO [board_num=%s, board_name=%s, board_pass=%s, board_subject=%s, board_content=%s, board_file=%s, board_re_ref=%s, board_re_lev=%s, board_re_seq=%s, board_re_readcount=%s, board_date=%s]",
				board_num, board_name, board_pass, board_subject, board_content, board_file, board_re_ref, board_re_lev,
				board_re_seq, board_re_readcount, board_date);
	}

}
