   package com.bw.haogang.common.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	//方法1：判断源字符串是否有值，空引号（空白字符串）也算没值
	public void testHasLength() {
		String src = " ";
		System.out.println(StringUtil.hasLength(src));
	}

	@Test
	//方法2：判断源字符串  空格也算没值
	public void testHasText() {
		String src = " ";
		System.out.println(StringUtil.hasText(src));
	}

	@Test
	//方法3：返回一个字符串
	public void testRandomChineseString() {
		String string = StringUtil.randomChineseString(100);
		System.out.println(string);
	}

	@Test
	//方法4：返回中文姓名，必须以真实姓开头
	public void testGenerateChineseName() {
		for (int i = 0; i < 100; i++) {
			String name = StringUtil.generateChineseName();
			System.out.println(name);
		}
	}
	
	@Test
	//方法5：判断是否邮箱
	public void testisEMail() {
		String str = "1165177756@qq.com";
		boolean b = StringUtil.isEMail(str);
		if(b) {
			System.out.println("是邮箱");
		}else {
			System.out.println("不是邮箱");
		}
	}
	
	@Test
	//方法6：判断是否是中国的手机号码
	public void testisPhone() {
		String str = "13051428252";
		boolean b = StringUtil.isPhone(str);
		if(b) {
			System.out.println("是中国的手机号码");
		}else {
			System.out.println("不是中国的手机号码");
		}
	}
	
	@Test
	//方法7：判断一个字符串是否是数字
	public void testisNumber() {
		String str = "3.14";
		boolean b = StringUtil.isNumber(str);
		if(b) {
			System.out.println("是数字");
		}else {
			System.out.println("不是数字");
		}
	}

}
