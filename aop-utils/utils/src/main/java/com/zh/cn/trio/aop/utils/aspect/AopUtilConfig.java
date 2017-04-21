package com.zh.cn.trio.aop.utils.aspect;

import org.springframework.util.StringUtils;

public abstract class AopUtilConfig {

	public static final String TIME_BEFORE = "BEFORE";
	public static final String TIME_AFTER = "AFTER";
	public static final String TIME_ERROR = "ERROR";
	public static final String TIME_AROUND_STARAT = "AROUND_SATART";
	public static final String TIME_AROUND_END = "AROUND_END";

	private String strategy;

	private String formatModel;

	private String formatString;

	private String[] targetTimes;
	private boolean async;

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	private boolean enableAround;

	public boolean isEnableAround() {
		return enableAround;
	}

	public void setEnableAround(boolean enableAround) {
		this.enableAround = enableAround;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getFormatModel() {
		return formatModel;
	}

	public void setFormatModel(String formatModel) {
		this.formatModel = formatModel;
	}

	public String getFormatString() {
		return formatString;
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public boolean checkEnable(String time) {
		if (targetTimes == null || StringUtils.isEmpty(time)) {
			return false;
		}
		for (String string : targetTimes) {
			if (time.equals(string)) {
				return true;
			}
		}
		return false;
	}
}
