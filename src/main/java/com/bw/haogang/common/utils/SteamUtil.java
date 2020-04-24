package com.bw.haogang.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SteamUtil {

	/**
	 * 方法1：批量关闭流，参数能传无限个
	 * 例如传入FileInputStream对象，JDBC中Connection对象都可以关闭
	 */
	public static void closeAll(AutoCloseable ... autoCloseables) {
		if(autoCloseables==null || autoCloseables.length==0)
			throw new RuntimeException("参数异常");
		for(AutoCloseable autoCloseables2 : autoCloseables) {
			try {
				autoCloseables2.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 方法2：传入一个文本文件对象，默认为UTF-8编码，返回该文件内容，要求方法内部调用上面第一个方法关闭流
	 */
	public static String readTextFile(InputStream src) {
		//构建BufferedReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(src));
		String str = null;
		StringBuffer sb = new StringBuffer();
		try {
			while((str= reader.readLine())!=null) {
				reader.readLine();
				sb.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			closeAll(reader);
		}
		return sb.toString();		
	}
	
	/**
	 * 方法3：传入文本文件对象，返回改文件内容，并且要求调用上面第2个方法
	 * 典型的方法重载
	 */
	public static String readTextFile(File textFile) {
		try {
			FileInputStream stream = new FileInputStream(textFile);
			return readTextFile(stream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 读取文件到集合
	 */
	public static List<String> readTextFile2List(File textFile){
		
		List<String> list = new ArrayList<String>();
		try {
			//构建BufferedReader
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(textFile)));
			String str = null;
			while((str=reader.readLine())!=null) {
				list.add(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
