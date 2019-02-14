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

import com.google.gson.reflect.TypeToken;
import com.ylink.entity.MerchantQueryRequest;
import com.ylink.entity.MerchantQueryResponse;
import com.ylink.entity.Response;
import com.ylink.utils.HttpClientUtil;
import com.ylink.utils.JsonUtils;
import com.ylink.utils.MD5Util;
import com.ylink.utils.MessageUtils;
import com.ylink.utils.SignUtil;
import com.ylink.utils.SignUtils;
import com.ylink.utils.StaticConfig;

/**
 * 网关商户请求
 */
public class MerchantQueryDemo extends BaseDemo {
	private static Logger logger = LoggerFactory.getLogger(MerchantQueryDemo.class);
	
	public void merchantQuery(MerchantQueryRequest request) {
		try {
			Map<String, String> param = SignUtil.assignment("1004", request, StaticConfig.MERCHANT_PRIVATE_KEY, StaticConfig.ACCESS_NO);
			String json = HttpClientUtil.sendPostString(StaticConfig.GATEWAY_URL, param);
			
			Response respone = process(json);
			logger.info(JsonUtils.toJson(respone, false));
			MerchantQueryResponse result = JsonUtils.fromJson(parse(respone), new TypeToken<MerchantQueryResponse>() {});
		} catch (Exception e) {
			logger.error("异常：", e);
		}
	}

	private Response process(String json) throws ValidationException {
		Response respone = JsonUtils.fromJson(json, new TypeToken<Response>() {
		});
		return respone;
	}

	public static void main(String[] args){
		MerchantQueryRequest request = new MerchantQueryRequest();
		request.setMerchantAccessNo("B10002142");
		request.setMerchantNo("");
		
		new MerchantQueryDemo().merchantQuery(request);
	}
}
