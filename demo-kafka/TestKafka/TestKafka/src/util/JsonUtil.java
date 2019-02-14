package util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;

public class JsonUtil
{
  public static String mapToJson(Map<String, Object> map)
  {
    if ((map == null) || (map.size() == 0)) {
      return null;
    }
    return JSON.toJSONString(map);
  }

  public static String toJson(Object obj)
  {
    if (obj == null) {
      return null;
    }
    return JSON.toJSONString(obj);
  }

  public static <T> T toObject(String text, Class<T> clazz)
  {
    if (text == null) {
      return null;
    }
    return JSON.parseObject(text, clazz);
  }

  public static Map<String, Object> jsonToMap(String jsonStr)
    throws Exception
  {
    if ((jsonStr == null) || (StringUtil.empty(jsonStr))) {
      return null;
    }
    return (Map)JSON.parseObject(jsonStr, Map.class);
  }

  public static Map<String, Object> jsonToMap2(String jsonStr)
    throws Exception
  {
    if ((jsonStr == null) || (StringUtil.empty(jsonStr))) {
      return null;
    }
    return (Map)JSON.parseObject(jsonStr, new TypeReference()
    {
    }
    , new Feature[0]);
  }

  public static void main(String[] args) {
    List list = new ArrayList();
    Map map = new HashMap();
    map.put("totalCount", Integer.valueOf(25));
    map.put("totalPeriod", Integer.valueOf(30));

    Map map2 = new HashMap();
    map2.put("参数名称2", "参数值2");
    map2.put("参数类型编号", "参数类型名称");
    list.add(map);
    list.add(map2);
    String json = toJson(map);
    System.out.println(json);
  }
}