package com.zh.cn.trio.aop.utils.strategy.function.logger.aspect;

import java.util.Map;

public class LoggerConfig{
	
	/**time->levels->name*/
	private Map<String, Map<String, String>> config;

	public Map<String, Map<String, String>> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Map<String, String>> config) {
		this.config = config;
	}
	
	
}
