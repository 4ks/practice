var fs = require('fs');
var stdin = process.stdin;
var stdout = process.stdout;

fs.readdir(__dirname, function(err, files){
	console.log('');
	console.log('Select which file or directory you want to see\n');

	var stats = [];
	function file(i) {
		var fileName = files[i];
		fs.stat(__dirname + '/' + fileName, function(err, stat){
			stats[i] = stat;
			if (stat.isFile()) {
				console.log(i + ' \033[90m' + files[i] + '\033[39m');
			} else {
				console.log(i + ' \033[36m' + files[i] + '/\033[36m');
			}
			if (i == files.length - 1) {
				read();
			} else {
				file(i + 1);
			}
		});
	}

	file(0);

	function read() {
		console.log('');
        stdout.write('\033[33mEnter your choice : \033[39m')

		stdin.setEncoding('utf8');
		stdin.resume();
	}

	stdin.on('data', function(data){
		var fileName = files[Number(data)];
		var stat = stats[Number(data)];
		if (stat) {
			if (stat.isDirectory()) {
				fs.readdir(__dirname + '/' + fileName, function(err, files){
					console.log('');
					console.log('( ' + files.length + ' files)');
					files.forEach(function(file){
						console.log(' - ' + file);
					});
					console.log('');
				});
			} else {
				fs.readFile(__dirname + '/' + fileName, 'utf8', function(err, data){
					console.log('');
					console.log('\033[90m' + data.replace(/(.*)/g,' $1') + '\033[39m');
				});
			}
		}
		stdin.pause();
	});
});