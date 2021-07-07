package coreSystem;

import java.util.Arrays;

public class School {
	
	private ClassRoom[] classRooms;

	public School() {
		super();
		classRooms = new ClassRoom[5];
	}

	public ClassRoom[] getClassRooms() {
		return classRooms;
	}
	
	
	
	public void setClassRooms(ClassRoom classRooms) {
		for (int i = 0; i < this.classRooms.length; i++) {
			if (this.classRooms[i] == null) {
				this.classRooms[i] = classRooms;
				break;
			}
		}
	}

	public double getSchoolAverage() {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				count ++;
				sum += classRooms[i].getClassAverage();
			}
		}
		return sum/count;
	}
	
	public double getSchoolProfessionAverage(String profession) {
		int count = 0;
		double sum = 0;
		for (int i = 0; i < classRooms.length; i++) {
			if (classRooms[i] != null) {
				sum += classRooms[i].getClassProfessionAverage(profession);
				count ++;
			}
		}
		return sum/count;
	}
	
	

	@Override
	public String toString() {
		return "School [classRooms=" + Arrays.toString(classRooms) + "]";
	}

}
