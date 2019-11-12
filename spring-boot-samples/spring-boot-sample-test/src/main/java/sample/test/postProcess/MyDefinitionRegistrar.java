package sample.test.postProcess;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import sample.test.annotation.MyAnnotation;
import sample.test.domain.AnnoationClass;

/**
 * @Author: shenxl
 * @Date: 2019/9/30 15:01
 * @Version 1.0
 * @description：${description}
 */
public class MyDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
				importingClassMetadata.getAnnotationAttributes(
						MyAnnotation.class.getName()));

		annotationAttributes.


		registry.registerBeanDefinition("annoationClass", BeanDefinitionBuilder.rootBeanDefinition(AnnoationClass.class).getBeanDefinition());


	}
}
