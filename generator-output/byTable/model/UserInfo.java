/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2014
 */

package com.who.are.you.model;

import java.util.*;

import com.who.are.you.somebody.dao.*;
import com.who.are.you.somebody.service.*;

public class UserInfo extends BaseEntity implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private java.lang.Long userId;
	private java.lang.String username;
	private java.lang.String password;
	private java.util.Date birthDate;
	private java.lang.Integer sex;
	private java.lang.Integer age;

	public UserInfo{}

	public void setUserId(java.lang.Long value) {
		this.userId = value;
	}

	public java.lang.Long getUserId() {
		return this.userId;
	}

	public void setUsername(java.lang.String value) {
		this.username = value;
	}

	public java.lang.String getUsername() {
		return this.username;
	}

	public void setPassword(java.lang.String value) {
		this.password = value;
	}

	public java.lang.String getPassword() {
		return this.password;
	}

	public void setBirthDate(java.util.Date value) {
		this.birthDate = value;
	}

	public java.util.Date getBirthDate() {
		return this.birthDate;
	}

	public void setSex(java.lang.Integer value) {
		this.sex = value;
	}

	public java.lang.Integer getSex() {
		return this.sex;
	}

	public void setAge(java.lang.Integer value) {
		this.age = value;
	}

	public java.lang.Integer getAge() {
		return this.age;
	}


}

