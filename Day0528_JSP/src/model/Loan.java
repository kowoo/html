package model;

public class Loan {
	//회차 별 대출 상환 정보를 저장할 수 있는 클래스
	
	//상환액: repayTotal (월 상환원금+이자)
	//상환 원금: repayOrigin (월 상환원금)
	//이자: interest
	//상환총액: repaySum (현재까지 갚은 금액)
	//대출잔액: repayRemain
	int repayTotal;
	int repayOrigin;
	int interest;
	int repaySum;
	int repayRemain;
	
	public Loan() { }
	//원금 균등상환: repayMonth + 이자
	//원리금 균등상환: repayMonth;
	
	public Loan(int repayTotal, int repayOrigin, int interest, int repaySum, int repayRemain) {
		Loan loan = new Loan();
		this.repayTotal = repayTotal;
		this.repayOrigin = repayOrigin;
		this.interest = interest;
		this.repaySum = repaySum;
		this.repayRemain = repayRemain;
	}

	public int getRepayTotal() {
		return repayTotal;
	}

	public void setRepayTotal(int repayTotal) {
		this.repayTotal = repayTotal;
	}

	public int getRepayOrigin() {
		return repayOrigin;
	}

	public void setRepayOrigin(int repayOrigin) {
		this.repayOrigin = repayOrigin;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getRepaySum() {
		return repaySum;
	}

	public void setRepaySum(int repaySum) {
		this.repaySum = repaySum;
	}

	public int getRepayRemain() {
		return repayRemain;
	}

	public void setRepayRemain(int repayRemain) {
		this.repayRemain = repayRemain;
	}
	
	
	
}
