package io.github.zh.cn.trio.aop.plug.format.spel;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import io.github.zh.cn.trio.aop.croe.context.RunTimeConfig;
import io.github.zh.cn.trio.aop.croe.context.RunTimeContext;
import io.github.zh.cn.trio.aop.plug.format.Format;
import io.github.zh.cn.trio.aop.plug.format.bean.FormatBean;

public class SpelFromat implements Format {

	public Expression createExpression(String expressionString) {
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression(expressionString);
		return expression;
	}

	public EvaluationContext createContext(Object root) {
		return new StandardEvaluationContext(root);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T format(Object formatBean, String expressionString) {
		// 解析表达式
		Expression expression = createExpression(expressionString);
		// 构造上下文
		EvaluationContext context = createContext(formatBean);
		// 解析
		return (T) expression.getValue(context);
	}

	@Override
	public <T> T format(RunTimeContext runTimeContext,
			RunTimeConfig runTimeConfig, String expressionString) {
		FormatBean formatBean = new FormatBean(runTimeContext, runTimeConfig);
		return format(formatBean, expressionString);
	}

}
