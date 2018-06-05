package model;

import java.util.Date;

public class Post {
	private String postNumber;
	private String title;
	private String content;
	private String nick;
	private String pw;
	private Date regDate;
	
	public Post() {}
	//회원
	public Post(String postNumber, String title, String content, String nick) {
		this.postNumber = postNumber;
		this.title = title;
		this.content = content;
		this.nick = nick;
	}
	//비회원
	public Post(String postNumber, String title, String content, String nick, String pw) {
		this.postNumber = postNumber;
		this.title = title;
		this.content = content;
		this.nick = nick;
		this.pw = pw;
	}
	public String getPostNumber() {
		return postNumber;
	}
	public void setPostNumber(String postNumber) {
		this.postNumber = postNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + ", regDate=" + regDate + ", nick=" + nick + ", pw="
				+ pw + "]";
	}
	
	
}
