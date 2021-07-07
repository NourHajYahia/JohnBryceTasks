package mainSystem;

import coreSystem.ClassRoom;
import coreSystem.Grade;
import coreSystem.School;
import coreSystem.Student;
import coreSystem.Teacher;

//filling the School with random values of teacher, professions, students and grades.
public class SchoolStatistics {
	public static void initiateRandomVirtualSchool(School virtualSchool, String[] professions) {
		ClassRoom classRoom;
		Teacher teacher;
		Student student;
		Grade grade;
		for (int i = 0; i < 3; i++) {
			teacher = new Teacher("Teacher " + i, ((int) (Math.random() * 100) + 20), professions[i]);
			classRoom = new ClassRoom("Class Room " + i, teacher);
			for (int j = 0; j < 5; j++) {
				student = new Student("Student " + j, ((int) (Math.random() * 100) + 20));
				for (int z = 0; z < professions.length; z++) {
					grade = new Grade(professions[z]);
					student.setGrades(grade);
				}
				classRoom.setStudents(student);
			}
			virtualSchool.setClassRooms(classRoom);
			System.out.println(virtualSchool);
			System.out.println();
		}
	}

	// Q1: printing the total school average;
	public static void printTotalSchoolAverage(School virtualSchool) {
		System.out.println("Q1:");
		System.out.println("School total average is: " + virtualSchool.getSchoolAverage());
	}

	// Q2: printing each class room average.
	public static void printClassRoomsAverage(School virtualSchool) {
		System.out.println("Q2:");
		ClassRoom[] classRooms = virtualSchool.getClassRooms();
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				System.out.println(classRooms[i].getName() + " has an average of " + classRooms[i].getClassAverage());
			}
		}
	}

	// Q3: printing each profession total average
	public static void printprofessionsAverage(School virtualSchool, String[] professions) {
		System.out.println("Q3:");
		for (int i = 0; i < professions.length; i++) {
			System.out.println(
					professions[i] + " has an average of " + virtualSchool.getSchoolProfessionAverage(professions[i]));
		}
	}

	public static void printStudentAverageByAge(School virtualSchool, int minAge, int maxAge) {
		System.out.println("Q4: (Bonus)");
		int count = 0;
		double sum = 0;
		ClassRoom[] classRooms = virtualSchool.getClassRooms();
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				Student[] students = classRooms[i].getStudents();
				for (int j = 0; j < students.length; j++) {
					if (students[j] != null && students[j].getAge() >= minAge && students[j].getAge() <= maxAge) {
						sum += students[j].getStudentAverage();
						count++;
					}
				}
			}
		}
		if (count == 0) {
			System.out.println("There are no Students with ages btween 20 - 30");
		} else {
			System.out.println("There are " + count + " Students with ages btween " + minAge + " - " + maxAge
					+ " and there total average is " + sum / count);
		}
	}

	public static void printStudentAverageByAge(School virtualSchool, int minAge) {
		System.out.println("Q4: (Bonus)");
		int count = 0;
		double sum = 0;
		ClassRoom[] classRooms = virtualSchool.getClassRooms();
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				Student[] students = classRooms[i].getStudents();
				for (int j = 0; j < students.length; j++) {
					if (students[j] != null && students[j].getAge() >= minAge) {
						sum += students[j].getStudentAverage();
						count++;
					}
				}
			}
		}
		if (count == 0) {
			System.out.println("There are no Students upove age btween " + minAge);
		} else {
			System.out.println("There are " + count + " Students with age upove " + minAge
					+ " and there total average is " + sum / count);
		}
	}

	public static void printStudentAverageAge(School virtualSchool) {
		System.out.println("Q4: (Bonus)");
		int count = 0;
		double sum = 0;
		ClassRoom[] classRooms = virtualSchool.getClassRooms();
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				Student[] students = classRooms[i].getStudents();
				for (int j = 0; j < students.length; j++) {
					if (students[j] != null) {
						sum += students[j].getAge();
						count++;
					}
				}
			}
		}

		System.out.println("Total students average age is: " + sum / count);

	}

	public static void main(String[] args) {

		String[] professions = { "math", "chemistry", "geography", "literature", "physics", "sports" };
		School virtualSchool = new School();

		// starting the initiating function.
		initiateRandomVirtualSchool(virtualSchool, professions);

		System.out.println("======================");
		// Q1: calling printTotalSchoolAverage function.
		printTotalSchoolAverage(virtualSchool);

		System.out.println("=======================");
		// Q2: calling printClassRoomsAverage.
		printClassRoomsAverage(virtualSchool);

		System.out.println("=======================");
		// Q3: calling printClassRoomsAverage.
		printprofessionsAverage(virtualSchool, professions);

		System.out.println("=======================");
		// Q4 (Bonus): calling printStudentAverageByAge between 20-30.
		printStudentAverageByAge(virtualSchool, 20, 30);

		System.out.println("=======================");
		// Q4 (Bonus): calling printStudentAverageByAge above 31.
		printStudentAverageByAge(virtualSchool, 31);
		
		System.out.println("=======================");
		// Q5 (Bonus): calling printStudentAverageAge 
		printStudentAverageAge(virtualSchool);
		

	}

}
