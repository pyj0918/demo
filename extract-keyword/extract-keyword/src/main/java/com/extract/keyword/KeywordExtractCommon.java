package com.extract.keyword;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class KeywordExtractCommon {

	/**
	 * 提取关键字方法
	 * 
	 * @param content 抽取关键词的内容
	 * @param length 每个关键词的长度
	 * @param number 关键词的个数
	 * @return
	 * @throws IOException
	 */
	public static String[] getKeyWords(String content, Integer length, Integer number) throws IOException {
		// 调用提取单词方法
		List<String> keyWordsList = extract(content, length);
		// list转map并计次数
		Map<String, Integer> map = list2Map(keyWordsList);
		// 使用Collections的比较方法进行对map中value的排序
		ArrayList<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue() - o1.getValue());
			}
		});
		if (list.size() < number) {
			// 排序后的长度，以免获得到null的字符
			number = list.size();
		}
		// 设置将要输出的关键字数组空间
		String[] keyWords = new String[number];
		// 循环排序后的数组
		for (int i = 0; i < list.size(); i++) {
			if (i < number) {
				keyWords[i] = list.get(i).getKey();
			}
		}
		return keyWords;
	}

	/**
	 * 传入String类型的文章，智能提取单词放入list中
	 * 
	 * @param content 抽取关键词的内容
	 * @param length 每个关键词的长度
	 * @return
	 * @throws IOException
	 */
	private static List<String> extract(String content, Integer length) throws IOException {
		// 定义一个list来接收将要截取出来单词
		List<String> list = new ArrayList<String>();
		// 初始化IKAnalyzer
		IKAnalyzer analyzer = new IKAnalyzer();
		// 将IKAnalyzer设置成智能截取
		analyzer.setUseSmart(true);
		// 调用tokenStream方法(读取文章的字符流)
		TokenStream tokenStream = analyzer.tokenStream("", new StringReader(content));
		// 循环获得截取出来的单词
		while (tokenStream.incrementToken()) {
			// 转换为char类型
			CharTermAttribute charTermAttribute = tokenStream.getAttribute(CharTermAttribute.class);
			// 转换为String类型
			String keWord = charTermAttribute.toString();
			// 判断截取关键字在几个单词以上的数量(默认为2个单词以上)
			if (keWord.length() > length) {
				// 将最终获得的单词放入list集合中
				list.add(keWord);
			}
		}
		return list;
	}

	/**
	 * 将list中的集合转换成Map中的key，value为数量默认为1
	 * 
	 * @param list
	 * @return
	 */
	private static Map<String, Integer> list2Map(List<String> list) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String key : list) {
			map.put(key, map.get(key) == null ? 1 : map.get(key) + 1);
		}
		return map;
	}
}
