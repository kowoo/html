package controller;

import controller.Action.Action;
import controller.Action.BoardCheckPassAction;
import controller.Action.BoardCheckPassFormAction;
import controller.Action.BoardDeleteAction;
import controller.Action.BoardListFormAction;
import controller.Action.BoardModifyAction;
import controller.Action.BoardModifyFormAction;
import controller.Action.BoardViewFormAction;
import controller.Action.BoardWriteAction;
import controller.Action.BoardWriteFormAction;
import controller.Action.MemberDeleteAction;
import controller.Action.MemberJoinAction;
import controller.Action.MemberJoinFormAction;
import controller.Action.MemberLoginAction;
import controller.Action.MemberLoginFormAction;
import controller.Action.MemberLogoutAction;
import controller.Action.MemberModifyAction;
import controller.Action.MemberModifyFormAction;
import controller.Action.MemberViewFormAction;

public class ActionFactory{
	public static Action getAction(String command) {
		Action action=null;
		System.out.println(command+" 시작");
		//보드 액션 9개
		if(command.equals("board_list")) {
			action= new BoardListFormAction();
		}else if(command.equals("board_write_form")) {
			action= new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action= new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action= new BoardViewFormAction();
		}else if(command.equals("board_check_pass_form")) {
			action= new BoardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action= new BoardCheckPassAction();
		}else if(command.equals("board_modify_form")) {
			action= new BoardModifyFormAction();
		}else if(command.equals("board_modify")) {
			action= new BoardModifyAction();
		}else if(command.equals("board_delete")) {
			action= new BoardDeleteAction();
		}
		//보드 액션
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
		//멤버 액션
		return action;
	}
}
