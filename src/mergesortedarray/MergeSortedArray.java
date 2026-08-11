package mergesortedarray;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] array1 = new int[] { 0, 3, 4, 31 };
		int[] array2 = new int[] { 4, 6, 30 };
		MergeSortedArray utl = new MergeSortedArray();
		System.out.println(Arrays.toString(utl.mergeSortedArrays(array1, array2)));
	}

	private int[] mergeSortedArrays(int[] array1, int[] array2) {
		
		if (array1 == null || array2 == null)
			return null;
		
		int totallength = array1.length + array2.length;

		int[] mergedArray = new int[totallength];

		int firstArrayPointer = 0;
		int secondArrayPointer = 0;
		int i = 0;
		while (i < totallength) {

			if (secondArrayPointer >= array2.length) {
				mergedArray[i] = array1[firstArrayPointer];
				firstArrayPointer++;
			} else if (firstArrayPointer >= array1.length) {
				mergedArray[i] = array2[secondArrayPointer];
				secondArrayPointer++;

			} else {
				if (array1[firstArrayPointer] < array2[secondArrayPointer]) {
					mergedArray[i] = array1[firstArrayPointer];
					firstArrayPointer++;
				} else {
					mergedArray[i] = array2[secondArrayPointer];
					secondArrayPointer++;
				}
			}
			i++;
		}

		return mergedArray;
	}
}