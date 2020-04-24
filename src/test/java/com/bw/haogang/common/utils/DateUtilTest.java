package com.bw.haogang.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	//随机年月日
	public void testRandom() {
		Calendar c = Calendar.getInstance();
		c.set(2010, 9, 1);
		Date date = DateUtil.random(c.getTime(), new Date());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String format = fm.format(date);
		System.out.println(format);
	}
	
	@Test
	//返回月初
	public void testgetInitMonth() {
		Date date = DateUtil.getInitMonth(new Date());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
		String format = fm.format(date);
		System.out.println(format);		
	}
	
	@Test
	//返回月末
	public void testgetEndMonth() {
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 7, 23);
		
		Date date = DateUtil. getEndMonth(c.getTime());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
		String format = fm.format(date);
		System.out.println(format);	
	}
	
	@Test
	//根据日期计算年龄
	public void testgetAgeByBirthday() {
		Calendar c = Calendar.getInstance();
		c.set(2000, 3, 23);
		
		int age = DateUtil.getAgeByBirthday(c.getTime());
		
		System.out.println(age);	
	}
	
	@Test
	/**
	 * 将上面{1}的位置使用DateUtil工具类中的getDateByInitMonth()返回值替换，
	 * 将上面{2}的位置使用DateUtil工具类中的getDateByFullMonth()返回值替换。
	 * 最后打印出正确拼接的SQL字符串
	 */
	public void testsql() {
		String sql = "select * from t_order where create_time>='{1}' and create_time<='{2}' ";
		Date initDate = DateUtil.getInitMonth(new Date());
		Date endMonth = DateUtil.getEndMonth(new Date());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH：mm:ss");
		String date1 = fm.format(initDate);
		String date2 = fm.format(endMonth);
		String newSql = sql.replace("{1}",date1).replace("{2}", date2);
		System.out.println(newSql);
	}
	
	

}
