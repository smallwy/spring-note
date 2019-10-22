package com.jdk;

import java.util.ArrayList;
import java.util.List;

public class ListO {
	public static void main(String[] args) {
		List<Object> list=new ArrayList<>(10);
		int i=0;
		while (true) {
			list.add(new user());
			System.out.println("--------------"+i++);
		}
	}
}