package com.ylink.entity;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 *
 */
public class NoticeAcceptModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String access_id;
    private String type;
    private String version;
    private String timestamp;
    private String content;
    private String format;
    private String sign;

    public String getAccess_id() {
        return access_id;
    }

    public void setAccess_id(String access_id) {
        this.access_id = access_id;
    }

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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "NoticeAcceptModel{" +
                "access_id='" + access_id + '\'' +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", content='" + content + '\'' +
                ", format='" + format + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
