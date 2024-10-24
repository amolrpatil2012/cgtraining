package com.example.demo.entities;

public class Student {

		int roll;
		String name;
		public int getRoll() {
			return roll;
		}
		public void setRoll(int roll) {
			this.roll = roll;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Student(int roll, String name) {
			super();
			this.roll = roll;
			this.name = name;
		}
		
		public Student() {}
		@Override
		public String toString() {
			return "Student [roll=" + roll + ", name=" + name + "]";
		}
}
