package sample.test.domain;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import sample.test.domain.test.Test;

/**
 * @Author: shenxl
 * @Date: 2019/10/8 10:59
 * @Version 1.0
 * @description：${description}
 */
public class ImportClass implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] { Test.class.getName() };
	}
}
