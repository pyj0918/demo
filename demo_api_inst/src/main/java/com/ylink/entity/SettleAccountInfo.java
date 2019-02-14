package com.ylink.entity;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 商户清算账户信息
 * author:jixu
 * date:2017年6月20日
 */
public class SettleAccountInfo implements Serializable {
	private static final long serialVersionUID = 7066004953423356907L;
	
	@NotBlank(message="账户类型为空")
	@Size(min=2, max=2, message="账户类型长度只能为2")
	private String bankAccountType; //string 是 2 账户类型 00：对私 01：对公（商户证件信息必填）
	@NotBlank(message="行别为空")
	private String bankType; //string 是 10 行别，参见附录
	@Size(max=30, message="清算联行号长度超过30")
	private String bankNo; //string 否 30 清算联行号（对公必填）
	@NotBlank(message="账户名称为空")
	@Size(max=30, message="账户名称长度超过30")
	private String accountName; //string 是 30 账户名称(直清必填)
	@NotBlank(message=" 银行账号为空")
	@Size(max=30, message=" 银行账号长度超过30")
	private String accountNo; //string 是 30 银行账号(直清必填)
	
	public String getBankAccountType() {
		return bankAccountType;
	}
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}
	public String getBankType() {
		return bankType;
	}
	public void setBankType(String bankType) {
		this.bankType = bankType;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
}
