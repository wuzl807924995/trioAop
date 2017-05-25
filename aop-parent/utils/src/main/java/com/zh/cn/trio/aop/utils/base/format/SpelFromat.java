package com.zh.cn.trio.aop.utils.base.format;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.util.CollectionUtils;

public class SpelFromat implements Format {

	public Expression createExpression(String expressionString) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(expressionString);
		return expression;
	}

	public EvaluationContext createContext(Object formatBean, Map<String, Object> map) {
		EvaluationContext context = new StandardEvaluationContext(formatBean);
		if (!CollectionUtils.isEmpty(map)) {
			for (String key : map.keySet()) {
				context.setVariable(key, map.get(key));
			}
		}
		return context;
	}

	@Override
	public <T> T format(Object formatBean, String expressionString) {
		return format(formatBean, expressionString, null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T format(Object formatBean, String expressionString, Map<String, Object> map) {
		// 解析表达式
		Expression expression = createExpression(expressionString);
		// 构造上下文
		EvaluationContext context = createContext(formatBean, map);
		// 解析
		T value = (T) expression.getValue(context);
		return value;
	}


	@Override
	public <T> T format(Object formatBean, ApplicationContext applicationContext, String expressionString) {
		return format(formatBean, applicationContext, expressionString, null);
	}

	@Override
	public <T> T format(Object formatBean, ApplicationContext applicationContext, String expressionString,
			Map<String, Object> map) {
		if (CollectionUtils.isEmpty(map)) {
			map=new HashMap<>();
		}
		map.put("context", applicationContext);
		return format(formatBean, expressionString, map);
		
	}

	
	

}
