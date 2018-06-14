package model;

import java.util.Date;

public class Comment {
	private int num;
	private int count;
	private String writerId;
	private String name;
	private String text;
	private Date writeDate;
	public Comment() {
	}
	public Comment(int num, int count, String writerId, String name, String text, Date writeDate) {
		this.num = num;
		this.count = count;
		this.writerId = writerId;
		this.name = name;
		this.text = text;
		this.writeDate = writeDate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
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
	@Override
	public String toString() {
		return "Comment [num=" + num + ", count=" + count + ", writerId=" + writerId + ", name=" + name + ", text="
				+ text + ", writeDate=" + writeDate + "]";
	}
}
