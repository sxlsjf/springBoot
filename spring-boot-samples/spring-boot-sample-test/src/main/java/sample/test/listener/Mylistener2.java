package sample.test.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import sample.test.event.MyEvent;

import java.util.Properties;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 16:46
 * @Version 1.0
 * @description：${description}
 */
public class Mylistener2 implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {


		System.out.println(event.getSource());

		event.getSpringApplication().getAllSources().forEach(System.out::println);
		event.getSpringApplication().getSources().forEach(System.out::println);
		//event.getSpringApplication().get

		Properties properties=new Properties();
		properties.setProperty("shen","xiaolong");
		PropertySource propertySource=new PropertiesPropertySource("myproperites",properties);
		event.getEnvironment().getPropertySources().addLast(propertySource);
		//event.getEnvironment().getPropertySources().stream().forEach(System.out::println);
		System.out.println("环境变量=================================================");
		event.getEnvironment().getSystemEnvironment().forEach((x,y)->{
			System.out.print(x+"=");
			System.out.println(y);
		});

		System.out.println("系统属性=================================================");
		event.getEnvironment().getSystemProperties().forEach((x,y)->{
			System.out.print(x+"=");
			System.out.println(y);
		});
		System.out.println("监听了-----"+event.getSource());
		System.out.println("监听了-----"+event.getClass());
		System.out.println("自己的listener2被监听");
	}
}
