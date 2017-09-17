package io.github.zh.cn.trio.aop.function.cache.face.decorate.impl;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.decorate.CacheOperation;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.plug.operaction.StringOperation;
import io.github.zh.cn.trio.aop.plug.serialization.Serialization;

public class CacheOperactionImpl implements CacheOperation {

	private StringOperation stringOperation;

	private Serialization serialization;

	private Format format;

	public StringOperation getRedisStringOperation() {
		return stringOperation;
	}

	public void setRedisStringOperation(
			StringOperation stringOperation) {
		this.stringOperation = stringOperation;
	}

	public Serialization getSerialization() {
		return serialization;
	}

	public void setSerialization(Serialization serialization) {
		this.serialization = serialization;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	String getKey(RunTimeContext runTimeContext, CacheConfig cacheConfig) {
		return format.format(runTimeContext, cacheConfig,
				cacheConfig.getKeyModelString());
	}

	@Override
	public boolean hasCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		return stringOperation.exists(string);
	}

	@Override
	public Object getCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		String val = stringOperation.get(string);
		return serialization.forSerialization(val,
				runTimeContext.getReturnClass());
	}

	@Override
	public boolean setCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		String val = serialization.serialization(runTimeContext
				.getResultObject());
		return stringOperation.expireat(string, val,
				cacheConfig.getCacheTime());
	}

	@Override
	public boolean removeCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		return stringOperation.del(string);
	}

}
