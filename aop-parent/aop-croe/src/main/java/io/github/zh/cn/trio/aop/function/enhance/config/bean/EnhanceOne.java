package io.github.zh.cn.trio.aop.function.enhance.config.bean;

import io.github.zh.cn.trio.aop.function.enhance.face.decorate.EnhanceType;

public class EnhanceOne {

	private boolean MethodResult;

	private int targetIndex;

	/**
	 * 被增强的所有参数
	 */
	private Object all;

	/**
	 * 当前的增强参数
	 */
	private Object root;

	/**
	 * 当前的增强目标
	 */
	private Object target;

	/**
	 * 增強參數的參數
	 */
	private Object enhanceArgs;


	private EnhanceType enhanceType;

	public boolean isMethodResult() {
		return MethodResult;
	}

	public void setMethodResult(boolean methodResult) {
		MethodResult = methodResult;
	}

	public int getTargetIndex() {
		return targetIndex;
	}

	public void setTargetIndex(int targetIndex) {
		this.targetIndex = targetIndex;
	}

	public Object getAll() {
		return all;
	}

	public void setAll(Object all) {
		this.all = all;
	}

	public Object getRoot() {
		return root;
	}

	public void setRoot(Object root) {
		this.root = root;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}

	public Object getEnhanceArgs() {
		return enhanceArgs;
	}

	public void setEnhanceArgs( Object enhanceArgs) {
		this.enhanceArgs = enhanceArgs;
	}


	public EnhanceType getEnhanceType() {
		return enhanceType;
	}

	public void setEnhanceType(EnhanceType enhanceType) {
		this.enhanceType = enhanceType;
	}

}
