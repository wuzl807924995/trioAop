package io.github.zh.cn.trio.aop.croe.context;

import org.springframework.util.StringUtils;

import io.github.zh.cn.trio.aop.croe.adapter.RunTimeAdapter;

/**
 *  上下文配置
 *			<br>
 *	主要是触发时间，运行适配器，其他自定义参数等
 */
public class RunTimeConfig {

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
	 * 触发时间
	 */
	private String[] targetTimes;

	private RunTimeAdapter runTimeAdapter;
	
	private boolean around;
	
	

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

	public String[] getTargetTimes() {
		return targetTimes;
	}

	public void setTargetTimes(String[] targetTimes) {
		this.targetTimes = targetTimes;
	}

	public RunTimeAdapter getRunTimeAdapter() {
		return runTimeAdapter;
	}

	public void setRunTimeAdapter(RunTimeAdapter runTimeAdapter) {
		this.runTimeAdapter = runTimeAdapter;
	}

	public boolean isAround() {
		return around;
	}

	public void setAround(boolean around) {
		this.around = around;
	}


}
