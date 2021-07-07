package coreSystem;

import java.util.Arrays;

public class Student extends Person {
	
	private Grade[] grades;

	public Student(String name, int age) {
		super(name, age);
		grades = new Grade[6];
		
	}

	public Grade[] getGrades() {
		return grades;
	}
	
	public double getStudentAverage() {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			if (grades[i] != null) {
				count ++;
				sum += grades[i].getScore();
			}
		}
		return sum/count;
	}
	
	public void setGrades(Grade grades) {
		for (int i = 0; i < this.grades.length; i++) {
			if (this.grades[i] == null) {
				this.grades[i] = grades;
				break;
			}
		}
		
	}

	@Override
	public String toString() {
		return "Student [grades=" + Arrays.toString(grades) + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ "]";
	}
	
	
}
