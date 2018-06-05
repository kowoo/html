package model;

public class Comment {
	private String nick;
	private String comment;
	private String pw;
	
	public Comment() {	}
	//회원
	public Comment(String nick, String comment) {
		this.nick = nick;
		this.comment = comment;		
	}
	//비회원
	public Comment(String nick, String comment, String pw) {
		this.nick = nick;
		this.comment = comment;
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Comment [nick=" + nick + ", comment=" + comment + ", pw=" + pw + "]";
	}
	
	
}
