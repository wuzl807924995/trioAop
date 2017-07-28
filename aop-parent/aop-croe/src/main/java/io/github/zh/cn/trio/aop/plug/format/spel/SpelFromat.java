package io.github.zh.cn.trio.aop.plug.format.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import io.github.zh.cn.trio.aop.plug.format.Format;

public class SpelFromat implements Format {

	public Expression createExpression(String expressionString) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(expressionString);
		return expression;
	}

	public EvaluationContext createContext(Object root) {
		EvaluationContext context = new StandardEvaluationContext(root);
		return context;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T format(Object formatBean, String expressionString) {
		// 解析表达式
		Expression expression = createExpression(expressionString);
		// 构造上下文
		EvaluationContext context = createContext(formatBean);
		// 解析
		T value = (T) expression.getValue(context);
		return value;
	}

}
