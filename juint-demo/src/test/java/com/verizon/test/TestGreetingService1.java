package com.verizon.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.verizon.service.GreetingService;

public class TestGreetingService1 {
	GreetingService gs;

	@Before
	public void setUp() throws Exception {
		this.gs = new GreetingService();
	}

	@After
	public void tearDown() throws Exception {
		this.gs = null;
	}

	@Test
	public void testGreetForValidUserName() {
		String input = "Sravya";
		String expectedOutput = "Hello Sravya";
		String actualOutput = gs.greet(input);
		assertEquals(expectedOutput, actualOutput);
	}

	@Test
	public void testGreetForNullUserName() { // prepare Test Data
	

		String actualOutput = gs.greet(null);

		assertNull(actualOutput);
	}
}
