package json;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 依赖以下jar包
 * commons-lang,用来处理Java基本对象方法的工具类包，可以简化很多平时经常要用到的写法，例如判断字符串是否为空等等;
 * ezmorph,EZMorph是一个简单的java类库用于将一种对象转换成另外一种对象。EZMorph原先是Json-lib项目中的转换器。EZMorph支持原始数据类型（Primitive），对象（Object），多维护数组转换与DynaBeans的转换;
 * commons-collections, 一个各种集合类和集合工具类的封装;
 * commons-beanutils,Commons-beanutil中包含大量和JavaBean操作有关的工具方法，使用它可以轻松利用Java反射机制来完成代码中所需要的功能，而不需要详细研究反射的原理和使用，同时，该类库中提出了动态Bean的概念，不但提供现有JavaBean的所有功能，而且还可以在运行时动态的对Bean中的属性数据类型进行修改以及增删属性。
 * <a href="http://json.org/">JSON官网</a>
 * <a href="http://sourceforge.net/projects/json-lib/files/json-lib/">json-lib下载</a>
 * @author Kim
 */
public class JSONDemo {
	
	private static final Log log = LogFactory.getLog(JSONDemo.class);
	
	/**
	 * 对象 转 字符串 
	 */
	public static String toJSONString(Person person) {
		JSONObject jsonObj = JSONObject.fromObject(person);
		return jsonObj.toString();
	}
	
	/**
	 * 字符串 转 对象 
	 */
	public static Person toPerson(String jsonStr) {
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		return (Person) JSONObject.toBean(jsonObj, Person.class);
	}
	
	/**
	 * 数组 转 字符串 
	 */
	public static String toJSONString(Person[] persons) {
		JSONArray jsonArr = JSONArray.fromObject(persons);
		return jsonArr.toString();
	}
	
	/**
	 * 字符串 转 数组 
	 */
	public static Person[] toPersonArray(String jsonStr) {
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		Object obj = JSONArray.toArray(jsonArr, Person.class);
		return (Person[]) obj;
	}
	
	/**
	 * 集合 转 字符串 
	 */
	public static String toJSONString(List<Person> personList) {
		JSONArray jsonArr = JSONArray.fromObject(personList);
		return jsonArr.toString();
	}
	
	/**
	 * 字符串 转 集合 
	 */
	@SuppressWarnings("unchecked")
	public static List<Person> toPersonList(String jsonStr) {
		JSONArray jsonArr = JSONArray.fromObject(jsonStr);
		Object obj = JSONArray.toCollection(jsonArr, Person.class);
		return (List<Person>) obj;
	}
	
	public static void main(String[] args) {
		String jsonStr = null;
		
		Person person = new Person();
		person.setName("小张");
		person.setSex(true);
		person.setAge(20);
		
		jsonStr = JSONDemo.toJSONString(person);
		log.info(jsonStr);
		log.info(JSONDemo.toPerson(jsonStr));
		
		Person person2 = new Person();
		person2.setName("小李");
		person2.setSex(false);
		person2.setAge(19);
		
		Person[] persons = new Person[2];
		persons[0] = person;
		persons[1] = person2;
		
		jsonStr = JSONDemo.toJSONString(persons);
		log.info(jsonStr);
		Person[] personRs = JSONDemo.toPersonArray(jsonStr);
		for (int i = 0, le = personRs.length; i < le; i++) {
			log.info(personRs[i]);
		}
		
		List<Person> personList = new ArrayList<Person>();
		personList.add(person);
		personList.add(person2);
		jsonStr = JSONDemo.toJSONString(personList);
		log.info(jsonStr);
		List<Person> personListRs = JSONDemo.toPersonList(jsonStr) ;
		for (int i = 0, size = personListRs.size(); i < size; i++) {
			log.info(personListRs.get(i));
		}
	}

}
