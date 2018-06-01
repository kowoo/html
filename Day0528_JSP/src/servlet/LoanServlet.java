package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

@WebServlet("/loanService")
public class LoanServlet extends HttpServlet{
 	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Loan> loanList=new ArrayList<Loan>();
		System.out.println("로그인 요청 받음");
		
		int repayTotal,repayOrigin,interest,repaySum,repayRemain;
		
		String amountStr = req.getParameter("amount");
		String rateStr = req.getParameter("rate");
		String periodStr = req.getParameter("period");
		String typeStr= req.getParameter("type");
		
	 	int amount = Integer.parseInt(amountStr);
	 	double rate = Double.parseDouble(rateStr);
	 	int period = Integer.parseInt(periodStr);
	 	int type = Integer.parseInt(typeStr);
	 	double mRate = rate/100/12;
	 	int repayMonth;
		repayRemain = amount;
		repaySum= 0;
	 	
		if(type==1) {
			repayMonth = amount/period; 
		}else {
			repayMonth = (int)((amount*mRate*Math.pow((1+mRate),period))/(Math.pow(1+mRate,period)-1));
		}
		
		for(int i=1; i<=period; i++) {
			interest = (int)(repayRemain*mRate);
			if(type==1) {
				//원금 균등상환
				repayTotal = repayMonth+interest;//이번달 내야할 금액
				repayOrigin = repayMonth;//이번달 내야할 원금
			}else {
				//원리금 균등상환
				repayTotal = repayMonth;
				repayOrigin = repayMonth-interest;
			}
			repayRemain = repayRemain-repayOrigin;
			repaySum+= repayTotal;
			Loan loan = new Loan(repayTotal,repayOrigin,interest,repaySum,repayRemain);
			loanList.add(loan);
		}
		req.setAttribute("loanList", loanList);
		loanList = null;
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("04loanResult.jsp");
		dispatcher.forward(req, resp);
		
	}
}
