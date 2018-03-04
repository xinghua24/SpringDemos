package com.xinghua24;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class App {
	public static void main(String[] args) {
		ExpressionParser parser = new SpelExpressionParser();
		String helloWorld = (String) parser.parseExpression("'Hello World'").getValue();
		System.out.println(helloWorld);
	}
}
