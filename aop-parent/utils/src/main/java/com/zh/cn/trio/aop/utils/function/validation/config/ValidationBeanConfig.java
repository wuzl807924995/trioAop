package com.zh.cn.trio.aop.utils.function.validation.config;

import com.zh.cn.trio.aop.utils.context.AopUtilConfig;

/**
 *	 
 *	验证模式配置
 */
public class ValidationBeanConfig extends AopUtilConfig<ValidationBeanConfig>  {

	/**
	 * 验证集合
	 */
	private String[] expression;

	/**
	 * 错误编码
	 */
	private String[] errorCode;
	
	/**
	 * 验证失败错误信息
	 */
	private String[] errorExpressionMsg;
	
	/**
	 * 验证失败信息
	 */
	private String errorResult;

	
	/**
	 * 验证失败返回结果
	 */
	private Object errorObject;
	

	public String[] getExpression() {
		return expression;
	}

	public void setExpression(String[] expression) {
		this.expression = expression;
	}

	public String[] getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String[] errorCode) {
		this.errorCode = errorCode;
	}

	public String[] getErrorExpressionMsg() {
		return errorExpressionMsg;
	}
	
	public void setErrorExpressionMsg(String[] errorExpressionMsg) {
		this.errorExpressionMsg = errorExpressionMsg;
	}
	
	public String getErrorResult() {
		return errorResult;
	}

	public void setErrorResult(String errorResult) {
		this.errorResult = errorResult;
	}

	public Object getErrorObject() {
		return errorObject;
	}

	public void setErrorObject(Object errorObject) {
		this.errorObject = errorObject;
	}

}
