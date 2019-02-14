package com.ylink.entity;

import java.io.Serializable;

/**
 * 商户入驻回复信息
 * author:jixu
 * date:2017年6月20日
 */
public class MerchantAddResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String merchantNo; //string 是 50 商户编号（商户在机构的唯一标识）
	private String merchantAccessNo; //string 是 50 商户接入编号(平台分配给商户的唯一标识)
	private String statusCode; //string 是 4 响应编码
	private String statusDesc; //string 是 255 响应描述

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantAccessNo() {
		return merchantAccessNo;
	}

	public void setMerchantAccessNo(String merchantAccessNo) {
		this.merchantAccessNo = merchantAccessNo;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}


}
