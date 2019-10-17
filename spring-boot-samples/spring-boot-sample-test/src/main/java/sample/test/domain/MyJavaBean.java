package sample.test.domain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import sample.test.annotation.MyAnnotation;


/**
 * @Author: shenxl
 * @Date: 2019/9/24 11:28
 * @Version 1.0
 * @description：${description}
 */
@MyAnnotation
public class MyJavaBean implements InitializingBean {
	private String desc;
	private String remark;
	@Autowired
	public AutwiredClass autwiredClass;

	public MyJavaBean() {
		System.out.println("第四步：MyJavaBean的构造函数被执行啦,autwiredClass="+autwiredClass);
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		System.out.println("调用setDesc方法");
		this.desc = desc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		System.out.println("调用setRemark方法");
		this.remark = remark;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("第六步：调用实现InitializingBean接口的afterPropertiesSet方法,autwiredClass="+autwiredClass);
		this.desc = "在初始化方法中修改之后的描述信息";
	}
	public void initMethod() {
		System.out.println("第七步：调用initMethod方法");
	}


	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[描述：").append(desc);
		builder.append("， 备注：").append(remark).append("]");
		return builder.toString();
	}

}
