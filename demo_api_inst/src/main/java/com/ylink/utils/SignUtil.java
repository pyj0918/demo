/**
 * 版权所有(C) 2017 深圳市雁联计算系统有限公司
 * 创建:YangHan 2017-05-11
 */
package com.ylink.utils;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.ylink.entity.Message;

/**
 * @author 杨瀚
 * @date 2017-05-11
 * @description
 */
public class SignUtil {

    private static final String CONTENT = "content";

    public static Map<String,String> assignment(String type,Message message,String prvKey,String merchantNo){

        Map<String,String> param = new LinkedHashMap <>();
        param.put("access_id",merchantNo);
        param.put("type",type);
        param.put("version","1.0");
        param.put("timestamp",DateUtil.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
        String content = JsonUtils.toJson(message,false);
        param.put("content",content);
        param.put("format","JSON");
        
        String signAfter = sign(param,content,prvKey);
        
        param.put("sign",signAfter);
        return param;

    }

    public static String sign(Map<String,String> param,String content,String prvKey){

        Map<String,Object> sign = new LinkedHashMap <>();

        sign.putAll(param);

        sign.put(CONTENT, MD5Util.getMD5(content));

        sign = MessageUtils.paraFilter(sign);

        String context = MessageUtils.createLinkString(sign);

        return SignUtils.sign(context,prvKey,SignUtils.RSA_SHA256);
    }

}
