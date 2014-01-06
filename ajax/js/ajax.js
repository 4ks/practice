
function send() {
	
	var xmlHttp = new XMLHttpRequest();

	xmlHttp.open("GET", "./servlet/AjaxServlet");
	xmlHttp.send(null);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			document.writeln("success");
		}
	}
	
	for (var i = 0; i < 20; i++) {
		setTimeout(function(){
			document.writeln(i);
		}, 1000 * (i + 1));
	}
	
}