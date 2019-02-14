package com.ylink.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 支付方式参数
 * author:jixu
 * date:2017年6月20日
 */
public class Payment implements Serializable {
	private static final long serialVersionUID = 7066004953423356907L;

	@NotBlank(message="支付类型为空")
	@Size(min=2, max=2, message="支付类型长度只能为2")
	private String paymentType; //string 是 2 支付类型 00：支付宝 01：微信
	@NotBlank(message="经营类目为空")
	@Size(max=30, message="经营类目长度超过30")
	private String category; //string 是 30 经营类目，详情参考附件对应相应支付方式的类目
	private String bindStatus; //string 是 2 绑定状态 00：失败 01：成功
	private String bindDesc; //string 否 255 绑定描述
	private String paymentMerchantNo; //string 是 50 支付方式子商户号
	
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBindStatus() {
		return bindStatus;
	}
	public void setBindStatus(String bindStatus) {
		this.bindStatus = bindStatus;
	}
	public String getBindDesc() {
		return bindDesc;
	}
	public void setBindDesc(String bindDesc) {
		this.bindDesc = bindDesc;
	}
	public String getPaymentMerchantNo() {
		return paymentMerchantNo;
	}
	public void setPaymentMerchantNo(String paymentMerchantNo) {
		this.paymentMerchantNo = paymentMerchantNo;
	}
	
	
}
