package model;

public class Student {
	private int snum;
	private String name;
	private int grade;
	private int kor;
	private int eng;
	private int math;
	
	public Student() {
		name = "이름없음";
		grade = 0;
		kor = 0;
		eng = 0;
		math = 0;
	}
	public Student(int snum, String name,int grade,int kor,int eng,int math) {
		this.snum = snum;
		this.name = name;
		this.grade = grade;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void getSnum() {
		this.snum = snum;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	
} 