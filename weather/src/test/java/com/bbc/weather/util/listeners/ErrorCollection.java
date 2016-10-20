// Copyright (c) 2012-2016 All Right Reserved, http://made.com/

// All other rights reserved.

package com.bbc.weather.util.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;
import org.testng.Reporter;

public class ErrorCollection {
	
	/*
	 * 
	 * Collects all the errors in the test based on the listener and pushed it out after the suite runs completes
	 */

    private static Map<ITestResult, List<Throwable>> verificationFailuresMap = new HashMap<ITestResult, List<Throwable>>();

    public static void addVerificationFailure(Throwable e) {
        List<Throwable> verificationFailures = getVerificationFailures();
        verificationFailuresMap.put(Reporter.getCurrentTestResult(), verificationFailures);
        verificationFailures.add(e);
    }

    public static List<Throwable> getVerificationFailures() {
        List<Throwable> verificationFailures = verificationFailuresMap.get(Reporter.getCurrentTestResult());
        return verificationFailures == null ? new ArrayList<Throwable>() : verificationFailures;
    }
}
