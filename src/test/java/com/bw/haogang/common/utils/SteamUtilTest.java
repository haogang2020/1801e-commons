package com.bw.haogang.common.utils;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;

public class SteamUtilTest {

	@Test
	public void testCloseAll() {
		
	}

	@Test
	public void testReadTextFileInputStream() throws FileNotFoundException {
		String path = "C:\\Users\\86178\\Desktop\\1801e.txt";
		String string = SteamUtil.readTextFile(new FileInputStream(path));
		System.out.println(string);
	
	}
	
	@Test 
	public void textReadTextFileFile() {
		String path = "C:\\Users\\86178\\Desktop\\1801e.txt";
		String string = SteamUtil.readTextFile(new File(path));
		System.out.println(string);
	}
	
	@Test 
	public void textReadTextFile2List() {
		String path = "C:\\Users\\86178\\Desktop\\1801e.txt";
		List<String> list = SteamUtil.readTextFile2List(new File(path));
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	

}
