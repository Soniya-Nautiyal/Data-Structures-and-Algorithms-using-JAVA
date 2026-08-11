package com.dxc.msgcommon.utility.common;

import java.util.Arrays;

public class MergeSortedArray
{
	public static void main(String[] args)
	{
        int[] array1= new int[]{0,3,4,31};
        int[] array2= new int[]{4,6,30};
        MergeSortedArray utl = new MergeSortedArray();
        System.out.println(Arrays.toString(utl.mergeSortedArrays(array1, array2)));
    }

    private int[] mergeSortedArrays(int[] array1, int[] array2) {
        int totallength = array1.length+array2.length;
        if(array1==null || array2==null)
            return null;

        if(array1.length ==1 && array2.length == 1){
            if(array1[0] > array2[0]){
                return new int[]{array2[0], array1[0]};
            } else {
                return new int[]{array1[0], array2[0]};
            }
        }

        if(array1.length == 0 && array2.length > 0)
            return array2;
        if(array1.length > 0 && array2.length == 0)
            return array1;

        int[] mergedArray = new int[totallength];

        int firstArrayPointer = 0;
        int secondArrayPointer = 0;
        int i=0;
        while(i< totallength){
            if(array1[firstArrayPointer] < array2[secondArrayPointer]){
                mergedArray[i] = array1[firstArrayPointer];
                firstArrayPointer++;
            } else {
                mergedArray[i] = array2[secondArrayPointer];
                secondArrayPointer++;
            }
            i++;
        }

        return mergedArray;
    }
}