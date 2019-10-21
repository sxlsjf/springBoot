package sample.test.domain.test;

import java.util.Map;
import java.util.Properties;

/**
 * @Author: shenxl
 * @Date: 2019/10/21 15:37
 * @Version 1.0
 * @description：${description}
 */
public class DemoSystemTest {

	public static void main(String[] args) {

		/*Map<String, String> envMap = System.getenv();
		envMap.forEach((key, value) -> {
			System.out.println(key + "=" + value);
		});
*/

		Properties properties = System.getProperties();
		System.setProperty("myProperty", "自定义的系统属性~"); // 允许自定义系统属性
		properties.forEach((key, value) -> {
			System.out.println(key + "=" + value);
		});

	}
}
