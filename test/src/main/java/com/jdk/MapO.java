package com.jdk;

import java.util.HashMap;
import java.util.Map;

public class MapO {

	public static void main(String[] args) {

		Map<String, String> maps = new HashMap<>(10);

		maps.put(1 + "", 2 + "");

		String value = maps.put(1 + "", 3 + "");

		String value1 = maps.put(2 + "", 4 + "");

		System.out.println(value);

		System.out.println(value1);

		System.out.println(maps);

	}
}