package com.bw.haogang.common.utils;

import java.util.Calendar;
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
	/**
	 * 根据传入的日期返回日期的月初，如传入2020-04-24,返回2020-04-01 00:00:00
	 * @param date
	 * @return
	 */
	public static Date getInitMonth(Date date) {
		//Calendar 是一个日历类，提供 设置日期，加减日期等方法，方便程序员对日期做计算
		Calendar c = Calendar.getInstance();//初始化一个日历类
		//用传入日期初始化
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}
	
	/**
	 * 根据传入的日期返回日期的月末
	 * @param date
	 * @return
	 */
	public static Date getEndMonth(Date date) {
		//Calendar 是一个日历类，提供 设置日期，加减日期等方法，方便程序员对日期做计算
		Calendar c = Calendar.getInstance();//初始化一个日历类
		//用传入日期初始化
		c.setTime(date);
		//让月加1 2020-5-24， 在变成2020-05-01 在减去一秒 在获取日期
		c.add(Calendar.MONTH, 1);
		Date nexMonthInit = getInitMonth(c.getTime());
		//初始化日历类
		c.setTime(nexMonthInit);
		c.add(Calendar.SECOND, -1);
		return c.getTime();	
	}
	
	public static int getAgeByBirthday(Date birthday) {
		//1、获取系统当前 年 月 日
		Calendar c = Calendar.getInstance();
		int nowYear = c.get(Calendar.YEAR);
		int nowMonth = c.get(Calendar.MONTH);
		int nowDate = c.get(Calendar.DAY_OF_MONTH);
		
		//2、获取传入日期的生日的 年 月 日
		Calendar c2 = Calendar.getInstance();
		c2.setTime(birthday);
		int birthdayYear = c2.get(Calendar.YEAR);
		int birthdayMonth = c2.get(Calendar.MONTH);
		int birthdayDate = c2.get(Calendar.DAY_OF_MONTH);
		//3、判断
		if(nowYear < birthdayYear) 
			throw new RuntimeException("传入日期错误");
		//4、两个年份相减得到年龄 2000-05-01
		int age = nowYear - birthdayYear;
		//没有到出生的月则减去1
		if(nowMonth < birthdayMonth)
			age--;
		//没有到出生日
		if(nowMonth == birthdayMonth && nowDate<birthdayDate)
			age--;
		return age;
	}
}
