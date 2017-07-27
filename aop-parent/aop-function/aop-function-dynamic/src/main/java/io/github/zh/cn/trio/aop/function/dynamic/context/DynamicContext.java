package io.github.zh.cn.trio.aop.function.dynamic.context;

import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;
import io.github.zh.cn.trio.aop.function.dynamic.face.DynamicFace;

public class DynamicContext extends AopUtilContext {

	private String dynamicKey;

	private DynamicFace dynamicFace;

	public String getDynamicKey() {
		return dynamicKey;
	}

	public void setDynamicKey(String dynamicKey) {
		this.dynamicKey = dynamicKey;
	}

	public DynamicFace getDynamicFace() {
		return dynamicFace;
	}

	public void setDynamicFace(DynamicFace dynamicFace) {
		this.dynamicFace = dynamicFace;
	}

}
