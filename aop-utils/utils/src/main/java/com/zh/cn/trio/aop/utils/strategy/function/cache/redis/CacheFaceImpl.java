package com.zh.cn.trio.aop.utils.strategy.function.cache.redis;

import com.zh.cn.trio.aop.utils.context.AopUtilContext;
import com.zh.cn.trio.aop.utils.strategy.function.cache.CacheFace;
import com.zh.cn.trio.aop.utils.strategy.function.cache.aspect.CacheConfig;

public class CacheFaceImpl implements CacheFace{

	@Override
	public boolean hasCache(AopUtilContext<CacheConfig> aopUtilContext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getCache(AopUtilContext<CacheConfig> aopUtilContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setCache(AopUtilContext<CacheConfig> aopUtilContext) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCache(AopUtilContext<CacheConfig> aopUtilContext) {
		// TODO Auto-generated method stub
		return false;
	}

}
