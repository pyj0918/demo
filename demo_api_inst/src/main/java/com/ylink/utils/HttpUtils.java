package com.ylink.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author:jixu 
 * @date:2017年7月20日
 */
public class HttpUtils {

	/**
	 * 表单post方式提交请求参数
	 * @param url
	 * @param params
	 * @return
	 */
	public static String httpPostParams(String url, Map<String, String> params) {
		URL u = null;
		HttpURLConnection con = null;
		//构建请求参数
		StringBuffer sb = new StringBuffer();
		if (params != null) {
			for (Entry<String, String> e : params.entrySet()) {
				sb.append(e.getKey());
				sb.append("=");
				sb.append(e.getValue());
				sb.append("&");
			}
			sb.substring(0, sb.length() - 1);
		}
		System.out.println("send_url:" + url);
		System.out.println("send_data:" + sb.toString());
		
		//发送请求
		try {
			u = new URL(url);
			con = (HttpURLConnection) u.openConnection();
			con.setRequestMethod(RequestMethod.POST.name());
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
			osw.write(sb.toString());
			osw.flush();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
		
		//读取返回内容
		StringBuffer buffer = new StringBuffer();
		try {
			// 获取所有响应头字段
			Map<String, List<String>> map = con.getHeaderFields();
			
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			
			String fileName = getFileName(con);
			if( StringUtil.isEmpty(fileName) ){
				throw new Exception("fileName is null");
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				buffer.append(temp);
				buffer.append("\n");
			}
			
			FileUtil.saveFile("D:/" +fileName, buffer.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return buffer.toString();
	}
	
	/**
	 * 从请求头信息中获取文件名
	 * @param con
	 * @return
	 */
	private static String getFileName(HttpURLConnection con) {
		String contentDispositionHeader = con.getHeaderField("Content-Disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("fileName")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
	}

	/**
	 * 上传文件到服务器
	 * @param urlStr
	 * @param fileName
	 * @param file
	 * @throws IOException
	 */
	public static void httpPostFile(String urlStr, String fileName, File file) throws IOException{
		DataInputStream in = null;
		OutputStream out = null;
		HttpURLConnection conn = null;
		InputStream ins = null;
		ByteArrayOutputStream outStream = null;
		try {
			URL url = new URL(urlStr + "?fileName=" + fileName);
			conn = (HttpURLConnection) url.openConnection();
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "text/html");
			conn.setRequestProperty("Cache-Control", "no-cache");
			conn.setRequestProperty("Charsert", "UTF-8");
			conn.connect();
			conn.setConnectTimeout(10000);
			out = conn.getOutputStream();

			//File file = new File("H:/Users/chengtingyu/Desktop/test/list.txt");
			in = new DataInputStream(new FileInputStream(file));

			int bytes = 0;
			byte[] buffer = new byte[1024];
			while ((bytes = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytes);
			}
			out.flush();

			// 返回流
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				ins = conn.getInputStream();
				outStream = new ByteArrayOutputStream();
				byte[] data = new byte[1024];
				int count = -1;
				while ((count = ins.read(data, 0, 1024)) != -1) {
					outStream.write(data, 0, count);
				}
				data = null;
				String resultStr = new String(outStream.toByteArray(), "UTF-8");
				System.out.println(resultStr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
			if (ins != null) {
				ins.close();
			}
			if (outStream != null) {
				outStream.close();
			}
			if (conn != null) {
				conn.disconnect();
			}
		}
	}

	/**
	 * 从url下载文件
	 * @param urlStr
	 * @param fileName
	 * @param savePath
	 * @throws IOException
	 */
	public static File httpdownLoadFileFromUrl(String urlStr, String fileName, String savePath) throws IOException {
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// 设置超时间为3秒
		conn.setConnectTimeout(3 * 1000);
		// 防止屏蔽程序抓取而返回403错误
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 得到输入流
		InputStream inputStream = conn.getInputStream();
		// 获取自己数组
		byte[] getData = readInputStream(inputStream);

		// 文件保存位置
		File saveDir = new File(savePath);
		if (!saveDir.exists()) {
			saveDir.mkdir();
		}
		File file = new File(saveDir + File.separator + fileName);
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getData);
		if (fos != null) {
			fos.close();
		}
		if (inputStream != null) {
			inputStream.close();
		}

		System.out.println("info:" + url + " download success");
		
		return file;
	}

	/**
	 * 从输入流中获取字节数组
	 * 
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputStream) throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}

	public static void main(String[] args) throws IOException {
		String photoUrl = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
		String fileName = photoUrl.substring(photoUrl.lastIndexOf("/"));
		// System.out.println("fileName---->"+fileName);
		String filePath = "d:";
		File file = httpdownLoadFileFromUrl(photoUrl, fileName, filePath);
		System.out.println("Run ok!/n<BR>Get URL file " + file);
	}

}
