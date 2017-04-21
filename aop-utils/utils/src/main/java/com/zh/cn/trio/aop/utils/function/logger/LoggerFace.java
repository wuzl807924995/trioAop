package com.zh.cn.trio.aop.utils.function.logger;

public interface LoggerFace {

	public abstract void logger(String level, String name, String info, Throwable e);
}
