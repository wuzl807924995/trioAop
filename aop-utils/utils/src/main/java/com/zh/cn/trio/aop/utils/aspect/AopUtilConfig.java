package com.zh.cn.trio.aop.utils.aspect;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public abstract class AopUtilConfig {

	public static final String TIME_BEFORE = "BEFORE";
	public static final String TIME_AFTER = "AFTER";
	public static final String TIME_ERROR = "ERROR";
	public static final String TIME_AROUND_STARAT = "AROUND_SATART";
	public static final String TIME_AROUND_END = "AROUND_END";

	private boolean async;

	private boolean around;

	private String[] targetTimes;

	private AopStrategy aopStrategy;

	private Format format;

	private String formatString;

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

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isAround() {
		return around;
	}

	public void setAround(boolean around) {
		this.around = around;
	}

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public AopStrategy getAopStrategy() {
		return aopStrategy;
	}

	public void setAopStrategy(AopStrategy aopStrategy) {
		this.aopStrategy = aopStrategy;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public String getFormatString() {
		return formatString;
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
