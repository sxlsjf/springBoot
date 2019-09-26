package sample.test.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;

import org.springframework.context.ApplicationListener;
import sample.test.event.MyEvent;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 10:59
 * @Version 1.0
 * @description：${description}
 */
public class MyListener implements ApplicationListener<MyEvent> {


	@Override
	public void onApplicationEvent(MyEvent event) {

		System.out.println("我在哪里被调用-------------------------------------------");

	}
}
