package io.github.zh.cn.trio.aop.function.cache.model;

import org.springframework.stereotype.Component;

import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;

@Component
public class ReadOnlyCacheModel extends AbstractCacheModel {

	@Override
	public String getModelName() {
		return READ_ONLY;
	}

	@Override
	public void execBefore(CacheBeanContext cacheBeanContext) {
		getCacheResult(cacheBeanContext);
	}

}
