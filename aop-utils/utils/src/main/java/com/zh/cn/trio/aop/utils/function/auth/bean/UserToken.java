package com.zh.cn.trio.aop.utils.function.auth.bean;

import java.io.Serializable;

public class UserToken<T extends Serializable> {

	private T sysUserId;
	
	private String token;

	public T getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(T sysUserId) {
		this.sysUserId = sysUserId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
