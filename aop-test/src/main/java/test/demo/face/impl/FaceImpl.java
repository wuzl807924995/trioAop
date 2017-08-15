package test.demo.face.impl;

import io.github.zh.cn.trio.aop.function.logger.annotation.TrioLogger;
import io.github.zh.cn.trio.aop.function.logger.config.LoggerConfig;
import test.demo.face.IFace;
import test.demo.face.bean.User;

public class FaceImpl implements IFace {

//	@TrioLogger(targetTime = CacheBeanContext.TIME_BEFORE, modelString = "'before:'+getTargetMethod()+':args:'+getTargetArgs()[0].getId()")
//	@TrioCache(cacheModel = CacheModel.READ_WRITE, keyModelString = "getTargetArgs()[0].getId()+''")
//	@TrioBeanValidation(beanName = "errorValidation")

	@TrioLogger(targetTime=LoggerConfig.TIME_BEFORE)
	@Override
	public User test1(User u) {
		System.err.println(u);
		System.out.println(u);
		return u;
	}

}
