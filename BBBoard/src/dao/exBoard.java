package dao;

import model.Board;

public class exBoard {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImp.getInstance();
		String id="";
		String title="";
		String content="";
		String name="";
		for(int i=1; i<=30; i++) {
			int	a= (int)(Math.random()*8)+1;
			id="dog"+i;
			switch(a) {
			case 1:
				title="비글이에요";
				content="비글비글";
				name="비글";
				break;
			case 2:
				title="푸들이에요";
				content="푸들푸들";
				name="푸들";
				break;
			case 3:
				title="웰시코기에요";
				content="웰시코기웰시코기";
				name="웰시코기";
				break;	
			case 4:
				title="물방개에요";
				content="물방개물방개";
				name="물방개";
				break;
			case 5:
				title="악어에요";
				content="악어악어";
				name="악어";
			case 6:
				title="홍삼이에요";
				content="홍삼홍삼";
				name="홍삼";
				break;	
			case 7:
				title="치약이에요";
				content="치약치약";
				name="치약";
				break;
			case 8:
				title="나무늘보에요";
				content="나무...";
				name="나무늘보";
			}
			Board b = new Board();
			b.setWriterId(id);
			b.setTitle(title);
			b.setName(name);
			b.setContent(content);
			dao.insertBoard(b);
		}
	}
	
}
