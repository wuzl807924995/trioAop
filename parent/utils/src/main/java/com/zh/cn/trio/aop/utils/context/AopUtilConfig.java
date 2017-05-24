package com.zh.cn.trio.aop.utils.context;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

public abstract class AopUtilConfig<T extends AopUtilConfig<T>> {

	public static final String TIME_BEFORE = "BEFORE";
	public static final String TIME_AFTER = "AFTER";
	public static final String TIME_ERROR = "ERROR";
	public static final String TIME_AROUND_STARAT = "AROUND_SATART";
	public static final String TIME_AROUND_END = "AROUND_END";

	private boolean async;

	private String[] targetTimes;

	private AopStrategy<T> aopStrategy;

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

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public AopStrategy<T> getAopStrategy() {
		return aopStrategy;
	}

	public void setAopStrategy(AopStrategy<T> aopStrategy) {
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
