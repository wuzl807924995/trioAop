package io.github.zh.cn.trio.aop.dynamic.face.impl;

import io.github.zh.cn.trio.aop.dynamic.context.DynamicContext;
import io.github.zh.cn.trio.aop.dynamic.face.MethodDynamic;
import io.github.zh.cn.trio.aop.plug.redis.operaction.jedis2.PoolThreadLocal;
import redis.clients.jedis.JedisPool;

public class Jedis2MethodDynamic extends MethodDynamic {

	private JedisPool getConfigPool(DynamicContext context) {
		return null;
	}

	@Override
	public void dynamicStart(DynamicContext dynamicContext) {
		JedisPool jedisPool = getConfigPool(dynamicContext);
		PoolThreadLocal.setPool(jedisPool);
	}

	@Override
	public void dynamicEnd(DynamicContext dynamicContext) {
		PoolThreadLocal.remove();
	}

}
