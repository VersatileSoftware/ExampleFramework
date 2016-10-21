// Copyright (c) 2012-2016 All Right Reserved, http://made.com/

// All other rights reserved.

package com.bbc.weather.util.listeners;

import java.util.List;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.ITestListener;
import org.testng.Reporter;
import org.testng.internal.Utils;

public class MethodListener implements ITestListener, IInvokedMethodListener {

	/*
	 * Listeners to report and error collect on failures
	 */

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		Reporter.log("Before invocation of "
				+ method.getTestMethod().getMethodName() + "\n");

	}

	/*
	 * After Invocation of the test the listener
	 */
	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		Reporter.log("AFTER invocation of "
				+ method.getTestMethod().getMethodName() + "\n");
		Reporter.setCurrentTestResult(testResult);
		if (method.isTestMethod()) {
			List<Throwable> verificationFailures = ErrorCollection
					.getVerificationFailures();
			if (verificationFailures.size() != 0) {
				testResult.setStatus(ITestResult.FAILURE);
				if (testResult.getThrowable() != null) {
					verificationFailures.add(testResult.getThrowable());
				}
				int size = verificationFailures.size();
				if (size == 1) {
					testResult.setThrowable(verificationFailures.get(0));
				} else {
					StringBuffer failureMessage = new StringBuffer(
							"Multiple failures (").append(size).append("):\n");
					for (int i = 0; i < size - 1; i++) {
						failureMessage.append("Failure ").append(i + 1)
								.append(" of ").append(size).append(": ");
						Throwable t = verificationFailures.get(i);
						String fullStackTrace = Utils.stackTrace(t, true)[0];
						failureMessage.append(fullStackTrace).append("\n\n");
					}
					Throwable last = verificationFailures.get(size - 1);
					failureMessage.append("Failure ").append(size)
							.append(" of ").append(size).append(":");
					failureMessage.append(last.toString());

					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());

					testResult.setThrowable(merged);
				}
			}
		}

	}

	@Override
	public void onFinish(ITestContext arg0) {
		Reporter.log(
				"Completed executing test " + arg0.getName() + " "
						+ arg0.getEndDate(), true);

	}

	@Override
	public void onStart(ITestContext arg0) {
		Reporter.log("About to begin executing test " + arg0.getName(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		Reporter.log("About to begin executing test " + arg0.getStartMillis()
				+ " End with " + arg0.getEndMillis(), true);
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Failed Test " + arg0.getName(), true);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub

	}
}
