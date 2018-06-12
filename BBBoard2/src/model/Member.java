package model;

import java.util.Date;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date regDate;
	private int boardW;
	private int commentW;
	public Member() {
	}
	public Member(String id, String pw, String name, String email, Date regDate, int boardW, int commentW) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.regDate = regDate;
		this.boardW = boardW;
		this.commentW = commentW;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBoardW() {
		return boardW;
	}
	public void setBoardW(int boardW) {
		this.boardW = boardW;
	}
	public int getCommentW() {
		return commentW;
	}
	public void setCommentW(int commentW) {
		this.commentW = commentW;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", regDate=" + regDate
				+ ", boardW=" + boardW + ", commentW=" + commentW + "]";
	}
}
