/**
 * 版权所有(C) 2017 深圳雁联计算系统有限公司
 * 创建：杨瀚  2017-06-20 14:36
 */
package com.ylink.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ylink.utils.JsonUtils;

/**
 * 报文响应.
 * author 杨瀚
 * data 2017-06-20 14:36
 */
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
     * 报文响应构造函数
     * @param type 报文类型
     * @param code 响应编码
     * @param msg 响应信息
     * @param error 错误信息
     * @param content 报文主体
     */
    public Response(String type, String code, String msg, String error, String content) {
        this.type = type;
        this.version = "1.0";
        this.code = code;
        this.msg = msg;
        this.error = error;
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.content = content;
    }


    private String type;

    private String version;

    private String code;

    private String msg;

    private String error;

    private String timestamp;

    private String content;

    private String sign;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String serializable(){
        return JsonUtils.toJson(this,false);
    }

    public String serializable(String sign){
        this.sign = sign;
        return this.serializable();
    }
}
