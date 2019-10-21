package sample.test.domain.test;

import javax.annotation.PostConstruct;

/**
 * @Author: shenxl
 * @Date: 2019/10/21 11:43
 * @Version 1.0
 * @description：${description}
 */
public class TestProPostAnn {

	@PostConstruct
	public void init(){
		System.out.println("PostConstruct执行了");
	}


	public static void main(String[] args) {

		new TestProPostAnn().get();

	}


	public void get(){
		System.out.println("nihao");
	}
}
