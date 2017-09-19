package io.github.zh.cn.trio.aop.function.enhance.face.decorate;

import io.github.zh.cn.trio.aop.croe.utils.face.SimpleName;
import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;

public interface EnhanceType extends SimpleName{

	Object enhanceDecorate(EnhanceOne enhanceOne);
}
