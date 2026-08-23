package mergesortedarray;

import java.util.Arrays;
//Smallest sum contiguous subarray

public class Solution {

	public int smallestSumSubarr(int[] arr, int k) {
		int sum =0,total =0;
		
		for(int i =0; i <arr.length ; i++) {
			
			if(total > 0)
				total = arr[i];
			else
				total += arr[i];
			
			sum  = Math.min(sum,total);
			
		}
		
		
		return sum;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int input[] = { 3, -4, 2, -3, -1, 7, -5 };
        int k = input.length;
    
        
        Solution arr= new Solution();
		
		System.out.println("input="+Arrays.toString(input));
		
		System.out.println("ans="+arr.smallestSumSubarr(input,k));
		
	}

}
