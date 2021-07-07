package exam.prog;

public class ExamProgram {

	public static void printArrNumbers(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	public static int[] findMaxNumber(int[] arr, int numOfDigits) {
		int[] max3dNum = new int[2];
		for (int i = 0; i < arr.length - 2; i++) {
			int temp3dNum = 0;
			int temp3dNumReverese = 0;
			int digit = 1;
			int reversdigits = (int) Math.pow(10, numOfDigits - 1);
			for (int j = i; j < numOfDigits + i; j++) {
				temp3dNum += arr[j] * digit;
				temp3dNumReverese += arr[j] * reversdigits;
				digit *= 10;
				reversdigits /= 10;
			}
			if (temp3dNum > max3dNum[0]) {
				max3dNum[0] = temp3dNum;
				temp3dNum = 0;
			}
			if (temp3dNumReverese > max3dNum[1]) {
				max3dNum[1] = temp3dNumReverese;
				temp3dNumReverese = 0;
			}
		}
		return max3dNum;
	}

	public static int[] findDistinctNumber(int[] arr1, int[] arr2, int arrDistinctLength) {
		int[] arr3 = new int[arrDistinctLength];

		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = -1;
		}

		boolean existFlag = false;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					existFlag = true;
				}
			}
			if (existFlag == false) {
				int j = 0;
				while (arr3[j] != -1) {
					if (arr1[i] == arr3[j]) {
						existFlag = true;
					}
					j++;
				}
				if (existFlag == false) {
					arr3[j] = arr1[i];
				}
			}
			existFlag = false;
		}
		
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr1.length; j++) {
				if (arr2[i] == arr1[j]) {
					existFlag = true;
				}
			}
			if (existFlag == false) {
				int j = 0;
				while (arr3[j] != -1) {
					if (arr2[i] == arr3[j]) {
						existFlag = true;
					}
					j++;
				}
				if (existFlag == false) {
					arr3[j] = arr2[i];
				}
			}
			existFlag = false;
		}
		return arr3;
	}

	public static long arrayWholeNumber(int[] arr) {
		int index = 0;
		int digit = 1;
		long distinctNum = 0;
		while (arr[index] != -1) {
			distinctNum += digit * arr[index];
			digit *= 10;
			index++;
		}

		return distinctNum;
	}

	public static void main(String[] args) {

		// Q1: constructing two arrays.
		// creating two int arrays with the same length.
		int[] nums1 = new int[15];
		int[] nums2 = new int[15];

		// initializing the two arrays with random numbers between 0-9
		for (int i = 0; i < nums2.length; i++) {
			nums1[i] = (int) (Math.random() * 10);
			nums2[i] = (int) (Math.random() * 10);
		}

		// Q2: Displaying both of the arrays.
		System.out.println("Q1 + Q2:");
		System.out.println("Array nums1 contains: ");
		printArrNumbers(nums1);
		System.out.println("Array nums2 contains: ");
		printArrNumbers(nums2);

		// Q3: finding max 3d number within array number 1 both left to write and
		// reverse.
		;
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("Q3:");
		System.out.println("Mazimum number of three digits within nums1 is: " + findMaxNumber(nums1, 3)[0]);
		System.out.println("Mazimum number of three digits within nums1 in reverse is: " + findMaxNumber(nums1, 3)[1]);

		System.out.println();
		System.out.println("==============================================================");
		System.out.println("Q4 + Q5 + Q6:");
		// Q4 creating the distinct array from array nums1 and nums2.
		int[] nums3;
		nums3 = findDistinctNumber(nums1, nums2, 10);
		// Q5 Displaying the distinct array.
		System.out.println("Dispaying distinct array: ");
		printArrNumbers(nums3);
		// Displaying the whole number as integer.
		System.out.println("Distinct number of arrays nums1 and nums2 as an integer are: " + arrayWholeNumber(nums3));

	}
}
