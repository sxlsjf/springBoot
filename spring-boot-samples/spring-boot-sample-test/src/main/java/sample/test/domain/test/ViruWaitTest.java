package sample.test.domain.test;

/**
 * @Author: shenxl
 * @Date: 2019/10/18 11:27
 * @Version 1.0
 * @description：${description}
 */
public class ViruWaitTest {

	public static void main(String[] args) {
		Clerk clerk=new Clerk();

		Producer producer=new Producer(clerk);
		Consumer consumer=new Consumer(clerk);

		new Thread(producer,"生产者A1").start();
		new Thread(consumer,"消费者B1").start();

	}
	// 店员类：负责进货和售货
	static class Clerk{

		//TOTAL表示我的店最大可以容纳的总量
		private static final int TOTAL=1; //数字取1是为了放大问题
		private int num=0; //店里当前的货物量

		public synchronized void get() { //店员进货  每次进货一个
			if(num >= TOTAL) {
				System.out.println("库存已满，无法进货");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(Thread.currentThread().getName()+" : "+ (num++));
				this.notifyAll();
			}
		}

		public synchronized void sale() { //店员卖货 每次卖掉一个货
			if(num<=0) {
				System.out.println("库存已空，无法卖货");
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				System.out.println(Thread.currentThread().getName()+" : "+(num--));
				this.notifyAll();
			}
		}
	}

	// 生产者 可以有很多生产者卖货给这个店员
	static class Producer implements Runnable{
		private Clerk clerk;

		public Producer(Clerk clerk) {
			this.clerk=clerk;
		}

		@Override
		public void run() {
			for (int i = 0; i<20; i++) {
				try {
					Thread.sleep(200); //放大问题
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				clerk.get();
			}
		}
	}

	//消费者：可以很多消费者找店员买货
	static class Consumer implements Runnable{
		private Clerk clerk;

		public Consumer(Clerk clerk) {
			this.clerk=clerk;
		}

		@Override
		public void run() {
			for (int i = 0; i<20; i++) {
				clerk.sale();
			}
		}
	}

}
