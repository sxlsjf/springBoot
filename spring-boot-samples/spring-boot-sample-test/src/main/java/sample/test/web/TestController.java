package sample.test.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.test.event.MyEvent;
import sample.test.utils.ApplicationContextUtil;

/**
 * @Author: shenxl
 * @Date: 2019/9/24 15:56
 * @Version 1.0
 * @description：${description}
 */
@Controller
public class TestController {

	private ApplicationContext applicationContext;

	@RequestMapping("/get")
	@ResponseBody
	public String getUser(){

		applicationContext=ApplicationContextUtil.getApplicationContext();
		//applicationContext.publishEvent(new MyEvent("hello"));

		return "shenxl";
	}
}
