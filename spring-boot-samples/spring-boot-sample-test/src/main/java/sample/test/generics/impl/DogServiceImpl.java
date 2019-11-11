package sample.test.generics.impl;

import org.springframework.stereotype.Repository;
import sample.test.generics.BaseRepository;
import sample.test.generics.dto.Dog;

/**
 * @Author: shenxl
 * @Date: 2019/10/21 17:12
 * @Version 1.0
 * @description：${description}
 */
@Repository
public class DogServiceImpl implements BaseRepository<Dog> {

	@Override
	public Dog getBean(String beanName) {
		Dog dog=new Dog();
		dog.setName(beanName);
		System.out.println("我是"+beanName+"dog");
		return dog;
	}

	@Override
	public void printString(Dog dog) {

		System.out.println(dog.getName());
	}
}
