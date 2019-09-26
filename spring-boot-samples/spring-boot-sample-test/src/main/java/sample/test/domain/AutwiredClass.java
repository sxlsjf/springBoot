package sample.test.domain;

import org.springframework.stereotype.Component;

/**
 * @Author: shenxl
 * @Date: 2019/9/26 14:04
 * @Version 1.0
 * @description：${description}
 */
@Component
public class AutwiredClass {

	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
