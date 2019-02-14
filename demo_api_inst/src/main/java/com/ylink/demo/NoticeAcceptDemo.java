package com.ylink.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ylink.entity.NoticeAcceptModel;
import com.ylink.utils.MD5Util;
import com.ylink.utils.MessageUtils;
import com.ylink.utils.SignUtils;
import com.ylink.utils.StaticConfig;

@Controller
@RequestMapping("/callback")
public class NoticeAcceptDemo extends BaseDemo {
    private static final Logger logger = LoggerFactory.getLogger(NoticeAcceptDemo.class);
    
    private static final String CONTENT = "content";
    private static final int REQUEST_TIME_OUT = 60;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	@RequestMapping(
			value  = "/noticeResult.do", method = RequestMethod.GET)
    @ResponseBody
    public String entry(HttpServletRequest request) throws Exception {
        try{
        	logger.debug("接收到的回调信息为：{}", request);
        	
            Map<String, String> params = new TreeMap<String, String>();
            NoticeAcceptModel model = new NoticeAcceptModel();

            // 取出所有参数是为了验证签名
            Enumeration<String> parameterNames = request.getParameterNames();

            while (parameterNames.hasMoreElements()) {
                String parameterName = parameterNames.nextElement();
                params.put(parameterName, request.getParameter(parameterName));
            }
            
            model.setAccess_id(params.get("access_id"));
            model.setType(params.get("type"));
            model.setVersion(params.get("version"));
            model.setTimestamp(params.get("timestamp"));
            model.setContent(params.get("content"));
            model.setFormat(params.get("format"));
            model.setSign(params.get("sign"));
            
            parse(model);
        }catch (ValidationException e){
            logger.error("验签失败");
        }catch (Exception e){
            logger.error("发生异常");
        }
        return null;
    }
	
    private void parse(NoticeAcceptModel model) throws ValidationException {
        //验证时间戳
        checkTimestamp(model);
        //验签
        verfiy(model);
        logger.info("模拟器接收业务数据:{}", model.getContent());
    }
    
    private void verfiy(NoticeAcceptModel model) throws ValidationException {
        try{
            String pubKey = StaticConfig.PLATFORM_PUBLIC_KEY;
            Map<String,Object> param = MessageUtils.conversionDataTransmissionForMap(model);
            param.put(CONTENT, MD5Util.getMD5(model.getContent()));
            param = MessageUtils.paraFilter(param,"sign");
            String context = MessageUtils.createLinkString(param);
            boolean isVerfiy = SignUtils.verify(context,model.getSign(),pubKey,SignUtils.RSA_SHA256);
            if(!isVerfiy)
                throw new ValidationException("验签失败.");
        }catch (Exception e){
            e.printStackTrace();
            throw new ValidationException("验签失败.");
        }
    }
    
    private void checkTimestamp(NoticeAcceptModel model){
        try {
            Date timestamp = sf.parse(model.getTimestamp());
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
