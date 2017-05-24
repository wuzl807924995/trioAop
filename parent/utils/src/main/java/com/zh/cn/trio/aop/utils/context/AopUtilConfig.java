package com.zh.cn.trio.aop.utils.context;

import org.springframework.util.StringUtils;

import com.zh.cn.trio.aop.utils.base.format.Format;
import com.zh.cn.trio.aop.utils.strategy.AopStrategy;

/**
 *	抽象父类配置
 * @param <T>
 */
public abstract class AopUtilConfig<T extends AopUtilConfig<T>> {

	/**
	 * 触发时间--前置触发
	 */
	public static final String TIME_BEFORE = "BEFORE";
	/**
	 * 触发时间--后置触发
	 */
	public static final String TIME_AFTER = "AFTER";
	/**
	 * 触发时间--异常触发
	 */
	public static final String TIME_ERROR = "ERROR";
	public static final String TIME_AROUND_STARAT = "AROUND_SATART";
	public static final String TIME_AROUND_END = "AROUND_END";

	/**
	 * 是否异步  需要策略支持异步
	 */
	private boolean async;

	/**
	 * 触发时间
	 */
	private String[] targetTimes;

	/**
	 * 策略
	 */
	private AopStrategy<T> aopStrategy;

	/**
	 * 填充模板
	 */
	private Format format;

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

}
