package mergesortedarray;

import java.util.Arrays;
import java.util.HashMap;
//Count Subarrays having Sum K
import java.util.Map;

public class SolutionCntSubarrays {

	public int cntSubarrays(int[] arr, int k) {
		int total =0, occ=0;
		int ind=-1;
		Map<Integer,Integer> count = new HashMap<>();
		
		for(int i =0; i <arr.length ; i++) {
			
			total += arr[i];
			
			if(total == k)
				occ++;
			
			 if (count.containsKey(total-k)) {
		            occ += count.get(total-k);
		        }

			
			count.put(total,count.getOrDefault(total, 0)+1);
			
		
		}
		
		
		return occ;
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] input = {10, 2, -2, -20, 10};
        int k = -10;
    
        
        SolutionCntSubarrays arr= new SolutionCntSubarrays();
		
		System.out.println("input="+Arrays.toString(input));
		
		System.out.println("ans="+arr.cntSubarrays(input,k));
		
	}

}
