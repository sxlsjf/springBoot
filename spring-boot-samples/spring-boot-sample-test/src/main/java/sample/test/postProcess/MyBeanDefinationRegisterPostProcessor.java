package sample.test.postProcess;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;
import sample.test.annotation.MyAnnotation;
import sample.test.factoryBean.MyFactoryBean;

import java.util.Set;

/**
 * @Author: shenxl
 * @Date: 2019/9/25 10:32
 * @Version 1.0
 * @description：${description}
 */
@Component
public class MyBeanDefinationRegisterPostProcessor implements BeanDefinitionRegistryPostProcessor {

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

		RootBeanDefinition root = new RootBeanDefinition(MyFactoryBean.class);
		registry.registerBeanDefinition("myFactoryBean", root);
		System.out.println("第一步：myFactoryBean定义在这里被注册");

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		System.out.println("第二部：调用MyBeanDefinationRegisterPostProcessor的postProcessBeanFactory方法，可以改变bean定义");
		/*String[] list=beanFactory.getBeanDefinitionNames();
		for(int i=0;i<list.length; i++){

			System.out.println("postProcessBeanFactory:"+list [i]);

		}*/
	//扫描指定包及其子包下面拥有指定注解的类。
	/*@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		boolean useDefaultFilters = false;//是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
		String basePackage = "com.elim.learn.spring.bean";
		ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
		TypeFilter includeFilter = new AnnotationTypeFilter(MyAnnotation.class);
		beanScanner.addIncludeFilter(includeFilter);
		Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
		for (BeanDefinition beanDefinition : beanDefinitions) {
			//beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
			String beanName = beanDefinition.getBeanClassName();
			registry.registerBeanDefinition(beanName, beanDefinition);
		}
	}*/

    //扫描指定包及其子包下面的所有非接口和非抽象类。
	/*@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		boolean useDefaultFilters = false;//是否使用默认的filter，使用默认的filter意味着只扫描那些类上拥有Component、Service、Repository或Controller注解的类。
		String basePackage = "com.elim.learn.spring.bean";
		ClassPathScanningCandidateComponentProvider beanScanner = new ClassPathScanningCandidateComponentProvider(useDefaultFilters);
		TypeFilter includeFilter = new TypeFilter() {

			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
					throws IOException {
				return metadataReader.getClassMetadata().isConcrete();
			}

		};
		beanScanner.addIncludeFilter(includeFilter);
		Set<BeanDefinition> beanDefinitions = beanScanner.findCandidateComponents(basePackage);
		for (BeanDefinition beanDefinition : beanDefinitions) {
			//beanName通常由对应的BeanNameGenerator来生成，比如Spring自带的AnnotationBeanNameGenerator、DefaultBeanNameGenerator等，也可以自己实现。
			String beanName = beanDefinition.getBeanClassName();
			registry.registerBeanDefinition(beanName, beanDefinition);
		}
	}*/



	}
}
