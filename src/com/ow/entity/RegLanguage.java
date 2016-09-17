package com.ow.entity;

import java.io.Serializable;
import java.sql.Date;

public class RegLanguage implements Serializable {
	private String accountID;
	private String regLanguageID;
	private String regLanguageInfo;
	private Date startDateTime;
	private Date endDateTime;
	private String remark;
	private String state;
	

	public String getRegLanguageInfo() {
		return regLanguageInfo;
	}
	public void setRegLanguageInfo(String regLanguageInfo) {
		this.regLanguageInfo = regLanguageInfo;
	}
	public Date getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}
	public Date getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRegLanguageID() {
		return regLanguageID;
	}
	public void setRegLanguageID(String regLanguageID) {
		this.regLanguageID = regLanguageID;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	

}
