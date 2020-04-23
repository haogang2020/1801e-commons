package com.bw.haogang.common.utils;

import java.util.Date;

/**
 * 日期工具类
 * @author 86178
 *
 */
public class DateUtil {

	/**
	 * 随即产生min max之间的日期
	 * @param min
	 * @param max
	 * @return
	 */
	public static Date random(Date min,Date max) {
		long t1 = min.getTime();
		long t2 = max.getTime();
		
		long t = (long) (Math.random() * (t2-t1) + t1);
		return new Date(t);
	}
}
