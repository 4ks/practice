function Person(name) {
	this.name = name;
}

Person.prototype.talk = function () {
	alert("hello," + this.name);
}

Person.prototype.setName = function (name) {
	this.name = name;
}

var p = new Person("b");