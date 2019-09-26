package sample.test.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import sample.test.postProcess.MyBeanDefinationRegisterPostProcessor;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 11:37
 * @Version 1.0
 * @description：${description}
 */
@Configuration
@Component
public class JavaConfig {

	@Bean(initMethod="initMethod")
	public MyJavaBean myJavaBean(){
		return new MyJavaBean();
	}

	/*@Bean
	public MyBeanDefinationRegisterPostProcessor myBeanDefinationRegisterPostProcessor(){
		return new MyBeanDefinationRegisterPostProcessor();
	}*/

}
