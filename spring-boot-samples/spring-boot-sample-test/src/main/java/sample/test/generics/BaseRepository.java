package sample.test.generics;

/**
 * @Author: shenxl
 * @Date: 2019/10/21 17:08
 * @Version 1.0
 * @description：${description}
 */
public interface BaseRepository<T> {

	 T getBean(String beanName);

	 void printString(T t) ;


}
