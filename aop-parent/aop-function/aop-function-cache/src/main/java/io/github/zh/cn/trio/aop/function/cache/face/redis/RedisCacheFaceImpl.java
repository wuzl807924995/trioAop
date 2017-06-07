package io.github.zh.cn.trio.aop.function.cache.face.redis;

import io.github.zh.cn.trio.aop.croe.utils.FormatConvertUtils;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.face.CacheFace;
import io.github.zh.cn.trio.aop.plug.redis.operaction.RedisStringOperation;
import io.github.zh.cn.trio.aop.plug.serialization.Serialization;

public class RedisCacheFaceImpl implements CacheFace {

	private RedisStringOperation redisStringOperation;

	private Serialization serialization;

	public RedisStringOperation getRedisStringOperation() {
		return redisStringOperation;
	}

	public void setRedisStringOperation(RedisStringOperation redisStringOperation) {
		this.redisStringOperation = redisStringOperation;
	}

	public Serialization getSerialization() {
		return serialization;
	}

	public void setSerialization(Serialization serialization) {
		this.serialization = serialization;
	}

	@Override
	public boolean hasCache(CacheBeanContext cacheBeanConfig) {
		String string = cacheBeanConfig.getFormat().format(FormatConvertUtils.convertContext(cacheBeanConfig),
				cacheBeanConfig.getKeyModelString());
		return redisStringOperation.exists(string);
	}

	@Override
	public Object getCache(CacheBeanContext cacheBeanConfig) {
		String string = cacheBeanConfig.getFormat().format(FormatConvertUtils.convertContext(cacheBeanConfig),
				cacheBeanConfig.getKeyModelString());
		String val = redisStringOperation.get(string);
		Object object = serialization.forSerialization(val, cacheBeanConfig.getReturnClass());
		return object;
	}

	@Override
	public boolean setCache(CacheBeanContext cacheBeanConfig) {
		String string = cacheBeanConfig.getFormat().format(FormatConvertUtils.convertContext(cacheBeanConfig),
				cacheBeanConfig.getKeyModelString());
		String val = serialization.serialization(cacheBeanConfig.getResultObject());
		redisStringOperation.expireat(string, val, cacheBeanConfig.getCacheTime());
		return true;
	}

	@Override
	public boolean removeCache(CacheBeanContext cacheBeanConfig) {
		String string = cacheBeanConfig.getFormat().format(FormatConvertUtils.convertContext(cacheBeanConfig),
				cacheBeanConfig.getKeyModelString());
		redisStringOperation.del(string);
		return true;
	}

}
