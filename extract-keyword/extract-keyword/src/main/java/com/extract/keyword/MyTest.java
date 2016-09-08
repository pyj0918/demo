package com.extract.keyword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MyTest {

	public static void main(String[] args) {
		
		//String keyword = "IKAnalyzer的分词效果到底怎么样呢，我们来看一下,吧,with,then,there,these";
		String keyword=readTxt();
		try {
			String[] keys = KeywordExtractCommon.getKeyWords(keyword, 1, 40);
			System.out.println(Arrays.toString(keys));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}

	public static String readTxt(){
		StringBuilder sb = new StringBuilder();
		File file = new File("D:\\论文.txt");
		InputStreamReader read=null;
		try {
			read = new InputStreamReader(new FileInputStream(file), "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			if (file.isFile() && file.exists()) {
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while ((txt = bufferedReader.readLine()) != null) {
					//System.out.println(txt.trim());
					sb.append(txt.trim());
				}
			} else {
				throw new Exception("文件不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
