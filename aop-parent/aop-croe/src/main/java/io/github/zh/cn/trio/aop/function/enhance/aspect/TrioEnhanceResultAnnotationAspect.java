package io.github.zh.cn.trio.aop.function.enhance.aspect;

import java.util.Map;


import io.github.zh.cn.trio.aop.croe.aspect.AbstractAopAspect;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.croe.utils.SimpleNameUtils;
import io.github.zh.cn.trio.aop.function.enhance.adapter.EnhanceAdapter;
import io.github.zh.cn.trio.aop.function.enhance.annotation.TrioEnhanceResult;
import io.github.zh.cn.trio.aop.function.enhance.config.EnhanceConfig;
import io.github.zh.cn.trio.aop.function.enhance.config.bean.EnhanceOne;
import io.github.zh.cn.trio.aop.function.enhance.face.decorate.EnhanceType;
import io.github.zh.cn.trio.aop.plug.format.Format;

public class TrioEnhanceResultAnnotationAspect extends AbstractAopAspect{

	private EnhanceAdapter enhanceAdapter;

	private Format format;
	
	private Map<String, EnhanceType> enhanceMap;

	
	private SimpleNameUtils simpleNameUtils;
	
	public EnhanceAdapter getEnhanceAdapter() {
		return enhanceAdapter;
	}
	
	public void setEnhanceAdapter(EnhanceAdapter enhanceAdapter) {
		this.enhanceAdapter = enhanceAdapter;
	}
	
	public Format getFormat() {
		return format;
	}
	
	public void setFormat(Format format) {
		this.format = format;
	}
	
	public Map<String, EnhanceType> getEnhanceMap() {
		return enhanceMap;
	}
	
	public void setEnhanceMap(Map<String, EnhanceType> enhanceMap) {
		this.enhanceMap = enhanceMap;
	}
	
	public SimpleNameUtils getSimpleNameUtils() {
		return simpleNameUtils;
	}
	
	public void setSimpleNameUtils(SimpleNameUtils simpleNameUtils) {
		this.simpleNameUtils = simpleNameUtils;
	}
	
	public EnhanceType geEnhanceType(String enhanceType) {
		return simpleNameUtils.getSipleBeanWithException(EnhanceType.class, enhanceType);
	}
	
	
	@Override
	public EnhanceConfig initConfig(RunTimeContext runTimeContext) {
		TrioEnhanceResult trioEnhanceResult = runTimeContext.getAnnotation(TrioEnhanceResult.class);
		
		EnhanceOne enhanceOne=new EnhanceOne();
		enhanceOne.setAll(runTimeContext.getResultObject());
		enhanceOne.setRoot(runTimeContext.getResultObject());
		enhanceOne.setEnhanceArgs(trioEnhanceResult.typeArgs());
		enhanceOne.setEnhanceType(geEnhanceType(trioEnhanceResult.type()));
		enhanceOne.setMethodResult(true);
		
		Object target = format.format(enhanceOne, trioEnhanceResult.target());
		enhanceOne.setTarget(target);
		
		EnhanceConfig enhanceConfig=new EnhanceConfig();
		enhanceConfig.setRunTimeAdapter(enhanceAdapter);
		enhanceConfig.addOne(enhanceOne);
		return enhanceConfig;
	}

}
