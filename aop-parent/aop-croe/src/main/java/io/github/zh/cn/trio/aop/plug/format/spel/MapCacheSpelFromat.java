package io.github.zh.cn.trio.aop.plug.format.spel;

import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;

public class MapCacheSpelFromat extends SpelFromat {

	private Map<Object, EvaluationContext> contextMap;

	private Map<String, Expression> expressionMap;

	public Map<Object, EvaluationContext> getContextMap() {
		if (contextMap == null) {
			contextMap = new WeakHashMap<>();
		}
		return contextMap;
	}

	public void setContextMap(Map<Object, EvaluationContext> contextMap) {
		this.contextMap = contextMap;
	}

	public Map<String, Expression> getExpressionMap() {
		if (expressionMap == null) {
			expressionMap = new WeakHashMap<>();
		}
		return expressionMap;
	}

	public void setExpressionMap(Map<String, Expression> expressionMap) {
		this.expressionMap = expressionMap;
	}

	@Override
	public EvaluationContext createContext(Object root) {
		EvaluationContext evaluationContext = getContextMap().get(root);
		if (evaluationContext == null) {
			evaluationContext = super.createContext(root);
			getContextMap().put(root, evaluationContext);
		}
		return evaluationContext;
	}

	@Override
	public Expression createExpression(String expressionString) {
		Expression expression = getExpressionMap().get(expressionString);
		if (expression == null) {
			expression = super.createExpression(expressionString);
			getExpressionMap().put(expressionString, expression);
		}
		return expression;
	}
}
