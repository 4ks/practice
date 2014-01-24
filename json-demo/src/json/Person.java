package json;

/**
 * 人，用于JSON示例的对象类。
 * @author Kim
 */
public class Person {

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private boolean sex;
	
	/**
	 * 年龄
	 */
	private int age;
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(name);
		sb.append(",");
		sb.append(sex ? "男" : "女");
		sb.append(",");
		sb.append(age);
		sb.append("岁");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
