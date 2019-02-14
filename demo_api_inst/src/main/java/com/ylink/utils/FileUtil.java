package com.ylink.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author jixu
 * @date 2017-04-24
 */
public class FileUtil {
    
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	/**
	 * 使用UTF-8编码格式输出到文件
	 * @param content
	 * @throws Exception 
	 */
	public static void saveFile(String fileName, String content) throws Exception {
		File outFile = new File(fileName);
		if (!outFile.exists()) {
			outFile.createNewFile();
		}
		BufferedWriter outWriter = null;
		try {
			outWriter = new BufferedWriter( new OutputStreamWriter(new FileOutputStream(fileName),"UTF-8"));
			outWriter.write(content);
		} catch (IOException e) {
			logger.error("保存数据到文件异常：", e);
		} finally {
			try {
				outWriter.flush();
				outWriter.close();
			} catch (IOException e) {
				logger.error("保存数据到文件异常：", e);
			}
		}
	}
}