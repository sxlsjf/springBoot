package sample.test.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: shenxl
 * @Date: 2019/9/29 10:18
 * @Version 1.0
 * @description：${description}
 */
@Component
public class MyApplicaionAware implements ApplicationContextAware, BeanNameAware, BeanFactoryAware {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	private BeanFactory beanFactory;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext=applicationContext;
		System.out.println("MyApplicaionAware：当前有多好个bean"+applicationContext.getBeanDefinitionCount());

	}

	@Override
	public void setBeanName(String name) {

		this.name=name;
		System.out.println("setBeanName======================================================================");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

		this.beanFactory=beanFactory;
	}
}
