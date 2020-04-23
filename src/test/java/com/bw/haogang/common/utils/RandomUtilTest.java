package com.bw.haogang.common.utils;

import org.junit.Test;

public class RandomUtilTest {

	@Test
	public void testRandom() {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtil.random(1, 130)); 
		}
	}

	@Test
	public void testSubRandom() {
		int[] is = RandomUtil.subRandom(1, 10, 3);
		for(int i : is) {
			System.out.println(i);
		}
	}

	@Test
	public void testRandomCharaacter() {
		char c = RandomUtil.randomCharaacter();
		System.out.println(c);
	}

	@Test
	public void testRandomString() {
		String string = RandomUtil.randomString(4);
		System.out.println(string);
	}

}
