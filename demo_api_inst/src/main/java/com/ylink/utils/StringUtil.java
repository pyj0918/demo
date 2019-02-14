package com.ylink.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Random;

public class StringUtil {

	private StringUtil() {	
		
	};

	/**
	 * 构造指定数量的空格字符串并返回。
	 * 
	 * @param amount
	 *            int 空格符的数量
	 * @return String
	 */
	public static String getSpacebar(int amount) {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	/**
	 * 构造指定数量的零字符组成字符串并返回。
	 * 
	 * @param amount
	 *            int 零字符的数量
	 * @return String
	 */
	public static String getZerobar(int amount) {
		StringBuffer sb = new StringBuffer();
		sb.append("");
		if (amount > 0) {
			for (int i = 0; i < amount; i++) {
				sb.append("0");
			}
		}
		return sb.toString();
	}

	/**
	 * 按照位数将源字符串切割成字符串数组
	 * 
	 * @param src
	 *            源字符串
	 * @param length
	 *            指定的位数
	 * @return
	 */
	public static String[] cutByLength(String src, int length) {
		if (null == src || src.length() == 0 || length <= 0) {
			return null;
		}
		int count = src.length() / length;
		if (src.length() % length != 0) { // 如果源字符串位数不能整除
			count++;
		}
		String[] result = new String[count];
		for (int i = 0; i < count - 1; i++) { // 注意此循环不切割最后一项
			result[i] = src.substring(i * length, (i + 1) * length);
		}
		result[count - 1] = src.substring((count - 1) * length); // 在此切割最后一项
		return result;
	}

	/*
	 * 金额小写转换成大写
	 */
	public static String convertDaxie(double money) {
		String hanzi[] = { "零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖" };
		String wei[] = { "分", "角", "元", "拾", "佰", "仟", "萬", "拾", "佰", "仟", "亿", "拾", "佰", "仟", "萬", "拾", "佰", "仟" };
		String retvalue = new String();
		int i, j = 0;
		boolean is_have = false, is_negative = false;

		if (money < 0) // 负数
		{
			money = Math.abs(money);
			is_negative = true;
		}

		money = Double.valueOf((new BigDecimal(money)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).doubleValue(); // 四舍五入
		if (money == 0.00)
			return "零元";

		for (i = 17; i >= 0; i--) // i 为位数
		{
			if (money == 0)
				break;

			double d1 = money / Math.pow(10.0, i - 2);
			String str = new String();

			if (i == 0)
				str = (new BigDecimal(d1)).setScale(0, BigDecimal.ROUND_HALF_DOWN).toString();
			else
				str = (new BigDecimal(d1)).setScale(0, BigDecimal.ROUND_DOWN).toString();

			// System.out.println("str = " + str + " d1=" + d1);
			j = Integer.valueOf(str).intValue(); // j 为 i 位上的数字
			// System.out.println("i = " + i + " j=" + j + " retvalue=" +
			// money);
			if (j == 0 && (i - 2) % 4 == 0 && is_have) {
				if (retvalue.substring(retvalue.length() - 1).equals(hanzi[0])) {
					if (!(retvalue.substring(retvalue.length() - 2).equals("亿零")))
						retvalue = retvalue.substring(0, retvalue.length() - 1) + wei[i];
				} else
					retvalue = retvalue + wei[i];

			} else if (j == 0 && is_have) {
				if (!(retvalue.substring(retvalue.length() - 1).equals(hanzi[0])))
					retvalue = retvalue + hanzi[0];
			} else if (j > 0) {
				retvalue = retvalue + hanzi[j] + wei[i];
				double d2 = Math.pow(10.0, i - 2);
				money = money - j * d2;
				money = Double.valueOf((new BigDecimal(money)).setScale(2, BigDecimal.ROUND_HALF_UP).toString()).doubleValue();
				is_have = true;
			}
			// System.out.println("retvalue=" + retvalue);
		}

		if (i >= 14)
			retvalue = retvalue + "萬亿元整";
		else if (i >= 10)
			retvalue = retvalue + "亿元整";
		else if (i == 9)
			retvalue = retvalue + "元整";
		else if (i >= 6)
			retvalue = retvalue + "萬元整";
		else if (i >= 2)
			retvalue = retvalue + "元整";
		else if (i >= 0)
			retvalue = retvalue + "整";

		if (is_negative)
			retvalue = "负" + retvalue; // 添前缀

		return retvalue;
	}

	/*
	 * 十六进制转换成二进制
	 */
	public static int Hex2Bin(char[] hexStr, long hexLen, byte[] binStr) {
		if (hexStr.length == 0 || hexLen <= 0 || (hexLen % 2) != 0)
			return -1;

		boolean errflag = false;
		int date[] = new int[2];

		int num = 0, pos = 0;

		while (num < hexLen && !errflag) {
			for (int i = 0; i < 2; i++) {
				if (hexStr[num + i] >= '0' && hexStr[num + i] <= '9')
					date[i] = hexStr[num + i] - '0';
				else if (hexStr[num + i] >= 'A' && hexStr[num + i] <= 'F')
					date[i] = 10 + hexStr[num + i] - 'A';
				else {
					errflag = true;
					break;
				}
			}

			binStr[pos] = (byte) (date[0] * 16 + date[1]);
			num += 2;
			pos++;
		}

		if (!errflag) {
			return 0;
		} else {
			return 1;
		}

	}

	/*
	 * 二进制转十六进制
	 */
	public static int Bin2Hex(byte[] binStr, int binLen, char[] hexStr) {
		// 不对binStr是否为NULL进行判断，因无法确定NULL对于二进制字符串而言是不是有效值
		if (binLen == 0)
			return -1;

		// define character for output
		char digitList[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char inData;
		boolean errflag = false;

		int num = 0, pos = 0;

		while (num < binLen && !errflag) {
			inData = (char) binStr[num];

			int charInd1 = (inData & 0xFF); // 禁止符号扩展

			hexStr[pos + 1] = digitList[charInd1];
			inData >>= 4;
			int charInd2 = (inData & 0xFF);
			hexStr[pos] = digitList[charInd2];
			num++;
			pos += 2;
		}

		if (!errflag) {
			return 0;
		} else {
			return 1;
		}
	}

	/*
	 * 将数字转换成百分数 scale：百分数的小数点后面的位数
	 */
	public static String getPercent(double d, int scale) {
		String str = String.valueOf(d);
		BigDecimal bd = new BigDecimal(str);
		str = bd.multiply(new BigDecimal(100)).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
		int iPos = str.indexOf(".");
		if (iPos > -1) {
			for (int i = scale; i >= 1; i--) {
				if (str.charAt(iPos + i) == '0')
					str = str.substring(0, iPos + i);
				else
					break;
			}
			if (str.length() == iPos + 1)
				str = str.substring(0, iPos);
		}

		return str + "%";
	}

	/**
	 * 字符串替换
	 * 
	 * @param str
	 *            字符串
	 * @param destStr
	 *            替换前字符串
	 * @param srcStr
	 *            替换后字符串
	 * @return
	 */
	public static String replaceMark(String str, String destStr, String srcStr) {

		// 返回值
		StringBuffer retVal = new StringBuffer();

		// 记录查找到相似字符的位置

		int findStation = str.indexOf(destStr);

		int resumStation = 0;

		while (findStation > -1) {
			retVal.append(str.substring(resumStation, findStation));
			retVal.append(srcStr);
			if (srcStr == "")
				resumStation = findStation + 1;
			else
				resumStation = findStation + srcStr.length();

			findStation = str.indexOf(destStr, resumStation);
		}

		retVal.append(str.substring(resumStation));
		return retVal.toString();
	}

	/**
	 * 获取前面不带0755区号、0、-的电话号码
	 * 
	 * @param tel
	 *            电话号码
	 * @return
	 */
	public static String getPureTel(String tel) {
		if (tel != null && tel.length() > 0) {
			if (tel.startsWith("0755")) {
				tel = tel.substring(4);
				tel = tel.trim();
			}
			if (tel.startsWith("-")) {
				tel = tel.substring(1);
			}
			if (tel.startsWith("0")) {
				tel = tel.substring(1);
				tel = tel.trim();
			}
		}
		return tel;
	}

	/**
	 * 获取前面不带0的手机号码
	 * 
	 * @param telNo
	 *            手机号码
	 * @return
	 */
	public static String getPureMobileTel(String telNo) {
		if (telNo != null && telNo.length() > 0 && telNo.startsWith("01")) {
			telNo = telNo.substring(1);
		}
		return telNo;
	}

	/**
	 * 根据15位身份证号码获取18位升位后号码
	 * 
	 * @param perIDSrc
	 *            15位身份证号码
	 * @return
	 */
	public static String per15To18(String perIDSrc) {

		if (perIDSrc.length() != 15) // 如果长度不是15，默认返回null
			return null;

		long per15 = 0;

		// １５位身份证号不是整数
		try {
			per15 = Long.parseLong(perIDSrc);
		} catch (NumberFormatException e) {
			return null;
		}

		// １５位身份证号不是正整数
		if (per15 < 0) {
			return null;
		}

		int iS = 0;

		// 加权因子常数
		int[] iW = new int[] { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };

		// 校验码常数
		String LastCode = "10X98765432";

		// 新身份证号
		String perIDNew;

		perIDNew = perIDSrc.substring(0, 0 + 6);

		// 填在第6位及第7位上填上‘1’，‘9’两个数字
		perIDNew += "19";

		perIDNew += perIDSrc.substring(6, 6 + 9);

		// 进行加权求和
		for (int i = 0; i < 17; i++) {
			iS += Integer.parseInt(perIDNew.substring(i, i + 1)) * iW[i];
		}

		// 取模运算，得到模值
		int iY = iS % 11;

		// 从LastCode中取得以模为索引号的值，加到身份证的最后一位，即为新身份证号。
		perIDNew += LastCode.substring(iY, iY + 1);

		return perIDNew;
	}

	/**
	 * 全角转半角
	 * 
	 * @param QJstr
	 * @return
	 */
	public static final String qjStr2BjStr2(String QJstr) {
		String outStr = "";
		String Tstr = "";
		byte[] b = null;

		for (int i = 0; i < QJstr.length(); i++) {
			try {
				Tstr = QJstr.substring(i, i + 1);
				b = Tstr.getBytes("unicode");
			} catch (java.io.UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			if (b[3] == -1) {
				b[2] = (byte) (b[2] + 32);
				b[3] = 0;

				try {
					outStr = outStr + new String(b, "unicode");
				} catch (java.io.UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			} else
				outStr = outStr + Tstr;
		}

		return outStr;
	}

	/**
	 * 全角转半角
	 * 
	 * @param QJstr
	 * @return
	 */
	public static final String qjStr2BjStr(String QJstr) {
		if (null == QJstr || QJstr.length() == 0)
			return QJstr;
		String outStr = "";

		outStr = QJstr.replaceAll("１", "1").replaceAll("２", "2").replaceAll("３", "3").replaceAll("４", "4").replaceAll("５", "5").replaceAll("６", "6").replaceAll("７", "7").replaceAll("８", "8").replaceAll("９", "9").replaceAll("０", "0").replaceAll("。", ".").replaceAll("Ｘ", "X");
		return outStr;
	}

	/*
	 * 将两位的带字母的36进制数转为整数 比如0A转为10,0Z转为35
	 */
	public static final int str36ToInt(String str36) {
		if (null == str36 || str36.length() == 0)
			return -1;
		int result = 0;

		int num = 0;
		for (int i = 0; i < str36.length(); i++) {
			char c = str36.charAt(i);
			if (c >= '0' && c <= '9') {
				num = c - 48;
			} else if (c >= 'A' && c <= 'Z') {
				num = c - 55;
			}
			if (num == 0) {
				continue;
			} else {
				num = num * (int) Math.pow(36, str36.length() - i - 1);
			}
			result = result + num;
		}

		return result;
	}

	/*
	 * 将整数转为两位的带字母的36进制数 比如10转为0A,35转为0Z 该整数在0-1295之间
	 */
	public static final String intToStr36(int res) {
		if (res < 0 || res > 1295)
			return "ERROR";
		StringBuffer result = new StringBuffer();
		char c1, c2;
		int i1 = (int) res / 36;
		int i2 = (int) res % 36;
		if (i1 > 9) {
			c1 = (char) (i1 + 55);
		} else {
			c1 = (char) (i1 + 48);
		}
		if (i2 > 9) {
			c2 = (char) (i2 + 55);
		} else {
			c2 = (char) (i2 + 48);
		}
		result.append(c1).append(c2);
		return result.toString();
	}

	/**
	 * 左补字符
	 * 
	 * @param oldstr
	 *            原字符
	 * @param padStr
	 *            填充用字符
	 * @param strCount
	 *            填充后的字符串长度
	 */
	public static final String leftPad(String oldStr, char padStr, int strCount) {
		String newStr = oldStr;
		String leftAddStr = "";
		int oldstrCount = oldStr.length();
		int addCount = strCount - oldstrCount;

		if (addCount > 0) {

			for (int i = 0; i < addCount; i++) {
				leftAddStr += padStr;
			}

			newStr = leftAddStr + newStr;

		}
		return newStr;
	}

	/**
	 * 右补字符
	 * 
	 * @param oldstr
	 *            原字符
	 * @param padStr
	 *            填充用字符
	 * @param strCount
	 *            填充后的字符串长度
	 */
	public static final String rightPad(String oldStr, char padStr, int strCount) {
		String newStr = oldStr;
		String leftAddStr = "";
		int oldstrCount = oldStr.length();
		int addCount = strCount - oldstrCount;

		if (addCount > 0) {

			for (int i = 0; i < addCount; i++) {
				leftAddStr += padStr;
			}

			newStr = newStr + leftAddStr;

		}
		return newStr;
	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	

	// ///////////////////////add by 071291 on
	// 20071105//////////////////////////////////////
	/**
	 * 取得随机数字符串（在整数范围内）
	 * 
	 * @param amount
	 * @return
	 */
	private static java.util.Random r = new java.util.Random();

	public static String getRandomNumber() {
		return r.nextInt() + "";
	}
	// ///////////////////////end////////////////////////////////////////
	/***
	 * 星号保护
	 * @description 
	 * @param str
	 * @param begin 0
	 * @param len
	 * @return  
	 * @author lyg
	 * @date 2012-12-13
	 */
	public static String asteriskProtection(String str,int begin,int len)
	{
		String result="";
		if(str==null)
			return result;
		if(str.length()-begin<len)
			len=str.length()-begin;
		if(begin>0)
			result=str.substring(0,begin);
		for(int i=0;i<len;i++)
		{
			result+="*";
		}
		result+=str.substring(len+begin);
		return result;
		
	}
	public static  String fenToYuan(String amount)
	{
		
		if(amount==null||amount.equals("0"))
			return "0";
		long fen=Long.valueOf(amount);
		return fenToYuan(fen);
	}
	public static  String fenToYuan2(String amount)
	{
		
		if(amount==null||amount.equals("0"))
			return "0.00";
		long fen=Long.valueOf(amount);
		return String.format("%.2f", fen/100d);
	}
	public static  String fenToYuanFormat(String amount)
	{
		String result="0";
		if(amount==null||amount.equals("0"))
			return "0";
		long fen=Long.valueOf(amount);
		result=String.format("%1$,1.2f",fen/100d);
		return result;
	}
	
	public static  String fenToYuan(long amount)
	{
		String result="0";
		result=String.format("%1$1.2f", amount/100d);
		return result;
		
	}
	public static long yuanToFen(String amount)
	{
		if(amount==null)
			 return 0;
		double d=Double.valueOf(amount);
		BigDecimal a =BigDecimal.valueOf(d);
		BigDecimal b =BigDecimal.valueOf(100);
		long result=a.multiply(b).longValue();
		return result;
	}
	
	public static String formatCardNo(String cardNo)
	{
		StringBuilder sb=new StringBuilder();
		if(cardNo==null||cardNo.equals(""))
			return cardNo;
		int len=cardNo.length();
		for(int i=0;i<len;)
		{	
			int end=i+4>len?len:i+4;
			sb.append(cardNo.substring(i,end)+" ");
			i=i+4;
		}
		
		return sb.toString().trim();
	}
	public static String formatBankCardNo(String cardNo){
		if(cardNo.length()>7){
			StringBuilder builder=new StringBuilder();
			builder.append(cardNo.substring(0,4));
			builder.append(" ");
			for(int i=0;i<cardNo.length()-7;i++){
				builder.append("*");
			}
			builder.append(" ");
			builder.append(cardNo.substring(cardNo.length()-3));
			return builder.toString();
		}else{
			return cardNo;
		}
	}
	
	public static String trim(String str)
	{
		if(str==null)
			return "";
		return str.trim();
		
	}
	public static String filterBlank(String str)
	{
		if(str==null)
			return null;
		str=str.replaceAll(" ", "");
		return str;
	}
	
	/**
	 * 获取6位随机码
	 * @param radomLen随机码位数
	 * @return
	 */
	public static String getMathRadom(int radomLen){
		//35是因为数组是从0开始的，26个字母+10个数字
		final int  maxNum = 10;
		int i;  //生成的随机数
		int count = 0; //生成的密码的长度
		char[] str = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer radomstr = new StringBuffer("");
		Random r = new Random();
		while(count < radomLen){
			//生成随机数，取绝对值，防止生成负数，
			i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
			if (i >= 0 && i < str.length) {
				radomstr.append(str[i]);
			    count ++;
		   }
		}
		return radomstr.toString();
	}
	
	public static String readInputStream(InputStream in, String charset) throws Exception {
		ByteArrayOutputStream bytestream = new ByteArrayOutputStream();

		int ch = in.read();
		while (ch != -1) {
			bytestream.write(ch);
			ch = in.read();
		}

		byte[] data = bytestream.toByteArray();

		return new String(data, charset);
	}

	public static boolean isNEmpty(String str) {
		return ((null != str) && (str.trim().length() > 0) && (!("null".equals(str))));
	}

	public static boolean isEmpty(String str) {
		return (!(isNEmpty(str)));
	}
	//省略字符
	public static String formatString(String val){
		if(val.length()>16){
			StringBuilder builder=new StringBuilder();
			builder.append(val.substring(0,6));
			builder.append(" ");
			builder.append("***");
			builder.append(" ");
			builder.append(val.substring(val.length()-3));
			return builder.toString();
		}else{
			return val;
		}
	}
	
}
