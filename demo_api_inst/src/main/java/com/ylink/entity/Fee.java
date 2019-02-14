package com.ylink.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 费用参数
 * author:jixu
 * date:2017年6月21日
 */
public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank(message="时效类型为空")
	@Size(min=2, max=2, message="时效类型长度只能为2")
	private String timeType; //string 是 2 时效类型: 00：T0 01:T1
	@NotBlank(message="费用类型为空")
	@Size(min=2, max=2, message="费用类型长度只能为2")
	private String feeType; //string 是 2 费用类型 00：交易 01：提现
	@NotBlank(message="费用参数为空")
	@Size(max=10, message="费用参数长度超过10")
	private String feeParam; //string 是 10 费用参数 1、当费用类型为交易时：小数点保留3位（百分比），例如输入0.100，代表千分之一 2、当费用类型为提现时，代表每笔交易手续费（单位分）
	
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}
	public String getFeeParam() {
		return feeParam;
	}
	public void setFeeParam(String feeParam) {
		this.feeParam = feeParam;
	}
	public String getTimeType() {
		return timeType;
	}
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}
	
	
}
