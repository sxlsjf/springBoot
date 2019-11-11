package sample.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.test.event.MyEvent;
import sample.test.generics.BaseRepository;
import sample.test.generics.dto.Cat;
import sample.test.generics.dto.Dog;
import sample.test.postProcess.MyApplicaionAware;
import sample.test.utils.ApplicationContextUtil;

import javax.annotation.Resource;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 15:56
 * @Version 1.0
 * @description：${description}
 */
@Controller
public class TestController {

	@Autowired
	private ApplicationContext applicationContext;

	@Resource(name="catServiceimpl")
	private BaseRepository<Cat> catBaseRepository;

	@Autowired
	private BaseRepository<Dog> dogBaseRepository;


	@RequestMapping("/get")
	@ResponseBody
	public String getUser(){

		//applicationContext=ApplicationContextUtil.getApplicationContext();
		applicationContext.publishEvent(new MyEvent("hello"));
		MyApplicaionAware myApplicaionAware=applicationContext.getBean(MyApplicaionAware.class);
		boolean s=myApplicaionAware.getApplicationContext().equals(applicationContext);

		System.out.println(s);

		catBaseRepository.getBean("波斯猫");
		dogBaseRepository.getBean("德国牧羊犬");

		return "shenxl";
	}
}
