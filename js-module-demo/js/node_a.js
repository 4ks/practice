module.exports = Person;

function Person(name) {
	this.name = name;
}

Person.prototype.talk = function () {
	console.log("hello," + this.name);
}

Person.prototype.setName = function (name) {
	this.name = name;
}