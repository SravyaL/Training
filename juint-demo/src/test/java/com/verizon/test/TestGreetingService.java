package com.verizon.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.verizon.service.GreetingService;

//Assert class has static functions.
public class TestGreetingService {

	@Test
	public void testGreetWithNullInput() { // prepare Test Data
		String input = null; // Run the
		GreetingService gs = new GreetingService();
		String actualOutput = gs.greet(input); // Check the
		// result
		assertNull(actualOutput);
	}

	// Function to be tested
	//
	@Test
	public void testGreet() {
		// Prepare Test Data
		String input = "Sravya";
		String expectedOutput = "Hello Sravya";

		// Run the function to be tested

		GreetingService gs = new GreetingService();
		String actualOutput = gs.greet(input);

		// Check for test result
		assertEquals(expectedOutput, actualOutput);
	}
}
