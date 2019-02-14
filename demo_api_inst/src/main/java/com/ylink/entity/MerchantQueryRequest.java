package com.ylink.entity;

/**
 * 商户查询请求信息
 * author:jixu
 * date:2017年6月20日
 */
public class MerchantQueryRequest implements Message {
	private static final long serialVersionUID = 1L;

	private String merchantNo; //string 是 50 商户编号（商户在机构的唯一标识）
	private String merchantAccessNo; //string 是 50 商户接入编号(平台分配给商户的唯一表示)
	
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

}
