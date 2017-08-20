package io.github.zh.cn.trio.aop.function.cache.face.decorate.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.function.cache.context.CacheConfig;
import io.github.zh.cn.trio.aop.function.cache.face.decorate.CacheOperation;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.plug.redis.operaction.RedisStringOperation;
import io.github.zh.cn.trio.aop.plug.serialization.Serialization;

@Component
public class RedisCacheOperactionImpl implements CacheOperation {

	@Autowired
	private RedisStringOperation redisStringOperation;

	@Autowired
	private Serialization serialization;

	@Autowired
	private Format format;

	public RedisStringOperation getRedisStringOperation() {
		return redisStringOperation;
	}

	public void setRedisStringOperation(
			RedisStringOperation redisStringOperation) {
		this.redisStringOperation = redisStringOperation;
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
		return redisStringOperation.exists(string);
	}

	@Override
	public Object getCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		String val = redisStringOperation.get(string);
		return serialization.forSerialization(val,
				runTimeContext.getReturnClass());
	}

	@Override
	public boolean setCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		String val = serialization.serialization(runTimeContext
				.getResultObject());
		return redisStringOperation.expireat(string, val,
				cacheConfig.getCacheTime());
	}

	@Override
	public boolean removeCache(RunTimeContext runTimeContext,
			CacheConfig cacheConfig) {
		String string = getKey(runTimeContext, cacheConfig);
		return redisStringOperation.del(string);
	}

}
