package test.demo.face.impl;

import io.github.zh.cn.trio.aop.function.cache.annotation.TrioCache;
import test.demo.face.IFace;
import test.demo.face.bean.User;

public class FaceImpl implements IFace {

	@TrioCache
	@Override
	public User test1(User u) {
		System.err.println(u);
		return u;
	}

}
