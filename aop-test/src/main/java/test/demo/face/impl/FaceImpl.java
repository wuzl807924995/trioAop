package test.demo.face.impl;

import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import io.github.zh.cn.trio.aop.function.cache.context.CacheBeanContext;
import io.github.zh.cn.trio.aop.function.cache.model.CacheModel;
import io.github.zh.cn.trio.aop.logger.annotation.TrioLogger;
import test.demo.face.IFace;
import test.demo.face.bean.User;

public class FaceImpl implements IFace {

	@TrioLogger(targetTime = CacheBeanContext.TIME_BEFORE, modelString = "'before:'+getTargetMethod()+':args:'+getTargetArgs()[0].getId()")
	@TrioCache(cacheModel = CacheModel.READ_WRITE, keyModelString = "getTargetArgs()[0].getId()+''")
	@Override
	public User test1(User u) {
		System.err.println(u);
		System.out.println(u);
		return u;
	}

}
