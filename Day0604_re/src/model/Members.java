package model;

public class Members {
	private int memberNumber;
	private String id;
	private String pw;
	private String nick;
	private String name;
	public Members() {}
	public Members(String id, String pw, String nick, String name) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.name = name;
	}
	public Members(int memberNumber, String id, String pw, String nick, String name) {
		this.memberNumber = memberNumber;
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.name = name;
	}
	public int GetMemberNumber() {
		return memberNumber;
	}
	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
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
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Member [memberNumber=" + memberNumber +", id=" + id + ", pw=" + pw + ", nick=" + nick + ", name=" + name + "]";
	}
	
}
