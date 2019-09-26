package sample.test.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import sample.test.domain.MyJavaBean;
import sample.test.factoryBean.MyFactoryBean;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 11:33
 * @Version 1.0
 * @description：${description}
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof MyJavaBean){
			MyJavaBean bean1= (MyJavaBean) bean;
			System.out.println("第五步：BeanPostProcessor，对象" + beanName + "调用初始化方法之前的数据： " + bean.toString()+bean1.autwiredClass);

		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(bean instanceof MyJavaBean){
			MyJavaBean bean1= (MyJavaBean) bean;
			System.out.println("第八步：BeanPostProcessor，对象" + beanName + "调用初始化方法之后的数据：" + bean.toString()+bean1.autwiredClass);
		}
		return bean;
	}


}
