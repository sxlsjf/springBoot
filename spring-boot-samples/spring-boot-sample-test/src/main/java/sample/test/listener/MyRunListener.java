package sample.test.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.env.ConfigurableEnvironment;
import sample.test.event.MyEvent;

/**
 * @Author: shenxl
 * @Date: 2019/9/23 17:12
 * @Version 1.0
 * @description：${description}
 */
public class MyRunListener implements SpringApplicationRunListener {

	private final SpringApplication application;

	private final String[] args;

	private final SimpleApplicationEventMulticaster initialMulticaster;

	public MyRunListener(SpringApplication application, String[] args){
		this.application = application;
		this.args = args;
		this.initialMulticaster = new SimpleApplicationEventMulticaster();

		for (ApplicationListener<?> listener : application.getListeners()) {
			this.initialMulticaster.addApplicationListener(listener);
		}

	}
	@Override
	public void starting() {
		//System.out.println("自己的Listener starting");
		this.initialMulticaster.multicastEvent(new MyEvent(""));

	}

	@Override
	public void environmentPrepared(ConfigurableEnvironment environment) {
		//System.out.println("自己的Listener environmentPrepared");
	}

	@Override
	public void contextPrepared(ConfigurableApplicationContext context) {
	//	System.out.println("自己的Listener contextPrepared");
	}

	@Override
	public void contextLoaded(ConfigurableApplicationContext context) {
		//System.out.println("自己的Listener contextLoaded");
	}

	@Override
	public void started(ConfigurableApplicationContext context) {
		//System.out.println("自己的Listener started");
	}

	@Override
	public void running(ConfigurableApplicationContext context) {

		this.initialMulticaster.multicastEvent(new MyEvent(""));
	//	System.out.println("自己的Listener running");
	}

	@Override
	public void failed(ConfigurableApplicationContext context, Throwable exception) {
		//System.out.println("自己的Listener failed");
	}
}
