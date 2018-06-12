package model;

import java.util.Date;

public class Comment {
	private String title;
	private int num;
	private String name;
	private String text;
	private Date writeDate;
	public Comment() {
	}
	public Comment(String title, int num, String name, String text, Date writeDate) {
		super();
		this.title = title;
		this.num = num;
		this.name = name;
		this.text = text;
		this.writeDate = writeDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Comment [title=" + title + ", num=" + num + ", name=" + name + ", text=" + text + ", writeDate="
				+ writeDate + "]";
	}
}
