package sample.test.domain.test;

/**
 * @Author: shenxl
 * @Date: 2019/10/8 11:05
 * @Version 1.0
 * @description：${description}
 */
public class Test {

	public static void main(String[] args) {


		System.out.println(2 & 3); // 2 按位与操作的规则是：仅当两个操作数都为1时。输出结果才为1。否则为0

		System.out.println(2 | 3); // 3 按位或操作的规则是：仅当两个操作数都为0时，输出的结果才为0。

		System.out.println(~12); // -13 按位取反操作规则为：全部的0置为1，1置为0，示比例如以下：
		//~ 1100 = 10000000 00000000 00000000 00001101 因此结果为-13


		System.out.println(2 << 3); // 16 左移就是把一个数的全部位数都向左移动若干位，示比例如以下：
		//10 << 3 向左移动三位为10000  转化为十进制为1 * 2的四次方 = 16


		System.out.println(2 >> 3); // 0 右移就是把一个数的全部位数都向右移动若干位
		//10 >> 3 向右移动三位 位数根本不够 所以直接就为0了
		System.out.println(100 >> 3); //12
		//1100100 >> 3 向右移动三位为1100 转换为十进制为8+4 = 12
		System.out.println(Integer.toBinaryString(100));



		//无符号右移（注意：没有无符号左移）
		//无符号右移，忽略符号位，空位都以0补齐。
		//
		//10进制转二进制的时候，因为二进制数一般分8位、 16位、32位以及64位 表示一个十进制数，所以在转换过程中，最高位会补零。
		//
		//在计算机中负数采用二进制的补码表示，10进制转为二进制得到的是源码，将源码按位取反得到的是反码，反码加1得到补码
		byte byteValue = -1;
		System.out.println(Integer.toBinaryString(byteValue)); //11111111111111111111111111111111
		//byte类型转二进制输出  需要& 0xff   否则是会向上转型为int类型再处理的
		//因为Byte类没有toBinaryString方法
		System.out.println(Integer.toBinaryString(byteValue & 0xff)); //11111111

		//此处也是一样 如果是byte类型 需要 & 0xff再右移
		System.out.println(byteValue & 0xff >>> 4);




	}
}
