package controller;

import controller.Action.Action;
import controller.Action.BoardCheckPassAction;
import controller.Action.BoardCheckPassFormAction;
import controller.Action.BoardDeleteAction;
import controller.Action.BoardListAction;
import controller.Action.BoardModifyAction;
import controller.Action.BoardModifyFormAction;
import controller.Action.BoardViewAction;
import controller.Action.BoardWriteAction;
import controller.Action.BoardWriteFormAction;

public class ActionFactory {
	//요청에 따라서 실제 동작할 객체를 만들어주는 역할
	
	public static Action getAction(String command) {
		Action action=null;
		
		System.out.println(command+" 시작");
		if(command.equals("board_list")) {
			action= new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action= new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action= new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action= new BoardViewAction();
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
		return action;
	}
}
