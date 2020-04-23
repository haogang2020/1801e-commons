package com.bw.haogang.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void testRandom() {
		
		Calendar c = Calendar.getInstance();
		c.set(2010, 9, 1);
		Date date = DateUtil.random(c.getTime(), new Date());
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		String format = fm.format(date);
		System.out.println(format);
	}

}
