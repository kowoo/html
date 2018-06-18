package model;

import java.util.Date;

public class Board {
	private int num;
	private String writerId;
	private String title;
	private String name;
	private String content;
	private int readCount;
	private int comments;
	private Date writeDate;
	private String writeDateString;
	public Board() {
	}
	public Board(int num, String writerId, String title, String name, String content, int readCount, int comments,
			Date writeDate, String writeDateString) {
		super();
		this.num = num;
		this.writerId = writerId;
		this.title = title;
		this.name = name;
		this.content = content;
		this.readCount = readCount;
		this.comments = comments;
		this.writeDate = writeDate;
		this.writeDateString = writeDateString;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
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
	public int getComments() {
		return comments;
	}
	public void setComments(int comments) {
		this.comments = comments;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getWriteDateString() {
		return writeDateString;
	}
	public void setWriteDateString(String writeDateString) {
		this.writeDateString = writeDateString;
	}
	@Override
	public String toString() {
		return "Board [num=" + num + ", writerId=" + writerId + ", title=" + title + ", name=" + name + ", content="
				+ content + ", readCount=" + readCount + ", comments=" + comments + ", writeDate=" + writeDate
				+ ", writeDateString=" + writeDateString + "]";
	}
}
