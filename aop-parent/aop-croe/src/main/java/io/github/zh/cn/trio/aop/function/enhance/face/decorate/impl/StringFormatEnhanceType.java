package io.github.zh.cn.trio.aop.function.enhance.face.decorate.impl;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;
import io.github.zh.cn.trio.aop.function.enhance.face.decorate.EnhanceType;

public class StringFormatEnhanceType implements EnhanceType {

	@Override
	public String getSimpleName() {
		return "StringFormat";
	}

	@Override
	public Object enhanceDecorate(EnhanceOne enhanceOne) {
		Object target = enhanceOne.getTarget();
		if (target==null) {
			return null;
		}
		MessageFormat messageFormat=new MessageFormat(enhanceOne.getEnhanceArgs().toString());
		if (target instanceof String) {
			return messageFormat.format(target);
		}
		
		if (target.getClass().isArray()) {
			Object[] temp=(Object[]) target;
			for (int i = 0; i < temp.length; i++) {
				temp[i]= messageFormat.format(temp[i]);
			}
			return temp;
		}
		
		if (target instanceof Collection<?>) {
			Collection<?> collection=(Collection<?>) target;
			Object[] objects = collection.toArray();
			Object[] temp=(Object[]) objects;
			for (int i = 0; i < temp.length; i++) {
				temp[i]= messageFormat.format(temp[i]);
			}
			collection.clear();
			CollectionUtils.mergeArrayIntoCollection(temp, collection);
			return collection;
		}
		
		if (target instanceof Map) {
			
		}
		return null;
	}

}
