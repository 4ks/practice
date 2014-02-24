var http = require('http');
var	server = http.createServer(function (req, res) {
	console.log("req.method = " + req.method);
	console.log("req.url = " + req.url);

	res.writeHeader(200, {"Content-Type": "text/html"});
	res.end("<b>Hello World</b>");
});
server.listen(3000);
console.log("httpd start @3000");