package com.ylink.utils;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

public class SignUtils {
	public static String charset = "UTF-8";
	public static String RSA_SHA1 = "SHA1withRSA";
	public static String RSA_SHA256 = "SHA256withRSA";

	public static String sign(String text, String key, String algorithm) {
		byte[] textBytes = text.getBytes();
		byte[] keyBytes = Base64.decode(key);
		byte[] resultBytes = null;
		try {
			resultBytes = SignatureUtil.sign(textBytes, keyBytes, algorithm);
			return Base64.encode(resultBytes);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static boolean verify(String text, String signText, String key, String algorithm) {
		try {
			return SignatureUtil.verify(text.getBytes(), Base64.decode(signText), Base64.decode(key), algorithm);
		} catch (Exception localException) {
		}
		return false;
	}

	public static String encrypt(String text, String key, String algorithm) {
		byte[] bytes = null;
		try {
			bytes = text.getBytes(charset);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		byte[] keyData = Base64.decode(key);
		try {
			byte[] cipherBytes = SymmtricCryptoUtil.symmtricCrypto(bytes, keyData, algorithm, 1);
			return Base64.encode(cipherBytes);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String text, String key, String algorithm) {
		byte[] bytes = Base64.decode(text);
		byte[] keyData = Base64.decode(key);
		try {
			byte[] cipherBytes = SymmtricCryptoUtil.symmtricCrypto(bytes, keyData, algorithm, 2);
			return new String(cipherBytes, charset);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}