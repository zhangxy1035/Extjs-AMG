package com.ow.entity;

import java.io.Serializable;


public class WebOperator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String accountID;
	private String webOperatorID;
	private String operatorName;
	private String password1;
	private String password2;
	private String password3;
	private String password4;
	private String sex;
	private String operatorUid;
	private String mobile;
	private String createDate;
	private String operatorFunction;
	private Integer state;
	private String operatorType;
	private String simNo;
	private String authenticationID;
	private String language;
	private String deviceNo;
	private Integer isBind;
	public Integer getIsBind() {
		return isBind;
	}
	public void setIsBind(Integer isBind) {
		this.isBind = isBind;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getWebOperatorID() {
		return webOperatorID;
	}
	public void setWebOperatorID(String webOperatorID) {
		this.webOperatorID = webOperatorID;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getPassword3() {
		return password3;
	}
	public void setPassword3(String password3) {
		this.password3 = password3;
	}
	public String getPassword4() {
		return password4;
	}
	public void setPassword4(String password4) {
		this.password4 = password4;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOperatorUid() {
		return operatorUid;
	}
	public void setOperatorUid(String operatorUid) {
		this.operatorUid = operatorUid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOperatorFunction() {
		return operatorFunction;
	}
	public void setOperatorFunction(String operatorFunction) {
		this.operatorFunction = operatorFunction;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}
	public String getSimNo() {
		return simNo;
	}
	public void setSimNo(String simNo) {
		this.simNo = simNo;
	}
	public String getAuthenticationID() {
		return authenticationID;
	}
	public void setAuthenticationID(String authenticationID) {
		this.authenticationID = authenticationID;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
//	public Timestamp getCreateDate() {
//		return createDate;
//	}
//	public void setCreateDate(Timestamp createDate) {
//		this.createDate = createDate;
//	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	

}
