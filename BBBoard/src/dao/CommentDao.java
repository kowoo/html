package dao;

import java.util.List;

import model.Comment;

public interface CommentDao {
	public int insertComment(Comment b);
	public int deleteComment(String id, String count);
	public Comment selectComment(String count);
	public List<Comment> selectAllComment();
	public List<Comment> selectAllCommentbyBoard(String num);
}
