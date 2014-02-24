function Person(name) {
	this.name = name;
}

Person.prototype.talk = function () {
	alert("hello," + this.name);
}

var myPerson = new Person("b");