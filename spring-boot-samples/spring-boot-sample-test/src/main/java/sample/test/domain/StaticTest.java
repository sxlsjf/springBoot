package sample.test.domain;

/**
 * @Author: shenxl
 * @Date: 2019/10/17 15:13
 * @Version 1.0
 * @description：${description}
 */
public class StaticTest {
	static int b = 112;


	static {
		System.out.println("1");
	}

	{
		System.out.println("2");
	}
	StaticTest() {
		System.out.println("3");
		System.out.println("a=" + a + ",b=" + b);
	}
	public static void staticFunction() {
		System.out.println("4");
	}
	int a = 110;

	public static void main(String[] args) {
		staticFunction();
	}
	//实例的初始化不一定等到类的初始化
	static StaticTest st = new StaticTest();
}
