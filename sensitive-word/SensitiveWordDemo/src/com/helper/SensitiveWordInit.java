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
 * @Description: ��ʼ�����дʿ⣬�����дʼ��뵽HashMap�У�����DFA�㷨ģ��
 * @Project��
 * @Author :
 * @Date ��
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
			// ��ȡ���дʿ�
			Set<String> keyWordSet = readSensitiveWordFile();
			// �����дʿ���뵽HashMap��
			addSensitiveWordToHashMap(keyWordSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sensitiveWordMap;
	}

	/**
	 * ��ȡ���дʿ⣬�����дʷ���HashSet�У�����һ��DFA�㷨ģ�ͣ�<br>
	 * �� = { isEnd = 0 �� = {<br>
	 * isEnd = 1 �� = {isEnd = 0 �� = {isEnd = 1} } �� = { isEnd = 0 �� = { isEnd =
	 * 1 } } } } �� = { isEnd = 0 �� = { isEnd = 0 �� = { isEnd = 0 �� = { isEnd = 1
	 * } } } }
	 * 
	 * @author
	 * @date
	 * @param keyWordSet
	 *            ���дʿ�
	 * @version 1.0
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addSensitiveWordToHashMap(Set<String> keyWordSet) {
		// ��ʼ�����д��������������ݲ���
		sensitiveWordMap = new HashMap(keyWordSet.size());
		String key = null;
		Map nowMap = null;
		Map<String, String> newWorMap = null;
		Iterator<String> iterator = keyWordSet.iterator();
		while (iterator.hasNext()) {
			key = iterator.next(); // �ؼ���
			nowMap = sensitiveWordMap;
			for (int i = 0; i < key.length(); i++) {
				char keyChar = key.charAt(i);
				Object wordMap = nowMap.get(keyChar);
				if (wordMap != null) { // ������ڸ�key��ֱ�Ӹ�ֵ
					nowMap = (Map) wordMap;
				} else {
					// ���������򹹽�һ��map��ͬʱ��isEnd����Ϊ0����Ϊ���������һ��
					newWorMap = new HashMap<String, String>();
					newWorMap.put("isEnd", "0"); // �������һ��
					nowMap.put(keyChar, newWorMap);
					nowMap = newWorMap;
				}
				if (i == key.length() - 1) {
					nowMap.put("isEnd", "1"); // ���һ��
				}
			}
		}
	}

	/**
	 * ��ȡ���дʿ��е����ݣ���������ӵ�set������
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
				throw new Exception("���дʿ��ļ�������");
			}
		} catch (Exception e) {
			throw e;
		} finally {
			read.close();
		}
		return set;
	}
}
