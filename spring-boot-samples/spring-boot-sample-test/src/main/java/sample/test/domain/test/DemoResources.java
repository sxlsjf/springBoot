package sample.test.domain.test;

import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

/**
 * @Author: shenxl
 * @Date: 2019/10/18 16:40
 * @Version 1.0
 * @description：${description}
 */
public class DemoResources {

	public static void main(String[] args) throws Exception {
		// 此处用相对路径，那就是相对DemoResources所在的路径。因此此处需要demo.properties和DemoResources.class文件在同一个包里面  否则请用对应的../../等
		// 这里DemoResources所在包为：sample.test.domian.test  因此最终找的文件地址为：sample/test/domain/test/demo.properties 会去这里找文件
		URL resource = DemoResources.class.getResource("demo.properties");
		System.out.println(resource); //file:/E:/work/remotegitcheckoutproject/myprojects/java/demo-war/target/classes/com/fsx/maintest/demo.properties

		// 若采用绝对路径 /就代表当前项目名~~~~  所以此处的效果同上~~~
		resource = DemoResources.class.getResource("classpath:sample/test/domain/test/demo.properties");
		System.out.println(resource); // 同上

		// 关于getResourceAsStream的使用，路径处理上和上面一致，此处就不做过多解释了
		InputStream resourceAsStream = DemoResources.class.getResourceAsStream("demo.properties");
		System.out.println(resourceAsStream); //java.io.BufferedInputStream@33e5ccce

        // 若采用绝对路径 /就代表当前项目名~~~~  所以此处的效果同上~~~
		resourceAsStream = DemoResources.class.getResourceAsStream("sample/test/domain/test/demo.properties");
		System.out.println(resourceAsStream); //java.io.BufferedInputStream@33e5ccce

		// ==================最后如果你想直接加载Classpath类路径下的配置文件(此处以类路径下的spring.properties为例)===================
		// 这个/ 不能省略，否则classpathResource为null
		URL classpathResource = DemoResources.class.getResource("/application.yml");
		System.out.println(classpathResource); //file:/E:/work/remotegitcheckoutproject/myprojects/java/demo-war/target/classes/spring.properties

		System.out.println(DemoResources.class.getResource("")); //.../demo-war/target/classes/com/fsx/maintest/ 它定位到的是Main这个类所在的路径
		System.out.println(DemoResources.class.getResource("/")); //.../demo-war/target/classes/  它定位到的是类路径




		// 这个大体上和class.getResource()类似。但是它没有class对路径的一个提前处理。所以它这里需要把路径写全了：com/fsx/maintest/demo.properties
		// 需要注意的是，因为它没有对路径处理的，所以不支持 `/`打头的这种绝对路径
		URL systemResource = ClassLoader.getSystemResource("sample/test/domain/test/demo.properties");
		System.out.println(systemResource); ///demo-war/target/classes/com/fsx/maintest/demo.properties

		//后面已经有一个/了，说明就是直接从classpath/目录下查找~~~~ 所以我们自己不需要再写/ 了
		systemResource = ClassLoader.getSystemResource("");
		System.out.println(systemResource); // .../demo-war/target/classes/  获取类路径的地址

		InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("sample/test/domain/test/demo.properties");
		System.out.println(systemResourceAsStream); //java.io.BufferedInputStream@46f5f779

		// 若要加载类路径下的文件，显然这个就更加的方便些~~~ 不需要 "/"了
		System.out.println(ClassLoader.getSystemResourceAsStream("application.yml")); //java.io.BufferedInputStream@5a42bbf4


		// 显然通过这种间接的方式去构建一个File对象也是可行的 只是比较绕
		String filePath = ClassLoader.getSystemResource("application.yml").getFile();
		System.out.println(new File(filePath).exists()); //true


		//File方式读取
		// 使用带盘符的绝对路径  显然这个把项目名以及target都暴露出来了
		File file = new File("E:\\work\\remotegitcheckoutproject\\myprojects\\java\\demo-war\\target\\classes\\com\\fsx\\maintest\\demo.properties");
		System.out.println(file.exists()); //true 这里是返回true，表示找到了这个文件

		// 另外一种方式，也可以这么写
		file = new File(System.getProperty("user.dir") + "\\target\\classes\\com\\fsx\\maintest\\demo.properties");
		System.out.println(file.exists()); // true
		// 采用相对路径   很显然，这里相对的是工程~~~
		File file2 = new File("my.properties");
		System.out.println(file2.exists()); //true

		//获取工程内部资源
		// 采用相对路径   很显然，这里相对的是工程~~~（这里也得把/demo-war/target/classes这些写出来，非常不优雅）
		File file3 = new File("../demo-war/target/classes/com/fsx/maintest/demo.properties");
		System.out.println(file3.exists()); //true


		ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
		Resource resource2 = new InputStreamResource(bis);
		if (resource2.exists()) {
			//dumpStream(resource); //Hello World!
		}


		UrlResource resource31 = new UrlResource("http://www.springframework.org/schema/beans/spring-beans.xsd");
		if (resource31.exists()) {
		//	File file4 = new File(resource31.getFile());
			System.out.println(resource31); //报错 java.io.FileNotFoundException: URL [xxx] cannot be resolved to absolute file path because it
			//dumpStream(resource3); //输出这个.xsd文件的所有的内容...
		}

		//FileUrlResource resource = new FileUrlResource("http://www.springframework.org/schema/beans/spring-beans.xsd");
		FileUrlResource resource4 = new FileUrlResource(new URL("http://www.springframework.org/schema/beans/spring-beans.xsd"));
		if (resource4.exists()) {
			//dumpStream(resource4); //输出这个.xsd文件的所有的内容...
		}


		//ClassPathResource resource = new ClassPathResource("spring.properties");

		// 如果是要获取指定类所在包下的文件，建议指定class
		ClassPathResource resource5 = new ClassPathResource("demo.properties",DemoResources.class);
		if (resource5.exists()) {
			//dumpStream(resource5); //name=fangshixiang  或者 demo=value
		}




		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource7 = resourceLoader.getResource("classpath:META-INF/spring.factories");
		// 因为`classpath:`只在本工程内查找，所以肯定找不到 spring.factories
		System.out.println(resource7.exists()); //false


		PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:META-INF/spring.factories");
		// 它会去找所有的jar包的类路径开始查找，所以现在是可议找到多个的~~~
		System.out.println(resources.length); //2
		System.out.println(Arrays.asList(resources));
		//[URL [jar:file:/E:/repository/org/springframework/spring-beans/5.0.6.RELEASE/spring-beans-5.0.6.RELEASE.jar!/META-INF/spring.factories],
		//URL [jar:file:/E:/repository/org/springframework/spring-test/5.0.6.RELEASE/spring-test-5.0.6.RELEASE.jar!/META-INF/spring.factories]]

		// 还能使用Ant风格进行匹配~~~  太强大了：
		resources = resourcePatternResolver.getResources("classpath*:META-INF/*.factories");
		System.out.println(resources); // 能匹配上所有了路径下，`META-INF/*.factories`匹配上的所有文件
		resources = resourcePatternResolver.getResources("classpath*:com/fsx/**/*.class");
		System.out.println(resources.length); //42 相当于把我当前项目所有的类都拿出来了


	}


}
