package sample.test.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 14:57
 * @Version 1.0
 * @description：${description}
 */
public class MyEvent extends ApplicationEvent {


	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public MyEvent(Object source) {
		super(source);
	}
}
