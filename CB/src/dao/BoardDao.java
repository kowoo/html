package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	public int insertBoard(Board b);
	public int updateBoard(Board b, String userId);
	public int deleteBoard(String num, String userId);
	public Board selectBoard(String num);
	public List<Board> selectAllBoard();
	public List<Board> selectAllBoard(int firstRow, int endRow);
	public int upReadCount(String num);
	public int boardCount();
	int upComment(String num);
	int downComment(String num);
}
