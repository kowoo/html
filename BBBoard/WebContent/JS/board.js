function open_win(url,name) {
	//상하 좌우 크기 구해서 팝업창 중앙정렬 시켜보자!!!
	var x = window.screen.width/2-(280/2);
	var y = window.screen.height/2-(130/2);
	window.open(url,name,"width=280, height=130");
}