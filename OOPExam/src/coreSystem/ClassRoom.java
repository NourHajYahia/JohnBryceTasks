package coreSystem;

import java.util.Arrays;

public class ClassRoom {

	private String name;
	private Teacher teacher;
	private Student[] students;

	public ClassRoom(String name, Teacher teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
		students = new Student[15];
	}

	public String getName() {
		return name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public Student[] getStudents() {
		return students;
	}
	
	

	public void setStudents(Student students) {
		for (int i = 0; i < this.students.length; i++) {
			if (this.students[i] == null) {
				this.students[i] = students;
				break;
			}
		}
	}

	public double getClassAverage() {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				count++;
				sum += students[i].getStudentAverage();
			}
		}
		return sum / count;
	}

	public double getClassProfessionAverage(String profession) {
		int count = 0;
		double sum = 0;
		Grade[] grades;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				grades = students[i].getGrades();
				for (int j = 0; j < grades.length; j++) {
					if (grades[j].getProfession() == profession) {
						count++;
						sum += grades[j].getScore();
					}
				}
			}
		}
		return sum/count;
	}

	@Override
	public String toString() {
		return "ClassRoom [name=" + name + ", teacher=" + teacher + ", students=" + Arrays.toString(students) + "]";
	}

}
