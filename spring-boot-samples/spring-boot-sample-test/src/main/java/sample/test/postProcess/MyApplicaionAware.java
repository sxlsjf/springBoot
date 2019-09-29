package sample.test.postProcess;

import org.springframework.beans.BeansException;
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
public class MyApplicaionAware implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		System.out.println("MyApplicaionAware：当前有多好个bean"+applicationContext.getBeanDefinitionCount());

	}
}
