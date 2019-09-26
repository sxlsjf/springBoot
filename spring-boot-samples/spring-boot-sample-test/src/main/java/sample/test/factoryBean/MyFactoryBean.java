package sample.test.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import sample.test.domain.MyJavaBean;

/**
 * @Author: shenxl
 * @Date: 2019/9/25 10:22
 * @Version 1.0
 * @description：${description}
 */

public class MyFactoryBean implements FactoryBean, InitializingBean {

	private String desc;
	private String remark;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public Object getObject() throws Exception {
		System.out.println("第六步：在这里返回MyJavaBean");
		return new MyJavaBean();
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

		System.out.println("MyFactoryBean开始afterPropertiesSet");
	}

	public void initMethod(){

		System.out.println("MyFactoryBean开始initMethod");
	}
}
