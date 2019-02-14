package com.ylink.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class MessageUtils {
	public static Map<String, Object> paraFilter(Map<String, Object> sArray, String ...ignoreFlied) {
		Map result = new HashMap();

		if ((sArray == null) || (sArray.size() <= 0)) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = (String) sArray.get(key);
			if ((value == null) || (value.equals("")))
				continue;
			if (ArrayUtils.contains(ignoreFlied, key)) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	public static String createLinkString(Map<String, Object> params) {
		List keys = new ArrayList(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); ++i) {
			String key = (String) keys.get(i);
			if (!(params.get(key) instanceof String)) {
				throw new RuntimeException("加签排序时发生数据异常.");
			}
			String value = (String) params.get(key);
			if (i == keys.size() - 1)
				prestr = prestr + key + "=" + value;
			else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr;
	}

	public static Map<String, Object> conversionDataTransmissionForMap(Object obj) throws Exception {
		List<Field> effectiveFields = findEffectiveFields(obj);
		Map datas = new HashMap();
		for (Field field : effectiveFields) {
			String key = field.getName();
			String value = (String) ReflectionUtil.reflectGetValue(obj, key);
			if (!(StringUtils.isEmpty(value)))
				;
			datas.put(key, value);
		}
		return datas;
	}

	protected static List<Field> findEffectiveFields(Object obj) throws Exception {
		Class clazz = obj.getClass();

		Field[] fields = clazz.getDeclaredFields();
		List effectiveFields = new ArrayList();
		for (Field field : fields) {
			effectiveFields.add(field);
		}

		Class superClass = clazz.getSuperclass();
		Field[] superField = superClass.getDeclaredFields();
		for (Field field : superField) {
			effectiveFields.add(field);
		}
		return effectiveFields;
	}
}
