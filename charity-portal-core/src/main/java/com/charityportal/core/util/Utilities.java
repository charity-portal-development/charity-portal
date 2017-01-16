package com.charityportal.core.util;

import java.util.UUID;

public class Utilities {
	
	public static String randomUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static long currentTime() {
		return System.currentTimeMillis();
	}

}
