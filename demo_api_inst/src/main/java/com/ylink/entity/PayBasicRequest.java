/**
 * 版权所有(C) 2017 深圳雁联计算系统有限公司
 * 创建：杨瀚  2017-06-21 10:57
 */
package com.ylink.entity;

/**
 * 
 * @author Administrator
 *
 */
public abstract class PayBasicRequest implements Message {
	private static final long serialVersionUID = 1L;

    protected String merchantAccessNo;
    protected String orderNo;
    protected String orderAmt;
    protected String subject;
    protected String orderDesc;
    protected String currency;
    protected String storeNo;
    protected String terminalNo;
    protected String employeeNo;
    protected String bgRetUrl;
    protected String remark;

    public String getMerchantAccessNo() {
        return merchantAccessNo;
    }

    public void setMerchantAccessNo(String merchantAccessNo) {
        this.merchantAccessNo = merchantAccessNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderAmt() {
        return orderAmt;
    }

    public void setOrderAmt(String orderAmt) {
        this.orderAmt = orderAmt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStoreNo() {
        return storeNo;
    }

    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getBgRetUrl() {
        return bgRetUrl;
    }

    public void setBgRetUrl(String bgRetUrl) {
        this.bgRetUrl = bgRetUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
