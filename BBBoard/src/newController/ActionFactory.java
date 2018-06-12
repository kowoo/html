package newController;

import newController.Action.BoardDeleteAction;
import newController.Action.BoardListFormAction;
import newController.Action.BoardModifyAction;
import newController.Action.BoardModifyFormAction;
import newController.Action.BoardViewFormAction;
import newController.Action.BoardWriteAction;
import newController.Action.BoardWriteFormAction;
import newController.Action.MemberDeleteAction;
import newController.Action.MemberJoinAction;
import newController.Action.MemberJoinFormAction;
import newController.Action.MemberLoginAction;
import newController.Action.MemberLoginFormAction;
import newController.Action.MemberLogoutAction;
import newController.Action.MemberModifyAction;
import newController.Action.MemberModifyFormAction;
import newController.Action.MemberViewFormAction;

public class ActionFactory{
	public static Action getAction(String command) {
		Action action=null;
		System.out.println(command+" 시작");
		//보드 액션 9개
		if(command.equals("board_list")) {
			action = new BoardListFormAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewFormAction();
		}else if(command.equals("board_modify_form")) {
			action = new BoardModifyFormAction();
		}else if(command.equals("board_modify")) {
			action = new BoardModifyAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}
		//보드 액션 종료
		
		//멤버 액션 7개
		else if(command.equals("member_join_form")) {
			action = new MemberJoinFormAction();
		}else if(command.equals("member_join")) {
			action = new MemberJoinAction();
		}else if(command.equals("member_login_form")) {
			action = new MemberLoginFormAction();
		}else if(command.equals("member_login")) {
			action = new MemberLoginAction();
		}else if(command.equals("member_logout")) {
			action = new MemberLogoutAction();
		}else if(command.equals("member_modify_form")) {
			action = new MemberModifyFormAction();
		}else if(command.equals("member_modify")) {
			action = new MemberModifyAction();
		}else if(command.equals("member_viewForm")) {
			action = new MemberViewFormAction();
		}else if(command.equals("member_delete")) {
			action = new MemberDeleteAction();
		}
		//멤버 액션 종료
		return action;
	}
}
