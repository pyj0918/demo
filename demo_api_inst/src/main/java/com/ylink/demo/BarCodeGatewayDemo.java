package com.ylink.demo;

import java.util.Map;

import javax.xml.bind.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.reflect.TypeToken;
import com.ylink.entity.BarCodePayRequest;
import com.ylink.entity.Response;
import com.ylink.utils.HttpClientUtil;
import com.ylink.utils.JsonUtils;
import com.ylink.utils.SignUtil;
import com.ylink.utils.StaticConfig;

/**
 * 扫码支付demo
 * @author jixu
 *
 */
public class BarCodeGatewayDemo extends BaseDemo {
	private Logger logger = LoggerFactory.getLogger(BarCodeGatewayDemo.class);

    public String process(BarCodePayRequest request){
        try{
            request.setBgRetUrl(StaticConfig.NOTICE_URL);
            request.setRemark("测试备注");
            Map<String,String> param = SignUtil.assignment("2004", request, StaticConfig.MERCHANT_PRIVATE_KEY, StaticConfig.ACCESS_NO);
            String json = HttpClientUtil.sendPostString(StaticConfig.GATEWAY_URL, param);
            logger.info(json);
            String result = process(json);
            logger.info(result);
        }catch (Exception e){
            logger.error("异常：", e);
        }
        return null;
    }
    
    private String process(String json) throws ValidationException {
        Response respone = JsonUtils.fromJson(json,new TypeToken<Response>(){});
        String content = parse(respone);
        return StringUtils.isEmpty(content) ? json : content;
    }
    
    public static void main(String[] args){
    	BarCodePayRequest request = new BarCodePayRequest();
    	request.setMerchantAccessNo("B10002154");
        request.setAuthCode("130311745708434650");
        request.setOrderNo("2017071202");
        request.setOrderAmt("1");
        request.setSubject("订单测试");
        request.setOrderDesc("test");
        request.setCurrency("CNY");
        request.setStoreNo("345");
        request.setTerminalNo("234");
        request.setEmployeeNo("123");
    	
    	new BarCodeGatewayDemo().process(request);
    }
}
