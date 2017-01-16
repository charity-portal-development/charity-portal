package com.charityportal.core.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractTestCase {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTestCase.class);
	
	private static final long SEED = System.nanoTime();
	static {
		LOGGER.info("Random seed is [{}].", SEED);
	}
	
	public static final List<Character> ALPHA_NUMERICS;
	static {
		List<Character> temp = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; ++c) temp.add(c);
		for (char c = 'A'; c <= 'Z'; ++c) temp.add(c);
		for (char c = '0'; c <= '9'; ++c) temp.add(c);
		ALPHA_NUMERICS = Collections.unmodifiableList(temp);
	}
	
	public static final Random RANDOM = new Random(SEED);

	protected String randomString(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; ++i) {
			sb.append(randomAlphanumeric());
		}
		return sb.toString();
	}
	
	protected char randomAlphanumeric() {
		return ALPHA_NUMERICS.get(RANDOM.nextInt(ALPHA_NUMERICS.size()));
	}
	
}
