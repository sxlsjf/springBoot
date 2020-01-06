package sample.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: shenxl
 * @Date: 2019/10/17 17:38
 * @Version 1.0
 * @description：${description}
 */
public class FeatureTaskTest {

	public static void main(String[] args) throws Exception {


		FutureTask<String> task = new FutureTask<>(() -> {
			System.out.println("买厨具ing...");
			//Thread.sleep(5000);
			System.out.println("买厨具完成");
			return "刀";
		});


		new Thread(task).start();

		// 第二步 去超市购买食材
	//	Thread.sleep(2000);  // 模拟购买食材时间

		System.out.println("第二步：食材到位");

/*
		// 第三步 用厨具烹饪食材
		if (!task.isDone()) {  // 联系快递员，询问是否到货
			System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
			//如果需要取消 这里调用task的cancel方法即可
		}*/
		String chuju = task.get();
		System.out.println("第三步：厨具到位，开始展现厨艺:"+chuju);

	}
}
