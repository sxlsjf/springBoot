package sample.test.listener;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import sample.test.event.MyEvent;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 16:46
 * @Version 1.0
 * @description：${description}
 */
public class Mylistener2 implements ApplicationListener<ApplicationStartingEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		System.out.println("自己的listener2被监听");
	}
}
