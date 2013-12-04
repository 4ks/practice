/*
	此例子说明,基本类型与对象类型的区别.
	调用基本类型,访问的是值,而调用对象类型,访问的是对值的引用.
*/
function difference() {
	// 基本类型
	var a = 1;
	var b = a;
	b = 2;

	// a 结果为1
	// b 结果为2

	// 对象类型
	var o1 = ['a','b'];
	var o2 = o1;

	o2[0] = 'b';

	// o1 结果为 ['b','b']
	// o2 结果为 ['b','b']
}

/*
	在JavaScript中准确无误地判断变量值的类型并非易事
*/
function demo(a, b) {
	var a = 'a';
	var s = new String('a');

	typeof a; // 结果是 'string'
	typeof s; // 结果是'object'

	a instanceof String; // false
	s instanceof String; // true

	// 还可以使用 == 或者 === 做判断
	a == s;  // true
	a === s; // false

	b[0] = 'b'; // 此函数里,建议不对参数a , b做修改,只使用值.
}

function demo2(b) {
	if (b[0] == 'a') {
		// TODO
	}
}

/*
	函数整合使用
*/
function exe() {
	var a = 'a';
	var b = ['a','b'];

	demo(a, b);

	// 继续使用 a 或者 b 做其他的处理.
	demo2(b);

	// 引申问题:参考上述的例子
	// 1.考虑代码开发要如何规避这些隐蔽的Bug?
	// 2.考虑函数返回值(return)的意义和使用规范?
	// 3.上升到架构层面,函数要如何设计,才可以规避这些隐蔽的Bug?
}

function exe2() {
	var a = 'a';
	var b = ['a','b'];

	demo(a, b);

	// 继续使用 a 或者 b 做其他的处理.
	demo3(b);

	// 引申问题:参考上述的例子
	// 1.考虑代码开发要如何规避这些隐蔽的Bug?
	// 2.考虑函数返回值(return)的意义和使用规范?
	// 3.上升到架构层面,函数要如何设计,才可以规避这些隐蔽的Bug?
}

var obj = new Object();
function (obj) {
	obj.a = 'a';
	obj.b = 'b';
}

function (a,b) {
	var obj = new Object();
	obj.a = a;
	obj.b = b;

	return obj;
}
