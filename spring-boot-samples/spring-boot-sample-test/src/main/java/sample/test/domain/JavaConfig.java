package sample.test.domain;
import	java.lang.annotation.Annotation;

import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import sample.test.annotation.MyAnnotation;
import sample.test.postProcess.MyBeanDefinationRegisterPostProcessor;
import sample.test.postProcess.MyBeanPostProcessor;
import sample.test.postProcess.MyDefinitionRegistrar;


/**
 * @Author: shenxl
 * @Date: 2019/9/24 11:37
 * @Version 1.0
 * @description：${description}
 */
@Configuration
@Import({ImportClass.class, MyDefinitionRegistrar.class})
public class JavaConfig {

	@Bean(initMethod="initMethod")
	public MyJavaBean myJavaBean(){
		return new MyJavaBean();
	}

	/*@Bean
	public MyBeanDefinationRegisterPostProcessor myBeanDefinationRegisterPostProcessor(){
		return new MyBeanDefinationRegisterPostProcessor();
	}*/

	@Bean
	public MyBeanPostProcessor MyBeanPostProcessor(MyJavaBean myJavaBean){
		return new MyBeanPostProcessor(myJavaBean);
	}


	@Bean
	@DependsOn(value = {"myJavaBean"})
	@ConditionalOnBean(annotation = MyAnnotation.class)
	public AnnoationClass annoationClass(){
		return new AnnoationClass();
	}
}
