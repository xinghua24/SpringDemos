package com.xinghua24;

import java.util.Date;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class SpElTest {
	ExpressionParser parser = new SpelExpressionParser();

	/**
	 * Hello World
	 */
	@Test
	public void testHelloWorld() {
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		System.out.println(helloWorld);
	}

	/**
	 * Literals - String, int, double, boolean, Object
	 */
	@Test
	public void testLiterals() {
		// String
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();

		// double
		double d = (double) parser.parseExpression("123.456").getValue();

		// int
		int i = (int) parser.parseExpression("123").getValue();

		// boolean
		boolean b = (boolean) parser.parseExpression("true").getValue();

		// object
		Date date = (Date) parser.parseExpression("new java.util.Date()").getValue();
		System.out.println(date);

	}

	/**
	 * invoke method on object
	 */
	@Test
	public void testMethodCall() {
		// invoke method on object
		long timeInMil = (long) parser.parseExpression("new java.util.Date().getTime()").getValue();
		System.out.println(timeInMil);
	}

	/**
	 * operator
	 */
	@Test
	public void testOperator() {
		boolean b1 = (boolean) parser.parseExpression("3 > 2").getValue();
		System.out.println(b1);

		boolean b2 = (boolean) parser.parseExpression("3 <= 2").getValue();
		System.out.println(b2);

		boolean b3 = (boolean) parser.parseExpression("3 > 2 and (1+1 > 1)").getValue();
		System.out.println(b3);
	}

	/**
	 * evaluate an expression on Context
	 */
	@Test
	public void testEvaluationContext() {
		User user = new User(1, "Alice");

		Expression exp = parser.parseExpression("name");

		EvaluationContext context = new StandardEvaluationContext(user);

		System.out.println(exp.getValue(context));
	}
}
