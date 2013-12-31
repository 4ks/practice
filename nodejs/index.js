var http = require('http');
var	server = http.createServer(function (req, res) {
	res.writeHeader(200, {"Content-Type": "text/plain"});
	res.end("Hello World123\n");
});
server.listen(80);
console.log("httpd start @80");