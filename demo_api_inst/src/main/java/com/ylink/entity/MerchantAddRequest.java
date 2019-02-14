package com.ylink.entity;

import java.util.List;

/**
 * 商户入驻请求信息
 * author:jixu
 * date:2017年6月20日
 */
public class MerchantAddRequest implements Message {

	private static final long serialVersionUID = 1L;
	
	private String merchantType; //string 是 2 商户类型01-个人，02-企业
	private String merchantNo; //string 是 50 商户编号（商户在机构的唯一标识）
	private String merchantName; //string 是 100 商户名称
	private String merchantAbbName; //string 是 50 商户简称
	private String merchantAddress; //string 是 300 商户地址
	private String provinceCode; //string 是 16 省份编码 详见附件地区代码
	private String cityCode; //string 是 16 城市代码
	private String districtCode; //string 是 16 区县代码
	private String contactName; //string 是 50 联系人姓名
	private String contactPhone; //string 是 20 联系人电话 （手机或座机）
	private String contactEmail; //string 否 50 联系人email
	private String legalName; //string 是 50 法人姓名(个人经营填营业执照上的姓名)
	private String legalIdType; //string 是 2 法人证件类型 01-身份证
	private String legalIdNo; //string 是 30 法人证件号码
	private String merchantCardType; //string 否 2 商户证件类型 01:营业执照02:统一社会信用代码
	private String merchantCardNo; //string 否 40 商户证件号码
	private String beginTermTime; //string 否 8 商户证件有效期开始日期（格式:yyyyMMdd）
	private String endTermTime; //string 否 8 商户证件有效期结束日期（格式:yyyyMMdd）
	private String settleType; //string 是 2 清算类型 00：直清，01：非直清
	private List<SettleAccountInfo> settleAccountInfo; //string 是  商户清算账户信息
	private List<Payment> payments; //string 支付方式参数
	private List<Fee> fees; //string 费用参数
	
	private String businessScope; //string 经营范围
    private String bgRetUrl;
	
	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantAbbName() {
		return merchantAbbName;
	}

	public void setMerchantAbbName(String merchantAbbName) {
		this.merchantAbbName = merchantAbbName;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getLegalName() {
		return legalName;
	}

	public void setLegalName(String legalName) {
		this.legalName = legalName;
	}

	public String getLegalIdType() {
		return legalIdType;
	}

	public void setLegalIdType(String legalIdType) {
		this.legalIdType = legalIdType;
	}

	public String getLegalIdNo() {
		return legalIdNo;
	}

	public void setLegalIdNo(String legalIdNo) {
		this.legalIdNo = legalIdNo;
	}

	public String getMerchantCardType() {
		return merchantCardType;
	}

	public void setMerchantCardType(String merchantCardType) {
		this.merchantCardType = merchantCardType;
	}

	public String getMerchantCardNo() {
		return merchantCardNo;
	}

	public void setMerchantCardNo(String merchantCardNo) {
		this.merchantCardNo = merchantCardNo;
	}

	public String getBeginTermTime() {
		return beginTermTime;
	}

	public void setBeginTermTime(String beginTermTime) {
		this.beginTermTime = beginTermTime;
	}

	public String getEndTermTime() {
		return endTermTime;
	}

	public void setEndTermTime(String endTermTime) {
		this.endTermTime = endTermTime;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public List<SettleAccountInfo> getSettleAccountInfo() {
		return settleAccountInfo;
	}

	public void setSettleAccountInfo(List<SettleAccountInfo> settleAccountInfo) {
		this.settleAccountInfo = settleAccountInfo;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<Fee> getFees() {
		return fees;
	}

	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}

	public String getBusinessScope() {
		return businessScope;
	}

	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}

	public String getBgRetUrl() {
		return bgRetUrl;
	}

	public void setBgRetUrl(String bgRetUrl) {
		this.bgRetUrl = bgRetUrl;
	}


}
