package com.zh.cn.trio.aop.utils.strategy.function.cache.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import com.zh.cn.trio.aop.utils.aspect.AbstractAopAspect;
import com.zh.cn.trio.aop.utils.bean.AopUtilBean;
import com.zh.cn.trio.aop.utils.context.AopUtilContext;

public class CacheXmlAspect extends AbstractAopAspect<CacheConfig> {

	private AopUtilBean<CacheConfig> aopUtilBean;

	public AopUtilBean<CacheConfig> getAopUtilBean() {
		return aopUtilBean;
	}

	public void setAopUtilBean(AopUtilBean<CacheConfig> aopUtilBean) {
		this.aopUtilBean = aopUtilBean;
	}

	@Override
	public AopUtilBean<CacheConfig> createBean(ProceedingJoinPoint proceedingJoinPoint,
			AopUtilContext<CacheConfig> aopUtilContext) {
		return aopUtilBean;
	}

}
