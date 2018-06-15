package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action.BoardDeleteAction;
import controller.Action.BoardListFormAction;
import controller.Action.BoardModifyAction;
import controller.Action.BoardModifyFormAction;
import controller.Action.BoardViewFormAction;
import controller.Action.BoardWriteAction;
import controller.Action.BoardWriteFormAction;
import controller.Action.CommentDeleteAction;
import controller.Action.CommentListFormAction;
import controller.Action.CommentWriteAction;
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
		//view와 action을 구분하는게 좋을듯?
		
		//보드 액션
		if(command.equals("board_list")) {
			action= new BoardListFormAction();
		}else if(command.equals("board_write_form")) {
			action= new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action= new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action= new BoardViewFormAction();
		}else if(command.equals("board_modify_form")) {
			action= new BoardModifyFormAction();
		}else if(command.equals("board_modify")) {
			action= new BoardModifyAction();
		}else if(command.equals("board_delete")) {
			action= new BoardDeleteAction();
		}
		//보드 액션
		
		//멤버 액션
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
		}else if(command.equals("member_view")) {
			action = new MemberViewFormAction();
		}else if(command.equals("member_delete")) {
			action = new MemberDeleteAction();
		}
		//멤버 액션
		
		//코멘트 액션
		else if(command.equals("comment_list")) {
			action = new CommentListFormAction();
		}else if(command.equals("comment_write")) {
			action = new CommentWriteAction();
		}else if(command.equals("comment_delete")) {
			action = new CommentDeleteAction();
		}
		//코멘트 액션
		
		return action;
	}
	
	public interface Action {
		public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
		//이런 액션들을 처리클래스, 핸들러라고 한다
	}
}
