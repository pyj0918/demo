package com.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 初始化敏感词库，将敏感词加入到HashMap中，构建DFA算法模型
 * @Project：
 * @Author :
 * @Date ：
 * @version
 */
public class SensitiveWordInit {

	private String ENCODING = "utf-8";
	@SuppressWarnings("rawtypes")
	public HashMap sensitiveWordMap;

	public SensitiveWordInit() {
		super();
	}

	/**
	 * @author
	 * @date
	 * @version 1.0
	 */
	@SuppressWarnings("rawtypes")
	public Map initKeyWord() {
		try {
			// 读取敏感词库
			Set<String> keyWordSet = readSensitiveWordFile();
			// 将敏感词库加入到HashMap中
			addSensitiveWordToHashMap(keyWordSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	/**
	 * 读取敏感词库，将敏感词放入HashSet中，构建一个DFA算法模型：<br>
	 * 中 = { isEnd = 0 国 = {<br>
	 * isEnd = 1 人 = {isEnd = 0 民 = {isEnd = 1} } 男 = { isEnd = 0 人 = { isEnd =
	 * 1 } } } } 五 = { isEnd = 0 星 = { isEnd = 0 红 = { isEnd = 0 旗 = { isEnd = 1
	 * } } } }
	 * 
	 * @author
	 * @date
	 * @param keyWordSet
	 *            敏感词库
	 * @version 1.0
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		// 初始化敏感词容器，减少扩容操作
		sensitiveWordMap = new HashMap(keyWordSet.size());
		String key = null;
		Map nowMap = null;
		Map<String, String> newWorMap = null;
		Iterator<String> iterator = keyWordSet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next(); // 关键字
			nowMap = sensitiveWordMap;
			for (int i = 0; i < key.length(); i++) {
				char keyChar = key.charAt(i);
				Object wordMap = nowMap.get(keyChar);
				if (wordMap != null) { // 如果存在该key，直接赋值
					nowMap = (Map) wordMap;
				} else {
					// 不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
					newWorMap = new HashMap<String, String>();
					newWorMap.put("isEnd", "0"); // 不是最后一个
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}
				if (i == key.length() - 1) {
					nowMap.put("isEnd", "1"); // 最后一个
				}
			}
		}
	}

	/**
	 * 读取敏感词库中的内容，将内容添加到set集合中
	 * 
	 * @author
	 * @date
	 * @return
	 * @version
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private Set<String> readSensitiveWordFile() throws Exception {
		Set<String> set = null;
		File file = new File("D:\\sensitiveword.txt");
		InputStreamReader read = new InputStreamReader(new FileInputStream(file), ENCODING);
		try {
			if (file.isFile() && file.exists()) {
				set = new HashSet<String>();
				BufferedReader bufferedReader = new BufferedReader(read);
				String txt = null;
				while ((txt = bufferedReader.readLine()) != null) {
					System.out.println(txt.trim());
					set.add(txt.trim());
				}
			} else {
				throw new Exception("敏感词库文件不存在");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			read.close();
		}
		return set;
	}
}
