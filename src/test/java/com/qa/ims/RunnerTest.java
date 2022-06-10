package com.qa.ims;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import org.junit.runner.notification.Failure;


public class RunnerTest {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestHolder.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}

// Help from
// https://www.guru99.com/create-junit-test-suite.html#:~:text=Steps%20to%20create%20Test%20Suite%20and%20Test%20Runner,MySecondClassTest%29%20and%20create%20a%20method%20annotated%20with%20%40test.