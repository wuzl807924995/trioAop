package com.zh.cn.trio.aop.utils.function.validation.config;

import java.util.Map;

import com.zh.cn.trio.aop.ValidationModel;
import com.zh.cn.trio.aop.croe.context.AopUtilConfig;

/**
 * 
 * 验证模式配置
 */
public class ValidationBeanConfig extends AopUtilConfig<ValidationBeanConfig> {

	private Map<String, ValidationModel> validationModelMap;

	public Map<String, ValidationModel> getValidationModelMap() {
		return validationModelMap;
	}

	public void setValidationModelMap(Map<String, ValidationModel> validationModelMap) {
		this.validationModelMap = validationModelMap;
	}

}
