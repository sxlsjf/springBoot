package sample.test.generics.impl;

import org.springframework.stereotype.Repository;
import sample.test.generics.BaseRepository;
import sample.test.generics.dto.Cat;

/**
 * @Author: shenxl
 * @Date: 2019/10/21 17:31
 * @Version 1.0
 * @description：${description}
 */
@Repository
public class Cat2Serviceimpl implements BaseRepository<Cat> {
	@Override
	public Cat getBean(String beanName) {
		Cat cat=new Cat();
		cat.setName(beanName);
		System.out.println("我是"+beanName+"cat2");
		return cat;
	}

	@Override
	public void printString(Cat cat) {

		System.out.println(cat.getName());
	}
}
