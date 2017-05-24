package com.zh.cn.trio.aop.utils.function.cache.redis;

import com.zh.cn.trio.aop.utils.base.format.utils.FormatConvertUtils;
import com.zh.cn.trio.aop.utils.base.redis.operaction.RedisStringOperation;
import com.zh.cn.trio.aop.utils.base.serialization.Serialization;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.function.cache.config.CacheBeanConfig;

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
	public boolean hasCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {

		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getKeyModelString());
		return redisStringOperation.exists(string);
	}

	@Override
	public Object getCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getKeyModelString());
		return redisStringOperation.get(string);
	}

	@Override
	public boolean setCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getKeyModelString());
		String val = serialization.serialization(aopUtilContext.getResultObject());
		redisStringOperation.expireat(string, val, aopUtilContext.getAopUtilConfig().getCacheTime());
		return true;
	}

	@Override
	public boolean removeCache(AopUtilContext<CacheBeanConfig> aopUtilContext) {
		String string = aopUtilContext.getAopUtilConfig().getFormat().format(
				FormatConvertUtils.convertContext(aopUtilContext), aopUtilContext.getAopUtilConfig().getKeyModelString());
		redisStringOperation.del(string);
		return true;
	}

}
