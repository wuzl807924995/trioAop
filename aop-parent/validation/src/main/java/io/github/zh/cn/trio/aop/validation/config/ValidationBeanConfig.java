package io.github.zh.cn.trio.aop.validation.config;

import java.util.Map;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.validation.model.ValidationModel;

/**
 * 
 * 验证模式配置
 * 
 * @param <E>
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
