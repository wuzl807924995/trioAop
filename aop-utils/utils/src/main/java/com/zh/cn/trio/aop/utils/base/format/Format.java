package com.zh.cn.trio.aop.utils.base.format;

import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;

public interface Format {

	<T> T format(FormatBean formatBean, String expressionString);

}
