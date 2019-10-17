package sample.test.domain;

import org.springframework.stereotype.Component;
import sample.test.annotation.MyAnnotation;

/**
 * @Author: shenxl
 * @Date: 2019/9/30 14:46
 * @Version 1.0
 * @description：${description}
 */

@MyAnnotation
public class AnnoationClass {

	public AnnoationClass(){

		System.out.println("--------------------AnnoationClass----------------------------");
	}

	public void say(){
		System.out.println("I'm AnnoationClass");
	}

}
