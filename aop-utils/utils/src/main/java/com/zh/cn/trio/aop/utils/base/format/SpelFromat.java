package com.zh.cn.trio.aop.utils.base.format;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.zh.cn.trio.aop.utils.base.format.utils.FormatBean;

public class SpelFromat implements Format {

	public Expression createExpression(String expressionString) {
		ExpressionParser parser = new SpelExpressionParser();
		// 解析表达式
		Expression expression = parser.parseExpression(expressionString);
		return expression;
	}

	public EvaluationContext createContext(Object formatBean) {
		EvaluationContext context = new StandardEvaluationContext();
		// 方法结果
		context.setVariable("root", formatBean);
		return context;
	}

	@SuppressWarnings("unchecked")
	public <T> T getVal(Expression expression, EvaluationContext context) {
		Object object = expression.getValue(context);
		return (T) object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T format(FormatBean formatBean, String expressionString) {
		// 解析表达式
		Expression expression = createExpression(expressionString);
		// 构造上下文
		EvaluationContext context = createContext(formatBean);
		// 解析
		return (T) getVal(expression, context);
	}

}
