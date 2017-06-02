package io.github.zh.cn.trio.aop.croe.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.zh.cn.trio.aop.croe.context.AopUtilConfig;
import io.github.zh.cn.trio.aop.croe.context.AopUtilContext;

public abstract class AbstractAopStrategy implements AopStrategy{

	private Logger logger=LoggerFactory.getLogger(getClass());
	
	public  <T extends AopUtilConfig>  void  beforeAop(AopUtilContext<T> aopUtilContext){
	}
	public  <T extends AopUtilConfig>  void  afertAop(AopUtilContext<T> aopUtilContext){}
	public  <T extends AopUtilConfig>  void  errorAop(AopUtilContext<T> aopUtilContext){}
	
	@Override
	public <T extends AopUtilConfig> void operAop(AopUtilContext<T> aopUtilContext, String targetTime) {
		if (AopUtilConfig.TIME_BEFORE.equals(targetTime)) {
			beforeAop(aopUtilContext);
		}else if (AopUtilConfig.TIME_AFTER.equals(targetTime)) {
			afertAop(aopUtilContext);
		}else if (AopUtilConfig.TIME_ERROR.equals(targetTime)) {
			errorAop(aopUtilContext);
		}else {
			logger.error("operAop has not time to target ");
		}
	}
}
