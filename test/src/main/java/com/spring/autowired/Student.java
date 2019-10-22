package com.spring.autowired;

public class Student {

	private int  age;

	private String name;

	private Car car;

	public Student(int age, String name, Car car) {
		this.age = age;
		this.name = name;
		this.car = car;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Student() {
	}
}