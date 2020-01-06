package sample.test.domain.test;

/**
 * @Author: shenxl
 * @Date: 2019/11/12 17:18
 * @Version 1.0
 * @description：${description}
 */
public class MyUser {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyUser{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
