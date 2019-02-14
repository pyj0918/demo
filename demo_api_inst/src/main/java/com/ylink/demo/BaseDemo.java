package com.ylink.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ylink.entity.Response;
import com.ylink.utils.MD5Util;
import com.ylink.utils.MessageUtils;
import com.ylink.utils.SignUtils;
import com.ylink.utils.StaticConfig;

/**
 * author:jixu
 * date:2017年7月27日
 */
public class BaseDemo {

	private static Logger logger = LoggerFactory.getLogger(BaseDemo.class);

	private static final String CONTENT = "content";
	private static final int REQUEST_TIME_OUT = 60;

	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String parse(Response response) throws ValidationException {
		// 验证时间戳
		checkTimestamp(response);
		// 验签
		verfiy(response);
		// 获取信息
		return response.getContent();
	}

	public static void verfiy(Response respone) throws ValidationException {
        try{
            String pubKey = StaticConfig.PLATFORM_PUBLIC_KEY;
            Map<String,Object> param = MessageUtils.conversionDataTransmissionForMap(respone);
            if(StringUtils.isNotBlank(respone.getContent())){
                param.put(CONTENT, MD5Util.getMD5(respone.getContent()));
            }
            param = MessageUtils.paraFilter(param,"sign");
            String context = MessageUtils.createLinkString(param);
            boolean isVerfiy = SignUtils.verify(context,respone.getSign(),pubKey,SignUtils.RSA_SHA256);
            if(!isVerfiy)
                throw new ValidationException("验签失败.");
        }catch (Exception e){
            e.printStackTrace();
            throw new ValidationException("验签失败.");
        }
    }
    
    public static void checkTimestamp(Response respone){
        try {
            Date timestamp = sf.parse(respone.getTimestamp());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(timestamp);
            calendar.add(Calendar.SECOND,REQUEST_TIME_OUT);
            if(calendar.getTime().getTime() < System.currentTimeMillis()){
                throw new RuntimeException("请求已超时.");
            }
        } catch (ParseException e) {
            throw new RuntimeException("时间戳格式错误.");
        }
    }

}
