<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	//비밀번호가 맞았을 때, 팝업화면에서 요청 진행을 하지 않고
	//큰 화면에서 요청을 진행하도록 만들어주는 jsp
	
	//열려있는 창의 부모 창의 주소를 바꿔주는듯? parent 자너!
	//window.opener.parent.location.href="board?command=board_modify_form&num=${param.num}";
	
	//비밀번호가 맞았을 때, 
	// update : 팝업화면에서 계속 요청진행이 아니라 큰화면에서 요청을 진행 하도록 하는 기능
	//delete : 삭제요청 만들면됨
	if(window.name=="modify"){
		window.opener.parent.location.href="board?command=board_modify_form&num=${param.num}";	
	}else if(window.name=="delete"){
		window.opener.parent.location.href="board?command=board_delete&num=${param.num}";
	}
	//켜져있는 팝업창 꺼주기
	window.close();	
</script>
