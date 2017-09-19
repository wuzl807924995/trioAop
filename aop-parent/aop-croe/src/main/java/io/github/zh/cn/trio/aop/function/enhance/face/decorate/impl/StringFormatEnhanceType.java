package io.github.zh.cn.trio.aop.function.enhance.face.decorate.impl;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;
import io.github.zh.cn.trio.aop.function.enhance.exception.EnhanceTypeNotdecorateException;
import io.github.zh.cn.trio.aop.function.enhance.face.decorate.EnhanceType;

public class StringFormatEnhanceType implements EnhanceType {

	public static final String ENHANCE_TYPE_STRINGFORMAT = "ENHANCE_TYPE_STRINGFORMAT";
	
	@Override
	public String getSimpleName() {
		return ENHANCE_TYPE_STRINGFORMAT;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
		if (target instanceof List) {
			List list=(List) target;
			Object tmp;
			for (int i = 0; i < list.size(); i++) {
				tmp=messageFormat.format(list.get(i));
				list.set(i, tmp);
			}
		}
		
		if (target instanceof Map) {
			Map map=(Map) target;
			for (Object key : map.keySet()) {
				map.put(key, messageFormat.format(map.get(key)));
			}
		}
		
		throw new EnhanceTypeNotdecorateException("StringFormatEnhanceType cont't decorate target:"+target);
	}

}
