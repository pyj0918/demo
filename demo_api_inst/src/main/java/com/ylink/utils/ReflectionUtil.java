package com.ylink.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtil {
	public static final String GETTER_PREFIX = "get";
	public static final String GETTER_PREFIX2 = "is";
	public static final String SETTER_PREFIX = "set";

	public static Map<String, String> propertiesByGetterAndSetter(Object obj) {
		if (obj == null) {
			return null;
		}
		Method[] methods = obj.getClass().getMethods();
		Map<String, Object> setterMap = new HashMap();
		Map<String, Object> getterMap = new HashMap();
		for (Method item : methods) {
			String property = item.getName();
			if (property.indexOf("set") != -1)
				setterMap.put(property.substring(3), item);
			else if (property.indexOf("get") != -1)
				getterMap.put(property.substring(3), item);
			else if (property.indexOf("is") != -1) {
				getterMap.put(property.substring(2), item);
			}
		}

		Map result = new HashMap();
		for (String key : setterMap.keySet()) {
			if (getterMap.get(key) != null) {
				key = key.replaceFirst(key.substring(0, 1), key.substring(0, 1).toLowerCase());
				result.put(key, key);
			}
		}

		return result;
	}

	public static void assign(Object from, Object to) {
		if ((from == null) || (to == null))
			return;
		Method[] methods = from.getClass().getMethods();
		Map<String, Object> setterMap = new HashMap<String, Object>();
		Map<String, Object> getterMap = new HashMap<String, Object>();
		for (Method item : methods) {
			String property = item.getName();
			if (property.indexOf("set") != -1)
				setterMap.put(property.substring(3), item);
			else if (property.indexOf("get") != -1)
				getterMap.put(property.substring(3), item);
			else if (property.indexOf("is") != -1) {
				getterMap.put(property.substring(2), item);
			}
		}

		if (setterMap.isEmpty()) {
			return;
		}
		for (String key : setterMap.keySet()) {
			Method setter = (Method) setterMap.get(key);
			Method getter = (Method) getterMap.get(key);
			if ((setter != null) && (getter != null))
				try {
					setter.invoke(to, new Object[]{getter.invoke(from, new Object[0])});
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
		}
	}

	public static Object reflectGetValue(Object model, String property)
  {
    Class clazz = model.getClass();
    Method[] methods = clazz.getMethods();
    Object result = null;

    for (Method item : methods) {
      try {
        if (item.getName().equalsIgnoreCase("get" + property)) {
          result = item.invoke(model, new Object[0]);
          break;
        }
      } catch (IllegalArgumentException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    label119: return result;
  }

	public static void reflectSetValue(Object model, String property, Object value) {
		Class clazz = model.getClass();
		Method[] methods = clazz.getMethods();

		for (Method item : methods)
			try {
				if (item.getName().equalsIgnoreCase("set" + property)) {
					item.invoke(model, new Object[]{value});
					return;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
	}
}
