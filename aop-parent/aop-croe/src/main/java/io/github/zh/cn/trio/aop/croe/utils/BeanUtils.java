package io.github.zh.cn.trio.aop.croe.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

public abstract class BeanUtils {
	private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	public static <U> U getBean(ApplicationContext applicationContext, String beanName, Class<U> tcls, U defaultBean) {
		if (StringUtils.isEmpty(beanName)) {
			return defaultBean;
		} else {
			try {
				return applicationContext.getBean(beanName, tcls);
			} catch (Exception e) {
				logger.error("getBean has exception beanName:" + beanName + " class:" + tcls, e);
				return defaultBean;
			}
		}
	}
}
