package com.bw.haogang.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 随机数工具类
 * @author 86178
 *
 */
public class RandomUtil {

	//方法1：返回min-max之间的随即整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不正确
	public static int random(int min,int max) {
		if(max<=min) {
			throw new RuntimeException("请输入正确的值");
		}
		Random r = new Random();
		return r.nextInt( max - min +1)+min;	
	}
	
	//方法2：在最小值min与最大值max之间截取subs个不重复的随机数，例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对
	public static int[] subRandom(int min,int max,int subs) {
		int[] result = new int[subs];
		
		HashSet<Integer> set = new HashSet<Integer>();//用来过滤重复的数据
		while(set.size()!=subs) {
			set.add(random(min,max));
		}
		//遍历set,把值放入数组
		int i=0;
		for (Integer value: set) {
			result[i] = value;
			i++;
		}
		return result;
	}
	
	//方法3：返回1个 1-9，a-Z之间的随机字符
	public static char randomCharaacter() {
		String str = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		return str.charAt(random(0, str.length()-1));
	}
	
	//方法4：返回参数length个字符串，方法内部要调用randomCharaacter()方法
	public static String randomString(int length) {
		StringBuffer str = new StringBuffer();
		for(int i=0;i<length ; i++) {
			str.append(randomCharaacter());
		}
		
		return str.toString();
	}
}
