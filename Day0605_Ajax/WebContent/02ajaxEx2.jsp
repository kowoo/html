<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script
	  src="https://code.jquery.com/jquery-3.3.1.min.js"
	  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	  crossorigin="anonymous">
	</script>
	<script type="text/javascript">
		function doAjax() {
			var d ="Hello Server!";
			$.ajax({
				url : "hello",
				type : "post",
				data : {"d" : d}, //그냥 보내면 어떤 이름을 가진 객체인지 알 수 없으니까 이름을 지정해서 보내자
				dataType : 'json', //따옴표로 해도 됨
				success : function(data) { //요청이 성공하면 경고창(데이터)가 나온다!
					alert("data.msg : " + data.msg);
					$("#txt1").text(data.msg);
				},
				error : function(request, status, error){
					alert("request : " + request + "\n"
						+ "status  : " + status + "\n"
						+ "error   : " + error + "\n"
					);
					
				}
				
			});	
		}
	
	</script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h1 id="txt1"></h1>
	<button onclick="doAjax();">요청</button>
	<form>
		
	</form>
</body>
</html>