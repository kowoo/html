package dao;

import java.util.List;

import model.Comment;

public interface CommentDao {
	public int insertComment(Comment b);
	public int deleteComment(String num);
	public Comment selectComment(String num);
	public List<Comment> selectAllComment();
}
