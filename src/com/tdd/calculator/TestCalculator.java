package com.tdd.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class TestCalculator {

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("com.tdd.calculator.TestCalculator");
	}
 
	@Test
	public void testEmptyStringArgument() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneArgument() {
		assertEquals(1, Calculator.add("1"));
	}

}