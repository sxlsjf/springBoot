package sample.test.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 11:32
 * @Version 1.0
 * @description：${description}
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("第三部：调用MyBeanFactoryPostProcessor的postProcessBeanFactory方法，也可以改变bean定义");
		BeanDefinition bd = beanFactory.getBeanDefinition("myJavaBean");
		MutablePropertyValues pv =  bd.getPropertyValues();
		if (pv.contains("remark")) {
			pv.addPropertyValue("remark", "在BeanFactoryPostProcessor中修改之后的备忘信息");
		}

	}

}
