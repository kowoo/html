package model;

import java.util.Date;

public class Board {
	private int num;
	private String title;
	private String name;
	private String content;
	private int readCount;
	private Date writeDate;
	public Board() {
	}
	public Board(int num, String title, String name, String content, int readCount,
			Date writeDate) {
		this.num = num;
		this.title = title;
		this.name = name;
		this.content = content;
		this.readCount = readCount;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", name=" + name
				+ ", content=" + content + ", readCount=" + readCount + ", writeDate=" + writeDate + "]";
	}
}
